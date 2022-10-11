package main.java.mii.miniproject.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Register {
    private String nama;
    private Long nomorInduk;
    private String alamat;
    private String email;
    private String noHp;
    private String username;
    private String password;
}
