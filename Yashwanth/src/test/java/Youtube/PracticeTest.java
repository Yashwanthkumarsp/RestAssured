package Youtube;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeTest {
	@Test
	public void frame() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Yashwanth");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Kumar");
		driver.switchTo().parentFrame();
		driver.switchTo().frame(2);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("S P");
		WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://docs.google.com/forms/d/1yfUq-GO9BEssafd6TvHhf0D6QLDVG3q5InwNE2FFFFQ/viewform?embedded=true']"));
		driver.switchTo().frame(iframe);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath("(//div[@class='d7L4fc bJNwt  FXLARc aomaEc ECvBRb'])[3]")).click();
		driver.findElement(By.xpath("//input[@class='Hvn9fb zHQkBf']")).sendKeys("Controlled By Automated Test Software");
		js.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath("(//div[@class='eBFwI'])[3]")).click();
		js.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath("//div[@class='MocG8c HZ3kWc mhLiyf LMgvRb KKjvXb DEh1R']")).click();
		driver.findElement(By.xpath("(//div[.='Well, now I know :-)'])[2]")).click();
		driver.findElement(By.xpath("//span[.='Next']")).click();
		js.executeScript("window.scrollBy(0,100)");
		driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']")).sendKeys("Hello");
		js.executeScript("window.scrollBy(0,100)");
		driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']")).sendKeys("Good site for practicing automation testing");
		driver.findElement(By.xpath("//span[.='Submit']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(3);
		driver.findElement(By.xpath("//input[@name='mytext4']")).sendKeys("India");
		Thread.sleep(2000);
		driver.quit();
	}
}
