# Gestão de Consultas - Sistema de Agendamento

Este repositório contém a implementação de um sistema de gestão de consultas médicas, permitindo o cadastro de pacientes e médicos, o agendamento de consultas, a realização de login e a listagem das consultas agendadas.

## Funcionalidades

- **Cadastro de Paciente**: Permite o cadastro de novos pacientes com nome, email, senha e CPF.
- **Cadastro de Médico**: Permite o cadastro de médicos com nome, email, senha, CRM e especialidade.
- **Agendamento de Consulta**: Possibilita o agendamento de consultas entre pacientes e médicos.
- **Listagem de Consultas**: Exibe a lista de consultas agendadas.
- **Login**: Permite que usuários realizem login no sistema utilizando email e senha, com bloqueio após três tentativas falhas consecutivas.

## Tecnologias Utilizadas

- **Java 11**: Linguagem de programação utilizada para o desenvolvimento.
- **Spring Boot**: Framework para criação de aplicações Java baseadas em microserviços.
- **JUnit 5**: Framework para testes unitários.
- **Mockito**: Biblioteca para criação de mocks e testes isolados.
- **Maven**: Gerenciador de dependências e build system.

## Instalação

### Pré-requisitos

- **Java 11 ou superior** instalado.
- **Maven** instalado para gerenciamento de dependências.

### Passos para Instalação

1. Clone o repositório:
   ```bash
   git clone https://github.com/jotapesalles/gestao-consulta-service.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd gestao-consultas
   ```

3. Instale as dependências com o Maven:
   ```bash
   mvn install
   ```

4. Para rodar a aplicação, use o comando:
   ```bash
   mvn spring-boot:run
   ```

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

```
gestao-consultas/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── consultas/
│   │   │           └── gestao/
│   │   │               ├── controllers/
│   │   │               ├── models/
│   │   │               ├── services/
│   │   │               └── GestaoApplication.java
│   │   ├── resources/
│   │   └── application.properties
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── consultas/
│       │           └── gestao/
│       │               ├── controllers/
│       │               ├── models/
│       │               └── services/
│       └── resources/
└── pom.xml
```

- **controllers/**: Contém as classes responsáveis pela lógica de controle de entrada e saída.
- **models/**: Contém as classes de modelo, como `Paciente`, `Medico`, `Consulta`.
- **services/**: Contém os serviços responsáveis pelas operações de backend, como `UsuarioService` e `AgendamentoService`.
- **GestaoApplication.java**: A classe principal da aplicação.

## Testes

Para rodar os testes unitários do projeto, utilize o comando:

```bash
mvn test
```

O projeto inclui testes unitários para as classes de controle e serviço, utilizando o **JUnit** e **Mockito** para simulação de dados e dependências.

## Como Usar

Ao executar a aplicação, o sistema exibirá um menu no terminal com as seguintes opções:

1. **Cadastrar paciente**
2. **Cadastrar médico**
3. **Agendar consulta**
4. **Listar consultas**
5. **Realizar login**
6. **Sair**

Basta escolher a opção desejada inserindo o número correspondente e seguir as instruções para interação com o sistema.

## Exemplo de Execução

### Menu:
```
==== Menu de Gestão de Consultas ====
1. Cadastrar paciente
2. Cadastrar médico
3. Agendar consulta
4. Listar consultas
5. Realizar login
6. Sair
Escolha uma opção: 
```

- Para **Cadastrar paciente**, será solicitado nome, email, senha e CPF.
- Para **Cadastrar médico**, será solicitado nome, email, senha, CRM e especialidade.
- Para **Agendar consulta**, será necessário informar o nome do paciente, do médico e a data da consulta.
- Para **Listar consultas**, o sistema exibirá todas as consultas agendadas.
- Para **Login**, o usuário deve fornecer email e senha.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).