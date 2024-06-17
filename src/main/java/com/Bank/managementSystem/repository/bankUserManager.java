package com.Bank.managementSystem.repository;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.Bank.managementSystem.entity.BankUser;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class bankUserManager {
    //connect to a database without the jdbc template

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public BankUser create(String name) {
        BankUser user = new BankUser(name);
        entityManager.persist(user);
        return user;
    }

    public BankUser findById(int id){
        return entityManager.find(BankUser.class, id);
    }

    public BankUser update(BankUser BankUser)  {return entityManager.merge(BankUser);}

    public void delete(int id){
        BankUser BankUser = findById(id);
        entityManager.remove(BankUser);
    }

    //This is done using JPQL as the findall method is not available in JPA that is why we will use this
    public List<BankUser> findAll(){
       TypedQuery<BankUser> namedQuery = entityManager.createNamedQuery("find_all_BankUsers", BankUser.class);
       return namedQuery.getResultList();
    }
}

