Feature: Acesso ao site do Sapo

  Como um usuário
  Quero acessar o site do Sapo
  Para verificar se a página inicial é carregada corretamente e navegar até as seções de "Atualidade", "Entretenimento" e "Mail".

  @requires_browser
  Scenario: O utilizador acessa o site do Sapo, seleciona as seções Atualidade, Entretenimento e Capas de Jornais
    Given o utilizador navega para a página inicial do Sapo
    Then a página do Sapo deve ser exibida corretamente
    And o utilizador seleciona Atualidade
    And o utilizador seleciona Entretenimento
    And o utilizador seleciona Capas de Jornais

  @requires_browser
  Scenario: O utilizador acessa o site do Sapo e faz login no Mail com Google
    Given o utilizador navega para a página inicial do Sapo
    Then a página do Sapo deve ser exibida corretamente
    And o utilizador seleciona a opção de Mail
    And o utilizador clica na opção de Entrar com Google
    And o utilizador seleciona a conta Luis Carlos Cera Santos
    Then o utilizador vê a mensagem de erro "Não foi possível iniciar sessão" e clica em Tentar Novamente
