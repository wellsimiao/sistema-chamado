# Desafio foi projetado para avaliar a sua capacidade técnica como candidato à vaga de
desenvolvedor de software sênior.

# Sobre o projeto

Instruções:
1. Crie um repositório público no gitlab.com;
2. Utilize todas as tecnologias informadas abaixo;
3. O backend deve ser desenvolvido utilizando os padrões de arquitetura e designer
sugeridos abaixo;
4. O repositório deverá conter um docker-compose devidamente configurado com os services (backend, frontend e database) e um tutorial de como subir o projeto para validação;
5. Deve ser construído um pipeline para o repositório com 2 tarefas:
6 – Instalação de dependências
7 – Teste unitário quando a pipeline terminar deverá armazenar o artefado api.jar para download.
8. Você terá até 7 dias para concluir o desafio e deverá enviar o link do git para o e-mail
<colocar e-mail do rh da first> para ser avaliado.

# Tecnologias utilizadas

## Back end
• Java +17;
• Spring +3;
• Angular +16;
• PostgreSQL +16.
• Spring Security
• JPA / Hibernate
• Maven

##Padrões de arquitetura e design (API):

• SOLID;
• Clean Architecture Ou port adapter architecture ou Hexagonal Architecture;
• Oauth 2.0;
• Rest;
• Swagger.

## Proposta:
Você deverá desenvolver uma central de ajuda. Esta plataforma deverá possuir uma API construída
com java utilizando o framework spring que servirá para fornecer a comunicação necessária a uma aplicação
web angular por onde os atendentes estarão dando suporte a usuários que abrirão chamados.

##Esta plataforma deve atender as seguintes histórias:
• Eu como usuário desejo logar para abrir um chamado;
• Eu como usuário desejo pontuar meu atendimento do chamado que foi encerrado (pesquisa de satisfação);
• Eu como usuário do gerenciador desejo realizar login;
• Eu como usuário do gerenciador desejo receber atualizações, em tempo real, de chamados solicitados por usuários;
• Eu como usuário do gerenciador desejo finalizar um atendimento;
• Eu como usuário desejo listar na aplicação WEB, com paginação, todos os meus chamados, ou seja, somente os chamados que foram abertos por mim utilizando um filtro com um único campo que deve encontrar um registro pelo assunto ou pelo ID - código do chamado.

 
## Implantação em produção

- Banco de dados: postgreSQL embutido no Spring Boot

# Como executar o projeto

## Back end
Pré-requisitos: Java 17

```bash
# clonar repositório
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
