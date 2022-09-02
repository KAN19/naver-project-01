package com.ronald.project01.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseResponse<T> {
    private String status;
    private T data;
    private String message;

    public static <T> BaseResponse<T> success(T t) {
        return new BaseResponse<>("success", t, null);
    }

    public static <T> BaseResponse<T> success(T t, String message) {
        return new BaseResponse<>("success", t, message);
    }

    public static <T> BaseResponse<T> error(String message) {
        return new BaseResponse<>("error", null, message);
    }
}
