package main.java.mii.miniproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import main.java.mii.miniproject.model.JadwalPelajaran;
import main.java.mii.miniproject.model.dto.request.AddKelasMatpelToJadwal;

@Service
public class JadwalPelajaranService {
        private RestTemplate restTemplate;

        @Value("${server.baseUrl}/jadwalpelajaran")
        private String url;

        @Autowired
        public JadwalPelajaranService(RestTemplate restTemplate) {
                this.restTemplate = restTemplate;
        }

        public List<JadwalPelajaran> getAll() {
                return restTemplate
                                .exchange(url, HttpMethod.GET, null,
                                                new ParameterizedTypeReference<List<JadwalPelajaran>>() {
                                                })
                                .getBody();
        }

        public JadwalPelajaran getById(Long id) {
                return restTemplate
                                .exchange(url.concat("/" + id), HttpMethod.GET, null,
                                                new ParameterizedTypeReference<JadwalPelajaran>() {
                                                })
                                .getBody();
        }

        public JadwalPelajaran addingMatpelToJadwal(AddKelasMatpelToJadwal addKelasMatpelToJadwal) {
                return restTemplate
                                .exchange(url + "/kelasmatpel", HttpMethod.POST, new HttpEntity(addKelasMatpelToJadwal),
                                                new ParameterizedTypeReference<JadwalPelajaran>() {

                                                })
                                .getBody();

        }

        public JadwalPelajaran create(JadwalPelajaran jadwalPelajaran) {
                return restTemplate
                                .exchange(url, HttpMethod.POST, new HttpEntity(jadwalPelajaran),
                                                new ParameterizedTypeReference<JadwalPelajaran>() {
                                                })
                                .getBody();
        }

        public JadwalPelajaran update(Long id, JadwalPelajaran jadwalPelajaran) {
                return restTemplate
                                .exchange(url.concat("/" + id), HttpMethod.PUT, new HttpEntity(jadwalPelajaran),
                                                new ParameterizedTypeReference<JadwalPelajaran>() {
                                                })
                                .getBody();
        }

        public JadwalPelajaran delete(Long id) {
                return restTemplate
                                .exchange(url.concat("/" + id), HttpMethod.DELETE, null,
                                                new ParameterizedTypeReference<JadwalPelajaran>() {
                                                })
                                .getBody();
        }
}
