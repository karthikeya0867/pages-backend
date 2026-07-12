package com.karthikeya.pages.dto.request;

import com.fasterxml.jackson.databind.JsonNode;
import com.karthikeya.pages.enums.BlockType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record NoteBlockReq(

    @NotNull
    BlockType blockType,

    @NotNull
    JsonNode payload,

    @PositiveOrZero(message = "Position must be a non-negative integer")
    @NotNull
    Integer position
){}
