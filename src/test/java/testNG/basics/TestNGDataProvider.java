package testNG.basics;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProvider {

	@Test(dataProvider = "inputData")
	public void test(String name, String email, String city) {
		System.out.println(name  + " this is name from data provider" );
		System.out.println(email + " this is email from data provider");
		System.out.println(city  + " this is city from data provider" );
	}

	@DataProvider(name = "inputData")
	public Object[][] data() {
		return new Object[][] { { "ShaiqQadery", "ShaiqQadery@tekschool.us", "Falls Church" },
								{ "SaqebQadery", "SaqebQadery@tekschool.us", "Falls Church" }, 
								{ "JebirQadary", "JebirQadary@tekschool.us", "Silver Spring"},
								{ "SadisQadery", "SadisQadery@tekschool.us", "Falls Church" }

		};
	}

}
