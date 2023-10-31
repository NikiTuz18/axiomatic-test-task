package ru.nikituz.axiomatictesttask.repositories;

import ru.nikituz.axiomatictesttask.entities.Request;

import java.util.List;

public interface RequestRepository {
    List<Request> findAll();

    void save(Request request);
}
