package Frame_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Frame_POM.POMClassTest;

public class ActionClass2Test extends GenericClassTest {
@Test
		public void google()
		{
			POMClassTest p=new POMClassTest(driver);
			driver.switchTo().frame(2);
			WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://docs.google.com/forms/d/1yfUq-GO9BEssafd6TvHhf0D6QLDVG3q5InwNE2FFFFQ/viewform?embedded=true']"));
			driver.switchTo().frame(iframe);
			p.google_link();
		}
}
