package main.java.mii.miniproject.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MataPelajaran {
    private Long id;
    private String nama;

    private List<Entitas> entitas;
    private List<JadwalPelajaran> jadwalPelajaran;

    private List<Rapot> rapots;
}
