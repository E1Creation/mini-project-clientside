package main.java.mii.miniproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class JadwalPelajaran {
    private long id, mata_pelajarans, kelas;
    private int jam_keluar, jam_masuk;
    private String hari;
}
