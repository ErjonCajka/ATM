package com.ATMproject.ATM.aspect;

import com.ATMproject.ATM.exception.AtmMachineOutOfFunction;
import com.ATMproject.ATM.exception.InsufficientBalanceException;
import com.ATMproject.ATM.exception.MaxWithdrawException;
import com.ATMproject.ATM.exception.ResourceNotFoundException;
import com.ATMproject.ATM.model.dto.TransactionCreateRequest;
import com.ATMproject.ATM.model.entity.Account;
import com.ATMproject.ATM.model.entity.AtmMachine;
import com.ATMproject.ATM.model.entity.Transaction;
import com.ATMproject.ATM.repository.AccountRepository;
import com.ATMproject.ATM.repository.AtmMachineRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.security.auth.login.AccountNotFoundException;

import java.util.Map;
import java.util.Optional;

import static com.ATMproject.ATM.helpers.Constant.*;
import static com.ATMproject.ATM.model.entity.DataInMemory.atmValues;

@Aspect
@Configuration
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Before(API_LAYER_POINTCUT)
    public void BeforeLogAspect(JoinPoint joinPoint) {
        logger.info(" Controller requested: " + joinPoint.getSignature() + " with endpoint :" + httpServletRequest.getMethod() + ", " + httpServletRequest.getRequestURI());
    }

    @AfterReturning(API_LAYER_POINTCUT)
    public void afterReturningAdvice(JoinPoint joinPoint) {
        logger.info("AfterReturningAdvice - Method call completed " + joinPoint.getSignature());
    }

    @After(API_LAYER_POINTCUT)
    public void afterAdvice(JoinPoint joinPoint) {
        logger.info("AfterAdvice - Method call completed " + joinPoint.getSignature());
    }

    @AfterThrowing(value = SERVICE_LAYER_POINTCUT, throwing = "exception")
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception exception) {
        logger.info("AfterThrowing - Method exception " + joinPoint.getSignature() + " error msg :" + exception.getMessage());
    }

    @Autowired
    private AccountRepository accountRepository;

    @Around("com.ATMproject.ATM.aspect.PointcutConfig.withdrawValidatePointcut(transactionCreateRequest)")
    public Object validateWithdrawal(ProceedingJoinPoint joinPoint, TransactionCreateRequest transactionCreateRequest) throws Throwable {
        Account account = accountRepository.findById(transactionCreateRequest.getAccount().getId());
        if(transactionCreateRequest.getAmount()>1000){
            throw new MaxWithdrawException("Max value you can withdraw is 1000$");
        }
        //Max value in a day it will be 1000;
        Double shuma =  0.d;
        for(Integer i : atmValues.keySet()){
                if( i == account.getId()){
                    shuma = shuma + atmValues.get(i) + transactionCreateRequest.getAmount();
                    if(shuma > 1000){
                        throw new MaxWithdrawException("Max value you can withdraw is 1000");
                    }
                }
            }


        Object result = joinPoint.proceed();


        return result;
    }

    @Autowired
    AtmMachineRepository atmMachineRepository;

    @Around("com.ATMproject.ATM.aspect.PointcutConfig.transferValidatePointcut(transactionCreateRequest,id)")
    public Object validateWithdrawal(ProceedingJoinPoint joinPoint, TransactionCreateRequest transactionCreateRequest, Integer id) throws Throwable {
        Account account = accountRepository.findById(transactionCreateRequest.getAccount().getId());

        if (account == null) {
            throw new AccountNotFoundException("Account not found with ID: " + account.getId());
        }

        if (account.getAccountBalance() < transactionCreateRequest.getAmount()) {
            throw new InsufficientBalanceException("Insufficient balance for withdrawal. Current balance: "
                    + account.getAccountBalance() + ", Transfer amount: " + transactionCreateRequest.getAmount());
        }

        Object result = joinPoint.proceed();

        return result;
    }

    @Around("com.ATMproject.ATM.aspect.PointcutConfig.atmStatus(transactionCreateRequest,id)")
    public Object atmStatus(ProceedingJoinPoint joinPoint, TransactionCreateRequest transactionCreateRequest, Integer id) throws Throwable {
        Account account = accountRepository.findById(transactionCreateRequest.getAccount().getId());

        Optional<AtmMachine> atmMachine = atmMachineRepository.findById(1);
        if (atmMachine.get().isStatus() == false) {
            throw new AtmMachineOutOfFunction("ATM IS OUT OF FUNCTION FOR THE MOMENT ");
        }
        if (atmMachine.get().getAtmAmount() < account.getAccountBalance()) {
            throw new ResourceNotFoundException("ATM DOESNT HAVE THE REQUIRED MONEY");
        }


        Object result = joinPoint.proceed();

        return result;
    }
    @Around("com.ATMproject.ATM.aspect.PointcutConfig.maxWithdraw(transactionCreateRequest,id)")
    public Object maxWithdraw(ProceedingJoinPoint joinPoint, TransactionCreateRequest transactionCreateRequest, Integer id) throws Throwable {
        Account account = accountRepository.findById(transactionCreateRequest.getAccount().getId());

        Optional<AtmMachine> atmMachine = atmMachineRepository.findById(1);
        if (atmMachine.get().isStatus() == false) {
            throw new AtmMachineOutOfFunction("ATM IS OUT OF FUNCTION FOR THE MOMENT ");
        }
        if (atmMachine.get().getAtmAmount() < account.getAccountBalance()) {
            throw new ResourceNotFoundException("ATM DOESNT HAVE THE REQUIRED MONEY");
        }


        Object result = joinPoint.proceed();

        return result;
    }

    @Around("com.ATMproject.ATM.aspect.PointcutConfig.maxTransfer(transactionCreateRequest,id)")
    public Object maxTransfer(ProceedingJoinPoint joinPoint, TransactionCreateRequest transactionCreateRequest,Integer id) throws Throwable {
        Account account = accountRepository.findById(transactionCreateRequest.getAccount().getId());
        if(transactionCreateRequest.getAmount()>5000){
            throw new MaxWithdrawException("Max value you can withdraw is 5000");
        }
        //Max value in a day it will be 1000;
        Double shuma =  0.d;
        for(Integer i : atmValues.keySet()){
            if( i == account.getId()){
                shuma = shuma + atmValues.get(i) + transactionCreateRequest.getAmount();
                if(shuma > 5000){
                    throw new MaxWithdrawException("Max value you can withdraw is 5000");
                }
            }
        }


        Object result = joinPoint.proceed();


        return result;
    }

}

