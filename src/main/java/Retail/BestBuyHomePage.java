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
	private WebElement forYourBusiness;
	
	@FindBy(xpath="//nav[@class='top-nav-items']/ul/li[6]")
	private WebElement backToSchool;
	
	@FindBy(xpath="//button[contains(@class,'modal-close-icon')]")
	private List<WebElement> popUpCloseButton;
	
	@FindBy(css="span[class='store-display-name']")
	private WebElement closestBestBuy;
	
	@FindBy(css="span[class='cart-label']")
	private WebElement cart;
	
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
	
	public WebElement getBackToSchoolLink()
	{
		return backToSchool;
	}
	
	public WebElement getClosestBestBuy()
	{
		return closestBestBuy;
	}
	
	public WebElement getCart()
	{
		return cart;
	}
}
