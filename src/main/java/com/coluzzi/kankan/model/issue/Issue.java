package com.coluzzi.kankan.model.issue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;


/**
 * Class that represents an Issue.
 * Issues are represented by their Title, Description, Author, etc...
 * Issues are identified by their ID, auto-generated at saving time.
 */
@Data
@Builder
@Entity
public class Issue {

    @Id @GeneratedValue (strategy=GenerationType.AUTO) 
    private final @NonNull Integer id;
    private @NonNull final String title;
    private @NonNull final String description;

}