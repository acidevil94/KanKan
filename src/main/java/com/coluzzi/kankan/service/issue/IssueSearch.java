package com.coluzzi.kankan.service.issue;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class IssueSearch {
    
    private @NonNull final String issueDescription;

}