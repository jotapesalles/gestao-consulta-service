package com.consultas.gestao.controllers;

import com.consultas.gestao.models.Consulta;
import com.consultas.gestao.services.AgendamentoService;
import com.consultas.gestao.services.NotificacaoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AgendamentoControllerTest {

  @Test
  public void testAgendarConsultaComSucesso() {
    AgendamentoService agendamentoService = Mockito.mock(AgendamentoService.class);
    NotificacaoService notificacaoService = Mockito.mock(NotificacaoService.class);
    AgendamentoController agendamentoController = new AgendamentoController(agendamentoService, notificacaoService);

    Consulta consulta = Mockito.mock(Consulta.class);
    when(agendamentoService.agendarConsulta(consulta)).thenReturn(true);

    agendamentoController.agendarConsulta(consulta);

    verify(agendamentoService).agendarConsulta(consulta);
    verify(notificacaoService).enviarNotificacaoEmail(consulta);
  }

  @Test
  public void testAgendarConsultaComFalha() {
    AgendamentoService agendamentoService = Mockito.mock(AgendamentoService.class);
    NotificacaoService notificacaoService = Mockito.mock(NotificacaoService.class);
    AgendamentoController agendamentoController = new AgendamentoController(agendamentoService, notificacaoService);

    Consulta consulta = Mockito.mock(Consulta.class);
    when(agendamentoService.agendarConsulta(consulta)).thenReturn(false);

    agendamentoController.agendarConsulta(consulta);

    verify(agendamentoService).agendarConsulta(consulta);
  }

  @Test
  public void testListarConsultas() {
    AgendamentoService agendamentoService = Mockito.mock(AgendamentoService.class);
    NotificacaoService notificacaoService = Mockito.mock(NotificacaoService.class);
    AgendamentoController agendamentoController = new AgendamentoController(agendamentoService, notificacaoService);

    agendamentoController.listarConsultas();

    verify(agendamentoService).listarConsultas();
  }
}
