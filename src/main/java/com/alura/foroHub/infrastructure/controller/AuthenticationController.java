package com.alura.foroHub.infrastructure.controller;


import com.alura.foroHub.application.dto.AutenticationDataDto;
import com.alura.foroHub.application.dto.TokenDataDtoJWT;
import com.alura.foroHub.domain.model.UserModel;
import com.alura.foroHub.infrastructure.security.TokenService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class AuthenticationController {

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AutenticationDataDto autenticationDataDto) {
        //el DTO es convertido en un DTO propio de spring security el cual después usa en la clase SecurityUserDetailService, este es transformado con el metodo UsernamePasswordAuthenticationToken, para que AuthenticationManager pueda usarlo
        var authenticationToken = new UsernamePasswordAuthenticationToken(autenticationDataDto.userName(), autenticationDataDto.userPassword());
        var autentication = authenticationManager.authenticate(authenticationToken);

        String tokenJWT = tokenService.generateToken((UserModel) autentication.getPrincipal());

        return ResponseEntity.ok(new TokenDataDtoJWT(tokenJWT));
    }

}
