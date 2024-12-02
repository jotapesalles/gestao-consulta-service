package com.consultas.gestao.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PacienteTest {

  @Test
  void testCriacaoPacienteValido() {
    Paciente paciente = new Paciente("João", "joao@email.com", "senhaSegura123", "123.456.789-00");

    assertNotNull(paciente);
    assertEquals("João", paciente.getNome());
    assertEquals("joao@email.com", paciente.getEmail());
    assertEquals("senhaSegura123", paciente.getSenha());
    assertEquals("123.456.789-00", paciente.getCpf());
  }

  @Test
  void testAlteracaoDeDadosPaciente() {
    Paciente paciente = new Paciente("João", "joao@email.com", "senhaSegura123", "123.456.789-00");

    paciente.setNome("Carlos");
    paciente.setEmail("carlos@email.com");
    paciente.setSenha("novaSenha123");
    paciente.setCpf("987.654.321-00");

    assertEquals("Carlos", paciente.getNome());
    assertEquals("carlos@email.com", paciente.getEmail());
    assertEquals("novaSenha123", paciente.getSenha());
    assertEquals("987.654.321-00", paciente.getCpf());
  }

  @Test
  void testValidacaoDeCpf() {
    Paciente paciente = new Paciente("João", "joao@email.com", "senhaSegura123", "123.456.789-00");

    assertTrue(paciente.validarCpf());

    paciente.setCpf("12345678900");
    assertFalse(paciente.validarCpf());

    paciente.setCpf("123.45x.789-00");
    assertFalse(paciente.validarCpf());

    paciente.setCpf(null);
    assertFalse(paciente.validarCpf());
  }

  @Test
  void testCamposObrigatoriosPreenchidosPaciente() {

    Paciente pacienteValido =
        new Paciente("João", "joao@email.com", "senhaSegura123", "123.456.789-00");
    assertTrue(pacienteValido.camposObrigatoriosPreenchidos());

    Paciente pacienteInvalidoCpfVazio =
        new Paciente("João", "joao@email.com", "senhaSegura123", "");
    assertFalse(pacienteInvalidoCpfVazio.camposObrigatoriosPreenchidos());

    Paciente pacienteInvalidoNomeVazio =
        new Paciente("", "joao@email.com", "senhaSegura123", "123.456.789-00");
    assertFalse(pacienteInvalidoNomeVazio.camposObrigatoriosPreenchidos());

    Paciente pacienteInvalidoEmailVazio =
        new Paciente("João", "", "senhaSegura123", "123.456.789-00");
    assertFalse(pacienteInvalidoEmailVazio.camposObrigatoriosPreenchidos());

    Paciente pacienteComCamposNulos = new Paciente(null, null, null, null);
    assertFalse(pacienteComCamposNulos.camposObrigatoriosPreenchidos());
  }

  @Test
  void testValidacaoDeCpfComCamposVaziosOuNulos() {
    Paciente paciente = new Paciente("João", "joao@email.com", "senhaSegura123", "123.456.789-00");

    paciente.setCpf("");
    assertFalse(paciente.validarCpf());

    paciente.setCpf(null);
    assertFalse(paciente.validarCpf());
  }
}
