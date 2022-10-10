package main.java.mii.miniproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Entitas {
    private  String nama, alamat, email, no_hp;
    private long id, nomor_induk;
}
