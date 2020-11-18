package com.coluzzi.kankan.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class Issue {

    @NonNull private final String description;

}