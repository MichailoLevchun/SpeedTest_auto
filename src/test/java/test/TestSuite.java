package test;

import static test.factories.CapabilitiesFactory.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BO.AppBO;
import test.core.BaseTest;

public class TestSuite extends BaseTest {

	private AppBO appBO;

	@BeforeMethod
	private void precondition() {
		appBO = new AppBO(androidDriver, 20);
		if (!checkIfSpeedTestInstalled()) {
			String testAppName = "Speedtest by Ookla";
			appBO.findAndInstallApp(testAppName);
		}
		androidDriver.quit();
	}

	@Test(description = "Test speed of internet")
	public void testInternetSpeed() {
		appBO = new AppBO(initializeDriver(getCapabilitiesOfSpeedTest()), 20);
		appBO.runSpeedTest();
	}
}
