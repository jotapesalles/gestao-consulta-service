package com.consultas.gestao.models;

public class Medico extends Usuario {
  private String crm;
  private String especialidade;

  public Medico(String nome, String email, String senha, String crm, String especialidade) {
    super(nome, email, senha);
    this.crm = crm;
    this.especialidade = especialidade;
  }

  public String getCrm() {
    return crm;
  }

  public void setCrm(String crm) {
    this.crm = crm;
  }

  public String getEspecialidade() {
    return especialidade;
  }

  public void setEspecialidade(String especialidade) {
    this.especialidade = especialidade;
  }

  public boolean validarCrm() {
    return crm != null && crm.matches("CRM\\d+");
  }

  @Override
  public boolean camposObrigatoriosPreenchidos() {
    return super.camposObrigatoriosPreenchidos()
        && crm != null
        && !crm.isEmpty()
        && especialidade != null
        && !especialidade.isEmpty();
  }
}
