$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/feature/alugar_filme.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# language: pt"
    }
  ],
  "line": 2,
  "name": "Alugar Filme",
  "description": "Como um usuario\r\nEu quero cadastrar aluguéis de filmes\r\nPara controlar preços e datas de entregas",
  "id": "alugar-filme",
  "keyword": "Funcionalidade"
});
formatter.scenario({
  "line": 7,
  "name": "Deve alugar um filme com sucesso",
  "description": "",
  "id": "alugar-filme;deve-alugar-um-filme-com-sucesso",
  "type": "scenario",
  "keyword": "Cenário"
});
formatter.step({
  "line": 8,
  "name": "um filme com estoque de 2 unidades",
  "keyword": "Dado "
});
formatter.step({
  "line": 9,
  "name": "que o preço do aluguel seja R$ 3",
  "keyword": "E "
});
formatter.step({
  "line": 10,
  "name": "alugar",
  "keyword": "Quando "
});
formatter.step({
  "line": 11,
  "name": "o preço do aluguel será R$ 3",
  "keyword": "Então "
});
formatter.step({
  "line": 12,
  "name": "o a data de entrega será no dia seguinte",
  "keyword": "E "
});
formatter.step({
  "line": 13,
  "name": "o estoque do filme será 1 unidade",
  "keyword": "E "
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 24
    }
  ],
  "location": "AlugarFilmesSteps.umFilmeComEstoqueDeUnidades(int)"
});
formatter.result({
  "duration": 336254700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 31
    }
  ],
  "location": "AlugarFilmesSteps.queOPreçoDoAluguelSejaR$(int)"
});
formatter.result({
  "duration": 95900,
  "status": "passed"
});
formatter.match({
  "location": "AlugarFilmesSteps.alugar()"
});
formatter.result({
  "duration": 947700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 27
    }
  ],
  "location": "AlugarFilmesSteps.oPreçoDoAluguelSeráR$(int)"
});
formatter.result({
  "duration": 1488200,
  "status": "passed"
});
formatter.match({
  "location": "AlugarFilmesSteps.oADataDeEntregaSeráNoDiaSeguinte()"
});
formatter.result({
  "duration": 124300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 24
    }
  ],
  "location": "AlugarFilmesSteps.oEstoqueDoFilmeSeráUnidade(int)"
});
formatter.result({
  "duration": 271700,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Não deve alugar filme sem estoque",
  "description": "",
  "id": "alugar-filme;não-deve-alugar-filme-sem-estoque",
  "type": "scenario",
  "keyword": "Cenário"
});
formatter.step({
  "line": 16,
  "name": "um filme com estoque de 0 unidades",
  "keyword": "Dado "
});
formatter.step({
  "line": 17,
  "name": "alugar",
  "keyword": "Quando "
});
formatter.step({
  "line": 18,
  "name": "não será possivel por falta de estoque",
  "keyword": "Então "
});
formatter.step({
  "line": 19,
  "name": "o estoque do filme será 0 unidade",
  "keyword": "E "
});
formatter.match({
  "arguments": [
    {
      "val": "0",
      "offset": 24
    }
  ],
  "location": "AlugarFilmesSteps.umFilmeComEstoqueDeUnidades(int)"
});
formatter.result({
  "duration": 90600,
  "status": "passed"
});
formatter.match({
  "location": "AlugarFilmesSteps.alugar()"
});
formatter.result({
  "duration": 54800,
  "status": "passed"
});
formatter.match({
  "location": "AlugarFilmesSteps.nãoSeráPossivelPorFaltaDeEstoque()"
});
formatter.result({
  "duration": 44200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0",
      "offset": 24
    }
  ],
  "location": "AlugarFilmesSteps.oEstoqueDoFilmeSeráUnidade(int)"
});
formatter.result({
  "duration": 95700,
  "status": "passed"
});
});