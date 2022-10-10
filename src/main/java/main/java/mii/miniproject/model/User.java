package main.java.mii.miniproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private long id;
    private boolean is_account_locked, is_enabled;
    private String username, password;
}
