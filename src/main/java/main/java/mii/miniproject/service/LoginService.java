package main.java.mii.miniproject.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import main.java.mii.miniproject.model.Entitas;
import main.java.mii.miniproject.model.dto.request.LoginRequest;
import main.java.mii.miniproject.model.dto.request.Register;
import main.java.mii.miniproject.model.dto.response.LoginResponse;
import main.java.mii.miniproject.model.dto.response.LoginResponseWithJWT;
import main.java.mii.miniproject.model.dto.response.UserData;

@Service
public class LoginService {

    private RestTemplate restTemplate;

    @Value("${server.baseUrl}")
    private String url;

    @Autowired
    public LoginService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean login(LoginRequest loginRequest) {
        ResponseEntity<LoginResponse> respon = restTemplate.exchange(url + "/login", HttpMethod.POST,
                new HttpEntity(loginRequest),
                new ParameterizedTypeReference<LoginResponse>() {

                });
        System.out.println(respon);
        if (respon.getStatusCode() == HttpStatus.OK) {
            setAuthentication(respon.getBody(), loginRequest.getPassword());
            return true;
        }
        return false;
    }

    public void setAuthentication(LoginResponse res, String password) {
        Collection<GrantedAuthority> authorities = res.getAuthorities()
                .stream().map(authority -> new SimpleGrantedAuthority(authority)).collect(Collectors.toList());

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                res.getUsername(),
                password,
                authorities);
        authToken.setDetails(res);
        SecurityContextHolder.getContext().setAuthentication(authToken);
        LoginResponse checkResponse = (LoginResponse) SecurityContextHolder.getContext().getAuthentication()
                .getDetails();
        System.out.println(checkResponse.getId());
    }

    public boolean loginWithJWT(LoginRequest loginRequest) {
        ResponseEntity<LoginResponseWithJWT> respon = restTemplate.exchange(url + "/login/jwt", HttpMethod.POST,
                new HttpEntity(loginRequest),
                new ParameterizedTypeReference<LoginResponseWithJWT>() {

                });
        System.out.println(respon);
        if (respon.getStatusCode() == HttpStatus.OK) {
            setAuthenticationWithJWT(respon.getBody(), loginRequest.getPassword());
            return true;
        }
        return false;
    }

    public void setAuthenticationWithJWT(LoginResponseWithJWT res, String password) {
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(res.getAccess_token());
        Long id = decodedJWT.getClaim("id").asLong();
        String username = decodedJWT.getSubject();
        String email = decodedJWT.getClaim("email").asString();

        String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                username,
                password,
                authorities);
        authToken.setDetails(new UserData(id, email,
                res.getAccess_token(), res.getRefresh_token()));
        SecurityContextHolder.getContext().setAuthentication(authToken);
        UserData checkResponse = (UserData) SecurityContextHolder.getContext().getAuthentication()
                .getDetails();
        System.out.println(checkResponse.getAccess_token());
    }

    public boolean Register(Register register) {
        ResponseEntity<Entitas> respon = restTemplate.exchange(url.concat("/entitas"), HttpMethod.POST,
                new HttpEntity(register),
                new ParameterizedTypeReference<Entitas>() {
                });
        if (respon.getStatusCode() == HttpStatus.CREATED) {
            return true;
        }
        return false;
    }

}
