package com.alura.foroHub.infrastructure.controller;


import com.alura.foroHub.application.dto.authentication.AutenticationDataDto;
import com.alura.foroHub.application.dto.authentication.CreateUserDtoEntrance;
import com.alura.foroHub.application.dto.authentication.TokenDataDtoJWT;
import com.alura.foroHub.domain.useCases.user.CreateUser;
import com.alura.foroHub.infrastructure.security.CustomUserDetails;
import com.alura.foroHub.infrastructure.security.TokenService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class AuthenticationController {

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final CreateUser createUser;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity login(@RequestBody @Valid AutenticationDataDto autenticationDataDto) {
        //el DTO es convertido en un DTO propio de spring security el cual después usa en la clase SecurityUserDetailService, este es transformado con el metodo UsernamePasswordAuthenticationToken, para que AuthenticationManager pueda usarlo
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(autenticationDataDto.userName(), autenticationDataDto.userPassword());
        var autentication = authenticationManager.authenticate(authenticationToken);

        String tokenJWT = tokenService.generateToken((CustomUserDetails) autentication.getPrincipal());

        return ResponseEntity.ok(new TokenDataDtoJWT(tokenJWT));
    }

    @PostMapping(value = "/createUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@RequestBody @Valid CreateUserDtoEntrance createUserDtoEntrance) {

        createUser.execute(createUserDtoEntrance);

        return ResponseEntity.ok().build();
    }
}
