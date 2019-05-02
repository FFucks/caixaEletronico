# caixaEletronico

# Implementação de API utilizando Java 8, Spring boot e MongoDB.

# É necessário ter o mongoDB configurado na máquina.  Para executar aaplicação selecionar o arquivo AtmServiceApplication.java, Run As -> # Spring Boot App
#
#
# Servidor configurado para executar em localhost na porta 8080.
#
# Para testar os endpoints utilizar Postman ou Insomnia, os endpoints são os seguintes:
#
# POST   /clients                 -> Cadastro de cliente
# GET    /clients                 -> Consulta todos os clientes cadastrados
# GET    /clients/{id}            -> Consulta cliente conforme id informado
# DELETE /clients/{id}            -> Exclui cliente conforme id informado
# PUT    /clients/{id}            -> Atualiza os dados do cliente e realiza um saque 
#
# Campos para serem insridos no body do request: name(string), account(string), limit(int). Campo cash(int) é utilizado no PUT para        # realizar um saque.
#
#
#
