package basico;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import supporte.VerificarElemento;

import java.awt.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class Tela4 {

    private Impressao imprimir;

    public Tela4() {
        imprimir = new Impressao();
    }

    public void preencherTela4(WebDriver driver, Variaveis dados) throws InterruptedException, IOException, UnsupportedFlavorException, FindFailed, AWTException {


        if (VerificarElemento.verificar(driver, "//*[contains(@value, 'YOUSE_ID_2')]", "XPATH", 10)) {

            System.out.println("Achou a tela 4");
            //ass 400 km
            Thread.sleep(1000);



            if (VerificarElemento.verificar(driver, "//*[contains(@data-track-name, 'Assistência a automóvel')]", "XPATH", 1)) {
                System.out.println("motorista");
                WebElement meuchk = driver.findElement(By.xpath("//*[contains(@data-track-name, 'Assistência a automóvel')]"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", meuchk);
            }


            //ass basica
           /* if (VerificarElemento.verificar(driver, "//*[contains(@value, 'YOUSE_ID_3')]", "XPATH", 1)) {
                WebElement rdbAss = driver.findElement(By.xpath("//*[contains(@value, 'YOUSE_ID_3')]"));
                JavascriptExecutor jsAss = (JavascriptExecutor) driver;
                jsAss.executeScript("arguments[0].click();", rdbAss);

            if (VerificarElemento.verificar(driver, "//*[contains(@value, 'YOUSE_ID_2')]", "XPATH", 1)) {
                WebElement rdbAss = driver.findElement(By.xpath("//*[contains(@value, 'YOUSE_ID_2')]"));
                JavascriptExecutor jsAss = (JavascriptExecutor) driver;
                jsAss.executeScript("arguments[0].click();", rdbAss);
            }*/
            if (VerificarElemento.verificar(driver, "//*[contains(@value, 'YOUSE_ID_1')]", "XPATH", 1)) {
                WebElement rdbAss = driver.findElement(By.xpath("//*[contains(@value, 'YOUSE_ID_1')]"));
                JavascriptExecutor jsAss = (JavascriptExecutor) driver;
                jsAss.executeScript("arguments[0].click();", rdbAss);
            }

            Thread.sleep(1000);
        /*if (VerificarElemento.verificar(driver, "//*[contains(@data-track-name, 'Reparos simples')]", "XPATH", 1)) {
            System.out.println("vidros");
            WebElement meuchk = driver.findElement(By.xpath("//*[contains(@data-track-name, 'Reparos simples')]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", meuchk);

        }*/
            WebElement meuchkChave = driver.findElement(By.xpath("//*[contains(@data-track-name, 'Chaveiro auto')]"));
            JavascriptExecutor jsChave = (JavascriptExecutor) driver;
            jsChave.executeScript("arguments[0].click();", meuchkChave);

            Thread.sleep(1000);
            if (VerificarElemento.verificar(driver, "//*[contains(@data-track-name, 'Motorista Youse')]", "XPATH", 1)) {
                System.out.println("motorista");
                WebElement meuchk = driver.findElement(By.xpath("//*[contains(@data-track-name, 'Motorista Youse')]"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", meuchk);
            }

            Thread.sleep(2000);


            if (VerificarElemento.verificar(driver, "//*[contains(@data-track-name, 'Lavagem e higieniza')]", "XPATH", 1)) {
                System.out.println("higienizacao");
                WebElement meuchk = driver.findElement(By.xpath("//*[contains(@data-track-name, 'Lavagem e higieniza')]"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", meuchk);
            }

            if (VerificarElemento.verificar(driver, "//*[contains(@data-track-name, 'leva e traz')]", "XPATH", 1)) {
                System.out.println("leva e traz");
                WebElement meuchk = driver.findElement(By.xpath("//*[contains(@data-track-name, 'leva e traz')]"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", meuchk);
            }

            Thread.sleep(1000);

          /*  if (VerificarElemento.verificar(driver, "//*[contains(@data-track-name, 'Restituição de IPVA')]", "XPATH", 1)) {
                System.out.println("ipva");
                WebElement meuchk = driver.findElement(By.xpath("//*[contains(@data-track-name, 'Restituição de IPVA')]"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", meuchk);
            }

            Thread.sleep(1000);

            if (VerificarElemento.verificar(driver, "//*[contains(@data-track-name, 'Serviço de histórico veicular')]", "XPATH", 1)) {
                System.out.println("hisyorico");
                WebElement meuchk = driver.findElement(By.xpath("//*[contains(@data-track-name, 'Serviço de histórico veicular')]"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", meuchk);
            }*/

            Thread.sleep(1000);

            if (VerificarElemento.verificar(driver, "//*[contains(@data-track-name, 'ncia a bike')]", "XPATH", 1)) {
                System.out.println("bike");
                WebElement meuchk = driver.findElement(By.xpath("//*[contains(@data-track-name, 'ncia a bike')]"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", meuchk);
            }

            Thread.sleep(6000);
            imprimir.imprimir(driver, dados.getNrlinha());
           // imprimir.imprimirPDF(driver, dados.getNrlinha(), "P3_");
        }
    }
}

