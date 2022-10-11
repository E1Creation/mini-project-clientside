package main.java.mii.miniproject.service;

import java.util.List;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RoleService {
        private RestTemplate restTemplate;

        @Value("${server.baseUrl}/roles")
        private String url;

        @Autowired
        public RoleService(RestTemplate restTemplate) {
                this.restTemplate = restTemplate;
        }

        public List<Role> getAll() {
                return restTemplate
                                .exchange(url, HttpMethod.GET, null,
                                                new ParameterizedTypeReference<List<Role>>() {
                                                })
                                .getBody();
        }

        public Role getById(Long id) {
                return restTemplate
                                .exchange(url.concat("/" + id), HttpMethod.GET, null,
                                                new ParameterizedTypeReference<Role>() {
                                                })
                                .getBody();
        }

        public Role create(Role role) {
                return restTemplate
                                .exchange(url, HttpMethod.POST, new HttpEntity(role),
                                                new ParameterizedTypeReference<Role>() {
                                                })
                                .getBody();
        }

        public Role update(Long id, Role role) {
                return restTemplate
                                .exchange(url.concat("/" + id), HttpMethod.PUT, new HttpEntity(role),
                                                new ParameterizedTypeReference<Role>() {
                                                })
                                .getBody();
        }

        public Role delete(Long id) {
                return restTemplate
                                .exchange(url.concat("/" + id), HttpMethod.DELETE, null,
                                                new ParameterizedTypeReference<Role>() {
                                                })
                                .getBody();
        }
}