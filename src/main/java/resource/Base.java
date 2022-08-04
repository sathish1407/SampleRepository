package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	WebDriver driver;
	protected Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		prop= new Properties();
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resource\\testdata.properties");
		
		prop.load(fis);
		
//		System.out.println(prop.getProperty("browser"));
		
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sathishdurga\\Desktop\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
		}
		else if (browsername.equals("firefox"))
		{
			System.out.println("no driver initialized");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sathishdurga\\Desktop\\driver");
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		return driver;
		
	}
	
	public String getScreenShot(String name,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"\\report\\"+name+".png";
		FileUtils.copyFile(src, new File(path));
		return path;
	}

}
