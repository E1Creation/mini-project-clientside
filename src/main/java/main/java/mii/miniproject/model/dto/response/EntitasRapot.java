package main.java.mii.miniproject.model.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.java.mii.miniproject.model.Rapot;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntitasRapot {
    private Long id;
    private Long nomorInduk;
    private String nama;
    private String alamat;
    private String email;
    private String noHp;
    private List<Rapot> rapots;
}
