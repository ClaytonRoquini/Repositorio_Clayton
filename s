[1mdiff --git "a/Utilidades/C\303\263digos importatntes.txt" "b/Utilidades/C\303\263digos importatntes.txt"[m
[1mdeleted file mode 100644[m
[1mindex dfca25f..0000000[m
[1m--- "a/Utilidades/C\303\263digos importatntes.txt"[m	
[1m+++ /dev/null[m
[36m@@ -1,78 +0,0 @@[m
[31m-def informarEmpresa(elem):[m
[31m-  empresa=Sys.Process("PRG010100").VBObject("frmPRG010100").VBObject("picEmpre").VBObject("txtCodEmp")[m
[31m-  empresa.Keys(elem)[m
[31m-  empresa.Keys("[Enter]")[m
[31m-  Delay(1000)[m
[31m-  [m
[31m-  if Sys.WaitProcess("PRG010100",100).WaitWindow("#32770", "Atenção", 1,100).Exists:[m
[31m-    buttonSim= Sys.Process("PRG010100").Window("#32770", "Atenção", 1).Window("Button", "&Sim", 1)[m
[31m-    buttonSim.clickbutton()[m
[31m-  else: [m
[31m-    fecharRotina=Sys.Process("PRG010100").VBObject("frmPRG010100")[m
[31m-    fecharRotina.Close()[m
[31m-    Delay(4000) [m
[31m-    return False[m
[31m-  return True[m
[31m-[m
[31m-*********************************************************************************************************[m
[31m-def selecionarPersonalidade(elem):[m
[31m-  [m
[31m-  if elem == "Jurídica":[m
[31m-    personalidadeJuridica=Sys.Process("PRG010100").VBObject("frmPRG010100").Window("ThunderRT6FormDC", "Dados Básicos", 1).Window("ThunderRT6Frame", "Personalidade", 3).Window("ThunderRT6OptionButton", "Jurídica", 2)[m
[31m-    personalidadeJuridica.ClickButton()[m
[31m-  else:[m
[31m-    personalidadeFisica=Sys.Process("PRG010100").VBObject("frmPRG010100").Window("ThunderRT6FormDC", "Dados Básicos", 1).Window("ThunderRT6Frame", "Personalidade", 3).Window("ThunderRT6OptionButton", "Física", 1)[m
[31m-    personalidadeFisica.ClickButton()[m
[31m-***********************************************************************************************************[m
[31m-def clicarAbaClassificacaoTributaria():[m
[31m-  classificasaoTributaria=Sys.Process("PRG010100").VBObject("frmPRG010100").VBObject("frmFolha").VBObject("picESocial").Window("XTPDockingPaneTabbedContainer", "", 1).VBObject("frmESocial").VBObject("fraEfdSocial").VBObject("ctlTabControlOpcoesESocial")[m
[31m-  OCR.Recognize(classificasaoTributaria).BlockByText("Classificação").Click()[m
[31m-***********************************************************************************************************[m
[31m-def aguardarTelaDiagnostico():[m
[31m-  Log.Enabled=False[m
[31m-  while True: [m
[31m-    if Sys.Process("PRG010900").VBObject("mdiPrincipal").Window("MDIClient", "", 1).VBObject("frmExclusaoEmpresa").VBObject("tabProcessos").VBObject("pbDiagnostico").Value== Sys.Process("PRG010900").VBObject("mdiPrincipal").Window("MDIClient", "", 1).VBObject("frmExclusaoEmpresa").VBObject("tabProcessos").VBObject("pbDiagnostico").Max:[m
[31m-      break[m
[31m-  Log.Enabled=True[m
[31m-*********************************************************************************************************[m
[31m-def status(elem,resultado):[m
[31m-  status= Sys.Process("GpsSst").WinFormsObject("frmCadastroAgenteNocivo").WinFormsObject("tabelControlAgenteNocivo").WinFormsObject("tabPageAgenteNocivo").WinFormsObject("AgenteNocivoInformacaoControl").WinFormsObject("panelFormularioAgenteNocivo").WinFormsObject("cmbStatus")[m
[31m-  status.ClickItem(elem)[m
[31m-  Utilidades.AssertEqual(resultado,status.wText)  [m
[31m-#  Log.Message(status.wText)[m
[31m-  [m
[31m-#def teste():[m
[31m-#  var="clayton"[m
[31m-#  var=var[2:][m
[31m-#  Log.message(var)[m
[31m-**********************************************************************************************************[m
[31m-def incluirCodigoAgenteNocivo(elem,resultado):[m
[31m-  incluirCodigoAgenteNocivo= Sys.Process("GpsSst").WinFormsObject("frmCadastroAgenteNocivo").WinFormsObject("tabelControlAgenteNocivo").WinFormsObject("tabPageAgenteNocivo").WinFormsObject("AgenteNocivoInformacaoControl").WinFormsObject("panelFormularioAgenteNocivo").WinFormsObject("dPesqAgenteNocivoOficial").WinFormsObject("tableLayoutPanel1").WinFormsObject("txt_search")[m
[31m-  incluirCodigoAgenteNocivo.DblClick()[m
[31m-  incluirCodigoAgenteNocivo.Keys(elem)[m
[31m-  incluirCodigoAgenteNocivo.Keys("[Enter]")[m
[31m-  Utilidades.AssertEqual(resultado,(incluirCodigoAgenteNocivo.wText)[:].replace(" ",""))[m
[31m-**********************************************************************************************************[m
[31m-def clicarExcluiremUsoLote(elem):[m
[31m-  clicarExcluir= Sys.Process("GPSSST").WinFormsObject("frmPrincipal").WinFormsObject("sctMenu").WinFormsObject("SplitterPanel", "", 2).WinFormsObject("ListaAgenteNocivoControl").WinFormsObject("panelCabecalho").WinFormsObject("ListaCabecalhoControl").WinFormsObject("flowLayoutPanelAddRemove").WinFormsObject("btnExcluir")[m
[31m-  clicarExcluir.Click()[m
[31m-  confirma=Sys.Process("GPSSST").Window("#32770", "Atenção", 1).Window("Button", "&Sim", 1)[m
[31m-  confirma.Click()[m
[31m-  validaExcluir= Sys.Process("GPSSST").Window("#32770", "Atenção", 1).Window("Static", "Um ou mais cadastros estão em uso e não foram excluídos.\r\n\r\nEm alternativa a exclusão é possível alterar o campo status para \"inativo\", evitando que sejam utilizados novamente e mantendo seu histórico de utilização.", 2)[m
[31m-  Utilidades.AssertEqual(elem,validaExcluir.WndCaption.replace("\n","").replace("\r",""))[m
[31m-  if Sys.WaitProcess("GPSSST",100).WaitWindow("#32770", "Atenção", 1,100).Exists:[m
[31m-    clickButton=Sys.Process("GPSSST").Window("#32770", "Atenção", 1).Window("Button", "OK", 1)[m
[31m-    clickButton.ClickButton()[m
[31m-************************************************************************************************************[m
[31m-def logLimiteDeTolerancia(resultado):[m
[31m-  logLimiteDeTolerancia= Sys.Process("GpsSst").WinFormsObject("frmCadastroAgenteNocivo").WinFormsObject("tabelControlAgenteNocivo").WinFormsObject("tabPageAgenteNocivo").WinFormsObject("AgenteNocivoInformacaoControl").WinFormsObject("panelFormularioAgenteNocivo").WinFormsObject("txtLimiteTolerancia")  [m
[31m-  Utilidades.AssertEqual(resultado,(logLimiteDeTolerancia.wText)[:].replace(" ",""))[m
[31m-*************************************************************************************************************[m
[31m-def fimExclusaoAgenteNocivo():[m
[31m-  Log.Message("Fim do Processamento Exclusao Agente Nocivo")[m
[31m-************************************************************************************************************[m
[31m-def msgManut():[m
[31m-  while Sys.WaitProcess("ManutInvRdm",1000).WaitWindow("#32770", "Atenção", 1,1000).Exists:[m
[31m-    Delay(1000)[m
[31m-  dat=Sys.Process("ManutInvRdm").Window("#32770", "Atenção", 1).Window("Button", "OK", 1)[m
[31m-  dat.Click()[m
\ No newline at end of file[m
