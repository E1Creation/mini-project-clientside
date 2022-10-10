package main.java.mii.miniproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import main.java.mii.miniproject.model.Kelas;

@Service
public class KelasService {
        private RestTemplate restTemplate;

        @Value("${server.baseUrl}/jadwal-pelajaran")
        private String url;
    
        @Autowired
        public KelasService(RestTemplate restTemplate){
            this.restTemplate=restTemplate;
        }
    
        public List<Kelas> getAll() {
            return restTemplate
                    .exchange(url, HttpMethod.GET, null,
                            new ParameterizedTypeReference<List<Kelas>>() {
                            }).getBody();
        }
    
        public Kelas getById(Long id) {
            return restTemplate
                    .exchange(url.concat("/" + id), HttpMethod.GET, null,
                            new ParameterizedTypeReference<Kelas>() {
                            }).getBody();
        }
    
        public Kelas create(Kelas kelas) {
            return restTemplate
                    .exchange(url, HttpMethod.POST, new HttpEntity(kelas),
                            new ParameterizedTypeReference<Kelas>() {
                            }).getBody();
        }
    
        public Kelas update(Long id, Kelas kelas) {
            return restTemplate
                    .exchange(url.concat("/" + id), HttpMethod.PUT, new HttpEntity(kelas),
                            new ParameterizedTypeReference<Kelas>() {
                            }).getBody();
        }
    
        public Kelas delete(Long id) {
            return restTemplate
                    .exchange(url.concat("/" + id), HttpMethod.DELETE, null,
                            new ParameterizedTypeReference<Kelas>() {
                            }).getBody();
        }    
}