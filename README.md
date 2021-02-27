# Justa-App

Um webservice desenvolvido com Spring Boot.

Foi utilizado o [Spring Initializr](https://start.spring.io/) para começar o projeto já com as dependências necessárias para ser criado um webservice.

- **Projeto:** Maven Project
- **Linguagem:** Java
- **Spring Boot:** 2.4.3
- **Packaging:** Jar
- **Java:** 8
- **Dependencies:** Rest Repositories

Além dessas dependências foram adicionadas as seguintes:

- **exp4j**
  - Biblioteca utilizada para avaliar expressões matemáticas e funções
- **json**
  - Biblioteca utilizada para que a response da aplicação seja feita em JSON
- **junit**
  - Biblioteca utilziada para efetuar os testes

## Dockerfile

O projeto conta com o arquivo Dockerfile com as diretrizes de como deve ser buildada a imagem.

Para buildar a imagem é necessário executar o seguinte comando:

```bash
docker build -t justa-app .
```

Após a imagem criada, para rodar a imagem executar o seguinte comando:

```bash
docker run justa-app
```
