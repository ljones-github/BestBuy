package Retail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class BBCreateAccountTest extends TestBase{

	private Logger log = LogManager.getLogger(BBCreateAccountTest.class.getName());
	private WebDriver driver;
	private BestBuyCreateNewAccount bbca;
	String methodName;
	
	@BeforeMethod
	public void navigateToCreateAccount() throws IOException
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		BBCreateAccountTest bbct = new BBCreateAccountTest();
		this.driver = bbct.initializeDriver();
		FileInputStream fis = new FileInputStream("C:\\Users\\ljone\\BestBuy\\Resources\\data.properties");
		Properties myProp = new Properties();
		myProp.load(fis);
		Actions s = new Actions(driver);
		
		try
		{
			log.info("Navigating to url");
			log.info("Initializing web elements");
			driver.get(myProp.getProperty("urltwo"));
			bbca = new BestBuyCreateNewAccount(driver);
			log.debug("Successfully navigated to url: " + myProp.getProperty("urltwo"));
			log.debug("Web elements successfully initialized");
		}
		
		catch(Exception e)
		{
			log.error("Class: " + BBCreateAccountTest.class.getName() + " || Method: " + methodName + " || Error: " + e);
		}
		
		if(bbca.getOops().isDisplayed())
		{
			s.click(bbca.getContinueShopping()).build().perform();
		}
		
		BestBuyHomePage bbhp = new BestBuyHomePage(driver);
		
		if(bbhp.getPopUpSize() > 0)
		{
			log.info("Class: " + BBHomePageTest.class.getName() + " || Info: Pop Window Is being displayed || Method: " + methodName);
			s.click(bbhp.getPopUpCloseButton()).build().perform();
		}
		
		if(driver.getCurrentUrl().equals(myProp.getProperty("urlone")))
		{
			log.info("Clicking account drop down button..");
			WebDriverWait myWait = new WebDriverWait(driver, 10);
			myWait.until(ExpectedConditions.elementToBeClickable(bbhp.getAccountDropDownMenuCarat()));
			s.moveToElement(bbhp.getAccountDropDownMenuCarat()).pause(Duration.ofSeconds(3)).build().perform();
			s.click(bbhp.getAccountDropDownMenuCarat()).build().perform();
			log.debug("Class: " + BBHomePageTest.class.getName() + " || Debug: Button successfully clicked || Method: " + methodName);
			myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("button[class*='am-create-account__button']"))));
			WebElement createAccount = driver.findElement(By.cssSelector("button[class*='am-create-account__button']"));
			
			log.info("Click on create account button..");
			s.click(createAccount).build().perform();
			s.pause(Duration.ofSeconds(10)).build().perform();
			log.debug("Class: " + BBHomePageTest.class.getName() + " || Debug: Button successfully clicked || Method: " + methodName);
		}
		
	}
	
	@Test
	public void returnToHomePageUno()
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		Actions s = new Actions(driver);
		try
		{
			log.info("Attempting to click on button ");
			s.click(bbca.getReturnToPrevious()).build().perform();
			s.pause(Duration.ofSeconds(6)).build().perform();
			log.debug("Successfully clicked on button ");
			
		}
		catch(Exception e)
		{
			log.error("Class: " + BBCreateAccountTest.class.getName() + " || Method: " + methodName + " || Error: " + e);
		}
		
		Assert.assertTrue(driver.getCurrentUrl().contains("www.bestbuy.com"));
	}
	
	@Test
	public void returnToHomePageDos()
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		Actions s = new Actions(driver);
		try
		{
			log.info("Attempting to click on button ");
			s.click(bbca.getBestBuyHomeIcon()).build().perform();
			s.pause(Duration.ofSeconds(6)).build().perform();
			log.debug("Successfully clicked on button ");
			
		}
		catch(Exception e)
		{
			log.error("Class: " + BBCreateAccountTest.class.getName() + " || Method: " + methodName + " || Error: " + e);
		}
		
		Assert.assertTrue(driver.getCurrentUrl().contains("www.bestbuy.com"));
	}
	
	@Test
	public void createAnAccountForm() throws IOException
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		Properties myProps = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\ljone\\BestBuy\\Resources\\data.properties");
		myProps.load(fis);
		Actions s = new Actions(driver);
		
		try
		{
			log.info("Sending text to fields");
			bbca.getFirstNameField().sendKeys(myProps.getProperty("firstName"));
			bbca.getLastNameField().sendKeys(myProps.getProperty("lastName"));
			bbca.getEmailField().sendKeys(myProps.getProperty("email"));
			bbca.getPasswordField().sendKeys(myProps.getProperty("password"));
			bbca.getReEnterPasswordField().sendKeys(myProps.getProperty("reenter"));
			bbca.getPhoneNumField().sendKeys(myProps.getProperty("phoneNum"));
			s.click(bbca.getRecoveryCheckBox()).build().perform();
			log.debug("Information sent correctly");
		}
		catch(Exception e)
		{
			log.error("Class: " + BBCreateAccountTest.class.getName() + " || Method: " + methodName + " || Error: " + e);
		}
		
		BBCreateAccountTest bbca = new BBCreateAccountTest();
		bbca.TakeAFULLScreenshot(methodName, driver);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		try
		{
			log.info("Closing the browser instance");
			driver.close();
			log.debug("Successfully closed the driver window");
		}
		catch(Exception e)
		{
			log.error("Class: " + BBCreateAccountTest.class.getName() + " || Method: " + methodName + " || Error: " + e);
		}
	}
	
	@Test
	public void validateLinks()
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		List<WebElement>links = driver.findElements(By.tagName("a"));
		List<String>myLinks = links.stream().map(link -> link.getAttribute("href")).collect(Collectors.toList());
		BBCreateAccountTest bbat = new BBCreateAccountTest();
		SoftAssert sa = new SoftAssert();
		myLinks.stream().forEach(link -> {
			try 
			{
				sa.assertTrue(bbat.verifyAllLinks(link));
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				log.error("Class: " + BBCreateAccountTest.class.getName() + " || Method: " + methodName + " || Error: " + e);
			}
		});
		
		sa.assertAll();
	}
	
	@Test
	public void myBestBuyId()
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		BestBuyCreateNewAccount bbca = new BestBuyCreateNewAccount(driver);
		Actions s = new Actions(driver);
		log.info("Attempting to click on web elements.");
		WebDriverWait myWait = new WebDriverWait(driver, 5);
		myWait.until(ExpectedConditions.elementToBeClickable(bbca.getCaratDown()));
		bbca.scrollElementIntoView(bbca.getCaratDown());
		s.click(bbca.getCaratDown()).build().perform();
		s.click(bbca.getFindMyMemberId()).pause(Duration.ofSeconds(2)).build().perform();
		WebElement firstName = driver.findElement(By.id("firstName"));
		WebElement lastName = driver.findElement(By.id("lastName"));
		WebElement phoneNum = driver.findElement(By.id("phone"));
		WebElement email =  driver.findElement(By.id("email"));
		
		try
		{
			log.info("Attempting to send info to fields..");
			s.sendKeys(firstName, "LaRon").build().perform();
			s.sendKeys(lastName, "Jones").build().perform();
			s.sendKeys(phoneNum, "8109648508").build().perform();
			s.sendKeys(email, "ljones_business@outlook.com").build().perform();
			log.debug("Information sent successfully.");
		}
		catch(Exception e)
		{
			log.error("Class: " + BBCreateAccountTest.class.getName() + " || Method: " + methodName + " || Error: " + e);
		}
		
		List<WebElement>iIcons = driver.findElements(By.xpath("//button[@aria-describedby='cia-member-id-phone']"));
		iIcons.stream().forEach(icon -> s.click(icon).pause(Duration.ofSeconds(2)).build().perform());
		for( int i = 0; i < iIcons.size(); i++)
		{
				s.click(iIcons.get(i)).pause(Duration.ofSeconds(2)).build().perform();
		}
		
	}
}
