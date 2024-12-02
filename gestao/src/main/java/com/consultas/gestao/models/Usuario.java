package com.consultas.gestao.models;

import static org.apache.logging.log4j.util.Strings.isNotBlank;

public class Usuario {
  private String nome;
  private String email;
  private String senha;

  public Usuario(String nome, String email, String senha) {
    this.nome = nome;
    this.email = email;
    this.senha = senha;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public boolean validarSenha(String senha) {
    return isNotBlank(senha)
        && senha.length() >= 8
        && senha.length() <= 18
        && this.senha.equals(senha);
  }

  public boolean camposObrigatoriosPreenchidos() {
    return nome != null
        && !nome.isEmpty()
        && email != null
        && !email.isEmpty()
        && senha != null
        && !senha.isEmpty();
  }
}
