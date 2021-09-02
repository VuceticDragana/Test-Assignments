package com.automation.TestAssigment;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.stqa.selenium.factory.WebDriverPool;

public class TestBase
{
  protected static URL gridHubUrl;
  protected static String baseUrl;
  protected static Capabilities capabilities;

  protected WebDriver driver;

  @BeforeAll
  public static void loadConfig() throws Throwable
  {
    SuiteConfiguration config = new SuiteConfiguration();
    baseUrl = config.getProperty("site.url");
    if (config.hasProperty("grid.url") && !"".equals(config.getProperty("grid.url")))
    {
      gridHubUrl = new URL(config.getProperty("grid.url"));
    }
    capabilities = config.getCapabilities();
  };

  @BeforeEach
  public void initDriver() throws Throwable
  {
    switch (capabilities.getBrowserName())
    {
    case "chrome":
      WebDriverManager.chromedriver().setup();
      break;
    case "firefox":
      WebDriverManager.firefoxdriver().setup();
      break;
    default:
      break;
    }

    driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }
}
