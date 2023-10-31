package ru.nikituz.axiomatictesttask.repositories.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.nikituz.axiomatictesttask.entities.Customer;
import ru.nikituz.axiomatictesttask.repositories.CustomerRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final SessionFactory sessionFactory;

    @Override
    public Customer find(long id) {
        return currentSession().find(Customer.class, id);
    }

    @Override
    public void save(Customer customer) {
        currentSession().persist(customer);
    }

    @Override
    public void update(Customer updatedCustomer) {
        currentSession().saveOrUpdate(updatedCustomer);
    }

    @Override
    public void delete(long id) {
        currentSession().remove(find(id));
    }

    @Override
    public List<Customer> findAll() {
        return currentSession()
                .createQuery("from Customer", Customer.class)
                .list();
    }

    @Override
    public List<Customer> findByFio(String fio) {
        return currentSession()
                .createQuery("from Customer where fio like concat('%', :fio, '%')", Customer.class)
                .setParameter("fio", fio)
                .list();
    }

    @Override
    public List<Customer> findByPassport(String passport) {
        return currentSession()
                .createQuery("from Customer where passport like concat('%', :passport, '%')", Customer.class)
                .setParameter("passport", passport)
                .list();
    }

    @Override
    public List<Customer> findByPhone(String phone) {
        return currentSession()
                .createQuery("from Customer where phone like concat('%', :phone, '%')", Customer.class)
                .setParameter("phone", phone)
                .list();
    }

    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }
}
