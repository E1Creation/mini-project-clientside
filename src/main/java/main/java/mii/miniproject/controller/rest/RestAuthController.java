package main.java.mii.miniproject.controller.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import main.java.mii.miniproject.model.dto.request.Register;
import main.java.mii.miniproject.service.LoginService;

@RestController
@AllArgsConstructor
@RequestMapping("api")
public class RestAuthController {
    private LoginService service;

    @PostMapping("/register")
    public Boolean register(@RequestBody Register register) {
        return service.Register(register);
    }
}
