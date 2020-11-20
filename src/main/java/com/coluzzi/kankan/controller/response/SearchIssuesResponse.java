package com.coluzzi.kankan.controller.response;

import java.util.List;

import com.coluzzi.kankan.model.issue.Issue;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Response entity for {@link com.coluzzi.kankan.controller.IssueController#getIssues(String)}
 */
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class SearchIssuesResponse {

    private List<Issue> issues;
    
}