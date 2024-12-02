package com.consultas.gestao.controllers;

import com.consultas.gestao.models.Usuario;
import com.consultas.gestao.services.UsuarioService;

public class LoginController {
  private final UsuarioService usuarioService;
  private int tentativasFalhas = 0;
  private long ultimaTentativaFalha = 0;

  public LoginController(UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
  }

  public boolean login(String email, String senha) {
    if (tentativasFalhas >= 3
        && System.currentTimeMillis() - ultimaTentativaFalha < 10 * 60 * 1000) {
      System.out.println("Aguarde 10 minutos para tentar novamente.");
      return false;
    }

    Usuario usuario = usuarioService.autenticar(email, senha);
    if (usuario != null) {
      tentativasFalhas = 0;
      System.out.println("Login bem-sucedido para o usuário: " + usuario.getNome());
      return true;
    }

    tentativasFalhas++;
    ultimaTentativaFalha = System.currentTimeMillis();
    System.out.println("Falha no login. Verifique suas credenciais.");
    return false;
  }
}
