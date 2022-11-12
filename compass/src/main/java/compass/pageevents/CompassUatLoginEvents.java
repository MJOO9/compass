package compass.pageevents;

import compass.core.ElementFetcher;
import compass.pagelements.CompassUatLoginElements;

public class CompassUatLoginEvents  implements CompassUatLoginElements{

	ElementFetcher fetcher=new ElementFetcher();
	




	public void enterUserID(String userID) {
		
		fetcher.getWebElement("id", UserIdInputField).sendKeys(userID);
	}
	
	
	public void clickOnContinue() {
		fetcher.getWebElement("xpath",ContinueButtonXpath);
	}
}
