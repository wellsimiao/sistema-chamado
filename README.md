# Desafio foi projetado para avaliar a sua capacidade t�cnica como candidato � vaga de
desenvolvedor de software s�nior.

# Sobre o projeto

Instru��es:
1. Crie um reposit�rio p�blico no gitlab.com;
2. Utilize todas as tecnologias informadas abaixo;
3. O backend deve ser desenvolvido utilizando os padr�es de arquitetura e designer
sugeridos abaixo;
4. O reposit�rio dever� conter um docker-compose devidamente configurado com os services (backend, frontend e database) e um tutorial de como subir o projeto para valida��o;
5. Deve ser constru�do um pipeline para o reposit�rio com 2 tarefas:
6 � Instala��o de depend�ncias
7 � Teste unit�rio quando a pipeline terminar dever� armazenar o artefado api.jar para download.
8. Voc� ter� at� 7 dias para concluir o desafio e dever� enviar o link do git para o e-mail
<colocar e-mail do rh da first> para ser avaliado.

# Tecnologias utilizadas

## Back end
� Java +17;
� Spring +3;
� Angular +16;
� PostgreSQL +16.
� Spring Security
� JPA / Hibernate
� Maven

##Padr�es de arquitetura e design (API):

� SOLID;
� Clean Architecture Ou port adapter architecture ou Hexagonal Architecture;
� Oauth 2.0;
� Rest;
� Swagger.

## Proposta:
Voc� dever� desenvolver uma central de ajuda. Esta plataforma dever� possuir uma API constru�da
com java utilizando o framework spring que servir� para fornecer a comunica��o necess�ria a uma aplica��o
web angular por onde os atendentes estar�o dando suporte a usu�rios que abrir�o chamados.

##Esta plataforma deve atender as seguintes hist�rias:
� Eu como usu�rio desejo logar para abrir um chamado;
� Eu como usu�rio desejo pontuar meu atendimento do chamado que foi encerrado (pesquisa de satisfa��o);
� Eu como usu�rio do gerenciador desejo realizar login;
� Eu como usu�rio do gerenciador desejo receber atualiza��es, em tempo real, de chamados solicitados por usu�rios;
� Eu como usu�rio do gerenciador desejo finalizar um atendimento;
� Eu como usu�rio desejo listar na aplica��o WEB, com pagina��o, todos os meus chamados, ou seja, somente os chamados que foram abertos por mim utilizando um filtro com um �nico campo que deve encontrar um registro pelo assunto ou pelo ID - c�digo do chamado.

 
## Implanta��o em produ��o

- Banco de dados: postgreSQL embutido no Spring Boot

# Como executar o projeto

## Back end
Pr�-requisitos: Java 17

```bash
# clonar reposit�rio
git clone https://github.com/wellsimiao/projeto-chamado.git
git clone https://gitlab.com/wellsimiao7788/projeto-chamado.git


# entrar na pasta do projeto back end
cd work6\central-de-ajuda

# executar o projeto
./mvnw spring-boot:run
```

# Autor

Wellington Simiao

https://www.linkedin.com/in/#projeto-chamado
