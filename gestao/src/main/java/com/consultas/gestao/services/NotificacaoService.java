package com.consultas.gestao.services;

import com.consultas.gestao.models.Consulta;

public class NotificacaoService {
  public void enviarNotificacaoEmail(Consulta consulta) {
    System.out.println(
        "Enviando email para "
            + consulta.getPaciente().getEmail()
            + " sobre a consulta com "
            + consulta.getMedico().getNome());
  }
}
