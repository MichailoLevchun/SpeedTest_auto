package test.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import test.factories.CapabilitiesFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    public AndroidDriver<MobileElement> androidDriver;

    public AndroidDriver initializeDriver(DesiredCapabilities capabilities) {
        try {
            androidDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),
                    capabilities);
        } catch (MalformedURLException ignored) {
        }

        androidDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return androidDriver;
    }

    public boolean checkIfSpeedTestInstalled() {
        return androidDriver.isAppInstalled(CapabilitiesFactory.APP_PACKAGE_CAPABILITY);
    }

    @BeforeClass
    public void setupDriver() {
        initializeDriver(CapabilitiesFactory.getCapabilities());
    }

    @AfterClass
    public void driverQuit() {
        androidDriver.closeApp();
    }
}
