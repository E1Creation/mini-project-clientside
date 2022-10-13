package main.java.mii.miniproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import main.java.mii.miniproject.model.MataPelajaran;
import main.java.mii.miniproject.model.dto.request.AddEntitasToMatpel;

@Service
public class MataPelajaranService {
        private RestTemplate restTemplate;

        @Value("${server.baseUrl}/matapelajaran")
        private String url;

        @Autowired
        public MataPelajaranService(RestTemplate restTemplate) {
                this.restTemplate = restTemplate;
        }

        public List<MataPelajaran> getAll() {
                return restTemplate
                                .exchange(url, HttpMethod.GET, null,
                                                new ParameterizedTypeReference<List<MataPelajaran>>() {
                                                })
                                .getBody();
        }

        public MataPelajaran getById(Long id) {
                return restTemplate
                                .exchange(url.concat("/" + id), HttpMethod.GET, null,
                                                new ParameterizedTypeReference<MataPelajaran>() {
                                                })
                                .getBody();
        }

        public MataPelajaran create(MataPelajaran mataPelajaran) {
                return restTemplate
                                .exchange(url, HttpMethod.POST, new HttpEntity(mataPelajaran),
                                                new ParameterizedTypeReference<MataPelajaran>() {
                                                })
                                .getBody();
        }

        public MataPelajaran createEntitasToMatpel(AddEntitasToMatpel addEntitasToMatpel) {
                return restTemplate.exchange(url + "/entitas", HttpMethod.POST, new HttpEntity(addEntitasToMatpel),
                                new ParameterizedTypeReference<MataPelajaran>() {

                                }).getBody();
        }

        public MataPelajaran update(Long id, MataPelajaran mataPelajaran) {
                return restTemplate
                                .exchange(url.concat("/" + id), HttpMethod.PUT, new HttpEntity(mataPelajaran),
                                                new ParameterizedTypeReference<MataPelajaran>() {
                                                })
                                .getBody();
        }

        public MataPelajaran delete(Long id) {
                return restTemplate
                                .exchange(url.concat("/" + id), HttpMethod.DELETE, null,
                                                new ParameterizedTypeReference<MataPelajaran>() {
                                                })
                                .getBody();
        }
}
