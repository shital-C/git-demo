package Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.Base;

;

public class HomePage extends Base{
	//public WebDriver driver;
	
	//@FindBy (xpath=(""))
	//WebElement LoginBtn;
//By loginBtn=By.xpath("//span[text()='Login']");
//By logo=By.xpath("//img[@class='img-responsive logo']");

	@FindBy(xpath="//span[text()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@class='img-responsive logo']")
	WebElement logo;
	
	
public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver=driver;
}

public String gettitle() {
	return driver.getTitle();
	
	
}
public LoginPage clickOnLoginbtn() throws InterruptedException {
	Thread.sleep(4000);
	loginBtn.click();
	return new LoginPage(driver);
}

public boolean getLogo() {
	return logo.isDisplayed();
}




}
