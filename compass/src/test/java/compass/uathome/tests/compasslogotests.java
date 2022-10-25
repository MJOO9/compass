package compass.uathome.tests;

import org.testng.annotations.Test;

import compass.pageevents.CompassUatLoginEvents;
import compass.testbase.BaseTests;

public class compasslogotests extends BaseTests {

	
	@Test
	public void logoVeryficationTest() {
		CompassUatLoginEvents events=new CompassUatLoginEvents();
		events.compassLogoVerification();
	}
}
