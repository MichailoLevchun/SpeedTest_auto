package BO;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import PO.PlayStorePO;
import PO.SpeedTestPO;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppBO {
	private static final Logger LOGGER = LogManager.getLogger(AppBO.class);

	private SpeedTestPO speedTestPO;
	private PlayStorePO playStorePO;

	public AppBO(AndroidDriver<? extends MobileElement> driver, int pageUpdateTimeOut) {
		speedTestPO = new SpeedTestPO(driver, pageUpdateTimeOut);
		playStorePO = new PlayStorePO(driver, pageUpdateTimeOut);
	}

	public void findAndInstallApp(String appName) {
		LOGGER.info(String.format("Find '%s' in Play Market", appName));
		playStorePO.findApp(appName);
		LOGGER.info(String.format("Install '%s'", appName));
		playStorePO.installApp();
	}

	public void runSpeedTest() {
		LOGGER.info("Open and run Speed test");
		speedTestPO.startSpeedTest();
		LOGGER.info("Get speed information");
		speedTestPO.getInternetSpeedValues().forEach(
				(key, value) -> LOGGER.info(key + StringUtils.SPACE + value)
		);
	}
}
