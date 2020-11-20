package com.coluzzi.kankan.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.coluzzi.kankan.model.issue.Issue;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@TestExecutionListeners(
    {
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
    }
)
public class IssueRepositoryTest {


    @Autowired
    public IssueRepository issueRepository;


    @Test
    @DatabaseSetup("/dataset/issues/singular_issue.xml")
    public void testFindByDescription() {
        List<Issue> issues = this.issueRepository.findByDescription("Test Issue");
        assertTrue(issues.size() == 1);

        Issue singular = issues.get(0);

        Issue expected = Issue.builder()
                                .id(5)
                                .title("Test Title")
                                .description("Test Issue Description")
                                .build();
        assertEquals(expected, singular, "");

    }
}