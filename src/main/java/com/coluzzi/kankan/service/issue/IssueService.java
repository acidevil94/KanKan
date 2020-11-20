package com.coluzzi.kankan.service.issue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.coluzzi.kankan.model.issue.Issue;
import com.coluzzi.kankan.repository.IssueRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class that contains the business logic to handle operations on {@link Issue}
 * objects.
 */
@Component
public class IssueService {

    private Logger logger = LoggerFactory.getLogger(IssueService.class);

    @Autowired
    public IssueRepository repository;


    public List<Issue> findIssues(String description) {

        List<Issue> issues ;
        if (description == null || description.isEmpty()) {
            logger.debug("tryGetIssue(): Calling findAll from service...");
            issues = new ArrayList<>(); 
           
            Iterator<Issue> iterator = repository.findAll().iterator();

            while(iterator.hasNext()) {
                issues.add(iterator.next());
            }

        } else {
            logger.debug("tryGetIssue(): Calling searchByDescription from service...");
            issues = repository.findByDescription(description);
        }

        return issues;
    }

}