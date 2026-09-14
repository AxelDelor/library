package com.axeld.library.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookCreateRequest(
        @NotBlank String title,
        @NotBlank String author,
        @NotBlank String isbn) {
}
