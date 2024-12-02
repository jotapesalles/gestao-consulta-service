package com.consultas.gestao.models;

public class Paciente extends Usuario {
  private String cpf;

  public Paciente(String nome, String email, String senha, String cpf) {
    super(nome, email, senha);
    this.cpf = cpf;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public boolean validarCpf() {
    return cpf != null && cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
  }

  @Override
  public boolean camposObrigatoriosPreenchidos() {
    return super.camposObrigatoriosPreenchidos() && cpf != null && !cpf.isEmpty();
  }
}
