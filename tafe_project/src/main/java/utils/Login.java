package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public void realizarLogin(){

        Navegador abrirComLogin = new Navegador();

        abrirComLogin.abrirNavegadorComLogin();

        String btnLogin = "#form div div div.col-sm-4.col-sm-offset-1 div form > button";

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[data-qa=\"login-email\"]")));
        driver.findElement(By.cssSelector("input[data-qa=\"login-email\"]")).sendKeys("vs@gmail.com");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[data-qa=\"login-password\"]")));
        driver.findElement(By.cssSelector("input[data-qa=\"login-password\"]")).sendKeys("123456");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(btnLogin)));
        driver.findElement(By.cssSelector(btnLogin)).click();

    }

    public void realizarLogout(){

        String btnLogout = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a";

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(btnLogout)));
        driver.findElement(By.cssSelector(btnLogout)).getText();

        Navegador fecharComLogout = new Navegador();

        fecharComLogout.fecharNavegador();

    }

}
