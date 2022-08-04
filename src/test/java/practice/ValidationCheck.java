package practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resource.Base;

public class ValidationCheck extends Base{
	
WebDriver driver;
	
@BeforeTest
public void initialize() throws IOException
{
	driver = initializeDriver();
	driver.navigate().to(prop.getProperty("url"));
	
}
	@Test
	public void validation() throws IOException
	{
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		LandingPage lp= new LandingPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(lp.getLightbox()));
		lp.getLightbox().click();
        
		Assert.assertEquals(lp.getText().getText(),"FEATURED COURSESes");
		Assert.assertTrue(lp.getLink().isDisplayed());
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	}

