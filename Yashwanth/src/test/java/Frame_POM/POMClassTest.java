package Frame_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Declaration
public class POMClassTest {
	
@FindBy(xpath="//input[@name='mytext1']")
private WebElement frame1;

@FindBy(xpath="//input[@name='mytext2']")
private WebElement frame2;

@FindBy(xpath="//input[@name='mytext3']")
private WebElement frame3;

@FindBy(xpath="(//div[@class='d7L4fc bJNwt  FXLARc aomaEc ECvBRb'])[3]")
private WebElement radiobutton;

@FindBy(xpath="//input[@class='Hvn9fb zHQkBf']")
private WebElement others_textfield;

@FindBy(xpath="(//div[@class='eBFwI'])[3]")
private WebElement checkbox;

@FindBy(xpath="//div[@class='MocG8c HZ3kWc mhLiyf LMgvRb KKjvXb DEh1R']")
private WebElement listbox;

@FindBy(xpath="(//div[.='Well, now I know :-)'])[2]")
private WebElement list_option;

@FindBy(xpath="//span[.='Next']")
private WebElement nextbutton;

@FindBy(xpath="//input[@class='whsOnd zHQkBf']")
private WebElement shorttext;

@FindBy(xpath="//textarea[@class='KHxj8b tL9Q4c']")
private WebElement longtext;

@FindBy(xpath="//span[.='Submit']")
private WebElement submitbutton;

@FindBy(xpath="//input[@name='mytext4']")
private WebElement frame4;

@FindBy(xpath = "//a[.='Sign in to Google']")
private WebElement googlelink;

@FindBy(xpath = "//a[@class='TYUeKb']")
private WebElement learnmorelink;

//Initialization
public POMClassTest(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

//Utilization
public void frame1(String f1_text)
{
	frame1.sendKeys(f1_text);
}

public void frame2(String f2_text)
{
	frame2.sendKeys(f2_text);
}

public void frame3(String f3_text)
{
	frame3.sendKeys(f3_text);
}

public void radio_button()
{
	radiobutton.click();
}

public void other_TF(String other_text)
{
	others_textfield.sendKeys(other_text);
}

public void check_box()
{
	checkbox.click();
}

public void list_box()
{
	listbox.click();
}

public void list_option()
{
	list_option.click();
}

public void next_button()
{
	nextbutton.click();
}

public void short_text(String s_text)
{
	shorttext.sendKeys(s_text);
}

public void long_text(String l_text)
{
	longtext.sendKeys(l_text);
}

public void submit_button()
{
	submitbutton.click();
}

public void frame4(String f4_text)
{
	frame4.sendKeys(f4_text);
}

public void google_link()
{
	googlelink.click();
}

public void learnmore_link()
{
	learnmorelink.click();
}
}
