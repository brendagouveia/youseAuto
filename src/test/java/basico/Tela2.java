package basico;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import supporte.VerificarElemento;

import java.awt.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

public class Tela2 {

    private Impressao imprimir;

    public Tela2() {
        imprimir = new Impressao();
    }

    public String preencherTela2(WebDriver driver, Variaveis dados) throws InterruptedException, AWTException, FindFailed, UnsupportedFlavorException, IOException {

        String testeCarro = "OK";
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("auto_order_flow_pricing_requirements_vehicle_attributes_license_plate_or_vin")));

        System.out.println("Achou a tela 2");


        driver.findElement(By.id("auto_order_flow_pricing_requirements_vehicle_attributes_license_plate_or_vin")).sendKeys("III7777");
        Thread.sleep(1000);
        driver.findElement(By.id("auto_order_flow_pricing_requirements_vehicle_attributes_license_plate_or_vin")).sendKeys(Keys.TAB);
        Thread.sleep(3000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div[10]/div/a")));
        //if (VerificarElemento.verificar(driver, "//*[@id=\"container\"]/div[10]/div/a", "XPATH", 3)) {
            System.out.println("Achou a JANELA PLACA ERRADA");
            driver.findElement(By.xpath("//*[@id=\"container\"]/div[10]/div/a")).click();
       // }
          /*  driver.switchTo().frame("webWidget");
            if (driver.findElements(By.xpath("//*[contains(@aria-label, 'Minimizar widget')]")).size() > 0) {
                driver.findElement(By.xpath("//*[contains(@aria-label, 'Minimizar widget')]")).click();

            }
            driver.switchTo().defaultContent();
*/

        Thread.sleep(1000);

        WebElement cmbMarca = driver.findElement(By.id("manual_auto_order_flow_pricing_requirements_vehicle_attributes_make"));
        Select slctMarca = new Select(cmbMarca);


        if (dados.getMarca().toUpperCase().contains("VW - VOLKSWAGEN")) {
            dados.setMarca("VOLKSWAGEN");
        }
        if (dados.getMarca().toUpperCase().contains("MITSUBISH")) {
            dados.setMarca("MITSUBISHI");
        }
        if (dados.getMarca().toUpperCase().contains("GM")) {
            dados.setMarca("CHEVROLET");
        }
        if (dados.getMarca().toUpperCase().contains("CITROEN")) {
            dados.setMarca("CITROËN");
        }
        if (dados.getMarca().toUpperCase().contains("KIA")) {
            dados.setMarca("KIA MOTORS");
        }
        if (dados.getVeiculo().toUpperCase().contains("GRAND VITARA 2.0 16V 5P AUT")) {
            dados.setMarca("GRAND VITARA 2.0 16V 4X2 / 4X4 5P AUT");
        }


        //verificar se a marca existe no combo
        int posicao = -1;
        java.util.List<WebElement> listaMarca = slctMarca.getOptions();
        for (int i = 0; i < listaMarca.size(); ) {
            if (listaMarca.get(i).getText().toUpperCase().contains(dados.getMarca().toUpperCase())) {
                posicao = i;
            }
            i++;
        }
        if (posicao > -1) {
            slctMarca.selectByIndex(posicao);
            Thread.sleep(5000);
            WebElement cmbVersao = driver.findElement(By.id("manual_auto_order_flow_pricing_requirements_vehicle_attributes_model"));
            Select slcVersao = new Select(cmbVersao);
            posicao = -1;
            java.util.List<WebElement> listaVersao = slcVersao.getOptions();
            for (int i = 0; i < listaVersao.size(); ) {
                if (listaVersao.get(i).getText().toUpperCase().equals(dados.getVersaoMod().toUpperCase())) {
                    posicao = i;
                }
                i++;
            }

            if (posicao > -1) {
                System.out.println(listaVersao.get(posicao).getText());
                slcVersao.selectByVisibleText(dados.getVersaoMod().toUpperCase());
                Thread.sleep(2000);
                WebElement cmbAno = driver.findElement(By.id("manual_auto_order_flow_pricing_requirements_vehicle_attributes_year"));
                Select slcAno = new Select(cmbAno);
                slcAno.selectByVisibleText(dados.getAnoModelo().toUpperCase());
                Thread.sleep(2000);
                WebElement cmbVeic = driver.findElement(By.id("manual_auto_order_flow_pricing_requirements_vehicle_attributes_version"));
                Select slcVeic = new Select(cmbVeic);
                List<WebElement> listaVeic = slcVeic.getOptions();

                //colocar espaço entre as barras q atrapalham
                      /*  if (dados.getVeiculo().contains("/")) {
                            String novoveic = "";
                            for (int i = 0; i < dados.getVeiculo().length(); ) {
                                char c = dados.getVeiculo().charAt(i);
                                String s = new StringBuilder().append(c).toString();
                                if (s.contains("/")) {
                                    novoveic = novoveic + " " + s + " ";
                                } else {
                                    novoveic = novoveic + s;
                                }
                                i++;
                            }
                            dados.setVeiculo(novoveic);
                        }*/

                posicao = -1;
                for (int i = 0; i < listaVeic.size(); ) {
                    if (listaVeic.get(i).getText().toUpperCase().contains(dados.getVeiculo().toUpperCase())) {
                        posicao = i;
                    }
                    i++;
                }


                if (posicao > -1) {

                    slcVeic.selectByIndex(posicao);
                    Thread.sleep(1000);
                    System.out.println("testar veiculo sem aceitacao");

                    if (driver.findElements(By.xpath("//*[contains(text(), 'a gente ainda não oferece seguros para o mesmo modelo e ano do seu carro.')]")).size() > 0) {
                        System.out.println("veiculo sem aceitacao");
                        testeCarro = "RESTRICAO VEICULO";

                    } else {

                        if (Integer.parseInt(dados.getAnoModelo()) > 2018) {
                            if (VerificarElemento.verificar(driver, "auto_order_flow_pricing_requirements_vehicle_attributes_brand_new", "ID", 30)) {
                                WebElement cmbZero = driver.findElement(By.id("auto_order_flow_pricing_requirements_vehicle_attributes_brand_new"));
                                Select slcZero = new Select(cmbZero);
                                if (dados.getZeroKm().toUpperCase().contains("S")) {
                                    slcZero.selectByIndex(1);
                                } else if (dados.getZeroKm().toUpperCase().contains("N")) {
                                    slcZero.selectByIndex(2);
                                }

                            }
                        }

                        if (VerificarElemento.verificar(driver, "//*[@id=\"vehicle-usage-section\"]/fieldset/div/div[1]", "XPATH", 30)) {
                            WebElement cmbUtiliz = driver.findElement(By.xpath("//*[@id=\"vehicle-usage-section\"]/fieldset/div/div[1]"));
                            cmbUtiliz.click();

                        }

                        Thread.sleep(1000);
                           /* WebElement cmbTipoPess = driver.findElement(By.id("auto_order_flow_pricing_requirements_vehicle_attributes_ownership_status"));
                            Select slcTipoPess = new Select(cmbTipoPess);
                            slcTipoPess.selectByIndex(1);*/
                        Thread.sleep(1000);
                        driver.findElement(By.xpath("/html/body/div[3]/div[1]/form/fieldset/fieldset[4]/fieldset/section/span[2]/div/label")).click();
//
                        Thread.sleep(1000);


                        //cep
                        if (dados.getCep1().contains("30110020")) {
                            dados.setCep1("30110000");
                        }
                        if (dados.getCep1().contains("06730000")) {
                            dados.setCep1("06730970");
                        }
                        if (dados.getCep1().contains("11250971")) {
                            dados.setCep1("11250261");
                        }
                       /* if (dados.getCep1().contains("14140000")) {
                            dados.setCep1("14140970");
                        }*/
                        if (VerificarElemento.verificar(driver, "auto_order_flow_pricing_requirements_vehicle_attributes_address_attributes_zipcode", "ID", 30)) {
                            for (int i = 0; i < dados.getCep1().length(); ) {
                                char c = dados.getCep1().charAt(i);
                                String s = new StringBuilder().append(c).toString();
                                driver.findElement(By.id("auto_order_flow_pricing_requirements_vehicle_attributes_address_attributes_zipcode")).sendKeys(s);
                                i++;
                            }
                            Thread.sleep(1000);


                          if(driver.findElement(By.id("auto_order_flow_pricing_requirements_vehicle_attributes_address_attributes_neighborhood")).isDisplayed()){
                               System.out.println("Achou bairro");
                                String bairro="centro";
                                for (int i = 0; i < bairro.length(); ) {
                                    char c = bairro.charAt(i);
                                    String s = new StringBuilder().append(c).toString();
                                    driver.findElement(By.id("auto_order_flow_pricing_requirements_vehicle_attributes_address_attributes_neighborhood")).sendKeys(s);
                                    i++;
                                }
                                Thread.sleep(1000);
                                driver.findElement(By.id("auto_order_flow_pricing_requirements_vehicle_attributes_address_attributes_street")).sendKeys("centro");
                            }
                            Thread.sleep(1000);
                            driver.findElement(By.id("auto_order_flow_pricing_requirements_vehicle_attributes_address_attributes_number")).sendKeys("100");
                        }

                        Thread.sleep(1000);


                        System.out.println("testar cpf");
                        if (VerificarElemento.verificar(driver, "auto_order_flow_pricing_requirements_insured_person_attributes_cpf", "ID", 1)) {
                            System.out.println("achou cpf");
                            for (int i = 0; i < dados.getCpfSegur().length(); ) {
                                char c = dados.getCpfSegur().charAt(i);
                                String s = new StringBuilder().append(c).toString();
                                driver.findElement(By.id("auto_order_flow_pricing_requirements_insured_person_attributes_cpf")).sendKeys(s);
                                i++;
                            }

                        }
                        Thread.sleep(1000);
                          /*  WebElement cmbEstCivil = driver.findElement(By.id("auto_order_flow_pricing_requirements_insured_person_attributes_marital_status"));
                            Select slcEstCivil = new Select(cmbEstCivil);
                            if (dados.getEstadoCivil().toUpperCase().contains("S")) {
                                slcEstCivil.selectByIndex(1);
                            } else if (dados.getEstadoCivil().toUpperCase().contains("C")) {
                                slcEstCivil.selectByIndex(2);
                            } else if (dados.getEstadoCivil().toUpperCase().contains("D")) {
                                slcEstCivil.selectByIndex(3);
                            } else {
                                slcEstCivil.selectByIndex(4);
                            }*/

                        if (VerificarElemento.verificarExiste(driver, "//*[contains(@data-narrative-form-trigger, 'driver_has_insurance_false')]", "XPATH", 2)) {
                            System.out.println("faixa roxa apareceu");
                            //if (driver.findElements(By.xpath("//*[contains(@data-narrative-form-trigger, 'driver_has_insurance_false')]")).size() > 0) {
                                /*WebElement nao25anos = driver.findElement(By.xpath("//*[contains(@data-narrative-form-trigger, 'driver_has_insurance_false')]"));

                                JavascriptExecutor jsColi = (JavascriptExecutor) driver;
                                jsColi.executeScript("arguments[0].click();", nao25anos);*/
                            driver.findElement(By.xpath("/html/body/div[3]/div[1]/form/fieldset/fieldset[8]/div/div/fieldset/section/span[2]/div/label")).click();
                        } else {
                            //tipo de seguro
                            WebElement cmbTipoSeg = driver.findElement(By.id("auto_order_flow_pricing_requirements_driver_attributes_has_insurance"));
                            Select slcTipoSeg = new Select(cmbTipoSeg);
                            if (Integer.parseInt(dados.getClasseBonus()) > 0) {
                                slcTipoSeg.selectByIndex(1);
                                Thread.sleep(1000);
                                WebElement cmbTenhoBonus = driver.findElement(By.id("auto_order_flow_pricing_requirements_driver_attributes_has_bonuses_class"));
                                Select slcTenhoBonus = new Select(cmbTenhoBonus);
                                slcTenhoBonus.selectByIndex(1);
                                Thread.sleep(1000);
                                System.out.println("COLOCAR O BONUS");


                                if (!driver.findElement(By.id("auto_order_flow_pricing_requirements_driver_attributes_user_bonuses_class")).isDisplayed()) {
                                    System.out.println("bonus nao ta ativo");
                                    if (driver.findElement(By.id("which_vehicle")).isDisplayed()) {
                                        WebElement cmbEsteCarro = driver.findElement(By.id("which_vehicle"));
                                        Select slcEsteCarro = new Select(cmbEsteCarro);
                                        slcEsteCarro.selectByIndex(1);
                                        Thread.sleep(1000);
                                    }
                                    if (driver.findElement(By.id("auto_order_flow_pricing_requirements_driver_attributes_former_insurer")).isDisplayed()) {
                                        WebElement cmbCiaAnt = driver.findElement(By.id("auto_order_flow_pricing_requirements_driver_attributes_former_insurer"));
                                        Select slcCiaAnt = new Select(cmbCiaAnt);
                                        slcCiaAnt.selectByIndex(1);
                                        Thread.sleep(1000);
                                    }

                                }
                                System.out.println("bonus ta ativo");
                                WebElement cmbBonus = driver.findElement(By.id("auto_order_flow_pricing_requirements_driver_attributes_user_bonuses_class"));
                                Select slcBonus = new Select(cmbBonus);
                                slcBonus.selectByIndex(Integer.parseInt(dados.getClasseBonus()));
                                System.out.println("OK O BONUS");
                                Thread.sleep(1000);

                                if (VerificarElemento.verificar(driver, "auto_order_flow_pricing_requirements_driver_attributes_ci_number", "ATIVO", 10)) {
                                    Thread.sleep(1000);
                                    driver.findElement(By.id("auto_order_flow_pricing_requirements_driver_attributes_ci_number")).sendKeys("517TX01O79ZMP6");
                                    Thread.sleep(1000);
                                }


                            } else {
                                slcTipoSeg.selectByIndex(2);
                            }
                        }
                        Thread.sleep(1000);

                        //menor de 25 anos
                           /* if (VerificarElemento.verificar(driver, "//*[contains(@for, 'young_driver_true')]", "XPATH", 1)) {
                                System.out.println("Achou CHK menor25");
                                if (driver.findElements(By.xpath("//*[contains(@aria-label, 'Minimizar widget')]")).size() > 0) {
                                    driver.findElement(By.xpath("//*[contains(@aria-label, 'Minimizar widget')]")).click();
                                }
                                Thread.sleep(1000);
                                driver.findElement(By.xpath("//*[contains(@for, 'young_driver_false')]")).click();
                            }*/

                        System.out.println("Proxima tela");


                        Thread.sleep(1000);
                         /*   driver.switchTo().frame("webWidget");
                            if (driver.findElements(By.xpath("//*[contains(@aria-label, 'Minimizar widget')]")).size() > 0) {
                                driver.findElement(By.xpath("//*[contains(@aria-label, 'Minimizar widget')]")).click();

                            }
                            driver.switchTo().defaultContent();*/


                        imprimir.imprimirPDF(driver, dados.getNrlinha(), "P1_");
                        imprimir.imprimir(driver, dados.getNrlinha());
                        Thread.sleep(1000);
                        driver.findElement(By.name("commit")).click();

                        Thread.sleep(1000);
                    }
                } else {
                    testeCarro = "CARRO";
                    System.out.println("nao achou o veiculo");
                }
            } else {
                testeCarro = "CARRO";
                System.out.println("nao achou versao");
            }

        } else {
            testeCarro = "CARRO";
            System.out.println("nao achou a marca");

        }


        return testeCarro;
    }

    public boolean verificarAceita(WebDriver driver, Variaveis dados) throws
            IOException, UnsupportedFlavorException {
        boolean aceita = false;
        System.out.println(driver.findElement(By.className("section-label")).getText());
        if (driver.findElement(By.className("section-label")).getText().contains("PLANOS")) {
            System.out.println("Aceitou");
            aceita = true;
        } else if (driver.findElement(By.className("section-label")).getText().contains("COBERTURAS")) {
            System.out.println("sem aceitacao");
            imprimir.imprimirRestricao(driver, dados.getNrlinha());
        }

        return aceita;
    }


}
