package basico;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import supporte.VerificarElemento;

import java.awt.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class Tela3 {

    private Impressao imprimir;

    public Tela3() {
        imprimir = new Impressao();
    }


    public void preencherTela3(WebDriver driver, Variaveis dados) throws InterruptedException, IOException, UnsupportedFlavorException, FindFailed, AWTException {

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Escolha um dos pacotes iniciais')]")));


        System.out.println("Achou a escolha produto");
        if (driver.findElements(By.xpath("//*[contains(text(), 'Entendi')]")).size() > 0) {
            driver.findElement(By.xpath("//*[contains(text(), 'Entendi')]")).click();
        }
           /* if (driver.findElements(By.xpath("//*[contains(text(), 'Agora não')]")).size() > 0) {
                driver.findElement(By.xpath("//*[contains(text(), 'Agora não')]")).click();
            }*/

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(text(), 'Personalizar')]")).click();
        Thread.sleep(1000);
        // if (VerificarElemento.verificar(driver, "//*[contains(text(), 'Adicione ou retire coberturas do seu seguro.')]", "XPATH", 30)) {
        if (VerificarElemento.verificar(driver, "//*[contains(@data-track-name, 'Vale para perda total')]", "XPATH", 30)) {
            System.out.println("Achou a tela 3");
            Thread.sleep(1000);

            //roubo e furto só
               /* WebElement meuchkcoli = driver.findElement(By.xpath("//*[contains(@data-track-name, 'Vale para perda total')]"));

                JavascriptExecutor jsColi = (JavascriptExecutor) driver;
                jsColi.executeScript("arguments[0].click();", meuchkcoli);*/

            //nao contratar qualquer batida
            WebElement meuchkcoli = driver.findElement(By.xpath("//*[contains(@data-track-name, 'Vale pra qualquer batida')]"));

            JavascriptExecutor jsColi = (JavascriptExecutor) driver;
            jsColi.executeScript("arguments[0].click();", meuchkcoli);

            // se não tem qualquer batida tem q tirar franquia
             /*   if (dados.getFranquia().toUpperCase().contains("RED")) {
                    if (VerificarElemento.verificar(driver, "/html/body/div[4]/section/form/ul/li[1]/div[2]/div[2]/ul/li[2]/div[2]/div[3]/div/div[2]/div/input", "XPATH", 30)) {
                        System.out.println("achou elemento franquia");
                        WebElement frqMin = driver.findElement(By.xpath("/html/body/div[4]/section/form/ul/li[1]/div[2]/div[2]/ul/li[2]/div[2]/div[3]/div/div[2]/span[1]"));
                        String valFrqMin = "";
                        for (int i = 0; i < frqMin.getText().length(); ) {
                            char c = frqMin.getText().charAt(i);
                            String s = new StringBuilder().append(c).toString();
                            if (!s.contains("$") && !s.contains(".") && !s.contains("R"))
                                valFrqMin = valFrqMin + s;
                            i++;
                        }
                        valFrqMin = valFrqMin.trim();
                        System.out.println(valFrqMin);

                        WebElement valfrq = driver.findElement(By.xpath("/html/body/div[4]/section/form/ul/li[1]/div[2]/div[2]/ul/li[2]/div[2]/div[3]/div/div[2]/div/input"));
                        ((JavascriptExecutor) driver).executeScript("$ ( arguments [ 0]) . val ( " + valFrqMin + ") . change ( )", valfrq);
                        System.out.println("digitou franquia");
                    }
                }*/
            if (Integer.parseInt(dados.getDm()) == 0) {
                WebElement meuchkdm = driver.findElement(By.xpath("//*[contains(@data-track-name, 'Danos materiais a terceiros')]"));

                JavascriptExecutor jsdm = (JavascriptExecutor) driver;
                jsdm.executeScript("arguments[0].click();", meuchkdm);
            } else {
                if (!dados.getDm().contains("50000")) {
                    if (Integer.parseInt(dados.getDm()) > 300000) {
                        dados.setDm("300000");
                    }
                    if (Integer.parseInt(dados.getDm()) < 50000) {
                        dados.setDm("50000");
                    }
                    if (VerificarElemento.verificar(driver, "//*[contains(@data-track-name, 'Danos materiais a terceiros')]", "XPATH", 30)) {
                        System.out.println("DM");

                        WebElement valDm = driver.findElement(By.xpath("/html/body/div[3]/section/form/ul/li[5]/div[2]/div[3]/div[2]/div/input"));
                        System.out.println("achou elemento digitar dm");

                        System.out.println(dados.getDm());

                        ((JavascriptExecutor) driver).executeScript("$ ( arguments [ 0]) . val ( " + dados.getDm() + ") . change ( )", valDm);
                        System.out.println("digitou o valor no DM");

                    }
                }
                if (VerificarElemento.verificar(driver, "//*[contains(@data-track-name, 'Danos corporais a terceiros')]", "XPATH", 30)) {
                    System.out.println("DC");
                    if (Integer.parseInt(dados.getDc()) > 300000) {
                        dados.setDc("300000");
                    }
                    if (Integer.parseInt(dados.getDc()) < 50000) {
                        dados.setDc("50000");
                    }

                    WebElement meuchk = driver.findElement(By.xpath("//*[contains(@data-track-name, 'Danos corporais a terceiros')]"));

                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].click();", meuchk);

                    System.out.println("valor do dc");

                    WebElement valDc = driver.findElement(By.xpath("/html/body/div[3]/section/form/ul/li[6]/div[2]/div[3]/div[2]/div/input"));
                    System.out.println("achou elemento digitar dc");

                   /* JavascriptExecutor js1 = (JavascriptExecutor) driver;
                    js1.executeScript("arguments[0].setAttribute('value','" + dados.getDc() + "');", valDc);*/
                    ((JavascriptExecutor) driver).executeScript("$ ( arguments [ 0]) . val ( " + dados.getDc() + ") . change ( )", valDc);
                    System.out.println("digitou o valor no DC");


                }
            }
            if (Integer.parseInt(dados.getApp()) > 0) {

                if (Integer.parseInt(dados.getApp()) > 20000) {
                    dados.setApp("20000");
                }
                if (Integer.parseInt(dados.getApp()) < 5000) {
                    dados.setApp("5000");
                }
                if (VerificarElemento.verificar(driver, "//*[contains(@data-track-name, 'Acidentes de passageiros')]", "XPATH", 30)) {
                    System.out.println("app");

                    WebElement meuchk = driver.findElement(By.xpath("//*[contains(@data-track-name, 'Acidentes de passageiros')]"));

                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].click();", meuchk);

                    System.out.println("valor do app");

                    WebElement valApp = driver.findElement(By.xpath("/html/body/div[3]/section/form/ul/li[7]/div[2]/div[3]/div[2]/div/input"));
                    System.out.println("achou elemento digitar app");

                        /* JavascriptExecutor js1 = (JavascriptExecutor) driver;
                        js1.executeScript("arguments[0].setAttribute('value','" + dados.getDc() + "');", valDc);*/
                    ((JavascriptExecutor) driver).executeScript("$ ( arguments [ 0]) . val ( " + dados.getApp() + ") . change ( )", valApp);
                    System.out.println("digitou o valor no app");


                }
            }
            imprimir.imprimirPDF(driver, dados.getNrlinha(), "P2_");
            imprimir.imprimir(driver, dados.getNrlinha());

            Thread.sleep(1000);
            System.out.println("clicar proxima tela");
            Thread.sleep(1000);
            if (VerificarElemento.verificar(driver, "commit", "NAME", 1)) {
                System.out.println("Proxima tela");
                driver.findElement(By.name("commit")).click();
            }
            Thread.sleep(1000);
        }


    }


}
