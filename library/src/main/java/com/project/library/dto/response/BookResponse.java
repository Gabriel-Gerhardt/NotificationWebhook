package com.project.library.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.library.entities.Author;

public record BookResponse(

        @JsonProperty("id")
        Long id,

        @JsonProperty("title")
        String title,

        @JsonProperty("author")
        Author author,

        @JsonProperty("author_name")
        String authorName,

        @JsonProperty("publish_year")
        Integer publishYear

) {}
