package Retail;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BestBuyCreateNewAccount {
	
	private WebDriver driver;
	
	@FindBy(css="a[class='mini-header__nav']")
	WebElement returnToPrevious;
	
	@FindBy(css="a[class='mini-header-logo__link']")
	WebElement bestBuyHomeIcon;
	
	@FindBy(xpath="//*[text()='sign up with your Google Account']")
	WebElement signUpWithGoogleAccount;
	
	@FindBy(xpath="//*[text()='Create a business account']")
	WebElement createABusinessAccount;
	
	@FindBy(id="firstName")
	WebElement firstNameField;
	
	@FindBy(id="lastName")
	WebElement lastNameField;
	
	@FindBy(id="email")
	WebElement emailField;
	
	@FindBy(id="fld-p1")
	WebElement passwordField;
	
	@FindBy(id="reenterPassword")
	WebElement reEnterPasswordField;
	
	@FindBy(id="phone")
	WebElement phoneNumField;
	
	@FindBy(id="is-recovery-phone")
	WebElement recoveryCheckBox;
	
	@FindBy(xpath="//*[text()='What is an Account Recovery phone number?']")
	WebElement whatIsAccRecoveryPhoneNum;
	
	@FindBy(css="div[class='cia-optional-section-v2']")
	WebElement bestBuyMemberId;
	
	@FindBy(css="button[type='submit']")
	WebElement submitNewAccountCreation;
	
	@FindBy(xpath="//button[contains(@class,'svg-button')]")
	WebElement realSignUpWithGoogle;
	
	@FindBy(xpath="//a[@class='cia-bottom-content__action']")
	WebElement signInLink;
	
	@FindBy(xpath="//*[text()='Oops, your session has expired.']")
	WebElement oops;
	
	@FindBy(xpath="//*[text()='click here to continue shopping']")
	WebElement continueShopping;
	
	@FindBy(xpath="//div[@class='cia-optional-section-v2__content']/div/following-sibling::button[1]")
	WebElement findMyMemberId;
	
	@FindBy(css=".ficon-caret-down")
	WebElement caratDownButton;
	
	public BestBuyCreateNewAccount(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getReturnToPrevious()
	{
		return returnToPrevious;
	}
	
	public WebElement getBestBuyHomeIcon()
	{
		return bestBuyHomeIcon;
	}
	
	public WebElement getSignUpWithGoogleAccount()
	{
		return signUpWithGoogleAccount;
	}
	
	public WebElement getCreateABusinessAccount()
	{
		return createABusinessAccount;
	}
	
	public WebElement getFirstNameField()
	{
		return firstNameField;
	}
	
	public WebElement getLastNameField()
	{
		return lastNameField;
	}
	
	public WebElement getEmailField()
	{
		return emailField;
	}
	
	public WebElement getPasswordField()
	{
		return passwordField;
	}
	
	public WebElement getReEnterPasswordField()
	{
		return reEnterPasswordField;
	}
	
	public WebElement getPhoneNumField()
	{
		return phoneNumField;
	}
	
	public WebElement getRecoveryCheckBox()
	{
		return recoveryCheckBox;
	}
	
	public WebElement getWhatIsAccountRecoverNum()
	{
		return whatIsAccRecoveryPhoneNum;
	}
	
	
	public WebElement getBestBuyMemberId()
	{
		return bestBuyMemberId;
	}
	
	public WebElement getSubmitAccountCreation()
	{
		return submitNewAccountCreation;
	}
	
	public WebElement getRealSignUpWithGoogle()
	{
		return realSignUpWithGoogle;
	}
	
	public WebElement getSignInLink()
	{
		return signInLink;
	}
	
	public WebElement getOops()
	{
		return oops;
	}
	
	public WebElement getContinueShopping()
	{
		return continueShopping;
	}
	
	public WebElement getFindMyMemberId()
	{
		return findMyMemberId;
	}
	
	public WebElement getCaratDown()
	{
		return caratDownButton;
	}

	public void scrollElementIntoView(WebElement ele)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
	}
}
