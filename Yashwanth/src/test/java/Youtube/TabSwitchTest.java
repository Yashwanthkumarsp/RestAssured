package Youtube;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TabSwitchTest {
	@Test
	public void test1() throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
		System.out.println(driver.getTitle());
		//((JavascriptExecutor) driver).executeScript ("window.open()"); 
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript ("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles()); 
		//to open new tab 
		driver.switchTo().window (tabs.get(1));
		driver.get("https://www.fb.com");
		//To come back to previews tab 
		driver.switchTo().window (tabs.get(0));
		//driver.getWindowHandles().forEach(tab-> driver.switchTo().window(tab)); //switching tabs
		Thread.sleep(2000);
		driver.quit();
	}
}
