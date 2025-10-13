package com.ecommerce.project.payload;

import com.ecommerce.project.security.response.UserInfoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseCookie;

@Data
//@AllArgsConstructor
public class AuthenticationResult {

    private final UserInfoResponse response;
    private final ResponseCookie jwtCookie;

    // All-args constructor
    public AuthenticationResult(UserInfoResponse response, ResponseCookie jwtCookie) {
        this.response = response;
        this.jwtCookie = jwtCookie;
    }

    // Getters (fields are final, so only getters needed)
    public UserInfoResponse getResponse() {
        return response;
    }

    public ResponseCookie getJwtCookie() {
        return jwtCookie;
    }

    @Override
    public String toString() {
        return "AuthenticationResult{" +
                "response=" + response +
                ", jwtCookie=" + jwtCookie +
                '}';
    }
}