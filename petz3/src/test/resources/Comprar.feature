#language: pt
Funcionalidade: Comprar Produto

  # Fluxo de compras no site Petz
  # Envolve as paginas Home, Resultado da Consulta e Detalhes Paginas
  @all @1
  Cenario: Compra a partir de uma busca
    Dado que acesso o site Petz
    Quando busco por "coleira" e pressiono Enter
    Entao exibe uma lista de produtos relacionados com "coleira"
    Quando escolho "Coleira Petz Azul para Cães"
    Entao exibe para o "Tamanho PP"
    E o preço "R$ 29,00"
