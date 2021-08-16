package petz3;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.Home;
import pages.Lista;



public class Comprar {
	
	// 3.1 - Atributos
		public static WebDriver driver; // objeto do Selenium WebDriver
		 String url = "https://www.petz.com.br";
		 
		static Home home; //objeto homeherdando a calasse home
		static Lista lista; 
			
		// 3.2 - Métodos ou Funções
		
		@Before  // Antes do Teste
		public static void iniciar() {
		  
		  System.setProperty("webdriver.chrome.driver", "drivers/88/chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();  //Maximizar a janela do browser
		  driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);  // Espera implicita de 30 segundos
		 
		  home = new Home(driver);
		  lista = new Lista(driver);// instanciar a classe Lista
		}
		
		@After // Depois do Teste
		public static void finalizar() {
//			if (driver!=null) {
//			driver.close();
			driver.quit();
//		}
		}
	
	@Dado("^que acesso o site Petz$")
	public void que_acesso_o_site_Petz() {
	  driver.get(url);
	  System.out.println("**********************Passo1");
	}

	@Quando("^busco por \"([^\"]*)\" e pressiono Enter$")
	public void busco_por_e_pressiono_Enter(String produto)  {
		home.buscarProdutoComEnter(produto);
		
		System.out.println("**********************Passo2");
	}

	@Entao("^exibe uma lista de produtos relacionados com \"([^\"]*)\"$")
	public void exibe_uma_lista_de_produtos_relacionados_com(String produto)  {
		assertEquals("RESULTADOS PARA \""+produto.toUpperCase()+"\"",lista.lerCabecalhoResultado());
		System.out.println("**********************Passo3");
	   
	}

	@Quando("^escolho \"([^\"]*)\"$")
	public void escolho(String produto) {
		lista.clicarNoProduto(produto);
		System.out.println("**********************Passo4");
	 
	}

//	@Entao("^exibe para o \"([^\"]*)\" o preco de \"([^\"]*)\"$")
//	public void exibe_para_o_o_preco_de(String tamanho, String valor) {
//		assertEquals("Tamanho PP \""+tamanho+"\"",lista.lerTamanhoProduto());
//		assertEquals("Tamanho PP \""+valor+"\"",lista.lerTamanhoProduto());
//		System.out.println("**********************Passo5");
//	   
//	}

	@Entao("^exibe para o \"([^\"]*)\"$")
	public void exibe_para_o(String tamanho)  {
		assertEquals(tamanho,lista.lerTamanhoProduto()); 
		System.out.println("**********************Passo5");
	}

	@Entao("^o preço \"([^\"]*)\"$")
	public void o_preço(String valor) {
		assertEquals(valor,lista.lerValorProduto()); 
		System.out.println("**********************Passo6");
	
	}

}
