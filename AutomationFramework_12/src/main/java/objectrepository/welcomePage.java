package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class welcomePage {

	@FindBy(linkText = "Log in")
	private WebElement loginLink;

	public welcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	
	public WebElement getLoginLink() {
		return loginLink;
	}
}
