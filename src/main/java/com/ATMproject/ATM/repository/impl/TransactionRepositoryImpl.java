package com.ATMproject.ATM.repository.impl;

import com.ATMproject.ATM.exception.ResourceNotFoundException;
import com.ATMproject.ATM.helpers.Constant;
import com.ATMproject.ATM.model.entity.Account;
import com.ATMproject.ATM.model.entity.Transaction;
import com.ATMproject.ATM.repository.TransactionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import static com.ATMproject.ATM.helpers.Constant.FIND_QUERY_BY_ID_ACCOUNT;
import static com.ATMproject.ATM.helpers.Constant.FIND_QUERY_BY_ID_TRANSACTION;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Transaction save(Transaction transaction) {
        entityManager.merge(transaction);
        return transaction;
    }

    @Override
    public Transaction update(Transaction transaction) {
        entityManager.merge(transaction);
        return transaction;
    }

    @Override
    public Transaction findById(Integer id) {
        try{
            TypedQuery<Transaction> findQuery = entityManager.createQuery(FIND_QUERY_BY_ID_TRANSACTION,Transaction.class);
            findQuery.setParameter("id",id);
            return findQuery.getSingleResult();
        }catch (NoResultException e){
            throw new ResourceNotFoundException("Transaction with id: " + id + " doesn't exist");
        }
    }
}
