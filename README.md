# Incident API
projeto spring mvc configurado
 
### Tecnologias:
 
 * spring boot 2.6.2
 * java 11
 * spring data
 * spring devtools
 * lombok ( requer plugin eclipse )
 * h2 database
 * mavem

### Funcionalidades:
 
 * Criar incidente
 * Listar todos os incidentes
 * Listar incidente por Id
 * Listar os ultimos 20 incidentes
 * Alterar incidente
 * Deletar incidente
 * Encerrar incidente
 
### Bibliotecas adicionais
 * Open API - Documentação da api (Swagger)

### Executar / Compilar:

* compilar: mvn install -Dmaven.test.skip=true

* Executar: run main  MainApplication class ou mvn spring-boot:run

* acessar: http://localhost:8080

* acessar swagger: http://localhost:8080/api/swagger-ui/index.html
  * Explore: /api/v3/api-docs
