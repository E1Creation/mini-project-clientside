package main.java.mii.miniproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Rapot {
    private Long id;
    private int nilai;
    private MataPelajaran mataPelajarans;
    private Entitas entitas;
    private int semester;
}
