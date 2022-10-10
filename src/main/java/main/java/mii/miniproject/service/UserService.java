package main.java.mii.miniproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import main.java.mii.miniproject.model.User;

@Service
public class UserService {
    private RestTemplate restTemplate;

        @Value("${server.baseUrl}/country")
        private String url;
    
        @Autowired
        public UserService(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }
    
        public List<User> getAll() {
            return restTemplate
                    .exchange(url, HttpMethod.GET, null,
                            new ParameterizedTypeReference<List<User>>() {
                            }).getBody();
        }
    
        public User getById(Long id) {
            return restTemplate
                    .exchange(url.concat("/" + id), HttpMethod.GET, null,
                            new ParameterizedTypeReference<User>() {
                            }).getBody();
        }
    
        public User create(User user) {
            return restTemplate
                    .exchange(url, HttpMethod.POST, new HttpEntity(user),
                            new ParameterizedTypeReference<User>() {
                            }).getBody();
        }
    
        public User update(Long id, User user) {
            return restTemplate
                    .exchange(url.concat("/" + id), HttpMethod.PUT, new HttpEntity(user),
                            new ParameterizedTypeReference<User>() {
                            }).getBody();
        }
    
        public User delete(Long id) {
            return restTemplate
                    .exchange(url.concat("/" + id), HttpMethod.DELETE, null,
                            new ParameterizedTypeReference<User>() {
                            }).getBody();
        }
}
