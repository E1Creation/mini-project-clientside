package main.java.mii.miniproject.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserData {
    private Long id;
    private String email;
    private String access_token;
    private String refresh_token;
}
