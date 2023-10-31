package ru.nikituz.axiomatictesttask.repositories.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.nikituz.axiomatictesttask.entities.Request;
import ru.nikituz.axiomatictesttask.repositories.RequestRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RequestRepositoryImpl implements RequestRepository {

    private final SessionFactory sessionFactory;

    @Override
    public List<Request> findAll() {
        return currentSession()
                .createQuery("from Request", Request.class)
                .list();
    }

    @Override
    public void save(Request request) {
        currentSession().persist(request);
    }

    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }
}
