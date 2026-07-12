package com.karthikeya.pages.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
public class ApiResponse<T> {

    private final boolean success;
    private final String message;
    private final T data;
    private final Map<String, String> errors;

    /**
     * Creates a successful API response containing data.
     *
     * @param message success message describing the response
     * @param data    response payload
     * @param <T>     type of the response payload
     * @return successful ApiResponse containing the provided data
     */
    public static <T> ApiResponse<T> success(
            String message,
            T data
    ) {
        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .errors(null)
                .build();

    }

    /**
     * Creates a successful API response without any data payload.
     *
     * @param message success message describing the response
     * @param <T>     type of the response payload
     * @return successful ApiResponse without data
     */
    public static <T> ApiResponse<T> success(
            String message
    ) {
        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(null)
                .errors(null)
                .build();

    }

    /**
     * Creates a failure API response without validation errors.
     *
     * @param message error message describing the failure
     * @param <T>     type of the response payload
     * @return failure ApiResponse without validation errors
     */
    public static <T> ApiResponse<T> failure(
            String message
    ) {
        return ApiResponse.<T>builder()
                .success(false)
                .message(message)
                .data(null)
                .errors(null)
                .build();

    }

    /**
     * Creates a failure API response containing validation errors.
     *
     * @param message error message describing the failure
     * @param errors  map containing field names and corresponding validation messages
     * @param <T>     type of the response payload
     * @return failure ApiResponse containing validation errors
     */
    public static <T> ApiResponse<T> failure(
            String message,
            Map<String, String> errors
    ) {
        return ApiResponse.<T>builder()
                .success(false)
                .message(message)
                .data(null)
                .errors(errors)
                .build();

    }
}