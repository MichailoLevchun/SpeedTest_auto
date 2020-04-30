package PO;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;

public class SpeedTestPO extends BasePO {
	@AndroidFindBy(xpath = "//*[@resource-id = 'org.zwanoo.android.speedtest:id/welcome_message_next_button']")
	private MobileElement nextButton;

	@AndroidFindBy(xpath = "//*[@resource-id = 'org.zwanoo.android.speedtest:id/permissions_continue_button']")
	private MobileElement continueButton;

	@AndroidFindBy(xpath = "//*[@resource-id = 'com.android.permissioncontroller:id/permission_deny_button']")
	private MobileElement denyButton;

	@AndroidFindBy(xpath = "//*[@resource-id = 'org.zwanoo.android.speedtest:id/go_button']")
	private MobileElement goButton;

	@AndroidFindBy(xpath = "//*[@content-desc='DOWNLOAD']//*//*[@resource-id = 'org.zwanoo.android.speedtest:id/txt_test_result_value']")
	private MobileElement getDownloadSpeed;

	@AndroidFindBy(xpath = "//*[@content-desc='UPLOAD']//*//*[@resource-id = 'org.zwanoo.android.speedtest:id/txt_test_result_value']")
	private MobileElement getUploadSpeed;

	@AndroidFindBy(xpath = "//*[@content-desc='Ping']//*//*[@resource-id = 'org.zwanoo.android.speedtest:id/txt_test_result_value']")
	private MobileElement getPingSpeed;

	@AndroidFindBy(xpath = "//*[@content-desc='Jitter']//*//*[@resource-id = 'org.zwanoo.android.speedtest:id/txt_test_result_value']")
	private MobileElement getJitterSpeed;

	public SpeedTestPO(AndroidDriver<? extends MobileElement> driver, int pageUpdateTimeOut) {
		super(driver, pageUpdateTimeOut);
	}

	public void startSpeedTest() {
		nextButton.click();
		continueButton.click();

		denyButton.click();
		denyButton.click();
		goButton.click();
		try {
			sleep(40000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Map<String, String> getInternetSpeedValues() {
		Map<String, String> map = new HashMap<>();
		map.put("DOWNLOAD SPEED", getDownloadSpeed.getText());
		map.put("UPLOAD SPEED", getUploadSpeed.getText());
		map.put("PING", getPingSpeed.getText());
		map.put("JITTER", getJitterSpeed.getText());
		return map;
	}

}
