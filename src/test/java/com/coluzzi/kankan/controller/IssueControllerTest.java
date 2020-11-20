package com.coluzzi.kankan.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.is;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.coluzzi.kankan.controller.util.ControllerConstants;
import com.coluzzi.kankan.model.issue.Issue;
import com.coluzzi.kankan.service.issue.IssueService;

import lombok.SneakyThrows;

@SpringBootTest
@AutoConfigureMockMvc
public class IssueControllerTest {
    

    @Autowired
    private MockMvc mvcMock;


    @Autowired
    public IssueController issueController;


    @MockBean 
    public IssueService issueService;



    @BeforeEach
    public void setUp() {
        this.mvcMock = MockMvcBuilders.standaloneSetup(issueController).build();
    }


    @Test
    @SneakyThrows
    public void getIssueByDescriptionTest() {

        List<Issue> response = new ArrayList<>();


        response.add(Issue.builder()
                            .id(5)
                            .title("Issue Title Test")
                            .description("Test Issue")
                            .build()
                            );

        
        when(issueService.findIssues("Test Issue"))
                        .thenReturn(response);


        mvcMock.perform(MockMvcRequestBuilders.get(ControllerConstants.URL_ISSUE)
                                .param(ControllerConstants.REQUEST_KEY_DESCRIPTION, "Test Issue"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.issues[0].id", is(5)));
    }
}