package com.dev.farmacia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.farmacia.dtos.TokenJWTDto;
import com.dev.farmacia.dtos.UsuarioAutenticacaoDto;
import com.dev.farmacia.entities.Usuario;
import com.dev.farmacia.services.AutenticacaoService;
import com.dev.farmacia.services.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> efetuarLogin(@RequestBody @Valid UsuarioAutenticacaoDto usuarioAutenticacao){
        var token = new UsernamePasswordAuthenticationToken(usuarioAutenticacao.username(), usuarioAutenticacao.senha());
        var autenticacao = authManager.authenticate(token);

        var tokenJwt = tokenService.gerarToken((Usuario) autenticacao.getPrincipal());
        return ResponseEntity.ok(new TokenJWTDto(tokenJwt));
    }
}
