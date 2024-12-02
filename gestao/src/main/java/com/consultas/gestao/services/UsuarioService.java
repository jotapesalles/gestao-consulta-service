package com.consultas.gestao.services;

import com.consultas.gestao.models.Usuario;
import java.util.HashMap;
import java.util.Map;

public class UsuarioService {
  private final Map<String, Usuario> usuarios;

  public UsuarioService() {
    this.usuarios = new HashMap<>();
  }

  public boolean cadastrarUsuario(Usuario usuario) {
    if (usuarios.containsKey(usuario.getEmail()) || !usuario.camposObrigatoriosPreenchidos()) {
      return false;
    }
    usuarios.put(usuario.getEmail(), usuario);
    return true;
  }

  public Usuario autenticar(String email, String senha) {
    Usuario usuario = usuarios.get(email);
    if (usuario != null && usuario.validarSenha(senha)) {
      return usuario;
    }
    return null;
  }
}
