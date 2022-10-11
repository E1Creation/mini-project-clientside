package main.java.mii.miniproject.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private Long id;
    private String username;
    private String password;
    private Boolean isAccountLocked;
    private Boolean isEnabled;
    private Entitas entitas;
    List<Role> roles;
}
