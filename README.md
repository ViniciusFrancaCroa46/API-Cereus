Sobre o projeto da GS1-2025:
  Backend em Java utilizando o framework SpringBoot, que será usado em conjunto da aplicação em React Native, 
  com objetivo de simular um sistema de detecção, alerta e ativação de barreiras para prevenir alagamentos.

Observações do funcionamento:

- Para acessar o banco de dados (http://localhost:8080/h2-console/)

- Os endereços dos EndPoint
  - Para registro
  /monitoramento/registrar/sensores-agua
  /monitoramento/registrar/barreira

  - Para visualização
  /monitoramento/barreira
  /monitoramento/sensores-agua
  /monitoramento/alerta

  - Para buscar e exclusão por id
  /monitoramento/sensores-agua/id
  /monitoramento/barreira/id

  - Os alertas são gerados automaticamente,
    sendo vinculados aos sensores que registram o nível da água maior que 5 m;
  - As barreiras serão ativadas quando um alerta é gerado, mas caso um dado de um sensor seja salvo,
    elas serão desativadas;
    

Equipe Cereus ©
Integrantes:
- Vinicius França C. RM557988
- Olivier A. RM98585
- Julivan Wagner RM559030

  
