package com.coluzzi.kankan.service.issue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.coluzzi.kankan.model.issue.Issue;
import com.coluzzi.kankan.repository.IssueRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class IssueServiceTest {
    

    @Autowired
    public IssueService service;


    @MockBean 
    public IssueRepository repository;

    

    @Test
    public void testFindAll() {
        List<Issue> res = new ArrayList<>();

        Issue issue1 = Issue.builder()
                        .id(5)
                        .description("Test Issue")
                        .title("Title Test")
                        .build();

        res.add(issue1);

        when(repository.findByDescription("Test Issue")).thenReturn(res);


        assertEquals(issue1, service.findIssues("Test Issue").get(0));

    }
}