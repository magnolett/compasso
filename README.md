# Como compilar e executar

### Para compilar
É necessário ter instalado o Maven (mvn) e o Docker na máquina.

* No terminal, acessar a pasta raiz e executar os seguintes comandos:
* mvn package
* docker-compose up
* O comando mvn package já irá criar as imagens necessárias, e o docker-compose irá carregar também o jdk e o Postgre.

### Endpoints Solicitados
As seguintes exigências foram cumpridas:

* http://localhost:8080/state
- POST - Fará o cadastro dos estados (pré-loading)
* http://localhost:8080/state/list
- GET - Listagem completa dos estados cadastrados
* http://localhost:8080/city
- POST - Endpoint utilizado para cadastrar uma nova cidade. JSON deve seguir o seguinte formato:
{
	"name": "Florianópolis",
	"state": {
		"name": "Santa Catarina",
		"state": "SC"
	}
}
* http://localhost:8080/state/name?name=Florianópolis
- GET - Endpoint para retornar uma cidade pelo nome. Parâmetro "name".
* http://localhost:8080/city/state?state=Santa Catarina
- GET - Endpoint para retornar a lista de cidades pelo nome do estado. Parâmetro "state".
* http://localhost:8080/customer
- POST - Endpoint utilizado para cadastrar um novo cliente. JSON deve seguir o seguinte formato:
{
	"name": "Marcos Agnoletto",
	"gender": "Masculino",
	"birthday": "1996-09-18",
	"age": 23,
	"city": {
		"name": "Florianópolis",
		"state": {
			"name": "Santa Catarina",
			"uf": "SC"
		}
	}
}
* http://localhost:8080/customer/name?name=Marcos Agnoletto
- GET - Endpoint para retornar um cliente pelo nome. Parâmetro "name".
* http://localhost:8080/customer/id?id=5
- GET - Endpoint para retornar um cliente pelo seu identificador. Parâmetro "id".
* http://localhost:8080/customer/remove
- DELETE - Endpoint para remover um cliente da base. JSON deve seguir o seguinte formato:
{
	"name": "Marcos Agnoletto",
	"gender": "Masculino",
	"birthday": "1996-09-18",
	"age": 23,
	"city": {
		"name": "Florianópolis",
		"state": {
			"name": "Santa Catarina",
			"uf": "SC"
		}
	}
}
* http://localhost:8080/customer/edit
- PUT - Endpoint para editar somente o nome do customer. JSON deve seguir o seguinte formato:
{
	"id": 1,
	"name": "Marcos Agnoletto",
}
