package com.coluzzi.kankan.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import com.coluzzi.kankan.model.issue.Issue;


/**
 * Interface that handle DB operations versus {@link Issue}
 * entities.
 * This interface extends {@link CrudRepository}.
 * 
 * This will be resolved by Spring at runtime.
 * 
 */
public interface IssueRepository extends CrudRepository<Issue, Integer> {


    @Query("SELECT i FROM Issue i WHERE i.description = :description")
    List<Issue> findByDescription(@Param("description") String description);

}