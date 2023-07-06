package Youtube;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.tika.exception.TikaException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Google {
	@Test()
	public void test() throws InterruptedException, IOException, SAXException, TikaException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		driver.findElement(By.xpath("//input[@name='upfile']")).sendKeys("C:\\Users\\HP\\Downloads\\Book1.csv");
		driver.findElement(By.xpath("//input[@name='note']")).sendKeys("Hello");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(1000);
		driver.quit();
//		FileInputStream fs =new FileInputStream("");
//		BodyContentHandler ch=new BodyContentHandler();
//		Metadata mt=new Metadata();
//		ParseContext pc=new ParseContext();
//		PDFParser p=new PDFParser();
//		p.parse(fs, ch, mt, pc);
//		System.out.println(ch.toString());
	}
}
