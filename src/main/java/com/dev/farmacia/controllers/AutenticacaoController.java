package com.dev.farmacia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.farmacia.dtos.UsuarioAutenticacaoDto;
import com.dev.farmacia.services.AutenticacaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authManager;

    @PostMapping
    public ResponseEntity<?> efetuarLogin(@RequestBody @Valid UsuarioAutenticacaoDto usuarioAutenticacao){
        var token = new UsernamePasswordAuthenticationToken(usuarioAutenticacao.username(), usuarioAutenticacao.senha());
        var autenticacao = authManager.authenticate(token);

        return ResponseEntity.ok().build();
    }
}
