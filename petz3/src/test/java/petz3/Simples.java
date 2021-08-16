package petz3;


//2 - Bibliotecas Importados
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

// 3 - Classe
public class Simples {
    // 3.1 - Atributos
	public static WebDriver driver; // objeto do Selenium WebDriver
	 String url = "https://www.petz.com.br";
		
	// 3.2 - Métodos ou Funções
	
	@BeforeClass  // Antes do Teste
	public static void iniciar() {
	  
	  System.setProperty("webdriver.chrome.driver", "drivers/88/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();  //Maximizar a janela do browser
	  driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);  // Espera implicita de 30 segundos
	  
	}
	
	@AfterClass // Depois do Teste
	public static void finalizar() {
//		if (driver!=null) {
//		driver.close();
		driver.quit();
//	}
	}
	@Test //O Teste
	public void abrirPagina() {
		driver.get(url); // Abrir a pagina inicial do site petz
		assertEquals("Pet Shop: Petz o maior pet shop do Brasil.", driver.getTitle());  // Validou o texto da guia da pagina
		
	}
	

}
