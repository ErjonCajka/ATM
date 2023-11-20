package com.ATMproject.ATM.repository.impl;

import com.ATMproject.ATM.exception.ResourceNotFoundException;
import com.ATMproject.ATM.model.entity.Account;
import com.ATMproject.ATM.model.entity.Customer;
import com.ATMproject.ATM.repository.AccountRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import static com.ATMproject.ATM.helpers.Constant.FIND_QUERY_BY_ID_ACCOUNT;
import static com.ATMproject.ATM.helpers.Constant.FIND_QUERY_BY_ID_CUSTOMER;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Account save(Account accountCreateRequest) {
        entityManager.persist(accountCreateRequest);
        return accountCreateRequest;
    }

    @Override
    public Account update(Account accountDTO) {
        entityManager.merge(accountDTO);
        return accountDTO;
    }

    @Override
    public Account findById(Integer id) {
        try{
            TypedQuery<Account> findQuery = entityManager.createQuery(FIND_QUERY_BY_ID_ACCOUNT,Account.class);
            findQuery.setParameter("id",id);
            return findQuery.getSingleResult();
        }catch (NoResultException e){
            throw new ResourceNotFoundException("Account with id: " + id + " doesn't exist");
        }
    }

    @Override
    public Account delete(Account account) {
       entityManager.remove(account);
        return account;
    }
}
