package com.consultas.gestao.models;

import java.time.LocalDateTime;

public class Consulta {
  private final Paciente paciente;
  private final Medico medico;
  private final LocalDateTime dataHora;
  private boolean cancelada;

  public Consulta(Paciente paciente, Medico medico, LocalDateTime dataHora) {
    this.paciente = paciente;
    this.medico = medico;
    this.dataHora = dataHora;
    this.cancelada = false;
  }

  public Paciente getPaciente() {
    return paciente;
  }

  public Medico getMedico() {
    return medico;
  }

  public LocalDateTime getDataHora() {
    return dataHora;
  }

  public boolean isCancelada() {
    return cancelada;
  }

  public void cancelar() {
    this.cancelada = true;
  }

  public boolean validarDados() {
    return paciente != null
        && medico != null
        && dataHora != null
        && dataHora.isAfter(LocalDateTime.now());
  }

  @Override
  public String toString() {
    return "Consulta{" +
            "paciente=" + paciente +
            ", medico=" + medico +
            ", dataHora=" + dataHora +
            ", cancelada=" + cancelada +
            '}';
  }
}
