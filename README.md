# E-commerce Clientes API

## Pré-requisitos

- Docker e Docker Compose instalados
- Java 21 ou superior
- Maven

## Subindo o banco de dados Postgres com Docker

O projeto já possui um arquivo `compose.yaml` configurado para subir o banco de dados Postgres em um container.

1. Abra o terminal na raiz do projeto.
2. Execute o comando abaixo para subir o container:
   ```sh
   docker compose up -d
   ```
3. Crie um banco chamado ecommerce
4. O banco estará disponível em `localhost:5432`.
   - Usuário: `postgres`
   - Senha: `postgres`
   - Banco: `clientes`

Se quiser parar o container:

```sh
docker compose down
```

## Configuração da aplicação

O arquivo `src/main/resources/application.properties` já está configurado para conectar ao banco Postgres do container.

## Executando a aplicação

1. Certifique-se que o banco está rodando (veja o passo anterior).
2. Execute o comando abaixo para iniciar a aplicação:
   ```sh
   ./mvnw spring-boot:run
   ```
3. A API estará disponível em `http://localhost:8080`.

## Testes

Para rodar os testes automatizados:

```sh
./mvnw test
```

## Observações

- O banco será migrado automaticamente ao subir a aplicação (scripts em `src/main/resources/db/migration`).
- Para acessar o banco, pode usar ferramentas como DBeaver, TablePlus ou psql.

---

Em caso de dúvidas, consulte o arquivo `compose.yaml` ou o código fonte.
