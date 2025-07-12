# 🩺 API - Medical Appointments

Sistema de agendamento médico desenvolvido como parte de um desafio técnico. Permite que médicos cadastrem horários disponíveis e pacientes agendem consultas, com gerenciamento de conflitos e persistência em banco de dados PostgreSQL.

---


## ✅ Funcionalidades Implementadas

### 👨‍⚕️ Médicos
- Cadastro de horários disponíveis
- Visualização de agendamentos realizados


### 👤 Pacientes
- Consulta de horários disponíveis por médico
- Agendamento de horário disponível
- Visualização de agendamentos passados e futuros

---


## 🧠 Tecnologias Utilizadas

| Camada         | Tecnologia        |
|----------------|-------------------|
| Backend        | Java 21, Spring Boot 3, Gradle |
| Banco de Dados | PostgreSQL        |
| Frontend       | React.js (não incluso neste repositório) |
| Testes         | JUnit (em construção) |

---

## ⚙️ Como Rodar o Projeto Localmente

### 1. Pré-requisitos

- Java 21+
- PostgreSQL 14+
- Gradle 7+
- Docker (opcional, para o postgresql)

### 2. Clonar o projeto

```bash
git clone https://github.com/janiotech/api-medical-appointments.git
cd api-medical-appointments
```

### 3. Configurar o banco de dados

Crie um banco chamado medical_db no PostgreSQL:
```sql
CREATE DATABASE medical_db;
```

Configure as credenciais em src/main/resources/application.yml:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/medical_db
    username: seu_usuario
    password: sua_senha
```

### 4. Executar a aplicação
```bash
./gradlew bootRun
```

A aplicação estará disponível em: http://localhost:8080


