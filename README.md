# viridis_service
Serviço RESTful que implementa um escopo simplificado de gestão de ativos industriais

As descrições abaixo indicam como rodar a aplicação. Para saber mais sobre a API, exemplos, testes unitários e as dependências utilizadas consulte o pdf com o Relatorio descritivo do projeto.

Como rodar localmente:
- Passo 1: Clone este repositório para sua IDE de preferência (Eclipse, STS, Intellij...) e realize o Maven update project, seja pela IDE ou Terminal.

- Passo 2: Você deve optar por criar ou não o banco de dados. Se desejar criá-lo, rode o arquivo createDb.sql que está na pasta database_scripts do Projeto no banco de Dados Postgres(foi utilizada a versão 9.4) para criar o database viridis. Caso não deseje criar um novo, altere o arquivo application.properties para a instância da sua base de dados, configurando o nome da database na url, o username e a password.

- Passo 3: Rode os arquivos tables.sql e inserts.sql nessa ordem, para criar as tabeas e inserir os dados que serã usados pela API.
Isso também pode ser feito de forma automática na inicialização da aplicação. Para isso, pegue os dois aqruivos citados e coloque-os na pasta resources. Abra o arquivo application.properties e edite-o adicionando as seguintes linhas:

spring.datasource.schema=classpath:tables.sql
spring.datasource.data=classpath:inserts.sql

- Passo 4: Rode a API e use uma ferramenta capaz de produzir e consumir chamadas Http. Eu recomedo o Postman. Você tem a opção de alterar a porta na qual está rodando a API através do arquivo application.properties. Por padrão está setada a porta 9444.

- Passo 5: Na aba builder do Postman, procure a aba Header, para inserir a key e o value da hash de autenticação. Se isso não for feito, a API retornará um erro de falha de autenticação e negará as chamadas dos métodos. A key e o value podem ser encontrados na classe AuthenticateService no pacote security do projeto.

- Passo 6: Acesse o Swagger através da url http://localhost:9444/swagger-ui.html#/ (tendo em mente que a porta não tenha sido alterada no application.properties. Caso ela não seja mais a 9444, deve-se passar na url a porta que está sendo utilizada). Lá pode-se ver todas as urls e métodos criados para a API.

URL's disponíveis: 
-  GET http://localhost:9444/viridis/equipamentos/buscar/{id} onde {id} é o parâmetro passado do id da primary key da tabela no banco.
-  GET http://localhost:9444/viridis/equipamentos/listar
-  GET http://localhost:9444/viridis/manutencao/buscar/{id} onde {id} é o parâmetro passado do id da primary key da tabela no banco.
-  GET http://localhost:9444/viridis/manutencao/listar
-  POST http://localhost:9444/viridis/manutencao/salvar onde deve ser passado um JSON com os dados a serem persistidos.
-       Exemplo: {
                    "equipamento": {
                        "idEquipamento": 1
                    },
                    "servico": {
                        "idServico": 1
                    },
                    "dataManutencao": "28/05/2018"
                }
- PUT http://localhost:9444/viridis/manutencao/alterar onde deve ser passado um JSON com os dados a serem persistidos.
-     Exemplo: {
                    "idManutencao": 3,
                    "equipamento": {
                        "idEquipamento": 1
                    },
                    "servico": {
                        "idServico": 1
                    },
                    "dataManutencao": "30/05/2018"
                }
