package main.java.mii.miniproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class JadwalPelajaran {
    private Long id;
    private String hari;
    private int jamMasuk;
    private int jamKeluar;

    private MataPelajaran mataPelajarans;

    private Kelas kelas;
}
