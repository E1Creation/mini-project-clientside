package main.java.mii.miniproject.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entitas {
    private Long nomorInduk;
    private String nama;
    private String alamat;
    private String email;
    private String noHp;

    List<MataPelajaran> mataPelajarans;

    private User user;
    private List<Rapot> rapots;
}
