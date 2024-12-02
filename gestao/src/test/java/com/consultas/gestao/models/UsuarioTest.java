package com.consultas.gestao.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

  @Test
  void testCriacaoUsuarioValido() {
    Usuario usuario = new Usuario("João", "joao@email.com", "senhaSegura123");

    assertNotNull(usuario);
    assertEquals("João", usuario.getNome());
    assertEquals("joao@email.com", usuario.getEmail());
    assertEquals("senhaSegura123", usuario.getSenha());
  }

  @Test
  void testAlteracaoDeDadosUsuario() {
    // Testa a alteração dos dados do usuário
    Usuario usuario = new Usuario("João", "joao@email.com", "senhaSegura123");

    // Alterando dados
    usuario.setNome("Carlos");
    usuario.setEmail("carlos@email.com");
    usuario.setSenha("novaSenha123");

    // Verifica se as alterações foram aplicadas corretamente
    assertEquals("Carlos", usuario.getNome());
    assertEquals("carlos@email.com", usuario.getEmail());
    assertEquals("novaSenha123", usuario.getSenha());
  }

  @Test
  void testValidacaoDeSenha() {

    Usuario usuario = new Usuario("João", "joao@email.com", "senhaSegura123");

    assertTrue(usuario.validarSenha("senhaSegura123"));

    assertFalse(usuario.validarSenha("senhaErrada123"));

    assertFalse(usuario.validarSenha("short"));

    assertFalse(usuario.validarSenha("umaSenhaMuitoLonga123"));
  }

  @Test
  void testCamposObrigatoriosPreenchidos() {

    Usuario usuarioValido = new Usuario("João", "joao@email.com", "senhaSegura123");
    assertTrue(usuarioValido.camposObrigatoriosPreenchidos());

    Usuario usuarioInvalidoNomeVazio = new Usuario("", "joao@email.com", "senhaSegura123");
    Usuario usuarioInvalidoEmailVazio = new Usuario("João", "", "senhaSegura123");
    Usuario usuarioInvalidoSenhaVazia = new Usuario("João", "joao@email.com", "");

    assertFalse(usuarioInvalidoNomeVazio.camposObrigatoriosPreenchidos());
    assertFalse(usuarioInvalidoEmailVazio.camposObrigatoriosPreenchidos());
    assertFalse(usuarioInvalidoSenhaVazia.camposObrigatoriosPreenchidos());

    Usuario usuarioComCamposNulos = new Usuario(null, null, null);
    assertFalse(usuarioComCamposNulos.camposObrigatoriosPreenchidos());
  }

  @Test
  void testValidacaoDeSenhaComCamposVaziosOuNulos() {
    Usuario usuario = new Usuario("João", "joao@email.com", "senhaSegura123");

    assertFalse(usuario.validarSenha(""));

    assertFalse(usuario.validarSenha(null));
  }

  @Test
  void testUsuarioComCamposNulos() {
    Usuario usuario = new Usuario(null, null, null);
    assertFalse(usuario.camposObrigatoriosPreenchidos());
  }
}
