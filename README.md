# Configurações para excutar a aplicação back-end.

Java 8+, PgAdmin 3+ e Maven 3+, git 2+ instalados.

Para baixar o projeto, execute o comando "git clone https://github.com/LeonardoBrendo/mobit-desafio-back-end.git" (sem aspas).

Em seguida, deve-se criar uma base de dados, onde a tabela utilizada pela aplicação será persistida. Após a criação da base de dados, faz-se necessário informar as credenciais da conexão no arquivo application.properties, localizado em src/main/resources. Dentre as informações estão o nome do usuário e senha do banco, assim como o nome da base de dados alocada para o proejto, dentre outras especificações técnicas.

Para executar o projeto, levando em consideração a utilização do software STS, clique com o botão direito do mouse sobre o projeto e na alternativa Run As -> Spring boot App.

Se surgir algum problema em decorrência da sincronização com o maven, execute "mvn clean install compile" (sem aspas).


