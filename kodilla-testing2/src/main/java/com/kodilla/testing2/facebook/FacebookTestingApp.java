package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    public static final String XPATH_BUTTON = "//button[2]";
    public static final String XPATH_SELECT = "//div[contains(@class, \"_6ltg\")]/a";
    public static final String XPATH_SELECT_DAY = "//span[contains(@class, \"_5k_4\")]/span/select[1]";
    public static final String XPATH_SELECT_MONTH = "//span[contains(@class, \"_5k_4\")]/span/select[2]";
    public static final String XPATH_SELECT_YEAR = "//span[contains(@class, \"_5k_4\")]/span/select[3]";

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com");

        driver.findElement(By.xpath(XPATH_BUTTON)).click();

        WebElement button = driver.findElement(By.xpath(XPATH_SELECT));
        button.click();

        Thread.sleep(700);

        WebElement selectDay = driver.findElement(By.xpath(XPATH_SELECT_DAY));
        Select sDay = new Select(selectDay);
        sDay.selectByValue("30");

        Thread.sleep(700);

        WebElement selectMonth = driver.findElement(By.xpath(XPATH_SELECT_MONTH));
        Select sMonth = new Select(selectMonth);
        sMonth.selectByValue("7");

        Thread.sleep(700);

        WebElement selectYear = driver.findElement(By.xpath(XPATH_SELECT_YEAR));
        Select sYear = new Select(selectYear);
        sYear.selectByValue("1980");

        Thread.sleep(1000);
        //driver.close();
    }
}
