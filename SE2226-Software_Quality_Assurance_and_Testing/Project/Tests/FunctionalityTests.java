package com.example.swtesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class MainPage {
    public MainPage() {
    }
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\emre\\Desktop\\test\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--remote-allow-origins=*"});
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.deezer.com/tr/");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
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
        WebElement ForwardRegisterButton = driver.findElement(By.xpath("//a[@class='unlogged-cta unlogged-cta-upper gap-m-bottom' and @href='/tr/register' and @data-tracked='true' and @data-tracking-action='free' and @data-tracking-category='offers-selection']"));
        ForwardRegisterButton.click();
        WebElement RegisterMail,RegisterUsername,RegisterPass,RegisterAge,RegisterGender,RegisterCbox,RegisterButton;
        RegisterMail = driver.findElement(By.id("register_form_mail_input"));
        RegisterUsername = driver.findElement(By.id("register_form_username_input"));
        RegisterPass = driver.findElement(By.id("register_form_password_input"));
        RegisterAge = driver.findElement(By.id("register_form_age_input"));
        RegisterGender = driver.findElement(By.id("register_form_gender_input"));
        RegisterCbox = driver.findElement(By.id("register_form_explicit_consent"));
        RegisterButton = driver.findElement(By.id("register_form_submit"));
        Select select = new Select(RegisterGender);
//Test1 // username test 1 ; no input for username
        RegisterMail.sendKeys("jifomidd9800@aicogz.com");
        RegisterUsername.sendKeys("");
        RegisterPass.sendKeys("sad4qw8dw4q8w4d21F");
        RegisterAge.sendKeys("22");
        select.selectByVisibleText("Erkek");
        RegisterCbox.click();
        RegisterButton.click();
        try {
            WebElement usernameTooShort = driver.findElement(By.cssSelector("[data-error-type='FORM_ERROR_BLOGNAME_TOO_SHORT']"));
            if (usernameTooShort.isDisplayed()) {
                System.out.println("Username Test 1 Passed: username too short");
            }
        }
        catch (Exception e){
            System.out.println("Username Test 1 Failed: system didnt catch blank username");
        }
//Test2 // username test; boundary value of 2 characters for username
        wait.until(ExpectedConditions.elementToBeClickable(RegisterMail));
        RegisterMail.clear();
        RegisterUsername.clear();
        RegisterPass.clear();
        RegisterAge.clear();
        RegisterMail.sendKeys("gmail@gmail.com");
        RegisterUsername.sendKeys("aa");
        RegisterPass.sendKeys("sad4qw8dw4q8w4d21F");
        RegisterAge.sendKeys("22");
        select.selectByVisibleText("Erkek");
        try {
            WebElement usernameTooShort = driver.findElement(By.cssSelector("[data-error-type='FORM_ERROR_BLOGNAME_TOO_SHORT']"));
            if (usernameTooShort.isDisplayed()) {
                System.out.println("Test Case 2 Failed: system did not allow 2 characters");
            }
        }
        catch (Exception e){
            System.out.println("Username Test 2 Passed: system allows 2 characters");
        }
//Test3 // username test; boundary value of 50 characters for username
        RegisterMail.clear();
        RegisterUsername.clear();
        RegisterPass.clear();
        RegisterAge.clear();
        RegisterMail.sendKeys("gmail@gmail.com");
        RegisterUsername.sendKeys("qx7C2NnF8ry1WuYvHgSz7Vdyh42aX9L2U4n6BY3dGcKqJFPxWV");
        RegisterPass.sendKeys("sad4qw8dw4q8w4d21F");
        RegisterAge.sendKeys("22");
        select.selectByVisibleText("Erkek");
        try {
            WebElement usernameTooShort = driver.findElement(By.cssSelector("[data-error-type='FORM_ERROR_BLOGNAME_TOO_LONG']"));
            if (usernameTooShort.isDisplayed()) {
                System.out.println("Test Case 3 Failed: system did not allow 50 characters");
            }
        }
        catch (Exception e){
            System.out.println("Username Test 3 Passed: system allows 50 characters");
        }
//Test4 // username test; boundary value of 50 characters for username
        RegisterMail.clear();
        RegisterUsername.clear();
        RegisterPass.clear();
        RegisterAge.clear();
        RegisterMail.sendKeys("gmail@gmail.com");
        RegisterUsername.sendKeys("qx7C2NnF8ry1WuYvHgSz7Vdyh42aX9L2U4n6BY3ddGcKqJFPxWV");
        RegisterPass.sendKeys("sad4qw8dw4q8w4d21F");
        RegisterAge.sendKeys("22");
        select.selectByVisibleText("Erkek");
        try {
            WebElement usernameTooShort = driver.findElement(By.cssSelector("[data-error-type='FORM_ERROR_BLOGNAME_TOO_LONG']"));
            if (usernameTooShort.isDisplayed()) {
                System.out.println("Username Test 4 Passed: system does not allow more than 50 characters" );
            }
        }
        catch (Exception e){
            System.out.println("Test Case 4 Failed: system did allow more than 50 characters");
        }
// Username Test 5 will be tested manually
// Username Test 5 valid username
/*
                RegisterUsername.clear();
        RegisterUsername.sendKeys("AD,1İ2Fs1if_d,i1 2");
        RegisterMail.clear();
        RegisterMail.sendKeys("sa5d4qw9d4qdwq@gmail.com");
        try{
         WebElement errorCheckAllBoxes = driver.findElement(By.id("register_form_global_error"));
         if (errorCheckAllBoxes.isDisplayed()){
             System.out.println("Test Case 5 Failed: system did not allow valid username ");
         }
        }
        catch (Exception e){
            System.out.println("Test Case 5 Passed: system did allow valid username");
        }
    */

//Test6 // Email Test 1: Empty Email Field
        RegisterMail.clear();
        RegisterUsername.clear();
        RegisterMail.sendKeys("");
        RegisterCbox.click();
        RegisterButton.click();
        RegisterUsername.sendKeys("qx7C2Nn2U4n6BY3ddGcKqJFPxWV");
        try {
            WebElement element = driver.findElement(By.cssSelector("div.form-control-error[data-error-type='FORM_ERROR_EMAIL_NOT_VALID']"));
            if (element.isDisplayed()) {
                System.out.println("Email Test 1 Passed: system does not allow blank email");
            }
        }
        catch (Exception e){
            System.out.println("Email Test 1 Failed: system allows blank email");
        }
//Test7 // Email Test 2: invalid Email Format
        RegisterMail.clear();
        RegisterMail.sendKeys("gmail@gmailcom");
        RegisterButton.click();
        try {
            WebElement element = driver.findElement(By.cssSelector("div.form-control-error[data-error-type='FORM_ERROR_EMAIL_NOT_VALID']"));
            if (element.isDisplayed()) {
                System.out.println("Email Test 2 Passed: system does not allow poorly typed email");
            }
        }
        catch (Exception e){
            System.out.println("Email Test 2 Failed: system does allow poorly typed email");
        }
//Test8 // Email Test 3: Email already in use
        RegisterMail.clear();
        RegisterMail.sendKeys("google@gmail.com");
        RegisterButton.click();
        try {
            WebElement element = driver.findElement(By.cssSelector("div.form-control-error[data-error-type='FORM_ERROR_EMAIL_ALREADY_USED']"));
            if (element.isDisplayed()) {
                System.out.println("Email Test 3 Passed: system does not email that is already in use ");
            }
        }
        catch (Exception e){
            System.out.println("Email Test 3 Failed: system does allow email that is already in use ");
        }
//Test 9 // Email Test 4: using email that does not exist will be tested manually
//Test 10 // Email Test 5: using email with special characters
        RegisterMail.clear();
        RegisterMail.sendKeys("i,şdwqğüdw@gmail.com");
        RegisterButton.click();
        try {
            WebElement element = driver.findElement(By.cssSelector("div.form-control-error[data-error-type='FORM_ERROR_EMAIL_NOT_VALID']"));
            if (element.isDisplayed()) {
                System.out.println("Email Test 5 Passed: system does not allow email that has special characters ");
            }
        }
        catch (Exception e){
            System.out.println("Email Test 5 Failed: system does allow email that has special characters ");
        }
//Test 10 // Password Test 1: blank password
        RegisterMail.clear();
        RegisterMail.sendKeys("gmailasdqwdwqd@gmail.com");
        RegisterPass.clear();
        RegisterPass.sendKeys("");
        RegisterButton.click();
        try {
            WebElement element = driver.findElement(By.cssSelector("[data-error-type='FORM_ERROR_PASSWORD_TOO_SHORT']"));
            if (element.isDisplayed()) {
                System.out.println("Password Test 1 Passed: system does not allow blank password ");
            }
        }
        catch (Exception e){
            System.out.println("Password Test 1 Failed: system does allow blank password ");
        }
//Test 11 // Password Test 2: less than 8 char
        RegisterPass.clear();
        RegisterPass.sendKeys("1234567");
        RegisterButton.click();
        try {
            WebElement element = driver.findElement(By.cssSelector("[data-error-type='FORM_ERROR_PASSWORD_TOO_SHORT']"));
            if (element.isDisplayed()) {
                System.out.println("Password Test 2 Passed: system does not allow password less then 8 characters");
            }
        }
        catch (Exception e){
            System.out.println("Password Test 2 Failed: system does allow password less then 8 characters");
        }

//Test 12 // Password Test 3: more than 50 char
        RegisterPass.clear();
        RegisterPass.sendKeys("asd6wq5d4qw65d4q56wd45q6wd465qwd54qw65d4wq64d54qqwwwwwwwwwwwwww");
        RegisterButton.click();
        try {
            WebElement element = driver.findElement(By.cssSelector("[data-error-type='FORM_ERROR_PASSWORD_TOO_LONG']"));
            if (element.isDisplayed()) {
                System.out.println("Password Test 3 Passed: system does not allow password more then 50 characters ");
            }
        }
        catch (Exception e){
            System.out.println("Password Test 3 Failed: system does allow password more then 50 characters ");
        }
//Test 13 // Password Test 4 : Exactly 8 characters
        RegisterPass.clear();
        RegisterPass.sendKeys("12345678");
        RegisterButton.click();
        try {
            WebElement element = driver.findElement(By.id("reg-pwd-error"));
            if (element.isDisplayed()) {
                System.out.println("Password Test 4 Failed: system does not allow 8 character password ");
            }
        }
        catch (Exception e){
            System.out.println("Password Test 4 Passed: system does allow 8 character password ");
        }
//Test 14 // Password Test 5 : Exactly 50 characters
        RegisterPass.clear();
        RegisterPass.sendKeys("qx7C2NnF8ry1WuYvHgSz7Vdyh42aX9L2U4n6BY3dGcKqJFPxWV");
        RegisterButton.click();
        try {
            WebElement element = driver.findElement(By.id("reg-pwd-error"));
            if (element.isDisplayed()) {
                System.out.println("Password Test 5 Failed: system does not allow 50 character password ");
            }
        }
        catch (Exception e){
            System.out.println("Password Test 5 Passed: system does allow 50 character password ");
        }
//Test 15 // Password Test 6 : between 8 and 50 characters
        RegisterPass.clear();
        RegisterPass.sendKeys("qx7C2NnF8ry1WuYvHgSz7Vdyh42aX9L2U4n6BY3dGcKqJFPxWV");
        RegisterButton.click();
        try {
            WebElement element = driver.findElement(By.id("reg-pwd-error"));
            if (element.isDisplayed()) {
                System.out.println("Password Test 6 Failed: system does not allow password between 8 and 50 characters ");
            }
        }
        catch (Exception e){
            System.out.println("Password Test 6 Passed: system does allow password between 8 and 50 characters ");
        }
//Test 16 // Age Test 1 : empty age
        RegisterAge.clear();
        RegisterAge.sendKeys("");
        RegisterButton.click();
        try {
            WebElement element = driver.findElement(By.cssSelector("[data-error-type='FORM_ERROR_AGE_INVALID']"));
            if (element.isDisplayed()) {
                System.out.println("Age Test 1 Passed: system does not allow blank age ");
            }
        }
        catch (Exception e){
            System.out.println("Age Test 1 Failed: system does allow blank age ");
        }
//Test 17 // Age Test 2 : impossible age below 0
        RegisterAge.clear();
        RegisterAge.sendKeys("-1");
        RegisterButton.click();
        try {
            WebElement element = driver.findElement(By.cssSelector("[data-error-type='FORM_ERROR_AGE_INVALID']"));
            if (element.isDisplayed()) {
                System.out.println("Age Test 2 Passed: system does not allow age less than 0 ");
            }
        }
        catch (Exception e){
            System.out.println("Age Test 2 Failed: system does allow age less than 0");
        }
//Test 18 // Age Test 3 : impossible age above 150 (boundary value)
        RegisterAge.clear();
        RegisterAge.sendKeys("151");
        RegisterButton.click();
        try {
            WebElement element = driver.findElement(By.cssSelector("[data-error-type='FORM_ERROR_AGE_INVALID']"));
            if (element.isDisplayed()) {
                System.out.println("Age Test 3 Passed: system does not allow age more than 150");
            }
        }
        catch (Exception e){
            System.out.println("Age Test 3 Failed: system does allow age more than 150");
        }
//Test 19 // Age Test 4 :  age below 16 (boundary value)
        RegisterAge.clear();
        RegisterAge.sendKeys("15");
        RegisterButton.click();
        try {
            WebElement element = driver.findElement(By.cssSelector("[data-error-type='FORM_ERROR_MIN_LEGAL_AGE']"));
            if (element.isDisplayed()) {
                System.out.println("Age Test 4 Passed: system does not allow age that is below minimum required age (16) ");
            }
        }
        catch (Exception e){
            System.out.println("Age Test 4 failed: system does allow age that is below minimum required age (16) ");
        }
//Test 20 // Age Test 5 :  age between 16 and 150 (boundary value)
        RegisterAge.clear();
        RegisterAge.sendKeys("22");
        RegisterButton.click();
        try {
            WebElement element1 = driver.findElement(By.cssSelector("[data-error-type='FORM_ERROR_AGE_INVALID']"));

            WebElement element2 = driver.findElement(By.cssSelector("[data-error-type='FORM_ERROR_MIN_LEGAL_AGE']"));
            if (element1.isDisplayed() || element2.isDisplayed()) {
                System.out.println("Age Test 5 Failed: system does not allow age that is between 16 and 150");
            }
        }
        catch (Exception e){
            System.out.println("Age Test 5 Passed: system does allow age that is between 16 and 150");
        }

//Test 21 // Gender Test 1 :  unchecked
        select.selectByVisibleText("Cinsiyet");
        RegisterButton.click();
        try {
            WebElement element = driver.findElement(By.cssSelector("[data-error-type='FORM_ERROR_SEX_NOT_VALID']"));
            if (element.isDisplayed()) {
                System.out.println("Gender Test 1 Passed: System requires Gender to be selected");
            }
        }
        catch (Exception e){
            System.out.println("Gender Test 1 Failed: System does not require Gender to be selected");
        }
//Test 21 // Gender Test 1 :  unchecked
        select.selectByVisibleText("Cinsiyet");
        RegisterButton.click();
        try {
            WebElement element = driver.findElement(By.cssSelector("[data-error-type='FORM_ERROR_SEX_NOT_VALID']"));
            if (element.isDisplayed()) {
                System.out.println("Gender Test 1 Passed: System requires Gender to be selected");
            }
        }
        catch (Exception e){
            System.out.println("Gender Test 1 Failed: System does not require Gender to be selected");
        }
//Test 22 // Gender Test 2 :  Male
        select.selectByVisibleText("Erkek");
        RegisterButton.click();
        try {
            WebElement element = driver.findElement(By.cssSelector("[data-error-type='FORM_ERROR_SEX_NOT_VALID']"));
            if (element.isDisplayed()) {
                System.out.println("Gender Test 2 Failed: System does not allow Gender to be selected as Male ");
            }
        }
        catch (Exception e){
            System.out.println("Gender Test 2 Passed: System allows Gender to be selected as Male");
        }
//Test 23 // Gender Test 3 :  Female
        select.selectByVisibleText("Kadın");
        RegisterButton.click();
        try {
            WebElement element = driver.findElement(By.cssSelector("[data-error-type='FORM_ERROR_SEX_NOT_VALID']"));
            if (element.isDisplayed()) {
                System.out.println("Gender Test 3 Failed: System does not allow Gender to be selected as Female ");
            }
        }
        catch (Exception e){
            System.out.println("Gender Test 3 Passed: System allows Gender to be selected as Female");
        }
//Test 22  // Checkbox Test 1 :  unchecked
        RegisterButton.click();
        try {
            WebElement element = driver.findElement(By.cssSelector("[data-error-type='FORM_ERROR_EXPLICIT_CONSENT']"));
            if (element.isDisplayed()) {
                System.out.println("Checkbox Test 1 Passed: System requires checkbox to be checked");
            }
        }
        catch (Exception e){
            System.out.println("Checkbox Test 1 Failed: System does not require checkbox to be checked");
        }
// Login Page Testing
        try {
            WebElement element = driver.findElement(By.cssSelector("a.auth-link[data-tracking-action='switch-to-login']"));
            element.click();
            System.out.println("Switched to login page.");
        } catch (Exception e) {
            System.out.println("Failed to switch to login page.");
        }
        WebElement LoginMail,LoginPassword,LoginButton;
        LoginMail = driver.findElement(By.id("login_mail"));
        LoginPassword = driver.findElement(By.id("login_password"));
        LoginButton = driver.findElement(By.id("login_form_submit"));

//Test 23 // login Test 1 : empty mail
        LoginMail.sendKeys("");
        LoginPassword.sendKeys("129123123123");
        LoginButton.click();
        Thread.sleep(1000L);
        try {
            WebElement element = driver.findElement(By.cssSelector("[data-error-type='FORM_ERROR_EMAIL_NOT_VALID']"));
            if (element.isDisplayed()) {
                System.out.println("Login Test 1 Passed: System shows error about empty email");
            }
        }
        catch (Exception e){
            System.out.println("Login Test 1 Failed: System does not shows error about empty email");
        }
        
//Test 24 // login Test 2 : empty password
        //LoginPassword.clear();
        //LoginPassword.sendKeys("");
        LoginMail.sendKeys("softwaretesting1231254@proton.me");
        LoginButton.click();
        Thread.sleep(1000L);
        try {
            WebElement element = driver.findElement(By.id("login_error"));
            if (element.isDisplayed()) {
                System.out.println("Login Test 2 Passed: System shows error about incorrect password");
            }
        }
        catch (Exception e){
            System.out.println("Login Test 2 Failed: System does not show error about incorrect password");
        }
        Thread.sleep(1000L);
//Test 25 // login Test 3 : valid login
        LoginMail.clear();
        LoginMail.sendKeys("softwaretesting1231254@proton.me");
        LoginPassword.clear();
        LoginPassword.sendKeys(""); // deducted for privacy 
        LoginButton.click();
        Thread.sleep(1000L);
        try {
            WebElement element = driver.findElement(By.id("login_error"));
            if (element.isDisplayed()) {
                System.out.println("Login Test 3 Failed: System does not show error about incorrect password");
            }
        }
        catch (Exception e){
            System.out.println("Login Test 3 Passed: System logged in with valid information");

        }
    }
}
