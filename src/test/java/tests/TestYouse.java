package tests;

import basico.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import javax.swing.*;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.RemoteWebDriver;


public class TestYouse {
    private WebDriver driver;

    @Test
    public void ativarYouse() throws IOException{
	//criar pastas
 	/*File pastaarquivos1 = new File("/home/robertinho/youse/arquivos");
        pastaarquivos1.mkdir();
	File pastaarquivos2 = new File("/home/robertinho/youse/pdf");
        pastaarquivos2.mkdir();
	File pastaarquivos3 = new File("/home/robertinho/youse/prontos");
        pastaarquivos3.mkdir();
	File pastaarquivos4 = new File("/home/robertinho/youse/carro");
        pastaarquivos4.mkdir();
	File pastaarquivos5 = new File("/home/robertinho/youse/restricao veiculo");
        pastaarquivos5.mkdir();


        //distribuir
	//cria arquivo com o nome da vm caso nao exista
             

	FileWriter arq1 = new FileWriter("/home/robertinho/ferramentas/mover/NomeVm.txt");
        String hostname = "Unknown";

        try
        {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
        }
        catch (UnknownHostException ex)
        {
            System.out.println("Hostname can not be resolved");
        }
        PrintWriter gravararq = new PrintWriter(arq1);
        gravararq.println(hostname);
        gravararq.flush();
        gravararq.close();

        Scanner ler = new Scanner("/home/robertinho/ferramentas/mover/NomeVm.txt");
        String nome1 = ler.nextLine();
        FileReader arq = new FileReader(nome1);
        BufferedReader LerArquivo = new BufferedReader(arq);
        String nomevm = LerArquivo.readLine();
        arq.close();
 	

        // caminho de onde ira pegar os arquivos
        File diretorio = new File("/run/user/1000/gvfs/smb-share:server=freenas.local,share=arquivosgerais/E/LABSEG/apolice/result/youse/prontos/distribuir/" + nomevm + "/");
        File destino = new File("/home/robertinho/youse/arquivos/");
	//distribui os arquivos para a vm
        if (diretorio.exists()) {
            FileUtils.copyDirectory(diretorio, destino);
            FileUtils.deleteDirectory(diretorio);
        }

*/
        //instanciando classes que serão utilizadas
        NrArquivo nrlinha = new NrArquivo();
        LerArquivoYouse arquivo = new LerArquivoYouse();
        AbrirYouse abrirNavegador = new AbrirYouse();
        Tela1 tela = new Tela1();
        Tela2 tela2=new Tela2();
        Tela3 tela3=new Tela3();
        Tela4 tela4=new Tela4();
        //fim instanciando



        //carregar numlinha dos arquivos na pasta
        ArrayList<String> listaNr = nrlinha.carregarArquivos();
        System.out.println("carregou lista com numero dos arquivos");

        if (listaNr.size() == 0) {
            JOptionPane.showMessageDialog(null, "Acabou todos os arquivos!");
        }

        while (listaNr.size() > 0) {

            try {

                //chamar o abrir que retornar o navegador com a consulta do calculo realizada
                driver = abrirNavegador.abrirNavegadorYouse();
                //setar no objeto as informações contida no arquivo
                Variaveis variaveis = arquivo.lerArquivoNr(listaNr.get(0));
                //adicionar o nrlinha no objeto
                variaveis.setNrlinha(listaNr.get(0));

                tela.preencherTela1(driver, variaveis);
                String retorno = tela2.preencherTela2(driver, variaveis);
                if (retorno.contains("OK")) {
                    boolean aceita = tela2.verificarAceita(driver, variaveis);
                    if (aceita) {
                        tela3.preencherTela3(driver, variaveis);
                        tela4.preencherTela4(driver, variaveis);
                    }
                    //mover arquivo para prontos
                    nrlinha.deleteArquivo(listaNr.get(0), "PRONTOS");
                } else if (retorno.contains("CARRO")) {
                    //carro com descrição errada
                    nrlinha.deleteArquivo(listaNr.get(0), "CARRO");
                } else if (retorno.contains("RESTRICAO VEICULO")) {
                    nrlinha.deleteArquivo(listaNr.get(0), "RESTRICAO VEICULO");
                }

                //carregar novamente os arquivos da pasta
                listaNr = nrlinha.carregarArquivos();
                if (listaNr.size() == 0) {
                    JOptionPane.showMessageDialog(null, "Acabou todos os arquivos!");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());

            } finally {
                if(driver!=null){
                    driver.quit();
                }
                System.gc();
                continue;

            }
        }
    }
}
