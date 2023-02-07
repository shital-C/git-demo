package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.Base;

public class LoginPage extends Base{
	//public WebDriver driver;
	
//By email=By.id("user_email");
//By pwd=By.id("user_password");
//By LogBtn=By.cssSelector("input[type='submit']");
//By alertmsg=By.cssSelector("div[role='alert']");

@FindBy(id="user_email")
WebElement email;

@FindBy(id="user_password")
WebElement pwd;

@FindBy(css="input[type='submit']")
WebElement LogBtn;

@FindBy(css="div[role='alert']")
WebElement alertmsg;

public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	//this.driver=driver;
}

public String gettitle() {
	return driver.getTitle();
}

//public WebElement getEmail() {
//	 return driver.findElement(email);
//}

public void getEmail(String username) {
	 email.sendKeys(username);
}

//public WebElement getpwd() {
//	return driver.findElement(pwd);
//}

public void getpwd(String password) {
	pwd.sendKeys(password);;
}
//public void clickOnlogbtn() {
//	driver.findElement(LogBtn).click();
//}

public void clickOnlogbtn() {
	LogBtn.click();
}
public String getAlerttext() {
	return alertmsg.getText();
}

}
