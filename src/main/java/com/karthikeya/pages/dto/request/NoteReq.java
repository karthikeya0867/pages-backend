package com.karthikeya.pages.dto.request;

import jakarta.validation.constraints.NotNull;

public record NoteReq(
        @NotNull
        String title
) {}
