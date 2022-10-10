package main.java.mii.miniproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Rapot {
    private long id, mata_pelajarans;
    private int nilai, semester;
}
