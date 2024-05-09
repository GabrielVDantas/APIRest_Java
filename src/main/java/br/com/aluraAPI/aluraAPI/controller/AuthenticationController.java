package br.com.aluraAPI.aluraAPI.controller;

import br.com.aluraAPI.aluraAPI.domain.user.AuthenticationInfoDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/start_login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationInfoDTO authenticationInfoDTO) {
        var token = new UsernamePasswordAuthenticationToken(authenticationInfoDTO.email(), authenticationInfoDTO.password());
        Authentication authentication = authenticationManager.authenticate(token);

        return ResponseEntity.ok().build();
    }
}
