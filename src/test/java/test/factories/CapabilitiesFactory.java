package test.factories;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;

import java.util.HashMap;
import java.util.Map;

public class CapabilitiesFactory {
	private static final String PLATFORM_NAME_CAPABILITY = "Android";

	//Set your device name
	private static final String DEVICE_NAME_CAPABILITY = "H8324";

	//Set your device uuid
	private static final String UDID_CAPABILITY = "BH9010PABZ";

	public static final String APP_PACKAGE_CAPABILITY = "org.zwanoo.android.speedtest";

	public static final String APP_ACTIVITY_CAPABILITY = "com.ookla.mobile4.screens.main.MainActivity";
	private static final String COMMAND_TIME_OUT_CAPABILITY = "60";

	public static DesiredCapabilities getCapabilities() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME_CAPABILITY);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME_CAPABILITY);
		capabilities.setCapability(MobileCapabilityType.UDID, UDID_CAPABILITY);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");

		capabilities.setCapability("appPackage", "com.android.vending");
		capabilities.setCapability("appActivity", "com.google.android.finsky.activities.MainActivity");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, COMMAND_TIME_OUT_CAPABILITY);
		return capabilities;
	}


	public static DesiredCapabilities getCapabilitiesOfSpeedTest() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME_CAPABILITY);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME_CAPABILITY);
		capabilities.setCapability(MobileCapabilityType.UDID, UDID_CAPABILITY);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");

		capabilities.setCapability("appPackage", APP_PACKAGE_CAPABILITY);
		capabilities.setCapability("appActivity", APP_ACTIVITY_CAPABILITY);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, COMMAND_TIME_OUT_CAPABILITY);
		return capabilities;
	}
}
