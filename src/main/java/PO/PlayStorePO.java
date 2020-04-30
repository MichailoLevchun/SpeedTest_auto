package PO;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PlayStorePO extends BasePO {
	@AndroidFindBy(xpath = "//*[@resource-id = 'com.android.vending:id/search_bar_hint']")
	private MobileElement searchTab;

	@AndroidFindBy(xpath = "//*[@resource-id = 'com.android.vending:id/search_bar_text_input']")
	private MobileElement searchTabInput;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Install\")")
	private MobileElement installButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Open\")")
	private MobileElement openButton;


	public PlayStorePO(AndroidDriver<? extends MobileElement> driver, int pageUpdateTimeOut) {
		super(driver, pageUpdateTimeOut);
	}


	public void findApp(String appName) {
		searchTab.click();
		searchTabInput.setValue(appName);
		driver.pressKeyCode(AndroidKeyCode.ENTER);
	}

	public void installApp() {
		installButton.click();
		installButton.click();
		waitUntilIsClickable(openButton);
	}
}
