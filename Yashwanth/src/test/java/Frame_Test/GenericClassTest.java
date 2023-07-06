package Frame_Test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericClassTest {
	WebDriver driver;
	@BeforeMethod
	public void open() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://ui.vision/demo/webtest/frames/");
}
	@AfterMethod
	public void close() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
}
