package com.consultas.gestao.controllers;

import static org.junit.jupiter.api.Assertions.*;

import com.consultas.gestao.models.Usuario;
import com.consultas.gestao.services.UsuarioService;
import org.junit.jupiter.api.Test;

class LoginControllerTest {

  @Test
  void testLoginValido() {
    Usuario usuario = new Usuario("Carlos Silva", "carlos@email.com", "senhaSegura");
    UsuarioService usuarioService = new UsuarioService();
    usuarioService.cadastrarUsuario(usuario);
    LoginController loginController = new LoginController(usuarioService);

    boolean resultado = loginController.login("carlos@email.com", "senhaSegura");

    assertTrue(resultado);
  }

  @Test
  void testLoginInvalidoComSenhaErrada() {
    Usuario usuario = new Usuario("Carlos Silva", "carlos@email.com", "senhaSegura");
    UsuarioService usuarioService = new UsuarioService();
    usuarioService.cadastrarUsuario(usuario);
    LoginController loginController = new LoginController(usuarioService);

    boolean resultado = loginController.login("carlos@email.com", "senhaErrada");

    assertFalse(resultado);
  }

  @Test
  void testLoginInvalidoComEmailNaoCadastrado() {
    UsuarioService usuarioService = new UsuarioService();
    LoginController loginController = new LoginController(usuarioService);

    boolean resultado = loginController.login("usuarioNaoExistente@email.com", "senhaSegura");

    assertFalse(resultado);
  }

  @Test
  void testBloqueioDeLoginAposTresTentativasFalhas() throws InterruptedException {
    Usuario usuario = new Usuario("Carlos Silva", "carlos@email.com", "senhaSegura");
    UsuarioService usuarioService = new UsuarioService();
    usuarioService.cadastrarUsuario(usuario);
    LoginController loginController = new LoginController(usuarioService);

    loginController.login("carlos@email.com", "senhaErrada");
    loginController.login("carlos@email.com", "senhaErrada");
    loginController.login("carlos@email.com", "senhaErrada");

    boolean resultado = loginController.login("carlos@email.com", "senhaSegura");

    assertFalse(resultado);
  }
}
