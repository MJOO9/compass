package compass.pageevents;

import compass.core.ElementFetcher;
import compass.pagelements.CompassUatHomeElements;

public class CompassUatHomeEvents implements CompassUatHomeElements{


	
	ElementFetcher fetch=new ElementFetcher();
	
	public boolean compassLogoVerification() {
		
	return fetch.doesElementExists("xpath", CompassLogoXpath);
	}
	
	public String compassPropositionWarningVerification() {
		
	return	fetch.getTextByWebElement("xpath", CompassPropositionWarningXpath);
		}
		
	public CompassUatLoginEvents ClickOnLogin() {
		
		fetch.getWebElement("xpath", LoginButtonXpath).click();;
	    return new CompassUatLoginEvents();
	}

	
	
}
