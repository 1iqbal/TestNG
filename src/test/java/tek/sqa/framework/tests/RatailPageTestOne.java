package tek.sqa.framework.tests;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import tek.sqa.framework.base.BaseUITest;
import tek.sqa.framework.config.POMFactory;
import tek.sqa.framework.utilities.ExcelReader;

public class RatailPageTestOne extends BaseUITest{

	
	private POMFactory factory;

	
	@BeforeMethod
	public void initializeTest() {
		this.factory = POMFactory.getPOMFactory();
	}
	
		@Test(dataProvider = "informationData")
		public void RetailApplicationTest(String emailFaildV, String passFaildV, String cardNumV, String nameOnCardV,
				String expMonthV, String expYearV, String cvcCodeV) throws InterruptedException {
			POMFactory.getPOMFactory().retailPage().clickSignInOption();
			sendText(POMFactory.getPOMFactory().retailPage().emailField, emailFaildV);
			sendText(POMFactory.getPOMFactory().retailPage().emailField, emailFaildV);
			Thread.sleep(5000);
			POMFactory.getPOMFactory().retailPage().clickOnAccountOption();
			Thread.sleep(5000);
			sendText(POMFactory.getPOMFactory().retailPage().cardInputField, cardNumV);
			sendText(POMFactory.getPOMFactory().retailPage().nameOnCardInputField,nameOnCardV);
			selectValueByVisibleText(POMFactory.getPOMFactory().retailPage().expirationYear, expYearV);
			selectValueByVisibleText(POMFactory.getPOMFactory().retailPage().expirationMonth, expMonthV);
			sendText(POMFactory.getPOMFactory().retailPage().securityCodeInput, cvcCodeV);
			click(POMFactory.getPOMFactory().retailPage().addYourCardButton);
			Thread.sleep(5000);
			
		}

		@DataProvider(name = "informationData")
		public Object[][] data() throws IOException {
			// path to excel file
			String ExcelFilePath = ".\\src\\test\\resources\\testData\\userInformation.xlsx";
			List<Map<String, Object>> infoData = ExcelReader
					.readSheetWithFirstRowAsHeader(ExcelReader.getExcelSheet(ExcelFilePath, 3));
			Object[][] object = new Object[infoData.size()][infoData.get(0).size()];
			for (int i = 0; i < object.length; i++) {
				object[i][0] = infoData.get(i).get("email");
				object[i][1] = infoData.get(i).get("password");
				object[i][2] = infoData.get(i).get("cardNumber");
				object[i][3] = infoData.get(i).get("nameOnCard");
				object[i][4] = infoData.get(i).get("expirationYear");
				object[i][5] = infoData.get(i).get("expirationMonth");
				object[i][6] = infoData.get(i).get("cvcCode");

			}
			return object;
		}
		
	}

	
	
	

