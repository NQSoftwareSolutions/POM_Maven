package com.pom.base;

import com.pom.utils.PageURLs;
import com.pom.utils.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase extends PageURLs {
    public static WebDriver driver;
    public static Properties prop;

    public TestBase() {
        super();
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("D:\\Downloads\\Documents\\MyWork\\Java\\POM_Maven\\src\\main\\java\\com\\pom\\config\\config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty(prop.getProperty("chrome_browser_key"), prop.getProperty("chrome_driver_address"));
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtils.PAGE_LOAD_TIME_OUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.IMPLICITLY_WAIT));

        driver.get(url);
    }
}
