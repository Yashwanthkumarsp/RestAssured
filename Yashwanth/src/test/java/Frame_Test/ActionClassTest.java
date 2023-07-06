package Frame_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Frame_POM.POMClassTest;

public class ActionClassTest extends GenericClassTest {
@Test
public void action()
{
	POMClassTest p=new POMClassTest(driver);
	driver.switchTo().frame(0);
	p.frame1("Yashwanth");
	driver.switchTo().defaultContent();
	driver.switchTo().frame(1);
	p.frame2("Kumar");
	driver.switchTo().defaultContent();
	driver.switchTo().frame(2);
	p.frame3("S P");
	WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://docs.google.com/forms/d/1yfUq-GO9BEssafd6TvHhf0D6QLDVG3q5InwNE2FFFFQ/viewform?embedded=true']"));
	driver.switchTo().frame(iframe);
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,200)");
	p.radio_button();
	p.other_TF("Controlled By Automated Test Software");
	js.executeScript("window.scrollBy(0,200)");
	p.check_box();
	js.executeScript("window.scrollBy(0,200)");
	p.list_box();
	p.list_option();
	p.next_button();
	js.executeScript("window.scrollBy(0,100)");
	p.short_text("Nice");
	js.executeScript("window.scrollBy(0,100)");
	p.long_text("Good site for practicing automation testing");
	p.submit_button();
	driver.switchTo().defaultContent();
	driver.switchTo().frame(3);
	p.frame4("Sira");
}
}
