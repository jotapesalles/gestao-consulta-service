package com.consultas.gestao;

import com.consultas.gestao.controllers.AgendamentoController;
import com.consultas.gestao.controllers.LoginController;
import com.consultas.gestao.models.Consulta;
import com.consultas.gestao.models.Medico;
import com.consultas.gestao.models.Paciente;
import com.consultas.gestao.services.AgendamentoService;
import com.consultas.gestao.services.NotificacaoService;
import com.consultas.gestao.services.UsuarioService;
import java.time.LocalDateTime;
import java.util.Scanner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestaoApplication {

  private static final Scanner scanner = new Scanner(System.in);
  private static final UsuarioService usuarioService = new UsuarioService();
  private static final AgendamentoService agendamentoService = new AgendamentoService();
  private static final NotificacaoService notificacaoService = new NotificacaoService();

  private static final AgendamentoController agendamentoController =
      new AgendamentoController(agendamentoService, notificacaoService);
  private static final LoginController loginController = new LoginController(usuarioService);

  public static void main(String[] args) {

    while (true) {
      exibirMenu();
      int opcao = scanner.nextInt();
      scanner.nextLine(); // Consumir a nova linha após a escolha

      switch (opcao) {
        case 1:
          cadastrarPaciente();
          break;
        case 2:
          cadastrarMedico();
          break;
        case 3:
          agendarConsulta();
          break;
        case 4:
          listarConsultas();
          break;
        case 5:
          realizarLogin();
          break;
        case 6:
          System.out.println("Saindo...");
          scanner.close();
          return;
        default:
          System.out.println("Opção inválida! Tente novamente.");
      }
    }
  }

  static void exibirMenu() {
    System.out.println("==== Menu de Gestão de Consultas ====");
    System.out.println("1. Cadastrar paciente");
    System.out.println("2. Cadastrar médico");
    System.out.println("3. Agendar consulta");
    System.out.println("4. Listar consultas");
    System.out.println("5. Realizar login");
    System.out.println("6. Sair");
    System.out.print("Escolha uma opção: ");
  }

  static void cadastrarPaciente() {
    System.out.print("Digite o nome do paciente: ");
    String nomePaciente = scanner.nextLine();
    System.out.print("Digite o email do paciente: ");
    String emailPaciente = scanner.nextLine();
    System.out.print("Digite a senha do paciente: ");
    String senhaPaciente = scanner.nextLine();
    System.out.print("Digite o CPF do paciente: ");
    String cpfPaciente = scanner.nextLine();
    Paciente paciente = new Paciente(nomePaciente, emailPaciente, senhaPaciente, cpfPaciente);
    usuarioService.cadastrarUsuario(paciente);
    System.out.println("Paciente cadastrado com sucesso!");
  }

   static void cadastrarMedico() {
    System.out.print("Digite o nome do médico: ");
    String nomeMedico = scanner.nextLine();
    System.out.print("Digite o email do médico: ");
    String emailMedico = scanner.nextLine();
    System.out.print("Digite a senha do médico: ");
    String senhaMedico = scanner.nextLine();
    System.out.print("Digite o CRM do médico: ");
    String crmMedico = scanner.nextLine();
    System.out.print("Digite a especialidade do médico: ");
    String especialidadeMedico = scanner.nextLine();
    Medico medico =
        new Medico(nomeMedico, emailMedico, senhaMedico, crmMedico, especialidadeMedico);
    usuarioService.cadastrarUsuario(medico);
    System.out.println("Médico cadastrado com sucesso!");
  }

  static void agendarConsulta() {
    System.out.print("Digite o nome do paciente para agendamento: ");
    String pacienteNome = scanner.nextLine();
    System.out.print("Digite o nome do médico para agendamento: ");
    String medicoNome = scanner.nextLine();
    System.out.print("Digite a data da consulta (exemplo: 2024-12-10T10:30): ");
    String dataConsulta = scanner.nextLine();
    Paciente pacienteAgendamento = new Paciente(pacienteNome, "", "", "");
    Medico medicoAgendamento = new Medico(medicoNome, "", "", "", "");
    Consulta consulta =
        new Consulta(pacienteAgendamento, medicoAgendamento, LocalDateTime.parse(dataConsulta));
    agendamentoController.agendarConsulta(consulta);
    System.out.println("Consulta agendada com sucesso!");
  }

  static void listarConsultas() {
    agendamentoController.listarConsultas();
  }

  static void realizarLogin() {
    System.out.print("Digite o email: ");
    String email = scanner.nextLine();
    System.out.print("Digite a senha: ");
    String senha = scanner.nextLine();

    boolean loginSucesso = loginController.login(email, senha);

    if (loginSucesso) {
      System.out.println("Login bem-sucedido!");
    } else {
      System.out.println("Credenciais inválidas ou bloqueio de tentativas.");
    }
  }
}
