package com.coluzzi.kankan.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coluzzi.kankan.model.issue.Issue;


/**
 * Class that handle DB operations versus {@link Issue}
 * entities.
 * 
 * This class implements {@link CrudRepository}.
 */
@Repository
public class IssueRepository implements CrudRepository<Issue, Integer> {

    public List<Issue> findByDescription(String description) {
        return new ArrayList<>();
    }

    @Override
    public <S extends Issue> S save(S entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Issue> Iterable<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Issue> findById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean existsById(Integer id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterable<Issue> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<Issue> findAllById(Iterable<Integer> ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Issue entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAll(Iterable<? extends Issue> entities) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub

    }

}