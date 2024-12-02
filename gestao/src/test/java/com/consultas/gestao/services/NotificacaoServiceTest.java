package com.consultas.gestao.services;

import static org.mockito.Mockito.*;

import com.consultas.gestao.models.Consulta;
import com.consultas.gestao.models.Medico;
import com.consultas.gestao.models.Paciente;
import org.junit.jupiter.api.Test;

class NotificacaoServiceTest {

  @Test
  void testEnviarNotificacaoEmail() {
    Consulta consultaMock = mock(Consulta.class);
    when(consultaMock.getPaciente()).thenReturn(mock(Paciente.class));
    when(consultaMock.getMedico()).thenReturn(mock(Medico.class));

    NotificacaoService notificacaoService = new NotificacaoService();

    notificacaoService.enviarNotificacaoEmail(consultaMock);

    verify(consultaMock.getPaciente()).getEmail();
    verify(consultaMock.getMedico()).getNome();
  }
}
