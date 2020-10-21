package basico;


import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import supporte.VerificarElemento;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tela1 {

    String tipoSO = "WINDOWS";
    //String tipoSO="LINUX";


    public void preencherTela1(WebDriver driver, Variaveis dados) throws InterruptedException {
        if (VerificarElemento.verificar(driver, "auto_order_flow_lead_person_data_lead_person_attributes_name", "ID", 5)) {
            System.out.println("Achou a tela 1");

            Thread.sleep(1000);
            driver.findElement(By.id("auto_order_flow_lead_person_data_lead_person_attributes_name")).sendKeys(dados.getNomeSegur());

            driver.findElement(By.id("auto_order_flow_lead_person_data_lead_person_attributes_email")).sendKeys("jose1@hotmail.com");

            driver.findElement(By.id("auto_order_flow_lead_person_data_lead_person_attributes_phone")).sendKeys("1198888888");

            if (VerificarElemento.verificar(driver, "commit", "NAME", 1)) {
                System.out.println("Proxima tela");
                driver.findElement(By.name("commit")).click();

            }

        }
    }



}


