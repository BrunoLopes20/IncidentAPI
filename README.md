# SistemaRH
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
 

### Executar / Compilar:

* compilar: mvn clean package -Dmaven.test.skip=true -P "hml"

* Executar: run main  MainApplication class ou mvn spring-boot:run -P "dev"

* acessar: http://localhost:5000

