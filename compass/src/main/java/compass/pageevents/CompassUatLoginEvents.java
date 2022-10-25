package compass.pageevents;

import compass.core.ElementFetcher;
import compass.pagelements.CompassUatLoginElements;

public class CompassUatLoginEvents  implements CompassUatLoginElements{

	ElementFetcher fetch=new ElementFetcher();
	
	public void compassLogoVerification() {
		
	fetch.doesElementExists("xpath", CompassLogo);
	}
	
	
}
