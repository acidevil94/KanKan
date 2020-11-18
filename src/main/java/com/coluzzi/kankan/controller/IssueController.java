package com.coluzzi.kankan.controller;

import java.util.ArrayList;
import java.util.List;

import com.coluzzi.kankan.controller.util.ControllerConstants;

import com.coluzzi.kankan.model.Issue;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for CRUD operations on 
 * {@link com.coluzzi.kankan.model.Issue} instances.
 */
@RestController
public class IssueController {


    @GetMapping(ControllerConstants.ISSUE_URL)
    public List<Issue> getIssues() {
        return new ArrayList<>();
    }

}
