package books;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.listenerUtility;
import objectrepository.HomePage;
@Listeners(listenerUtility.class)
public class TC_DWS_001_Test extends BaseClass {
	
	@Test
	 public void clickOnBooks() throws EncryptedDocumentException, IOException {
		hp = new HomePage(driver);
		Assert.assertEquals(driver.getTitle(), eUtil.getStringDataFromExcel("Books", 1, 0),"Books is not dosplayed");
		test.log(Status.PASS, "Books is displayed");
	}

}
