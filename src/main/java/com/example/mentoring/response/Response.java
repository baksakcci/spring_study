package com.example.mentoring.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Response {
    private boolean success;
    private int code;
    private Result result;

    // 데이터가 없이 성공 반환해주는 경우
    public static Response success() {
        return new Response(true, 0 ,null);
    }

    // 데이터를 포함해서 성공 반환해주는 경우
    public static <T> Response success(T data) {
        return new Response(true, 0, new Success<>(data));
    }

    // 에러 발생 시 반환해주는 경우
    public static Response failure(int code, String msg) {
        return new Response(false, code, new Failure(msg));
    }
}
