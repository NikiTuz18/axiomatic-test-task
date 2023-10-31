package ru.nikituz.axiomatictesttask.repositories.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.nikituz.axiomatictesttask.entities.Contract;
import ru.nikituz.axiomatictesttask.repositories.ContractRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ContractRepositoryImpl implements ContractRepository {

    private final SessionFactory sessionFactory;

    @Override
    public List<Contract> findAll() {
        return currentSession()
                .createQuery("from Contract ", Contract.class)
                .list();
    }

    @Override
    public void save(Contract contract) {
        currentSession().persist(contract);
    }

    @Override
    public Contract find(long id) {
        return currentSession().find(Contract.class, id);
    }

    @Override
    public void update(Contract updatedContract) {
        currentSession().saveOrUpdate(updatedContract);
    }

    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }
}
