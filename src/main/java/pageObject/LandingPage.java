package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
		
	By loginlink = By.xpath("//span[text()='Login']");
	
	By lightbox= By.xpath("//div[contains(@class,'sumome-react-svg-image-container')]/following::div");
	
	By textheading= By.xpath("//h2[text()='Featured Courses']");
	
//	By contact =  By.linkText("Contact");
	By contact = By.xpath("//a[text()='Contact']");
	
	public WebElement getToLogin()
	{
		return driver.findElement(loginlink);
	}
	
	public WebElement getLightbox()
	{
		return driver.findElement(lightbox);
	}
	
	public WebElement getText()
	{
		return driver.findElement(textheading);
	}
	
	public WebElement getLink()
	{
		return driver.findElement(contact);
	}

}
