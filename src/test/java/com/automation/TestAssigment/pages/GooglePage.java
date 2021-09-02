package com.automation.TestAssigment.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GooglePage
{
  protected WebDriver driver;

  @FindBy(how = How.NAME, using = "q")
  public WebElement searchBox;

  @FindBy(how = How.ID, using = "result-stats")
  public WebElement numberOfCheese;

  public GooglePage(WebDriver driver)
  {
    super();
    this.driver = driver;
  }

  public void searchBoxInsertText(String c)
  {
    searchBox.clear();
    searchBox.sendKeys(c);
    searchBox.sendKeys(Keys.ENTER);
  }

  public String numberOfCheese()
  {
    return numberOfCheese.getText();
  }
}
