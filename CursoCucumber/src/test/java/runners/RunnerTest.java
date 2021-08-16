package runners;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/feature/inserir_conta.feature",
		glue = "steps",
		tags = {},
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false
		)
public class RunnerTest {
	
@BeforeClass
public static void reset() {
	
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://seubarriga.wcaquino.me/login");	
	driver.findElement(By.id("email")).sendKeys("clayton.roquini@hotmail.com");
	driver.findElement(By.name("senha")).sendKeys("Wolters@102030");
	driver.findElement(By.tagName("button")).click();
	driver.findElement(By.linkText("reset")).click();
	driver.quit();
}
}
