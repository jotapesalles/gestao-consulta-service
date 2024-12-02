package com.consultas.gestao.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MedicoTest {

  @Test
  void testCriacaoMedicoValido() {
    Medico medico =
        new Medico("Dr. João", "dr.joao@email.com", "senhaSegura123", "CRM12345", "Cardiologia");
    assertNotNull(medico);
    assertEquals("Dr. João", medico.getNome());
    assertEquals("dr.joao@email.com", medico.getEmail());
    assertEquals("senhaSegura123", medico.getSenha());
    assertEquals("CRM12345", medico.getCrm());
    assertEquals("Cardiologia", medico.getEspecialidade());
  }

  @Test
  void testAlteracaoDeDadosMedico() {
    Medico medico =
        new Medico("Dr. João", "dr.joao@email.com", "senhaSegura123", "CRM12345", "Cardiologia");
    medico.setNome("Dr. Carlos");
    medico.setEmail("dr.carlos@email.com");
    medico.setSenha("novaSenha123");
    medico.setCrm("CRM54321");
    medico.setEspecialidade("Neurologia");
    assertEquals("Dr. Carlos", medico.getNome());
    assertEquals("dr.carlos@email.com", medico.getEmail());
    assertEquals("novaSenha123", medico.getSenha());
    assertEquals("CRM54321", medico.getCrm());
    assertEquals("Neurologia", medico.getEspecialidade());
  }

  @Test
  void testValidacaoDeCrm() {
    Medico medico =
        new Medico("Dr. João", "dr.joao@email.com", "senhaSegura123", "CRM12345", "Cardiologia");
    assertTrue(medico.validarCrm());
    medico.setCrm("12345");
    assertFalse(medico.validarCrm());
    medico.setCrm("CRMabc");
    assertFalse(medico.validarCrm());
    medico.setCrm(null);
    assertFalse(medico.validarCrm());
  }

  @Test
  void testCamposObrigatoriosPreenchidosMedico() {
    Medico medicoValido =
        new Medico("Dr. João", "dr.joao@email.com", "senhaSegura123", "CRM12345", "Cardiologia");
    assertTrue(medicoValido.camposObrigatoriosPreenchidos());
    Medico medicoInvalidoCrmVazio =
        new Medico("Dr. João", "dr.joao@email.com", "senhaSegura123", "", "Cardiologia");
    assertFalse(medicoInvalidoCrmVazio.camposObrigatoriosPreenchidos());
    Medico medicoInvalidoNomeVazio =
        new Medico("", "dr.joao@email.com", "senhaSegura123", "CRM12345", "Cardiologia");
    assertFalse(medicoInvalidoNomeVazio.camposObrigatoriosPreenchidos());
    Medico medicoInvalidoEmailVazio =
        new Medico("Dr. João", "", "senhaSegura123", "CRM12345", "Cardiologia");
    assertFalse(medicoInvalidoEmailVazio.camposObrigatoriosPreenchidos());
    Medico medicoComCamposNulos = new Medico(null, null, null, null, null);
    assertFalse(medicoComCamposNulos.camposObrigatoriosPreenchidos());
  }
}
