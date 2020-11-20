package com.coluzzi.kankan.controller;

import java.util.List;

import com.coluzzi.kankan.controller.response.SearchIssuesResponse;
import com.coluzzi.kankan.controller.util.ControllerConstants;

import com.coluzzi.kankan.model.issue.Issue;
import com.coluzzi.kankan.service.issue.IssueService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller for CRUD operations on 
 * {@link com.coluzzi.kankan.model.Issue} instances.
 */
@RestController
public class IssueController {

    private Logger logger = LoggerFactory.getLogger(IssueController.class);

    @Autowired
    public IssueService service;

    /**
     * API that Searchs for issues. 
     * @param description Description that the resulting set of issues must contains
     * @return {@link List} of {@link Issue} objects found.
     */
    @GetMapping(ControllerConstants.URL_ISSUE)
    public ResponseEntity<SearchIssuesResponse> getIssues(
                                    @RequestParam(ControllerConstants.REQUEST_KEY_DESCRIPTION) String description) {

        logger.debug("getIssues(): Init, description : '{}'", description);
        try {
            List<Issue> issues = this.service.findIssues(description);
            logger.info("getIssues(): Returning {} issues",  issues.size());
            return new ResponseEntity<>(SearchIssuesResponse.builder()
                                    .issues(issues)
                                    .build(), HttpStatus.OK);
        } catch(Exception exc) {
             logger.error("Couldn't respond to getIssue request", exc);
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }        
    }

}
