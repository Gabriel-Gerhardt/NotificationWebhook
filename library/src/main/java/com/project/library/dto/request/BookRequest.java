package com.project.library.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.library.entities.Author;

public record BookRequest(

        @JsonProperty("title")
        String title,

        @JsonProperty("author")
        Author author,

        @JsonProperty("publish_year")
        Integer publishYear

) {}
