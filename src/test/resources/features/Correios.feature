#language: pt
#/**
# * Autor: Lucas Candido
# * Empresa: Atomic Solutions
# * Data: 27/02/2020
# *
# */

@Correios 
Funcionalidade: Pesquisa site Correios
  
  Eu como analista de testes quero validar as informações
  retornadas das pesquisas por CEP e Logradouro no site dos Correios.

  @Correios @Lucas_Candido @PesquisarCEP
  Esquema do Cenario: Validar informacoes retornadas da pesquisa pelo CEP no site dos Correios
    Dado que estou na pagina Home dos Correios
    Quando informar o CEP <cep> para realizar a pesquisa
    Entao valido o redirecionamento da pagina e gero um arquivo com as informacoes da tabela de resultados da busca pelo CEP

    Exemplos: 
      | cep         |
      | "01311-922" |

  @Correios @Lucas_Candido @PesquisarLogradouro
  Esquema do Cenario: Validar informacoes retornadas da pesquisa pelo Logradouro no site dos Correios
    Dado que estou na pagina Home dos Correios
    Quando informar o logradouro <logradouro> para realizar a pesquisa
    Entao valido o redirecionamento da pagina e gero um arquivo com as informacoes da tabela de resultados da busca pelo logradouro

    Exemplos: 
      | logradouro         |
      | "avenida sao joao" |
