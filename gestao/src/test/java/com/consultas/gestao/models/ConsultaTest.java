package com.consultas.gestao.models;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class ConsultaTest {

  @Test
  void testCriacaoConsultaValida() {
    Paciente paciente =
        new Paciente("Carlos Silva", "carlos@email.com", "senhaSegura", "123.456.789-00");
    Medico medico =
        new Medico("Dr. João", "dr.joao@email.com", "senhaSegura123", "CRM12345", "Cardiologia");
    LocalDateTime dataHora = LocalDateTime.now().plusDays(1);
    Consulta consulta = new Consulta(paciente, medico, dataHora);

    assertNotNull(consulta);
    assertEquals(paciente, consulta.getPaciente());
    assertEquals(medico, consulta.getMedico());
    assertEquals(dataHora, consulta.getDataHora());
    assertFalse(consulta.isCancelada());
  }

  @Test
  void testCancelarConsulta() {
    Paciente paciente =
        new Paciente("Carlos Silva", "carlos@email.com", "senhaSegura", "123.456.789-00");
    Medico medico =
        new Medico("Dr. João", "dr.joao@email.com", "senhaSegura123", "CRM12345", "Cardiologia");
    LocalDateTime dataHora = LocalDateTime.now().plusDays(1);
    Consulta consulta = new Consulta(paciente, medico, dataHora);

    consulta.cancelar();
    assertTrue(consulta.isCancelada());
  }

  @Test
  void testValidarDadosConsultaValida() {
    Paciente paciente =
        new Paciente("Carlos Silva", "carlos@email.com", "senhaSegura", "123.456.789-00");
    Medico medico =
        new Medico("Dr. João", "dr.joao@email.com", "senhaSegura123", "CRM12345", "Cardiologia");
    LocalDateTime dataHora = LocalDateTime.now().plusDays(1);
    Consulta consulta = new Consulta(paciente, medico, dataHora);

    assertTrue(consulta.validarDados());
  }

  @Test
  void testValidarDadosConsultaPacienteNulo() {
    Medico medico =
        new Medico("Dr. João", "dr.joao@email.com", "senhaSegura123", "CRM12345", "Cardiologia");
    LocalDateTime dataHora = LocalDateTime.now().plusDays(1);
    Consulta consulta = new Consulta(null, medico, dataHora);

    assertFalse(consulta.validarDados());
  }

  @Test
  void testValidarDadosConsultaMedicoNulo() {
    Paciente paciente =
        new Paciente("Carlos Silva", "carlos@email.com", "senhaSegura", "123.456.789-00");
    LocalDateTime dataHora = LocalDateTime.now().plusDays(1);
    Consulta consulta = new Consulta(paciente, null, dataHora);

    assertFalse(consulta.validarDados());
  }

  @Test
  void testValidarDadosConsultaDataHoraNulo() {
    Paciente paciente =
        new Paciente("Carlos Silva", "carlos@email.com", "senhaSegura", "123.456.789-00");
    Medico medico =
        new Medico("Dr. João", "dr.joao@email.com", "senhaSegura123", "CRM12345", "Cardiologia");
    Consulta consulta = new Consulta(paciente, medico, null);

    assertFalse(consulta.validarDados());
  }

  @Test
  void testValidarDadosConsultaDataHoraPassada() {
    Paciente paciente =
        new Paciente("Carlos Silva", "carlos@email.com", "senhaSegura", "123.456.789-00");
    Medico medico =
        new Medico("Dr. João", "dr.joao@email.com", "senhaSegura123", "CRM12345", "Cardiologia");
    LocalDateTime dataHora = LocalDateTime.now().minusDays(1);
    Consulta consulta = new Consulta(paciente, medico, dataHora);

    assertFalse(consulta.validarDados());
  }
}
