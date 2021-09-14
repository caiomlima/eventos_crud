Este projeto básico foi feito com o intuito de aprender mais sobre CRUD, HTML, CSS e javaScript e melhorar minhas habilidades nas tecnologias: Java, Spring Boot e Security, Thymeleaf (JSP), MySQL, JPA

No momento, o site contém:

- Conexão com o MySQL, Thymeleaf (JSP p/ input e output de dados), JPA (CRUD)


- Criação, exibição, edição e exclusão dos eventos (CRUD completo dos eventos)
  

- Criação de usuário com role "USER" e adm com role "ADM" - relação ManyToMany no MySQL entre as tabelas "usuarios" / "adms, "roles" e "relacao_users_roles" / "relacao_adms_roles"
  

- Login (autenticação) dos usuários e ADMs para controle de acesso a certos conteúdos (Controle de autoridade) com roles ("USER" e "ADM")
  

- Relação do evento ao email do ADM que criou o evento, possibilitando a limitação de update e delete apenas ao ADM que criou esse evento caso ele esteja logado