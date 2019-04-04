# Api rest 
Tecnologias usadas
* mongodb
* spring boot
* docker
* html
* js
* css

## Subir o mongo

Antes de tudo é necessário subir o mongo na porta 27017. Caso você não tenha o mongo instalado você pode executar facilmente usando o docker, executando os comandos:

* sudo docker pull tutum/mongodb
* sudo docker run -d -p 27017:27017 -e AUTH=no tutum/mongodb

Prepare o ambiente executando no mongo o conteúdo do arquivo script_mongo.txt. Você pode executar no robomongo ou direto no terminal. 

Para executar no terminal primeiro conecte-se no mongo usando o comando

* mongo 127.0.0.1:27017

## Executar a aplicação 

Em uma pasta do seu computador faça o clone do repositório com os seguintes comandos:

* git init
* git clone https://github.com/renatinhah/api-rest-com-java.git
* cd desafioDito/backend/

Faça o build da aplicação

* mvn clean install

Agora execute o backend da aplicação
* mvn spring-boot:run

## Acessando o frontend

Acesse a pasta frontend e execute o arquivo index.html
