package main.java.mii.miniproject.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Kelas {
    private Long id;

    private String tingkatan;

    private String kode;

    private List<JadwalPelajaran> jadwalPelajarans;
}
