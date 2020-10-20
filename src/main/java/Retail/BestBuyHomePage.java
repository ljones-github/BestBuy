package Retail;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	private WebElement buyBuyOutletLink;
	
	private WebElement xboxSeriesLink;
	
	private WebElement playstationFiveLink;
	
	private WebElement giftIdeasLink;
	
	private WebElement fallSaleLink;
	
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
	
	public void clickToInitializeProducts()
	{
		getProductsDropDownMenuCarat().click();
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
				buyBuyOutletLink = productsDropDownLinks.get(1);
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
				fallSaleLink = productsDropDownLinks.get(5);
				break;
			case 6:
				appleLatestLink = productsDropDownLinks.get(6);
				break;
			case 7:
				elevateHomeLink = productsDropDownLinks.get(7);
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
} 
