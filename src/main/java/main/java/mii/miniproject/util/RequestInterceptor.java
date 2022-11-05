package main.java.mii.miniproject.util;

import java.io.IOException;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author MSI-JO
 */
public class RequestInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(request.getURI().getPath());
        System.out.println(request.getMethod());
        if (!request.getURI().getPath().equals("/login")
                && !request.getURI().getPath().equals("/entitas/registrasi")
                && !request.getURI().getPath().equals("/login/jwt")) {
            System.out.println("Access_token :" + BasicHeader.accessToken());
            request.getHeaders().add("Authorization", "Bearer " +
                    BasicHeader.accessToken());

            // request.getHeaders().add("Authorization", "Basic " +
            // BasicHeader.createBasicToken(authentication.getPrincipal().toString(),
            // authentication.getCredentials().toString()));

        }

        ClientHttpResponse response = execution.execute(request, body);

        return response;

    }

}
