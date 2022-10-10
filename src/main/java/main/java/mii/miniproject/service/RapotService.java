package main.java.mii.miniproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import main.java.mii.miniproject.model.Rapot;

@Service
public class RapotService {
    private RestTemplate restTemplate;

        @Value("${server.baseUrl}/rapot")
        private String url;
    
        @Autowired
        public RapotService(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }
    
        public List<Rapot> getAll() {
            return restTemplate
                    .exchange(url, HttpMethod.GET, null,
                            new ParameterizedTypeReference<List<Rapot>>() {
                            }).getBody();
        }
    
        public Rapot getById(Long id) {
            return restTemplate
                    .exchange(url.concat("/" + id), HttpMethod.GET, null,
                            new ParameterizedTypeReference<Rapot>() {
                            }).getBody();
        }
    
        public Rapot create(Rapot rapot) {
            return restTemplate
                    .exchange(url, HttpMethod.POST, new HttpEntity(rapot),
                            new ParameterizedTypeReference<Rapot>() {
                            }).getBody();
        }
    
        public Rapot update(Long id, Rapot rapot) {
            return restTemplate
                    .exchange(url.concat("/" + id), HttpMethod.PUT, new HttpEntity(rapot),
                            new ParameterizedTypeReference<Rapot>() {
                            }).getBody();
        }
    
        public Rapot delete(Long id) {
            return restTemplate
                    .exchange(url.concat("/" + id), HttpMethod.DELETE, null,
                            new ParameterizedTypeReference<Rapot>() {
                            }).getBody();
        }
}
