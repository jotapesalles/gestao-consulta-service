package com.consultas.gestao.controllers;

import com.consultas.gestao.models.Consulta;
import com.consultas.gestao.services.AgendamentoService;
import com.consultas.gestao.services.NotificacaoService;

public class AgendamentoController {
  private final AgendamentoService agendamentoService;
  private final NotificacaoService notificacaoService;

  public AgendamentoController(AgendamentoService agendamentoService, NotificacaoService notificacaoService) {
    this.agendamentoService = agendamentoService;
      this.notificacaoService = notificacaoService;
  }

  public void agendarConsulta(Consulta consulta) {
    if (agendamentoService.agendarConsulta(consulta)) {
      notificacaoService.enviarNotificacaoEmail(consulta);
      System.out.println("Consulta agendada com sucesso.");
    } else {
      System.out.println("Falha ao agendar consulta. Verifique os dados.");
    }
  }

  public void listarConsultas() {
    for (Consulta consulta : agendamentoService.listarConsultas()) {
      System.out.println(consulta);
    }
  }
}
