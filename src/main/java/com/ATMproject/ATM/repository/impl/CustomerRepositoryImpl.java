package com.ATMproject.ATM.repository.impl;

import com.ATMproject.ATM.exception.ResourceNotFoundException;
import com.ATMproject.ATM.model.entity.Customer;
import com.ATMproject.ATM.repository.CustomerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.ATMproject.ATM.helpers.Constant.*;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Customer findById(int id) {
        try{
            TypedQuery<Customer> findQuery = entityManager.createQuery(FIND_QUERY_BY_ID_CUSTOMER,Customer.class);
            findQuery.setParameter("id",id);
            return findQuery.getSingleResult();
        }catch (NoResultException e){
            throw new ResourceNotFoundException("Customer with id: " + id + " doesn't exist");
        }


    }

    @Override
    public List<Customer> findAll(int pageNumber, int pageSize) {
        TypedQuery<Customer> findQuery = entityManager.createQuery(FIND_QUERY_ALL_CUSTOMER,Customer.class);
        findQuery.setFirstResult((pageNumber - 1) * pageSize);
        findQuery.setMaxResults(pageSize);
        return findQuery.getResultList();
    }
}
