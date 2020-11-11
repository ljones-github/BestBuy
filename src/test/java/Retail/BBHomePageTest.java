package Retail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import jdk.jfr.Timespan;

public class BBHomePageTest extends TestBase{
	
	private Logger log = LogManager.getLogger(BBHomePageTest.class.getClass());
	//private WebDriver driver;
	private String methodName;
	
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		TestBase tb = new BBHomePageTest();
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		driver = tb.initializeDriver();
		Properties myProps = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\Resources\\data.properties");
		myProps.load(fis);
		log.info("Class: " + BBHomePageTest.class.getName() + " || Info: Navigating to page || Method: " + methodName);
		driver.get(myProps.getProperty("urlone"));
		log.debug("Successfully navigated to page: " + myProps.getProperty("url"));
		Actions s = new Actions(driver);
		
		BestBuyHomePage bbhp = new BestBuyHomePage(driver);
		//WebDriverWait wdw = new WebDriverWait(driver, 10);
		//wdw.until(ExpectedConditions.visibilityOf(bbhp.getPopUpCloseButton()));
			
		/*if(bbhp.getPopUpCloseButton().isDisplayed())
		{
			log.info("Class: " + BBHomePageTest.class.getName() + " || Info: Pop Window Is being displayed || Method: " + methodName);
			s.click(bbhp.getPopUpCloseButton()).build().perform();
		}*/
		
		if(bbhp.getPopUpSize() > 0)
		{
			log.info("Class: " + BBHomePageTest.class.getName() + " || Info: Pop Window Is being displayed || Method: " + methodName);
			s.click(bbhp.getPopUpCloseButton()).build().perform();
		}
	}
	
	@Test
	public void pressHomeIcon() throws IOException
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		BestBuyHomePage bbhp = new BestBuyHomePage(driver);
		
		Actions s = new Actions(driver);
		log.info("Class: " + BBHomePageTest.class.getName() + " || Info: Attempting to click on button || Method: " + methodName);
		s.moveToElement(bbhp.getHomeLogo()).click(bbhp.getHomeLogo()).build().perform();
		log.debug("Class: " + BBHomePageTest.class.getName() + " || Debug: Button successfully clicked || Method: " + methodName);
	}
	
	@Test
	public void clickCreditCards() throws IOException
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		Actions s = new Actions(driver);
		BestBuyHomePage bbhp = new BestBuyHomePage(driver);
		log.info("Class: " + BBHomePageTest.class.getName() + " || Info: Attempting to click on button || Method: " + methodName);
		
		s.moveToElement(bbhp.getCreditCardsLink()).pause(Duration.ofMillis(2000)).build().perform();
		s.pause(Duration.ofSeconds(3)).doubleClick(bbhp.getCreditCardsLink()).pause(Duration.ofMillis(6000)).build().perform();
		
		log.debug("Class: " + BBHomePageTest.class.getName() + " || Debug: Button successfully clicked || Method: " + methodName);
		
		TestBase tb = new BBHomePageTest();
		String myScreenshot = tb.TakeAScreenshot(methodName, driver);
		
		Assert.assertTrue(driver.getTitle().contains("Credit"));
	}
	
	@Test
	public void clickTopDeals() throws IOException
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		Actions s = new Actions(driver);
		BestBuyHomePage bbhp = new BestBuyHomePage(driver);
		log.info("Class: " + BBHomePageTest.class.getName() + " || Info: Attempting to click on button || Method: " + methodName);
		
		s.moveToElement(bbhp.getTopDealsLink()).pause(Duration.ofMillis(2000)).build().perform();
		s.pause(Duration.ofSeconds(3)).doubleClick(bbhp.getTopDealsLink()).pause(Duration.ofMillis(6000)).build().perform();
		
		log.debug("Class: " + BBHomePageTest.class.getName() + " || Debug: Button successfully clicked || Method: " + methodName);
		
		TestBase tb = new BBHomePageTest();
		String myScreenshot = tb.TakeAScreenshot(methodName, driver);
		Assert.assertTrue(driver.getTitle().contains("Top Deals"));
	}
	
	@Test
	public void clickDealOfTheDay() throws IOException
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		Actions s = new Actions(driver);
		BestBuyHomePage bbhp = new BestBuyHomePage(driver);
		log.info("Class: " + BBHomePageTest.class.getName() + " || Info: Attempting to click on button || Method: " + methodName);
		
		s.moveToElement(bbhp.getDealOfTheDayLink()).pause(Duration.ofMillis(2000)).build().perform();
		s.pause(Duration.ofSeconds(3)).doubleClick(bbhp.getDealOfTheDayLink()).pause(Duration.ofMillis(6000)).build().perform();
		
		log.debug("Class: " + BBHomePageTest.class.getName() + " || Debug: Button successfully clicked || Method: " + methodName);
		
		TestBase tb = new BBHomePageTest();
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Deal of the Day"));
	}
	
	@Test
	public void clickGiftCards() throws IOException
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		Actions s = new Actions(driver);
		BestBuyHomePage bbhp = new BestBuyHomePage(driver);
		log.info("Class: " + BBHomePageTest.class.getName() + " || Info: Attempting to click on button || Method: " + methodName);
		
		s.moveToElement(bbhp.getGiftCardsLink()).pause(Duration.ofMillis(2000)).build().perform();
		s.pause(Duration.ofSeconds(3)).doubleClick(bbhp.getGiftCardsLink()).pause(Duration.ofMillis(6000)).build().perform();
		
		log.debug("Class: " + BBHomePageTest.class.getName() + " || Debug: Button successfully clicked || Method: " + methodName);
		
		TestBase tb = new BBHomePageTest();
		String myScreenshot = tb.TakeAScreenshot(methodName, driver);
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Gift"));
	}
	
	@Test
	public void clickForYourBusiness() throws IOException
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		Actions s = new Actions(driver);
		BestBuyHomePage bbhp = new BestBuyHomePage(driver);
		log.info("Class: " + BBHomePageTest.class.getName() + " || Info: Attempting to click on button || Method: " + methodName);
		
		s.moveToElement(bbhp.getForYourBusinessLink()).pause(Duration.ofMillis(2000)).build().perform();
		s.pause(Duration.ofSeconds(3)).doubleClick(bbhp.getForYourBusinessLink()).pause(Duration.ofMillis(6000)).build().perform();
		log.debug("Class: " + BBHomePageTest.class.getName() + " || Debug: Button successfully clicked || Method: " + methodName);
		
		TestBase tb = new BBHomePageTest();
		String myScreenshot = tb.TakeAScreenshot(methodName, driver);
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Business"));
	}
	
	@Test
	public void clickGiftIdeas() throws IOException
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		Actions s = new Actions(driver);
		BestBuyHomePage bbhp = new BestBuyHomePage(driver);
		log.info("Class: " + BBHomePageTest.class.getName() + " || Info: Attempting to click on button || Method: " + methodName);
		
		s.moveToElement(bbhp.getGiftIdeas()).pause(Duration.ofMillis(2000)).build().perform();
		s.pause(Duration.ofSeconds(3)).doubleClick(bbhp.getGiftIdeas()).pause(Duration.ofMillis(6000)).build().perform();
		log.debug("Class: " + BBHomePageTest.class.getName() + " || Debug: Button successfully clicked || Method: " + methodName);
		
		TestBase tb = new BBHomePageTest();
		//JavascriptExecutor je = (JavascriptExecutor)driver;
		//String myScript = "window.scrollBy(0,500)";
		//je.executeScript(myScript);
		//String myScreenshot = tb.TakeAScreenshot(methodName, driver);
		String myFullScreenshot = tb.TakeAFULLScreenshot(methodName, driver);
		Assert.assertTrue(driver.getTitle().contains("Gift Ideas"));
	}
	
	@Test
	public void closestBestBuyToMe() throws IOException
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		BestBuyHomePage bbhp = new BestBuyHomePage(driver);
		log.info("Class: " + BBHomePageTest.class.getName() + " || Info: Attempting to click on button || Method: " + methodName);
		Actions s = new Actions(driver);
		s.moveToElement(bbhp.getClosestBestBuy()).click(bbhp.getClosestBestBuy()).build().perform();
		log.debug("Class: " + BBHomePageTest.class.getName() + " || Debug: Button successfully clicked || Method: " + methodName);
		BBHomePageTest bbpt = new BBHomePageTest();
		log.info("Attempting to take screenshot");
		String myScreenshot = bbpt.TakeAScreenshot(methodName, driver);
		log.debug("Screenshot taken successfully");
		
	}
	
	@Test
	public void myCart() throws IOException, InterruptedException
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		log.info("Class: " + BBHomePageTest.class.getName() + " || Info: Attempting to click on button || Method: " + methodName);
		BestBuyHomePage bbhp = new BestBuyHomePage(driver);
		Actions s = new Actions(driver);
		WebElement eleCheck = driver.findElement(By.xpath("//img[@alt='cart icon']"));
		s.doubleClick(eleCheck).pause(Duration.ofSeconds(3)).build().perform();
		
		//Not recommended to use Thread sleep but we are going to use here for now
		Thread.sleep(5000);
		System.out.println("Is element enabled: " + bbhp.getCart().isEnabled());
		System.out.println("Is element displayed: " + bbhp.getCart().isDisplayed());
		log.debug("Class: " + BBHomePageTest.class.getName() + " || Debug: Button successfully clicked || Method: " + methodName);
		BBHomePageTest bbpt = new BBHomePageTest();
		String myScreenshot = bbpt.TakeAScreenshot(methodName, driver);
	}
	
	@Test
	public void createAccount() throws IOException
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		Actions s = new Actions(driver);
		BestBuyHomePage bbhp = new BestBuyHomePage(driver);
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
		
		Assert.assertTrue(driver.getCurrentUrl().contains("newAccount"));
		log.debug("Url title contains newAccount");
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
				log.error("Class: " + BBHomePageTest.class.getName() + " || Method: " + methodName + " || Error: " + e);
			}
		});
		
		sa.assertAll();
	}
	
	@Test
	public void productsHowToShop() throws IOException, InterruptedException
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		BestBuyHomePage bbhp = new BestBuyHomePage(driver);
		BBHomePageTest bbpt = new BBHomePageTest();
		try
		{
			log.info("Attempting to initialize items in the dropdown..");
			bbhp.clickToInitializeProducts();
			log.debug("Items successfully initialized");
		}
		catch (Exception e)
		{
			log.error("Class: " + BBHomePageTest.class.getName() + " || Method: " + methodName + " || Desc: " + e);
		}
		
		bbhp.getHowToShopLink().click();
		bbpt.TakeAFULLScreenshot(methodName, driver);
		//bbpt.TakeAScreenshot(methodName, driver);
		Thread.sleep(2000);
		
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.bestbuy.com/site/misc/shop-confidently/"));;
		
	}
	
	@Test
	public void productsBestBuyOutlet() throws IOException, InterruptedException
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		BestBuyHomePage bbhp = new BestBuyHomePage(driver);
		BBHomePageTest bbpt = new BBHomePageTest();
		try
		{
			log.info("Attempting to initialize items in the dropdown..");
			bbhp.clickToInitializeProducts();
			log.debug("Items successfully initialized");
		}
		catch (Exception e)
		{
			log.error("Class: " + BBHomePageTest.class.getName() + " || Method: " + methodName + " || Desc: " + e);
		}
		
		bbhp.getbestBuyOutletLink().click();
		bbpt.TakeAFULLScreenshot(methodName, driver);
		//bbpt.TakeAScreenshot(methodName, driver);
		Thread.sleep(2000);
		
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.bestbuy.com/site/electronics/outlet-refurbished-clearance/"));
		
	}
	
	@Test
	public void productsXboxSeries() throws IOException, InterruptedException
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		BestBuyHomePage bbhp = new BestBuyHomePage(driver);
		BBHomePageTest bbpt = new BBHomePageTest();
		try
		{
			log.info("Attempting to initialize items in the dropdown..");
			bbhp.clickToInitializeProducts();
			log.debug("Items successfully initialized");
		}
		catch (Exception e)
		{
			log.error("Class: " + BBHomePageTest.class.getName() + " || Method: " + methodName + " || Desc: " + e);
		}
		
		bbhp.getXboxSeriesLink().click();
		bbpt.TakeAFULLScreenshot(methodName, driver);
		//bbpt.TakeAScreenshot(methodName, driver);
		Thread.sleep(2000);
		
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.bestbuy.com/site/video-games/xbox-series-x-and-s/"));
		
	}
	
	@Test
	public void productsPlaystationFive() throws IOException, InterruptedException
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		BestBuyHomePage bbhp = new BestBuyHomePage(driver);
		BBHomePageTest bbpt = new BBHomePageTest();
		try
		{
			log.info("Attempting to initialize items in the dropdown..");
			bbhp.clickToInitializeProducts();
			log.debug("Items successfully initialized");
		}
		catch (Exception e)
		{
			log.error("Class: " + BBHomePageTest.class.getName() + " || Method: " + methodName + " || Desc: " + e);
		}
		
		bbhp.getPlaystationFiveLink().click();
		bbpt.TakeAFULLScreenshot(methodName, driver);
		//bbpt.TakeAScreenshot(methodName, driver);
		Thread.sleep(2000);
		
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.bestbuy.com/site/video-games/playstation-5/"));
		
	}
	
	@Test
	public void productsGiftIdeas() throws IOException, InterruptedException
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		BestBuyHomePage bbhp = new BestBuyHomePage(driver);
		BBHomePageTest bbpt = new BBHomePageTest();
		try
		{
			log.info("Attempting to initialize items in the dropdown..");
			bbhp.clickToInitializeProducts();
			log.debug("Items successfully initialized");
		}
		catch (Exception e)
		{
			log.error("Class: " + BBHomePageTest.class.getName() + " || Method: " + methodName + " || Desc: " + e);
		}
		
		bbhp.getGiftIdeasLink().click();
		bbpt.TakeAFULLScreenshot(methodName, driver);
		//bbpt.TakeAScreenshot(methodName, driver);
		Thread.sleep(2000);
		
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.bestbuy.com/site/electronics/gift-ideas/"));
		
	}
	
	@Test
	public void productsAppleLatest() throws IOException, InterruptedException
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		BestBuyHomePage bbhp = new BestBuyHomePage(driver);
		BBHomePageTest bbpt = new BBHomePageTest();
		try
		{
			log.info("Attempting to initialize items in the dropdown..");
			bbhp.clickToInitializeProducts();
			log.debug("Items successfully initialized");
		}
		catch (Exception e)
		{
			log.error("Class: " + BBHomePageTest.class.getName() + " || Method: " + methodName + " || Desc: " + e);
		}
		
		bbhp.getAppleLatestLink().click();
		bbpt.TakeAFULLScreenshot(methodName, driver);
		//bbpt.TakeAScreenshot(methodName, driver);
		Thread.sleep(2000);
		
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.bestbuy.com/site/brands/apple/"));
		
	}
	
	@Test
	public void productsTopTvDeals() throws IOException, InterruptedException
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		BestBuyHomePage bbhp = new BestBuyHomePage(driver);
		BBHomePageTest bbpt = new BBHomePageTest();
		try
		{
			log.info("Attempting to initialize items in the dropdown..");
			bbhp.clickToInitializeProducts();
			log.debug("Items successfully initialized");
		}
		catch (Exception e)
		{
			log.error("Class: " + BBHomePageTest.class.getName() + " || Method: " + methodName + " || Desc: " + e);
		}
		
		bbhp.getTopTvDealsLink().click();
		bbpt.TakeAFULLScreenshot(methodName, driver);
		//bbpt.TakeAScreenshot(methodName, driver);
		Thread.sleep(2000);
		
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.bestbuy.com/site/promo/tv-deals"));
		
	}
	
	@Test
	public void productsHolidayDecor() throws IOException, InterruptedException
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		BestBuyHomePage bbhp = new BestBuyHomePage(driver);
		BBHomePageTest bbpt = new BBHomePageTest();
		try
		{
			log.info("Attempting to initialize items in the dropdown..");
			bbhp.clickToInitializeProducts();
			log.debug("Items successfully initialized");
		}
		catch (Exception e)
		{
			log.error("Class: " + BBHomePageTest.class.getName() + " || Method: " + methodName + " || Desc: " + e);
		}
		
		bbhp.getHolidayDecorLink().click();
		bbpt.TakeAFULLScreenshot(methodName, driver);
		//bbpt.TakeAScreenshot(methodName, driver);
		Thread.sleep(2000);
		
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.bestbuy.com/site/promo/black-friday-seasonal-deals"));
		
	}
	
	@Test
	public void productsAppliances() throws InterruptedException, IOException
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		BestBuyHomePage bbhp = new BestBuyHomePage(driver);
		try
		{
			log.info("Attempting to click dropdowns to initialize web element objects..");
			bbhp.clickToInitializeProducts();
			bbhp.clickAppliancesInit();
			log.debug("Items successfully initialized");
		}
		catch(Exception e)
		{
			log.error("Class: " + BBHomePageTest.class.getName() + " || Method: " + methodName + " || Error: " + e);
		}
		
		bbhp.getMajorKitchenApp().click();
		Thread.sleep(3000);
		BBHomePageTest bbpt = new BBHomePageTest();
		bbpt.TakeAFULLScreenshot(methodName, driver);
		
	}
	
	@Test
	public void productsDropDownTest() throws InterruptedException
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		BestBuyHomePage bbhp = new BestBuyHomePage(driver);
		BBHomePageTest bbpt = new BBHomePageTest();
		Thread.sleep(4000);
		
		try
		{
			log.debug("Attempting to attain links");
			log.info(bbpt.clickLinksInDropdown(driver, bbhp.getProductsDropdown()));
			log.info("Links successfully clicked");
		}
		catch (Exception e)
		{
			log.error("Class: " + BBHomePageTest.class.getName() + " || Method: " + methodName + " || Error: " + e);
		}	
	}
	
	@Test
	public void brandsDropDownTest() throws InterruptedException
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		BestBuyHomePage bbhp = new BestBuyHomePage(driver);
		BBHomePageTest bbpt = new BBHomePageTest();
		Thread.sleep(4000);
		
		try
		{
			log.debug("Attempting to attain links");
			log.info(bbpt.clickLinksInDropdown(driver, bbhp.getBrandsDropdown()));
			log.info("Links successfully clicked");
		}
		catch (Exception e)
		{
			log.error("Class: " + BBHomePageTest.class.getName() + " || Method: " + methodName + " || Error: " + e);
		}	
	}
	
	@Test
	public void dealsDropDownTest() throws InterruptedException
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		BestBuyHomePage bbhp = new BestBuyHomePage(driver);
		BBHomePageTest bbpt = new BBHomePageTest();
		Thread.sleep(4000);
		
		try
		{
			log.debug("Attempting to attain links");
			log.info(bbpt.clickLinksInDropdown(driver, bbhp.getDealsDropdown()));
			log.info("Links successfully clicked");
		}
		catch (Exception e)
		{
			log.error("Class: " + BBHomePageTest.class.getName() + " || Method: " + methodName + " || Error: " + e);
		}	
	}
	
	@Test
	public void servicesDropDownTest() throws InterruptedException
	{
		methodName = new Throwable().getStackTrace()[0].getMethodName();
		BestBuyHomePage bbhp = new BestBuyHomePage(driver);
		BBHomePageTest bbpt = new BBHomePageTest();
		Thread.sleep(4000);
		
		try
		{
			log.debug("Attempting to attain links");
			log.info(bbpt.clickLinksInDropdown(driver, bbhp.getServicesDropdown()));
			log.info("Links successfully clicked");
		}
		catch (Exception e)
		{
			log.error("Class: " + BBHomePageTest.class.getName() + " || Method: " + methodName + " || Error: " + e);
		}	
	}
	
	// END
	@AfterMethod
	public void closeDriver()
	{
		driver.quit();
		log.debug("Class: " + BBHomePageTest.class.getName() + " || Debug: Current driver window was closed || Method: " + methodName);
	}

}
