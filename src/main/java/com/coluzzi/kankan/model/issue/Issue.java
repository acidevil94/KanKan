package com.coluzzi.kankan.model.issue;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Issue {

    private final long id;
    private @NonNull final String title;
    private @NonNull final String description;

}