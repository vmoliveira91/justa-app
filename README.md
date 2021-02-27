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

## Função

O webservice foi configurado para responder a requests para */units/si?units=expression*.

A *expression* é uma expressão que contém qualquer número de unidades multiplicadas ou divididas com parênteses ou não.

As unidades podem ser:

### Não SI
- minute / min
- hour / h
- day / d
- degree / °
- arcminute / '
- arcsecond / "
- hectare / ha
- litre / L
- tonne / t

### SI 
- s
- rad
- m²
- m³
- kg

Essa *expression* deve ter suas unidades convertidas para a sua unidade respectiva no SI e ter o seu fator de multiplicação gerado de acordo com a imagem abaixo:

![image](https://user-images.githubusercontent.com/23312905/109373206-48f98a00-788c-11eb-979b-0d39feb98b07.png)

Para que então gere um retorno da seguinte forma:

```bash
{
    "unit_name": "((rad/s)*s)*(m²*rad)",
    "multiplication_factor": 182.77045187202512
}
```

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

Agora que a imagem já está sendo executado para fazer uma requisição é necessário acessar a seguinte URL com uma *expression* seguindo os padrões citados acima:

```bash
localhost:8083/units/si?units=expression
```
