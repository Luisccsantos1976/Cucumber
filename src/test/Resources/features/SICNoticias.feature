Feature: Acesso ao site SIC Notícias

  Como um usuário
  Quero acessar o site SIC Notícias
  Para verificar se a página é carregada corretamente, aceitar a política de privacidade e acessar a seção do Conflito Israel-Palestina

  @requires_browser
  Scenario: O utilizador acessa o site SIC Notícias e aceita a política de privacidade
    Given o utilizador navega para a página inicial da SIC Notícias
    Then a página da SIC Notícias deve ser exibida corretamente
    And o utilizador aceita e fecha a política de privacidade
    And o utilizador acessa a seção Conflito Israel-Palestina
