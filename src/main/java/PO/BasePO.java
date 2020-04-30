package PO;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public abstract class BasePO {
	protected AndroidDriver<? extends MobileElement> driver;
	protected int pageUpdateTimeOut;

	public BasePO(AndroidDriver<? extends MobileElement> driver, int pageUpdateTimeOut) {
		this.driver = driver;
		this.pageUpdateTimeOut = pageUpdateTimeOut;
		PageFactory.initElements(new AppiumFieldDecorator(driver, pageUpdateTimeOut, TimeUnit.SECONDS), this);
	}

	protected void waitUntilIsClickable(WebElement webElement) {
		(new WebDriverWait(driver, 100)).until(ExpectedConditions.elementToBeClickable(webElement));

	}
}
