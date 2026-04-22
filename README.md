# 📒 Contact API

REST API para gerenciamento de contatos, desenvolvida com Spring Boot e documentada com Swagger.

## 🚀 Tecnologias

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- SpringDoc OpenAPI (Swagger)
- Lombok
- Bean Validation

## 📋 Funcionalidades

- Listar todos os contatos ativos
- Buscar contato por ID
- Criar novo contato (com validação de idade mínima de 18 anos)
- Atualizar contato (incluindo ativação/desativação)
- Deletar contato

## 🗂️ Estrutura do Projeto

```
src/main/java/pedrorios/contactapi/
├── controller/        # Endpoints REST
├── service/           # Regras de negócio
├── repository/        # Acesso ao banco de dados
├── domain/            # Entidade Contact
├── dto/               # ContactRequest e ContactResponse
└── exception/         # Tratamento global de erros
```

## ⚙️ Configuração

### Pré-requisitos

- Java 17+
- PostgreSQL rodando localmente
- Maven

### Banco de dados

Crie o banco de dados no PostgreSQL:

```sql
CREATE DATABASE contacts_db;
```

### application.yml

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/contacts_db
    username: seu_usuario
    password: sua_senha
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

### Rodando o projeto

```bash
./mvnw spring-boot:run
```

## 📖 Documentação da API

Com a aplicação rodando, acesse o Swagger em:

```
http://localhost:8080/swagger-ui.html
```

## 🔗 Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/contacts` | Lista todos os contatos ativos |
| GET | `/contacts/{id}` | Busca contato por ID |
| POST | `/contacts` | Cria um novo contato |
| PUT | `/contacts/{id}` | Atualiza um contato |
| DELETE | `/contacts/{id}` | Deleta um contato |

### Exemplo de payload (POST/PUT)

```json
{
  "name": "Pedro Rios",
  "birthDate": "2000-05-10",
  "gender": "M",
  "active": true
}
```

### Exemplo de resposta

```json
{
  "id": 1,
  "name": "Pedro Rios",
  "birthDate": "2000-05-10",
  "gender": "M",
  "active": true
}
```

## ✅ Regras de negócio

- Apenas contatos com **18 anos ou mais** podem ser cadastrados
- O campo `gender` aceita somente `"M"` ou `"F"`
- O campo `name` é obrigatório
- Contatos podem ser desativados via `PUT` setando `active: false`

## 👤 Autor

Pedro Rios — [@rios-pedro](https://github.com/rios-pedro)
