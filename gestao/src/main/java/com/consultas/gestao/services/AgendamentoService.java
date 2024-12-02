package com.consultas.gestao.services;

import com.consultas.gestao.models.Consulta;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoService {
  private final List<Consulta> consultas;

  public AgendamentoService() {
    this.consultas = new ArrayList<>();
  }

  public boolean agendarConsulta(Consulta consulta) {
    if (consulta.validarDados()) {
      consultas.add(consulta);
      return true;
    }
    return false;
  }

  public List<Consulta> listarConsultas() {
    return consultas;
  }

  public boolean cancelarConsulta(Consulta consulta) {
    if (consultas.contains(consulta)) {
      consulta.cancelar();
      return true;
    }
    return false;
  }
}
