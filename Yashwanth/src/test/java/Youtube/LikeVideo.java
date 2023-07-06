package Youtube;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LikeVideo {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.youtube.com/");
	driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys("cucumber framework selenium");
	driver.findElement(By.id("search-icon-legacy")).click();
	driver.findElement(By.xpath("//a[@href='/watch?v=4e9vhX7ZuCw&list=PLhW3qG5bs-L_mFHirOLEYJ7X2rIXu8SR2' and @id='thumbnail']")).click();
	Thread.sleep(3000);
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0, 300);");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@id='menu' and @class='style-scope ytd-watch-metadata']//yt-smartimation/div/div[1]")).click();
	Thread.sleep(2000);
	driver.quit();
}
}
