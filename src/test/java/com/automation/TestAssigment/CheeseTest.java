package com.automation.TestAssigment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import com.automation.TestAssigment.pages.GooglePage;

public class CheeseTest extends TestBase
{
  private GooglePage googlePage;

  @BeforeEach
  public void preSvakogTesta()
  {
    googlePage = PageFactory.initElements(driver, GooglePage.class);
  }

  @Test
  public void compareNumberOfFoundCheeseTo777OnGoogle()
  {
    driver.get(baseUrl);
    googlePage.searchBoxInsertText("cheese");

    String actualText = googlePage.numberOfCheese();
    String[] splited = actualText.split(" ");
    Assertions.assertEquals("777", splited[1], "There is too much cheese on the internet.");
  }
}
