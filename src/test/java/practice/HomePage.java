package practice;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resource.Base;

public class HomePage extends Base{
	
WebDriver driver;
private static Logger log = LogManager.getLogger(HomePage.class.getName());

@BeforeTest
public void initialize() throws IOException
{
	driver = initializeDriver();
	log.info("initializing browser");
	driver.navigate().to(prop.getProperty("url"));
	
}
	
	@Test(dataProvider="logindetails")
	public void navigation(String email,String password) throws IOException
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		LandingPage lp= new LandingPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(lp.getLightbox()));
		log.info("closing lightbox");
		lp.getLightbox().click();
		log.info("selecting login link");
		lp.getToLogin().click();
		log.error("testing report");
		LoginPage lop= new LoginPage(driver);
		
		log.info("entering email id");
		lop.getEmail().sendKeys(email);
		lop.getPassword().clear();
		log.info("entering password");
		lop.getPassword().sendKeys(password);
		lop.getLogin().click();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	@DataProvider(name="logindetails")
	public Object[][] getdata()
	{
		return new Object[][] {{"Sathish","password"}};
	}
	
	
	
	}

