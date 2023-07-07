package Youtube;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class techlistTest {
	@Test
	public void test1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Firstname");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Lastname");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		driver.findElement(By.id("exp-0")).click();
		driver.findElement(By.id("datepicker")).sendKeys("07-07-2023");
		js.executeScript("window.scrollBy(0,400)");
		driver.findElement(By.xpath("//input[@value='Selenium Webdriver']")).click();
		WebElement dropdown = driver.findElement(By.id("selenium_commands"));
		Select s = new Select(dropdown);
		s.selectByIndex(2);
		driver.findElement(By.xpath("//input[@class='input-file']")).sendKeys("C:\\Users\\HP\\Downloads\\Book1.csv");
		driver.findElement(By.xpath("//a[@href='https://github.com/stanfy/behave-rest/blob/master/features/conf.yaml']")).click();
		driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));	
		Thread.sleep(2000);
		//driver.quit();
	}
}
