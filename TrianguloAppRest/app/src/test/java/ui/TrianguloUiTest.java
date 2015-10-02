package ui;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class TrianguloUiTest {

    private DesiredCapabilities capacidades;
    private WebDriverWait wait;
    private AndroidDriver<MobileElement> driver;

    @Before
    public void preCondicao() throws MalformedURLException {
        capacidades = new DesiredCapabilities();
        capacidades.setCapability(MobileCapabilityType.APP_ACTIVITY, "activities.MainActivity");
        capacidades.setCapability(MobileCapabilityType.APP_PACKAGE, "com.eliasnogueira.trianguloapp");
        capacidades.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capacidades.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capacidades);
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void posCondicao() {
        driver.quit();
    }

    @Test
    public void testeTrianguloEquilatero() {
        driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/txtLado1")).sendKeys("3");
        driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/txtLado2")).sendKeys("3");
        driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/txtLado3")).sendKeys("3");
        driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/btnCalcular")).click();

        wait.withTimeout(30, TimeUnit.HOURS);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.eliasnogueira.trianguloapp:id/txtResultado")));
        assertEquals("O triângulo é Equilátero", driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/txtResultado")).getText());
    }

}