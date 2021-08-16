package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class Lista extends PageObject {
	// Atributos
//	@FindBy(xpath = "//h3[contains(text(),'Coleira Petz Azul para Cães')]")
//	private WebElement produtoDesejado;
	
	@FindBy(xpath = "/html[1]/body[1]/div[9]/div[2]/div[2]/div[2]/div[1]/h1[1]")
	WebElement cabecalhoResultado;
	
	@FindBy(xpath = "/html[1]/body[1]/div[9]/main[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/label[1]/div[1]")
	WebElement tamanhoProduto;
	
	@FindBy(xpath = "/html[1]/body[1]/div[9]/main[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/label[1]/div[2]")
	WebElement valorProduto;
	

	
	//Construtor
	public Lista(WebDriver driver) {
		super(driver);
	}
	
	//Metodos ou Funções
	public void clicarNoProduto(String produto) {
//		produtoDesejado.click();
	    WebElement produtoDesejado = driver.findElement(By.xpath("//h3[contains(text(),'"+produto+"')]"));
	    produtoDesejado.click();
		
	  	}
	
	public String lerCabecalhoResultado() {
//		WebElement cabecalhoResultado = driver.findElement(By.cssSelector("h2h2Categoria.nomeCategoria"));
		return cabecalhoResultado.getText();
		
	}
	
	public String lerTamanhoProduto() {
//		WebElement cabecalhoResultado = driver.findElement(By.cssSelector("h2h2Categoria.nomeCategoria"));
		return tamanhoProduto.getText();
		
	}
	
	public String lerValorProduto() {
//		WebElement cabecalhoResultado = driver.findElement(By.cssSelector("h2h2Categoria.nomeCategoria"));
		return valorProduto.getText();
		
	}
		
}



