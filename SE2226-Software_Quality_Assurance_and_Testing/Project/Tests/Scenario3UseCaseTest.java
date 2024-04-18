package com.example.scenari3;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

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

// page_url = https://www.jetbrains.com/
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
    // wait for captcha
    try {
      Thread.sleep(15000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.get("https://www.deezer.com/search/tamino/track");
    //driver.get("https://www.deezer.com/search/thurisaz/track");
    //WebElement state1 = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.svg-icon-group-btn.is-highlight[aria-label='Çal']")));
    WebElement firstTrackDiv = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-rowindex='1']")));
    WebElement clickFirstTrack = firstTrackDiv.findElement(By.tagName("button"));
    clickFirstTrack.click();
    try {
      WebElement lbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'css-17a1yib') and contains(@class, 'chakra-button') and contains(@class, 'e3mndjk0') and @aria-label='Şarkı sözleriyle dinle']")));
      lbutton.click();
      try{
        WebElement lbutton2 = driver.findElement(By.xpath("//button[@aria-label='Şarkı sözlerini gizle']"));
        if (lbutton2.isDisplayed()){
          System.out.println("lyrics are shown");
          System.out.println("Scenario TC1: PASSED");
        }
      }catch (Exception e){
        System.out.println(e);
      }
    }catch (Exception e){
      System.out.println(e);
    }

    driver.get("https://www.deezer.com/search/Thurisaz/track");
    WebElement firstTrackDiv2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-rowindex='1']")));
    WebElement clickFirstTrack2 = firstTrackDiv2.findElement(By.tagName("button"));
    clickFirstTrack2.click();
    try {
      WebElement lbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'css-17a1yib') and contains(@class, 'chakra-button') and contains(@class, 'e3mndjk0') and @aria-label='Şarkı sözleriyle dinle']")));
      lbutton.click();
      try{
        WebElement lbutton2 = driver.findElement(By.xpath("//button[@aria-label='Şarkı sözlerini gizle']"));
 /*       if (lbutton2.isDisplayed()){
          System.out.println("lyrics are shown");
          System.out.println("Scenario TC1: PASSED");
        }*/
      }catch (Exception e){
        System.out.println(e);
      }
    }catch (Exception e){
      System.out.println("Song has no lyrics");
      System.out.println("Scenario TC2: PASSED");
    }
    driver.close();
    WebDriver driver2 = new ChromeDriver(options);
    WebDriverWait wait2 = new WebDriverWait(driver2, Duration.ofSeconds(10));
    driver2.get("https://www.deezer.com/tr/artist/11121068/top_track");
    try {
      Thread.sleep(1000L);
    } catch (InterruptedException var9) {
      throw new RuntimeException(var9);
    }
    WebElement acceptCookie2 = driver2.findElement(By.id("gdpr-btn-accept-all"));
    acceptCookie2.click();
    try {
      WebElement lbutton = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'css-17a1yib') and contains(@class, 'chakra-button') and contains(@class, 'e3mndjk0') and @aria-label='Şarkı sözleriyle dinle']")));
      lbutton.click();
      try{
        WebElement lbutton2 = driver2.findElement(By.xpath("//button[@aria-label='Şarkı sözlerini gizle']"));
        if (lbutton2.isDisplayed()){
          System.out.println("lyrics are shown without an account");
          System.out.println("Scenario TC3: PASSED");
        }
      }catch (Exception e){
        System.out.println("catch1");
        System.out.println(e);
      }
    }catch (Exception e){
      System.out.println("catch2");
      System.out.println(e);
    }
    //driver2.close();
    driver2.get("https://www.deezer.com/tr/artist/4344705/top_track");
    try {
      WebElement lbutton = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'css-17a1yib') and contains(@class, 'chakra-button') and contains(@class, 'e3mndjk0') and @aria-label='Şarkı sözleriyle dinle']")));
      lbutton.click();
      try{
        WebElement lbutton2 = driver2.findElement(By.xpath("//button[@aria-label='Şarkı sözlerini gizle']"));
 /*       if (lbutton2.isDisplayed()){
          System.out.println("lyrics are shown");
          System.out.println("Scenario TC1: PASSED");
        }*/
      }catch (Exception e){
        System.out.println(e);
      }
    }catch (Exception e){
      System.out.println("Song has no lyrics (no login)");
      System.out.println("Scenario TC4: PASSED");
    }
  }
}
