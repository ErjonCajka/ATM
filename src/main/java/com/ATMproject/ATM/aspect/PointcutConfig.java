package com.ATMproject.ATM.aspect;

import com.ATMproject.ATM.model.dto.TransactionCreateRequest;
import org.aspectj.lang.annotation.Pointcut;

import static com.ATMproject.ATM.helpers.Constant.*;

public class PointcutConfig {

    @Pointcut(POINTCUT_CONTROLLER)
    public void apiLayerPointcut(){}

    @Pointcut(POINTCUT_SERVICE)
    public void serviceLayerPointcut(){}

    @Pointcut(POINTCUT_SERVICE_CONTROLLER)
    public void serviceControllerLayerPointcut(){}


    @Pointcut("execution(* com.ATMproject.ATM.service.*.*(..)) && args(transactionCreateRequest)")
    public void withdrawValidatePointcut(TransactionCreateRequest transactionCreateRequest) {}
    @Pointcut("execution(* com.ATMproject.ATM.service.*.*(..)) && args(transactionCreateRequest,id)")
    public void transferValidatePointcut(TransactionCreateRequest transactionCreateRequest,Integer id) {}

    @Pointcut("execution(* com.ATMproject.ATM.service.*.*(..)) && args(transactionCreateRequest,id)")
    public void atmStatus(TransactionCreateRequest transactionCreateRequest,Integer id) {}
    @Pointcut("execution(* com.ATMproject.ATM.service.*.*(..)) && args(transactionCreateRequest,id)")
    public void maxWithdraw(TransactionCreateRequest transactionCreateRequest,Integer id) {}
    @Pointcut("execution(* com.ATMproject.ATM.service.*.*(..)) && args(transactionCreateRequest,id)")
    public void maxTransfer(TransactionCreateRequest transactionCreateRequest,Integer id) {}
}

