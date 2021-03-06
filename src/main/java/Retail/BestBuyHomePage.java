package Retail;


import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jdk.jfr.Timespan;

public class BestBuyHomePage {

	WebDriver driver;
	
	@FindBy(id="gh-search-input")
	private WebElement searchBox;
	
	@FindBy(xpath="//img[@class='logo']")
	private WebElement homeLogo;
	
	@FindBy(xpath="//nav[@class='top-nav-items']/ul/li[1]")
	private WebElement creditCardsLink;
	
	@FindBy(xpath="//nav[@class='top-nav-items']/ul/li[2]")
	private WebElement topDealsLink;
	
	@FindBy(xpath="//nav[@class='top-nav-items']/ul/li[3]")
	private WebElement dealOfTheDayLink;
	
	@FindBy(xpath="//nav[@class='top-nav-items']/ul/li[4]")
	private WebElement giftCardsLink;
	
	@FindBy(xpath="//nav[@class='top-nav-items']/ul/li[5]")
	private WebElement giftIdeas;
	
	@FindBy(xpath="//nav[@class='top-nav-items']/ul/li[6]")
	private WebElement forYourBusiness;
	
	@FindBy(xpath="//button[contains(@class,'modal-close-icon')]")
	private List<WebElement> popUpCloseButton;
	
	@FindBy(css="span[class='store-display-name']")
	private WebElement closestBestBuy;
	
	@FindBy(css="span[class='cart-label']")
	private WebElement cart;
	
	@FindBy(xpath="//button[@data-lid='hdr_signin']")
	private WebElement accountDropDownMenu;
	
	@FindBy(xpath=("//button[contains(@class,'flyBtn')]"))
	private List<WebElement>dropDowns;
	
	private List<WebElement>productsDropDownLinks;
	
	private WebElement howToShopLink;
	
	private WebElement bestBuyOutletLink;
	
	private WebElement xboxSeriesLink;
	
	private WebElement playstationFiveLink;
	
	private WebElement giftIdeasLink;
	
	private WebElement topTvDealsLink;
	
	private WebElement holidayDecorLink;
	
	private WebElement appleLatestLink;
	
	private WebElement elevateHomeLink;
	
	private List<WebElement>productCategories;
	
	private WebElement appliances;
	
	private WebElement tvHomeTheatre;
	
	private WebElement computerTables;
	
	private WebElement cameraCamcorders;
	
	private WebElement cellPhones;
	
	private WebElement audio;
	
	private WebElement videoGames;
	
	private WebElement moviesMusic;
	
	private WebElement carElectronicGps;
	
	private WebElement wearableTech;
	
	private WebElement health;
	
	private WebElement sustainableLiving;
	
	private WebElement homeFurniture;
	
	private WebElement smartHome;
	
	private WebElement dronesToys;
	
	private WebElement productsClose;
	
	// Products/appliances enhanced menu-items
	
	private WebElement majorKitchenApp;
	
	private WebElement smallKitchenApp;

	private WebElement luxKitchenApp;
	
	private WebElement vacuumsNfloorCare;
	
	private WebElement washersNDryers;
	
	private WebElement heatCoolAirQa;

	private WebElement shopByBrand;
	
	private WebElement dealsNoutletAppliances;
	
	private WebElement servicesNsupportAppliances;
	
	/*******************************************/
	
	//Products/tv home theater enhanced menu-items
	
	private WebElement tvsBySize;
	
	private WebElement tvsByType;
	
	private WebElement homeTheatreAudioNVideo;
	
	private WebElement homeTheatreAcc;
	
	private WebElement dealsNoutletTv;
	
	private WebElement servicesNsupportTv;
	
	private WebElement inStoreExp;
	
	private WebElement breakCrumbTitle;

	private boolean reinitializeFlag = false;
	
	@FindBy(xpath="//ul[@class='global-nav-list']/li[1]")
	private WebElement productsDropdown;
	
	@FindBy(xpath="//ul[@class='global-nav-list']/li[2]")
	private WebElement brandsDropdown;
	
	@FindBy(xpath="//ul[@class='global-nav-list']/li[3]")
	private WebElement dealsDropdown;
	
	@FindBy(xpath="//ul[@class='global-nav-list']/li[4]")
	private WebElement servicesDropdown;
	
	public BestBuyHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getSearchBox()
	{
		return searchBox;
	}
	
	public WebElement getHomeLogo()
	{
		return homeLogo;
	}
	
	public WebElement getCreditCardsLink()
	{
		return creditCardsLink;
	}
	
	public WebElement getPopUpCloseButton()
	{
		WebElement e = null;
		for(int i = 0; i < popUpCloseButton.size(); i++)
		{
			e = popUpCloseButton.get(i);
		}
		
		return e;
	}
	
	public int getPopUpSize()
	{
		return popUpCloseButton.size();
	}
	
	public WebElement getTopDealsLink()
	{
		return topDealsLink;
	}
	
	public WebElement getDealOfTheDayLink()
	{
		return dealOfTheDayLink;
	}
	
	public WebElement getGiftCardsLink()
	{
		return giftCardsLink;
	}
	
	public WebElement getForYourBusinessLink()
	{
		return forYourBusiness;
	}
	
	public WebElement getGiftIdeas()
	{
		return giftIdeas;
	}
	
	public WebElement getClosestBestBuy()
	{
		return closestBestBuy;
	}
	
	public WebElement getCart()
	{
		return cart;
	}
	
	public WebElement getAccountDropDownMenuCarat()
	{
		return accountDropDownMenu;
	}
	
	public WebElement getProductsDropDownMenuCarat()
	{
		return dropDowns.get(0);
		
	}
	
	public WebElement getBrandsDropDownMenuCarat()
	{
		return dropDowns.get(1);
	}
	
	public WebElement getDealsDropDownMenuCarat()
	{
		return dropDowns.get(2);
	}
	
	public WebElement getServicesDropDownMenuCarat()
	{ 
		return dropDowns.get(3);
	}
	
	public void clickToInitializeProducts() throws InterruptedException
	{
		reinitializeFlag = true;
		Actions s = new Actions(driver);
		WebDriverWait myWait = new WebDriverWait(driver, TimeUnit.MILLISECONDS.toMillis(5000));
		myWait.until(ExpectedConditions.elementToBeClickable(getProductsDropDownMenuCarat()));
		Thread.sleep(1000);
		s.click(getProductsDropDownMenuCarat()).build().perform();
		productsClose = driver.findElement(By.cssSelector("button[class*='menu-close-button']"));
		productsDropDownLinks = driver.findElements(By.xpath("//ul[@data-level='1']/li/a"));
		productCategories = driver.findElements(By.xpath("//li[@class='item-parent-menu']"));
		
		for(int i = 0; i < productsDropDownLinks.size(); i++)
		{
			switch(i)
			{
			case 0: 
				howToShopLink = productsDropDownLinks.get(0);
				break;
			case 1:
				bestBuyOutletLink = productsDropDownLinks.get(1);
				break;
			case 2:
				xboxSeriesLink = productsDropDownLinks.get(2);
				break;
			case 3:
				playstationFiveLink = productsDropDownLinks.get(3);
				break;
			case 4:
				giftIdeasLink = productsDropDownLinks.get(4);
				break;
			case 5: 
				appleLatestLink = productsDropDownLinks.get(5);
				break;
			case 6:
				topTvDealsLink = productsDropDownLinks.get(6);
				break;
			case 7:
				holidayDecorLink = productsDropDownLinks.get(7);
				break;
			default:
				break;
				
			}
			
			for(int j = 0; j < productCategories.size(); j++)
			{
				String categoryText = productCategories.get(j).getText();
				WebElement temp = productCategories.get(j);
				
				switch(categoryText)
				{
				case("Appliances"):
					appliances = temp;
				case("TV & Home Theater"):
					tvHomeTheatre = temp;
				case("Computers & Tablets"):
					computerTables = temp;
				case("Cameras & Camcorders"):
					cameraCamcorders = temp;
				case("Cell Phones"):
					cellPhones = temp;
				case("Audio"):
					audio = temp;
				case("Video Games"):
					videoGames = temp;
				case("Movies & Music"):
					moviesMusic = temp;
				case("Car Electronics & GPS"):
					carElectronicGps = temp;
				case("Wearable Technology"):
					wearableTech = temp;
				case("Health, Fitness & Personal Care"):
					health = temp;
				case("Sustainable Living"):
					sustainableLiving = temp;
				case("Home, Furniture & Office"):
					homeFurniture = temp;
				case("Smart Home, Security & Wi-Fi"):
					smartHome = temp;
				case("Drones, Toys & Collectibles"):
					dronesToys = temp;
				default:
					break;
				
			}
				
			
		}		
}
		
		
}
	
	
	public WebElement getHowToShopLink()
	{
		return howToShopLink;
	}
	
	public WebElement getbestBuyOutletLink()
	{
		return bestBuyOutletLink;
	}
	
	public WebElement getXboxSeriesLink()
	{
		return xboxSeriesLink;
	}
	
	public WebElement getPlaystationFiveLink()
	{
		return playstationFiveLink;
	}
	
	public WebElement getGiftIdeasLink()
	{
		return giftIdeasLink;
	}
	
	public WebElement getAppleLatestLink()
	{
		return appleLatestLink;
	}
	
	public WebElement getTopTvDealsLink()
	{
		return topTvDealsLink;
	}
	
	public WebElement getHolidayDecorLink()
	{
		return holidayDecorLink;
	}
	
	public WebElement getAppliances()
	{
		return appliances;
	}
	
	public void clickAppliancesInit()
	{
		appliances.click();
		List<WebElement>appliancesItems = driver.findElements(By.xpath("//ul[@id='header-menu-13']//li[@class='item-parent-menu']"));
		breakCrumbTitle = driver.findElement(By.cssSelector(".breadcrumbTitle"));
		for(WebElement item : appliancesItems)
		{
			switch(item.getText())
			{
			case ("Major Kitchen Appliances"):
				majorKitchenApp = item;
			case ("Small Kitchen Appliances"):
				smallKitchenApp = item;
			case ("Luxury Kitchen Appliances"):
				luxKitchenApp = item;
			case ("Washers & Dryers"):
				washersNDryers = item;
			case ("Vacuums & Floor Care"):
				vacuumsNfloorCare = item;
			case ("Heating, Cooling & Air Quality"):
				heatCoolAirQa = item;
			case ("Shop by Brand"):
				shopByBrand = item;
			case ("Deals & Outlet"):
				dealsNoutletAppliances = item;
			case ("Services & Support"):
				servicesNsupportAppliances = item;
			default:
				break;
			
			
			}
		}
	}
	
	public void clickTvHomeTheatreInit()
	{
		tvHomeTheatre.click();
		List<WebElement>tvHomeTheatreItems = driver.findElements(By.xpath("//ul[@id='header-menu-25']//li[@class='item-parent-menu']"));
		breakCrumbTitle = driver.findElement(By.cssSelector(".breadcrumbTitle"));
		for(WebElement item : tvHomeTheatreItems)
		{
			switch(item.getText())
			{
			case ("TVs by Size"):
				tvsBySize = item;
			case ("TVs by Type"):
				tvsByType = item;
			case ("Home Theater Audio & Video"):
				homeTheatreAudioNVideo = item;
			case ("Home Theater Accessories"):
				homeTheatreAcc = item;
			case ("Deals & Outlet"):
				dealsNoutletTv = item;
			case ("Services & Support"):
				servicesNsupportTv = item;
			case ("In-Store Experience"):
				inStoreExp = item;
			default:
				break;
			
			
			}
		}
	}
	
	public WebElement getTvHomeTheatre()
	{
		return tvHomeTheatre;
	}
	
	public WebElement getComputerTables()
	{
		return computerTables;
	}
	
	public WebElement getCameraCamcorders()
	{
		return cameraCamcorders;
	}
	
	public WebElement getCellPhones()
	{
		return cellPhones;
	}
	
	public WebElement getAudio()
	{
		return audio;
	}
	
	public WebElement getVideoGames()
	{
		return videoGames;
	}
	
	public WebElement getMoviesMusic()
	{
		return moviesMusic;
	}
	
	public WebElement getCarElectronicGps()
	{
		return carElectronicGps;
	}
	
	public WebElement getWearableTech()
	{
		return wearableTech;
	}
	
	public WebElement getHealth()
	{
		return health;
	}
	
	public WebElement getSustainableLiving()
	{
		return sustainableLiving;
	}
	
	public WebElement getHomeFurniture()
	{
		return smartHome;
	}
	
	public WebElement getDronesToys()
	{
		return dronesToys;
	}
	
	public WebElement getMajorKitchenApp()
	{
		return majorKitchenApp; 				
	}
	
	public WebElement getSmallKitchenApp()
	{
		return smallKitchenApp;
	}

	public WebElement getLuxKitchenApp()
	{
		return luxKitchenApp;
	}
	
	public WebElement getVacuumsNfloorCare()
	{
		return vacuumsNfloorCare;
	}
	
	public WebElement getWashersNDryers()
	{
		return washersNDryers;
	}
	
	public WebElement getHeatCoolAirQa()
	{
		return heatCoolAirQa;
	}
	
	public WebElement getShopByBrand()
	{
		return shopByBrand;
	}
	
	public WebElement getDealsNoutletAppliances()
	{
		return dealsNoutletAppliances;
	}
	
	public WebElement getServicesNsupportAppliances()
	{
		return servicesNsupportAppliances;
	}
	// -- End
	public WebElement closeProducts()
	{
		return productsClose;
	}
	
	public WebElement getProductsDropdown()
	{
		return productsDropdown;
	}
	
	public WebElement getBrandsDropdown()
	{
		return brandsDropdown;
	}
	
	public WebElement getDealsDropdown()
	{
		return dealsDropdown;
	}
	
	public WebElement getServicesDropdown()
	{
		return servicesDropdown;
	}
} 
