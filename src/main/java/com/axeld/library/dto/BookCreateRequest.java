package com.axeld.library.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookCreateRequest(String title, String author, String isbn) {}
