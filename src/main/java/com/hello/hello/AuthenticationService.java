package com.hello.hello;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;

public class AuthenticationService {

    private static final String AUTH_TOKEN_HEADER_NAME = "Authorization";
    private static final String AUTH_TOKEN = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGaXJzdE5hbWUiOiJNb2JhcmFrIiwiTGFzdE5hbWUiOiJIb3NlbiIsIlVzZXJOYW1lIjoibW9iYXJhay5ob3NlbkB0ZWNobm9uZXh0LmNvbSIsIlVzZXJUeXBlIjoiQ01TIiwiaWQiOjMsImp0aSI6IjYwNmQ0MzVmLTRlYWUtNDU1YS1hZmVkLWM4MTA2MGViNzc4OCIsImlhdCI6MTczMDM2MjEwNCwiZXhwIjoxNzMzMTY0ODA1LCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjUwMDEiLCJhdWQiOiJodHRwOi8vbG9jYWxob3N0OjQyMDAifQ.ya9HVvMqVwnv2lVkjdmlftxNolV3G8_l1K41E69gzfE";

    public static Authentication getAuthentication(HttpServletRequest request) {
        String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);
        if (apiKey == null) {
            throw new BadCredentialsException("Invalid API Key");
        }

        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
    }
}