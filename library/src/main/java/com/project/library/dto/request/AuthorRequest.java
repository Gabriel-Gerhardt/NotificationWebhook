package com.project.library.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthorRequest(
        @JsonProperty("name")
        String name,

        @JsonProperty("bornYear")
        Integer bornYear
) {
}
