package com.consultas.gestao.services;

import static org.junit.jupiter.api.Assertions.*;

import com.consultas.gestao.models.Usuario;
import org.junit.jupiter.api.Test;

class UsuarioServiceTest {

  @Test
  void testCadastrarUsuarioValido() {
    Usuario usuario = new Usuario("Carlos Silva", "carlos@email.com", "senhaSegura");
    UsuarioService usuarioService = new UsuarioService();

    assertTrue(usuarioService.cadastrarUsuario(usuario));
  }

  @Test
  void testCadastrarUsuarioJaExistente() {
    Usuario usuario1 = new Usuario("Carlos Silva", "carlos@email.com", "senhaSegura");
    Usuario usuario2 = new Usuario("Ana Souza", "carlos@email.com", "outraSenha");
    UsuarioService usuarioService = new UsuarioService();
    usuarioService.cadastrarUsuario(usuario1);

    assertFalse(usuarioService.cadastrarUsuario(usuario2));
  }

  @Test
  void testCadastrarUsuarioCamposObrigatoriosNaoPreenchidos() {
    Usuario usuario = new Usuario("Carlos Silva", "", "senhaSegura");
    UsuarioService usuarioService = new UsuarioService();

    assertFalse(usuarioService.cadastrarUsuario(usuario));
  }

  @Test
  void testAutenticarUsuarioValido() {
    Usuario usuario = new Usuario("Carlos Silva", "carlos@email.com", "senhaSegura");
    UsuarioService usuarioService = new UsuarioService();
    usuarioService.cadastrarUsuario(usuario);

    Usuario usuarioAutenticado = usuarioService.autenticar("carlos@email.com", "senhaSegura");

    assertNotNull(usuarioAutenticado);
    assertEquals(usuario.getEmail(), usuarioAutenticado.getEmail());
  }

  @Test
  void testAutenticarUsuarioInvalidoSenhaErrada() {
    Usuario usuario = new Usuario("Carlos Silva", "carlos@email.com", "senhaSegura");
    UsuarioService usuarioService = new UsuarioService();
    usuarioService.cadastrarUsuario(usuario);

    Usuario usuarioAutenticado = usuarioService.autenticar("carlos@email.com", "senhaErrada");

    assertNull(usuarioAutenticado);
  }

  @Test
  void testAutenticarUsuarioNaoCadastrado() {
    UsuarioService usuarioService = new UsuarioService();

    Usuario usuarioAutenticado = usuarioService.autenticar("naoexistente@email.com", "senhaSegura");

    assertNull(usuarioAutenticado);
  }
}
