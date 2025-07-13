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

## 🧱 Clean Architecture

├── domain/              # Entidades, interfaces e regras de negócio puras
├── application/         # Casos de uso
├── infrastructure/      # Adaptadores de framework (Spring, DB, REST)


## ⚙️ Como Rodar o Projeto Localmente

### 1. Pré-requisitos

- Java 21+
- PostgreSQL 14+
- Gradle 7+
- Docker (opcional, para o postgresql e a aplicação com variáveis)

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

### 4. Variáveis de ambiente

Crie um arquivo .env no diretorio da aplicação com as seguintes variáveis:
```env
DB_HOST=postgres
# PostgreSQL
POSTGRES_DB=medical_db
POSTGRES_USER=root
POSTGRES_PASSWORD=root
POSTGRES_PORT=5432

# pgAdmin (opcional)
PGADMIN_DEFAULT_EMAIL=admin@admin.com
PGADMIN_DEFAULT_PASSWORD=admin
PGADMIN_PORT=5050
```

### 5. Buildar & Executar a aplicação com docker

Para executar a aplicação com as variáveis de ambiente abra seu terminal na raiz do projeto e execute:
```bash
docker-compose up --build
```
obs: esse comando vai criar o container api-medical-appointments com os 3 serviços postgres,pgadmin e medical-app


dica: caso já tenha usado o comando acima e não queira rebuildar seu projeto use:
```bash
docker-compose up -d
```

A aplicação estará disponível em: http://localhost:8080


