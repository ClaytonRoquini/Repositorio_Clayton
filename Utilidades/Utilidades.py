import shutil,os,re

def GetText(Elemento):
  if (type(Elemento.Text) is str ): 
    return Elemento.Text
  elif (type(Elemento.wText) is str ):
    return Elemento.wText
  else:
    return OCR.Recognize(Elemento).FullText
    
def InsereTexto(Elemento,Texto):
  Elemento.SetText(Texto)
  AssertEquals(Texto, GetText(Elemento))

def DigitaTexto(Elemento,Texto):
  Elemento.Keys(Texto)
  AssertEquals(Texto, GetText(Elemento))

def ClickElemento(Elemento):
  Elemento.Click()

def ClickDoubleElemento(Elemento):
  Elemento.DblClick()

def CheckElemento(Elemento,status):
  if(status == 1):
    Elemento.ClickButton(cbChecked)
  else:
    Elemento.ClickButton(cbUnchecked)
    
def ClickTabElemento(Elemento,Texto):
  Elemento.ClickTab(Texto)
  
def ClickDoubleItemElemento(Elemento,Texto):
  Elemento.DblClickItem(Texto)

def ClickItemElemento(Elemento,Texto,Texto2 = None):
  if Texto2 == None:
    Elemento.ClickItem(Texto)
  else:
    Elemento.ClickItem(Texto,Texto2)

def selecioneCombo(Elemento,Texto):
  Elemento.ClickItem(Texto)

def VerificaCheckBox(Elemento):
  if Elemento.wState == 1:
    return True
  else:
    return False

def AssertEquals(ValorEsperado, ValorTela, Coluna=''):
  
  if(ValorEsperado != ValorTela):
    if Project.Variables.VariableExists('crit1'):
      if Coluna == '':
        Log.Error("Empresa: \""+Project.Variables.crit1.Value["Empresa"]+"\" => Valor esperado: \""+ValorEsperado+"\" e o valor na tela: \""+ValorTela+"\"")
      else:  
        Log.Error("Empresa: \""+Project.Variables.crit1.Value["Empresa"]+"\" => O campo \""+Project.Variables.crit1.ColumnName[int(Coluna)]+"\". Valor esperado: \""+ValorEsperado+"\" e o valor na tela: \""+ValorTela+"\"")
    else:
      Log.Error("Valor esperado: \""+ValorEsperado+"\" e o valor na tela: \""+ValorTela+"\"")
  else:
    if Project.Variables.VariableExists('crit1'):
      if Coluna == '':
        Log.Checkpoint("Empresa: \""+Project.Variables.crit1.Value["Empresa"]+"\" => Valor Esperado: \""+ValorEsperado+"\" é igual  Valor na tela \""+ValorTela+"\"")
      else:  
        Log.Checkpoint("Empresa: \""+Project.Variables.crit1.Value["Empresa"]+"\" => O campo \""+Project.Variables.crit1.ColumnName[int(Coluna)]+"\". Valor esperado: \""+ValorEsperado+"\" e o valor na tela: \""+ValorTela+"\"")
    else:
      Log.Checkpoint("Valor Esperado: \""+ValorEsperado+"\" é igual  Valor na tela \""+ValorTela+"\"")

                  
def Informa(Texto):
  return Log.Message("##**##**##**##**##**##**##**##**##     "+Texto+"     ##**##**##**##**##**##**##**##**##") 
  
       
def AguardeElementoEnabled(Elemento,contador = 10): 
  while not Elemento.Enabled:
    if not contador == 0:
      Delay(1000)
      contador -= 1
    else:
      break  

def AguardeVBObject(Processo,VBObject,contador = 10): 
  while not Sys.Process(Processo).WaitVBObject(VBObject,contador).Exists:
    if not contador == 0:
      Delay(1000)
      contador -= 1
    else:
      break 
     
def AguardeProcesso(nomeProcesso, contador = 10):
  p = Sys.Process(nomeProcesso)
  while not p.Visible:
   if not contador == 0:
      Delay(1000)
      contador -= 1
   else:
      break
      
def EsperarElementoDesaparecer_Processo2(Processo):
   while True:
     p = Sys.Process(Processo)
     if not p.Visible: 
       break
     

def AguardeWindow(Processo,Window,contador = 10): 
  while not Sys.Process(Processo).WaitWindow(Window,contador).Exists:
    if not contador == 0:
      Delay(1000)
      contador -= 1
    else:
      break 
          
# Exemplo de utilizaÃ§Ã£o do mÃ©todo:
# Elemento = 'Aliases.PRG010100.frmPRG010100'
# Elemento = 'Sys.Process("PRG010100").VBObject("frmPRG010100")' 
# Processo = "PRG010100"
def EsperarElementoDesaparecer_Processo(Processo):
   while True:
     p = Sys.WaitProcess(Processo,2000)
     if not p.IsOpen: 
       break
       
def EsperarElementoDesaparecer_Windows(Process):
   while True:
     Delay(2000)
     if not Process.Enabled: 
       break

def VerificaValorCheckBox(valor):
  if valor == "Sim":
    return 1
  else:
    return 0
  
def AssertIn(ValorEsperado, ValorTela):
  if ValorEsperado in ValorTela:
    Log.Checkpoint("A tela contains o valor \""+ValorEsperado+"\"")
  else:
    Log.Error("A tela não contains o valor \""+ValorEsperado+"\"")


# Medicao de Performance       

def PerformanceStart():
  aqPerformance.Start() 

def PerformanceGetTime():
  #Log do tempo de execuÃ§Ã£o Total apÃ³s o start
  time = (aqPerformance.__getprop__("Value"))/1000
  Log.Message("Tempo: " + InttoStr(time) + "s" )
  
def PerformanceCheck(time):
  #Checagem do tempo definido
  aqPerformance.Check(time)  
    
# --- Método para Excluir Arquivos -------------      
def Remove_Arquivos(folder,type):
  #folder = 'C:\\xml'
  #type = '.xml'     
  for file in os.listdir(folder):
    if re.search(type,file):
      file_path = os.path.join(folder, file)
      os.unlink(file_path)
      Log.Message("Arquivo Removido: " + file)
      
def Remove_Conteudo_Pasta(folder):
  #folder = 'C:\\xml'
  for the_file in os.listdir(folder):
      file_path = os.path.join(folder, the_file)
      if os.path.isfile(file_path):
        os.unlink(file_path)

def Remove_Pasta(folder):
  if os.path.isdir(folder):
    shutil.rmtree(folder)

# --- Método HighLight -------------
def Highlight(elem):  
  Sys.HighlightObject(elem, 2, RGB(255, 0, 0))
    
def RGB(r, g, b):  
  rr = CorrectRGBComponent(r);
  gg = CorrectRGBComponent(g);
  bb = CorrectRGBComponent(b);
  return rr | (gg << 8) | (bb << 16);

def CorrectRGBComponent(value):
  val = aqConvert.VarToInt(value)
  if (val < 0):
    return 0
  if (val > 255):
    return 255
  return val
  
    
      
def AssertEqual(ValorEsperado, ValorTela):
  if str(ValorEsperado) == "None":
    ValorEsperado = ""
  ValorEsperado = str(ValorEsperado)   
  if(ValorEsperado != ValorTela):
      Log.Error("Valor esperado: \""+ValorEsperado+"\" e o valor na tela: \""+ValorTela+"\"")
  else:
      Log.Checkpoint("Valor Esperado: \""+ValorEsperado+"\" é igual  Valor na tela \""+ValorTela+"\"")
    
    

