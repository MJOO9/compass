package compass.uat.tests;

import org.testng.annotations.Test;



import compass.core.ElementFetcher;
import compass.pageevents.CompassUatHomeEvents;
import compass.pageevents.CompassUatLoginEvents;
import compass.testbase.BaseTests;

public class CompassUattests extends BaseTests {
	
 ElementFetcher fetch= new ElementFetcher();
	
	@Test(testName = "Homepage Verification")
	public void TC_1() {
		CompassUatHomeEvents events=new CompassUatHomeEvents();
		boolean isLogoPresent= events.compassLogoVerification();
		fetch.verify(isLogoPresent,true," Compass Logo is present.");
		String isProposition= events.compassPropositionWarningVerification();
		fetch.verify(isProposition,"Proposition 65 WARNING"," Compass Proposition warning 65 is present.");
	}

   @Test(testName = "Login with valid user")
   public void TC_2 () {
	    CompassUatHomeEvents events=new CompassUatHomeEvents();
	    CompassUatLoginEvents loginevents=   events.ClickOnLogin();
	    loginevents.enterUserID("typeinavalidemail@amarrcompass.com");
	    loginevents.clickOnContinue();
	}
}


