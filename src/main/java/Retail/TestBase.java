package Retail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestBase {
	
	public WebDriver driver;
	//Properties myProps;
	public String dynamicPath;
	
	public WebDriver initializeDriver() throws IOException
	{
		Boolean flag = true;
		Properties myProps = new Properties();
		String browserType = System.getProperty("browser");
		
		if(browserType == null)
		{
			flag = false;
			dynamicPath = System.getProperty("user.dir") + "\\Resources\\data.properties";
			FileInputStream fis = new FileInputStream(dynamicPath);
			myProps.load(fis);
					
		}
		
		if(flag == false)
		{
			if(myProps.getProperty("browser").contains("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Resources\\drivers\\chromedriver.exe");
				ChromeOptions co = new ChromeOptions();
				co.addArguments("disable-geolocation");
				driver = new ChromeDriver(co);
			}
			
			else if(myProps.getProperty("browser").contains("headless"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Resources\\drivers\\chromedriver.exe");
				ChromeOptions co = new ChromeOptions();
				co.addArguments("headless");
				co.addArguments("disable-geolocation");
				driver = new ChromeDriver(co);
			}
			
			else if(myProps.getProperty("browser").contains("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Resources\\drivers\\geckodriver.exe");
				FirefoxOptions ffo = new FirefoxOptions();
				ffo.addPreference("geo.enabled", false);
				driver = new FirefoxDriver(ffo);
			}
			else
			{
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Resources\\drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		}
		else
		{
			if(browserType.contains("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Resources\\drivers\\chromedriver.exe");
				ChromeOptions co = new ChromeOptions();
				co.addArguments("disable-geolocation");
				driver = new ChromeDriver(co);
			}
			
			else if(browserType.contains("headless"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Resources\\drivers\\chromedriver.exe");
				ChromeOptions co = new ChromeOptions();
				co.addArguments("headless");
				co.addArguments("disable-geolocation");
				driver = new ChromeDriver(co);
			}
			
			else if(browserType.contains("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Resources\\drivers\\geckodriver.exe");
				FirefoxOptions ffo = new FirefoxOptions();
				ffo.addPreference("geo.enabled", false);
				driver = new FirefoxDriver(ffo);
			}
			else
			{
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Resources\\drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(7000, TimeUnit.MILLISECONDS);
		return driver;
		
	}
	
	public String TakeAScreenshot(String methodName, WebDriver driver) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "\\Resources\\Screenshots\\" + methodName + ".png";
		Path fileToDelete = Paths.get(dest);
		
		if(fileToDelete.toFile().exists())
		{
			Files.delete(fileToDelete);
		}
		
		FileHandler.copy(src, new File(dest));
		return dest;
	}

	public String TakeAFULLScreenshot(String methodName, WebDriver driver) throws IOException
	{
		//File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "\\Resources\\Screenshots\\" + methodName + ".png";
		
		 Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);             
		 try
		 {
		 	Path fileToDelete = Paths.get(dest);
			
			if(fileToDelete.toFile().exists())
			{
				Files.delete(fileToDelete);
			}
		 }
		 
		 catch(Exception e)
		 {
			 System.out.println("Error desc: " + e);
		 }
		 
		  try 
		  {                 
			  ImageIO.write(screenshot.getImage(),"PNG",new File(dest));             
		  } 
		  catch (IOException e) 
		  { 
			  System.out.println("Error desc: " + e);
		  }
		return dest;
	}
	
	public Boolean verifyAllLinks(String url) throws MalformedURLException, IOException
	{
		Boolean flag = true;
		HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int resCode = conn.getResponseCode();
		System.out.println("Response code of URL: " + url + " is " + resCode);
		if(resCode >= 400)
		{
			flag = false;
		}
		
		return flag;
		
	}
}
