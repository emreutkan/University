package com.example.scenario2;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\emre\\Desktop\\test\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--remote-allow-origins=*"});
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.deezer.com/tr/login");
        WebElement acceptCookie = driver.findElement(By.id("gdpr-btn-accept-all"));
        acceptCookie.click();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException var9) {
            throw new RuntimeException(var9);
        }
        WebElement LoginMail,LoginPassword,LoginButton;


        LoginMail = driver.findElement(By.id("login_mail"));
        LoginPassword = driver.findElement(By.id("login_password"));
        LoginButton = driver.findElement(By.id("login_form_submit"));
        LoginMail.clear();
        LoginMail.sendKeys("softwaretesting1231254@proton.me");
        LoginPassword.clear();
        LoginPassword.sendKeys(""); // deducted
        LoginButton.click();
        // wait for captcha
        sleep(15000L);
        driver.get("https://www.deezer.com/search/thurisaz/track");
        //WebElement state1 = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.svg-icon-group-btn.is-highlight[aria-label='Çal']")));
        WebElement firstTrackDiv = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-rowindex='1']")));
        WebElement clickFirstTrack = firstTrackDiv.findElement(By.tagName("button"));
        clickFirstTrack.click();

        WebElement favButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'css-17a1yib') and contains(@class, 'chakra-button') and contains(@class, 'e3mndjk0')]")));
        favButton.click();


        sleep(1000);
        try {
            WebElement addedMessage = driver.findElement(By.xpath("//aside[@role='alert' and contains(@class, '_2mybT')]//h2[@class='_ro5K' and text()='Sevdiğin şarkılara eklendi']"));
            if (addedMessage.isDisplayed()) {
                System.out.println("Track is Added to Favorities");
                System.out.println("Scenario Test Case 1 : Passed");
            } else {
                System.out.println("error on 1st try catch if else");
            }
        } catch (NoSuchElementException e) {
            System.out.println("cant find addedMessage xpath");
        }

        WebElement favTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(@class, 'sidebar-nav-item')]//span[text()='Favoriler']")));
        favTab.click();
        String URL = driver.getCurrentUrl();
        String URL2 = URL + "/loved";
        driver.get(URL2);

        sleep(2000);
        // TC2
        driver.get("https://www.deezer.com/search/thurisaz/track");
        WebElement firstTrackDiv2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-rowindex='1']")));
        WebElement clickFirstTrack2 = firstTrackDiv2.findElement(By.tagName("button"));
        clickFirstTrack2.click();
        WebElement favButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'css-17a1yib') and contains(@class, 'chakra-button') and contains(@class, 'e3mndjk0')]")));
        favButton2.click();
        sleep(1000);
        try {
            WebElement removedMessage = driver.findElement(By.xpath("//aside[@role='alert' and contains(@class, '_2mybT')]//h2[@class='_ro5K' and text()='Sevdiğin şarkılardan çıkarıldı']"));
            if (removedMessage.isDisplayed()) {
                System.out.println("Track is Removed From Favorities");
                System.out.println("Scenario Test Case 2 : Passed");
            } else {
                System.out.println("error on 2nd try catch if else");
            }
        } catch (NoSuchElementException e) {
            System.out.println("cant find removedMessage xpath");
        }
        WebElement favTab2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(@class, 'sidebar-nav-item')]//span[text()='Favoriler']")));

        favTab2.click();
        sleep(2000);
        driver.get(URL2);
        //TC3
        driver.quit();
        WebDriver driver2 = new ChromeDriver(options);
        WebDriverWait wait2 = new WebDriverWait(driver2, Duration.ofSeconds(10));
        driver2.get("https://www.deezer.com/search/thurisaz");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException var9) {
            throw new RuntimeException(var9);
        }
        WebElement acceptCookie2 = driver2.findElement(By.id("gdpr-btn-accept-all"));
        acceptCookie2.click();
        WebElement favButton3 = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'css-17a1yib') and contains(@class, 'chakra-button') and contains(@class, 'e3mndjk0')]")));
        favButton3.click();
        sleep(2000);
        String URL3 = driver2.getCurrentUrl();
        if (URL3.startsWith("https://www.deezer.com/tr/login")) {
            System.out.println("User without account redirected to login page");
            System.out.println("Scenario TC3 : Passed");
        }

    }
}
