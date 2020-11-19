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
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.Matchers.is;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.coluzzi.kankan.controller.util.ControllerConstants;
import com.coluzzi.kankan.model.issue.Issue;
import com.coluzzi.kankan.service.issue.IssueSearch;
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


    private ObjectMapper objectMapper = new ObjectMapper();


    @BeforeEach
    public void setUp() {
        this.mvcMock = MockMvcBuilders.standaloneSetup(issueController).build();
    }


    @Test
    @SneakyThrows
    public void getIssueBySearchTest() {
        IssueSearch search = IssueSearch.builder()
                    .issueDescription("Test Issue")
                    .build();

        List<Issue> response = new ArrayList<>();


        response.add(Issue.builder()
                            .id(5L)
                            .title("Issue Title Test")
                            .description("Test Issue")
                            .build()
                            );

        
        when(issueService.searchBy(search))
                        .thenReturn(response);


        mvcMock.perform(MockMvcRequestBuilders.get(ControllerConstants.URL_ISSUE)
                                .param(ControllerConstants.REQUEST_KEY_DESCRIPTION, "Test Issue"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$." + ControllerConstants.RESPONSE_KEY_ISSUES + "[0]." + 
                                                ControllerConstants.RESPONSE_KEY_ISSUE_ID, is(5)));
    }
}