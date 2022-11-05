package main.java.mii.miniproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import main.java.mii.miniproject.model.Entitas;
import main.java.mii.miniproject.model.dto.response.CountEntitasMatpel;

@Service
public class EntitasService {
        private RestTemplate restTemplate;

        @Value("${server.baseUrl}/entitas")
        private String url;

        @Autowired
        public EntitasService(RestTemplate restTemplate) {
                this.restTemplate = restTemplate;
        }

        public List<Entitas> getAll() {
                System.out.println(restTemplate
                                .exchange(url, HttpMethod.GET, null,
                                                new ParameterizedTypeReference<List<Entitas>>() {
                                                })
                                .getBody());
                return restTemplate
                                .exchange(url, HttpMethod.GET, null,
                                                new ParameterizedTypeReference<List<Entitas>>() {
                                                })
                                .getBody();
        }

        public Entitas getById(Long id) {
                return restTemplate
                                .exchange(url.concat("/" + id), HttpMethod.GET, null,
                                                new ParameterizedTypeReference<Entitas>() {
                                                })
                                .getBody();
        }

        public List<Entitas> getAllByRole(Long id) {
                return restTemplate.exchange(url.concat("/role/" + id), HttpMethod.GET, null,
                                new ParameterizedTypeReference<List<Entitas>>() {

                                }).getBody();
        }

        public Entitas create(Entitas entitas) {
                return restTemplate
                                .exchange(url, HttpMethod.POST, new HttpEntity(entitas),
                                                new ParameterizedTypeReference<Entitas>() {
                                                })
                                .getBody();
        }

        public Entitas update(Long id, Entitas entitas) {
                return restTemplate
                                .exchange(url.concat("/" + id), HttpMethod.PUT, new HttpEntity(entitas),
                                                new ParameterizedTypeReference<Entitas>() {
                                                })
                                .getBody();
        }

        public Entitas delete(Long id) {
                return restTemplate
                                .exchange(url.concat("/" + id), HttpMethod.DELETE, null,
                                                new ParameterizedTypeReference<Entitas>() {
                                                })
                                .getBody();
        }

        public CountEntitasMatpel getCount() {
                return restTemplate.exchange(url + "/count", HttpMethod.GET, null,
                                new ParameterizedTypeReference<CountEntitasMatpel>() {

                                }).getBody();
        }
}