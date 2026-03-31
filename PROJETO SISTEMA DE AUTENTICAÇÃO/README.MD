# 🚀 API de Autenticação com Spring Boot

Este projeto é uma API REST de autenticação desenvolvida com **Spring Boot**, com foco em boas práticas de backend, segurança e organização em camadas.

---

## 🧠 Objetivo

Simular um sistema real de autenticação, aplicando conceitos utilizados no mercado como:

* Arquitetura em camadas
* Autenticação com JWT
* Criptografia de senha
* Tratamento global de exceções
* Uso de DTOs

---

## ⚙️ Tecnologias utilizadas

* Java 17+
* Spring Boot
* Spring Security
* JWT (JSON Web Token)
* PostgreSQL
* Maven

---

## 🔐 Funcionalidades

✔ Cadastro de usuário
✔ Login com geração de token JWT
✔ Senhas criptografadas com BCrypt
✔ Proteção de rotas com Spring Security
✔ Filtro de autenticação JWT
✔ Endpoint de usuário autenticado (/users/me)
✔ Tratamento global de exceções
✔ Uso de DTOs para segurança dos dados

---

## 📌 Endpoints

### 🔹 Criar usuário

POST `/users`

```json
{
  "name": "Kaua",
  "email": "kaua@email.com",
  "password": "123456"
}
```

---

### 🔹 Login

POST `/users/login`

```json
{
  "email": "kaua@email.com",
  "password": "123456"
}
```

Resposta:

```json
{
  "token": "SEU_TOKEN_JWT"
}
```

---

### 🔹 Usuário autenticado

GET `/users/me`

Header:

```
Authorization: Bearer SEU_TOKEN
```

---

## 🔒 Segurança

* Senhas armazenadas com **BCrypt**
* Autenticação baseada em **JWT**
* Rotas protegidas via **Spring Security**
* Filtro customizado para validação de token

---

## 🧱 Estrutura do projeto

```
controller
business (service)
dto
security
config
exception
infrastructure
```

---

## ⚠️ Tratamento de erros

A API retorna erros padronizados:

```json
{
  "timestamp": "2026-03-31T15:00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Mensagem de erro",
  "path": "/users"
}
```

---

## 🚀 Como rodar o projeto

```bash
git clone https://github.com/SEU-USUARIO/SEU-REPO.git

cd SEU-REPO

./mvnw spring-boot:run
```

---

## 💡 Melhorias futuras

* Refresh Token
* Controle de roles (ADMIN/USER)
* Dockerização
* Deploy em cloud (AWS, Render, etc)

---

## 👨‍💻 Autor

Desenvolvido por Kauã Costa
Em busca de oportunidade de estágio em desenvolvimento backend 🚀
