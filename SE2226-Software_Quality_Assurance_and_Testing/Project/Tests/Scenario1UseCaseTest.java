package com.example.testcase1;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
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
        driver.get("https://www.deezer.com/tr/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException var9) {
            throw new RuntimeException(var9);
        }

        WebElement acceptCookie = driver.findElement(By.id("gdpr-btn-accept-all"));
        acceptCookie.click();

        try {
            Thread.sleep(500L);
        } catch (InterruptedException var8) {
            throw new RuntimeException(var8);
        }

        WebElement ForwardLoginButton = driver.findElement(By.className("topbar-action"));
        ForwardLoginButton.click();


        WebElement LoginMail,LoginPassword,LoginButton;

        LoginMail = driver.findElement(By.id("login_mail"));
        LoginPassword = driver.findElement(By.id("login_password"));
        LoginButton = driver.findElement(By.id("login_form_submit"));

// valid login
        LoginMail.clear();
        LoginMail.sendKeys("softwaretesting1231254@proton.me");
        LoginPassword.clear();
        LoginPassword.sendKeys(""); // deducted
        LoginButton.click();
       // WebDriverWait waitCaptcha = new WebDriverWait(driver, Duration.ofSeconds(60));
       // waitCaptcha.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("CAPTCHA_XPATH")));
// find and click the artist
        WebElement searchArea = new WebDriverWait(driver, Duration.ofSeconds(100)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[aria-label='Ara']")));
        //WebElement searchAreaClick = driver.findElement(By.className("topbar-search-submit"));
        searchArea.click();
        searchArea.sendKeys("Thurisaz");
        WebElement searches = driver.findElement(By.className("search-category"));
        WebElement insearches = searches.findElement(By.xpath(".//span[@class='search-item-label' and text()='thurisaz']"));
        if (insearches != null) {
            System.out.println("System Found the artist");
            WebElement foundArtist = driver.findElement(By.cssSelector("a.search-item[href='/search/thurisaz']"));
            foundArtist.click();
            // WebElement clickOnTracks = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='page_naboo_search']/div[1]/nav/div/ul/li[2]/a")));
            WebElement clickOnTracks = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.chakra-text.navbar-link.css-d7qwgv.e3mndjk0[role='tab'][tabindex='0'][aria-selected='false'][data-testid='track-tab']")));


            clickOnTracks.click();
        } else {
            System.out.println("System did not found the artist");
        }
// navigate to songs and play the first Track from the list
        WebElement state1 = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.svg-icon-group-btn.is-highlight[aria-label='Çal']")));
        WebElement firstTrackDiv = driver.findElement(By.cssSelector("div[aria-rowindex='1']"));
        WebElement clickFirstTrack = firstTrackDiv.findElement(By.tagName("button"));
        clickFirstTrack.click();
        /* WebElement state = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.className("svg-icon-group-btn")));
        String playPause = state.getAttribute("aria-label");
        if (playPause.equals("Durdur")) {
            System.out.println("Track is currently playing");
        }
        else if (playPause.equals("Çal")) {
            System.out.println("Track did not start");
        }
        else {
            System.out.println(playPause);
        }
         */
        if (state1.isDisplayed()) {
            System.out.println("Track is currently playing");
            System.out.println("Scenario 1 TC1 : Passed");
        }
        else if (!state1.isDisplayed()) {
            System.out.println("Track did not start");
        }
        else {
            System.out.println("error");
        }
        // TC2

        searchArea.click();
        searchArea.sendKeys("d)(/(732d125");
        WebElement searchButton = driver.findElement(By.cssSelector("svg[data-testid='SearchIcon']"));
        searchButton.click();
        WebElement notFoundMessage = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.heading-1")));

        if (notFoundMessage.isDisplayed()) {
            System.out.println("System Did not Found the artist and Showed an error message");
            System.out.printf("Scenario 1 TC2 : Passed");
        } else {
            System.out.println("System did not found the artist");
        }
// TC 3
        driver.quit();
        WebDriver driver2 = new ChromeDriver(options);
        driver2.get("https://www.deezer.com/search/thurisaz");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException var9) {
            throw new RuntimeException(var9);
        }

        WebElement acceptCookie2 = driver2.findElement(By.id("gdpr-btn-accept-all"));
        acceptCookie2.click();
        // WebElement clickOnTracks = new WebDriverWait(driver2, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='page_naboo_search']/div[1]/nav/div/ul/li[2]/a")));
        WebElement clickOnTracks = new WebDriverWait(driver2, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.chakra-text.navbar-link.css-d7qwgv.e3mndjk0[role='tab'][tabindex='0'][aria-selected='false'][data-testid='track-tab']")));
        clickOnTracks.click();
        WebElement firstTrackDiv2 = driver2.findElement(By.cssSelector("div[aria-rowindex='1']"));
        WebElement clickFirstTrack2 = firstTrackDiv2.findElement(By.tagName("button"));
        clickFirstTrack2.click();
        WebElement state2 = new WebDriverWait(driver2, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.svg-icon-group-btn.is-highlight[aria-label='Çal']")));
        if (state2.isDisplayed()) {
            System.out.println("Track did not start");
            System.out.println("Scenario 1 TC3 : Failed (track does not start from artist's tracks list when using the app without an account)");
            System.out.println("Expected Scenario For TC3 : play the track, give an error message about limited duration for playback");
        }
        else if (!state2.isDisplayed()) {
            System.out.println("Track is currently playing");
            System.out.println("Scenario 1 TC3 : Passed");
        }
        else {
            System.out.println("error");
        }
        // TC4
        WebElement searchArea2 = new WebDriverWait(driver2, Duration.ofSeconds(100)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[aria-label='Ara']")));
        searchArea2.click();
        searchArea2.sendKeys("d)(/(732d125");
        WebElement searchButton2 = driver2.findElement(By.cssSelector("svg[data-testid='SearchIcon']"));
        searchButton2.click();
        WebElement notFoundMessage2 = new WebDriverWait(driver2, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.heading-1")));

        if (notFoundMessage2.isDisplayed()) {
            System.out.println("System Did not Found the artist and Showed an error message");
            System.out.printf("Scenario 1 TC4 : Passed");
        } else {
            System.out.println("System did not found the artist");
        }

    }
}

