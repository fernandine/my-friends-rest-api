# Digytal Code - Programação, Pesquisa e Educação
[www.digytal.com.br](http://www.digytal.com.br)

[(11) 95894-0362](https://api.whatsapp.com/send?phone=5511958940362)


#### Autores
- [Gleyson Sampaio](https://github.com/glysns)

## Spring Rest API
Api para testar operações de CRUD comuns em APIs REST que pode ser consumida por qualquer friend http.


![](/img/swagger.png "Swagger")

#### Estrutura do Projeto

| Nome       | Descrição                                                            |
|------------|----------------------------------------------------------------------|
| config     | configuração e beans manuais do projeto como Model Mapper e Open API |
| infra      | configuração do recusos comuns da aplicação como exceções globais    |
| model      | classes de modelo da aplicação                                       |
| dto        | camada de tráfego de dados da aplicação                              |
| repository | recursos de acesso a dados em uma base relacional da aplicação       |
| service    | camada de regra de negócios da aplicação                             |
| controller | serviços http baseados na arquitetura REST                           |

#### Tecnologias

* Java
* JPA / Hibernate
* JPA Annotations
* Spring Boot Web
* Spring Boot Data JPA
* Spring Boot Data JPA Pagging
* Open API - Swagger 3
* Model Mapper
* H2 Database (in memory)
* JUnit 5
* Spring Exception Handler


#### Funcionalidades
Download do arquivo para o Postman
[builders.postman_collection.json](https://github.com/glysns/builders-cadastro-friend/blob/main/doc/builders.postman_collection.json "download")
1. Inclusão de friend
```
POST: http://localhost:8080/friends
```
```
{
  "name": "GLEYSON SAMPAIO",
  "birthDate": "2022-06-28",
  "email": "gleyson@digytal.com.br",
  "whatsapp": "11958940362",
  "address": {
    "zipCode": "786686",
    "street": "RUA 9",
    "number": "876",
    "city": "TERESINA",
    "state": "PI"
  }
}
```
2. Listagem de friends
```
GET: http://localhost:8080/friends
```
3. Exclusão de friend
```
DELETE: http://localhost:8080/friends/1
```
4. Alteração de friend
```
PUT: http://localhost:8080/friends/1
```
```
{
  "name": "GLEYSON SAMPAIO DE OLIVEIRA",
  "birthDate": "2022-06-28",
  "email": "gleyson@digytal.com.br",
  "whatsapp": "11958940362",
  "address": {
    "zipCode": "786686",
    "street": "AV NOSSA SENHORA",
    "number": "3245",
    "city": "TERESINA",
    "state": "PI"
  }
}
```
5. Busca de um friend
```
GET: http://localhost:8080/friends/1
```

6. Busca de um address de um friend
```
GET: http://localhost:8080/friends/1/address
```

7. Alteração do address de um friend
```
PATCH: http://localhost:8080/friends/1/address
```
```
{
    "zipCode": "786686",
    "street": "AV AIRTON SENHA",
    "number": "5681",
    "city": "TERESINA",
    "state": "PI"
  }
```
8. Constula de friends por nome com paginação
```
GET: http://localhost:8080/friends/search?name=GLEYSON&page=0&size=3
```

9. Alteração de friend INVÁLIDO
```
PUT: http://localhost:8080/friends/10
```
```
{
  "name": "GLEYSON SAMPAIO DE OLIVEIRA",
  "birthDate": "2022-06-28",
  "email": "gleyson@digytal.com.br",
  "whatsapp": "11958940362",
  "address": {
    "zipCode": "786686",
    "street": "AV NOSSA SENHORA",
    "number": "3245",
    "city": "TERESINA",
    "state": "PI"
  }
}
```
Resposta
```
{
    "dateTime": "2022-06-28 13:54:15",
    "success": false,
    "message": "Não foi localizado um registro com o ID informado: 10 ",
    "code": "001",
    "body": null,
    "suggestion": "Informe um ID Válido"
}
```


#### Referências
* https://www.infoq.com/br/articles/nivelando-sua-rest-api/
* https://www.oracle.com/br/technical-resources/articles/dsl/crud-rest-sb2-hibernate.html
* https://www.bezkoder.com/spring-boot-pagination-filter-jpa-pageable/
* https://www.bezkoder.com/spring-boot-pagination-filter-jpa-pageable/
* http://modelmapper.org/examples/
* https://www.baeldung.com/spring-rest-openapi-documentation
* https://blog.mbeck.com.br/api-rest-e-os-verbos-http-46e189085e21



