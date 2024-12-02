package com.consultas.gestao.services;

import static org.junit.jupiter.api.Assertions.*;

import com.consultas.gestao.models.Consulta;
import com.consultas.gestao.models.Medico;
import com.consultas.gestao.models.Paciente;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;

class AgendamentoServiceTest {

  @Test
  void testAgendarConsultaValida() {
    Paciente paciente =
        new Paciente("Carlos Silva", "carlos@email.com", "senhaSegura", "123.456.789-00");
    Medico medico =
        new Medico("Dr. João", "dr.joao@email.com", "senhaSegura123", "CRM12345", "Cardiologia");
    LocalDateTime dataHora = LocalDateTime.now().plusDays(1);
    Consulta consulta = new Consulta(paciente, medico, dataHora);
    AgendamentoService agendamentoService = new AgendamentoService();

    assertTrue(agendamentoService.agendarConsulta(consulta));
    assertEquals(1, agendamentoService.listarConsultas().size());
  }

  @Test
  void testAgendarConsultaInvalida() {
    Paciente paciente =
        new Paciente("Carlos Silva", "carlos@email.com", "senhaSegura", "123.456.789-00");
    Medico medico =
        new Medico("Dr. João", "dr.joao@email.com", "senhaSegura123", "CRM12345", "Cardiologia");
    LocalDateTime dataHora = LocalDateTime.now().minusDays(1);
    Consulta consulta = new Consulta(paciente, medico, dataHora);
    AgendamentoService agendamentoService = new AgendamentoService();

    assertFalse(agendamentoService.agendarConsulta(consulta));
    assertEquals(0, agendamentoService.listarConsultas().size());
  }

  @Test
  void testCancelarConsultaExistente() {
    Paciente paciente =
        new Paciente("Carlos Silva", "carlos@email.com", "senhaSegura", "123.456.789-00");
    Medico medico =
        new Medico("Dr. João", "dr.joao@email.com", "senhaSegura123", "CRM12345", "Cardiologia");
    LocalDateTime dataHora = LocalDateTime.now().plusDays(1);
    Consulta consulta = new Consulta(paciente, medico, dataHora);
    AgendamentoService agendamentoService = new AgendamentoService();
    agendamentoService.agendarConsulta(consulta);

    assertTrue(agendamentoService.cancelarConsulta(consulta));
    assertTrue(consulta.isCancelada());
  }

  @Test
  void testCancelarConsultaNaoExistente() {
    Paciente paciente =
        new Paciente("Carlos Silva", "carlos@email.com", "senhaSegura", "123.456.789-00");
    Medico medico =
        new Medico("Dr. João", "dr.joao@email.com", "senhaSegura123", "CRM12345", "Cardiologia");
    LocalDateTime dataHora = LocalDateTime.now().plusDays(1);
    Consulta consulta = new Consulta(paciente, medico, dataHora);
    AgendamentoService agendamentoService = new AgendamentoService();

    assertFalse(agendamentoService.cancelarConsulta(consulta));
  }

  @Test
  void testListarConsultas() {
    Paciente paciente =
        new Paciente("Carlos Silva", "carlos@email.com", "senhaSegura", "123.456.789-00");
    Medico medico =
        new Medico("Dr. João", "dr.joao@email.com", "senhaSegura123", "CRM12345", "Cardiologia");
    LocalDateTime dataHora = LocalDateTime.now().plusDays(1);
    Consulta consulta1 = new Consulta(paciente, medico, dataHora);
    Consulta consulta2 = new Consulta(paciente, medico, dataHora.plusDays(1));
    AgendamentoService agendamentoService = new AgendamentoService();
    agendamentoService.agendarConsulta(consulta1);
    agendamentoService.agendarConsulta(consulta2);

    List<Consulta> consultas = agendamentoService.listarConsultas();

    assertEquals(2, consultas.size());
    assertTrue(consultas.contains(consulta1));
    assertTrue(consultas.contains(consulta2));
  }
}
