import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void doLogin() {
		
		driver.get("http://gmail.com");
		driver.findElement(By.name("identifier")).sendKeys("anshumansehgal@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
		driver.findElement(By.name("password")).sendKeys("anshumansehgal");
		driver.findElement(By.xpath("//*[@id=\"forgotPassword\"]/span/span")).click();
	}
	
	@AfterSuite
	public void tearDown() {
		
		driver.quit();
		
	}
}
