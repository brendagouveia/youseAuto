package basico;

import java.io.*;
import java.util.Scanner;

public class LerArquivoYouse {
    private String nrlinha;
    private Variaveis arquivoP;


    public Variaveis lerArquivoNr(String nrlinha) throws IOException {
        this.nrlinha = nrlinha;
        arquivoP = new Variaveis();

        File file = new File("D:\\youse\\arquivos\\" + nrlinha);
        //File file = new File("/home/robertinho/youse/arquivos/" + nrlinha);
        if (file.exists()) {
           // Scanner ler = new Scanner("/home/robertinho/youse/arquivos/" + nrlinha);
            Scanner ler = new Scanner("D:\\youse\\arquivos\\" + nrlinha);
            String arquivo = ler.nextLine();
            FileReader arq = new FileReader(arquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            arquivoP.setNomeSegur(lerArq.readLine());
            arquivoP.setCpfSegur(lerArq.readLine());
            arquivoP.setCep1(lerArq.readLine());
            arquivoP.setDataSegur(lerArq.readLine());
            arquivoP.setEstadoCivil(lerArq.readLine());
            arquivoP.setSexoCondu(lerArq.readLine());
            arquivoP.setFranquia(lerArq.readLine());
            arquivoP.setAnoModelo(lerArq.readLine());
            arquivoP.setZeroKm(lerArq.readLine());
            arquivoP.setMarca(lerArq.readLine());
            lerArq.readLine();
            arquivoP.setVeiculo(lerArq.readLine());
            arquivoP.setVersaoMod(lerArq.readLine());
            arquivoP.setValorMer(lerArq.readLine());
            arquivoP.setComercial(lerArq.readLine());
            arquivoP.setDm(lerArq.readLine());
            arquivoP.setDc(lerArq.readLine());
            lerArq.readLine();
            arquivoP.setApp(lerArq.readLine());
            arquivoP.setClasseBonus(lerArq.readLine());


        }

        return arquivoP;
    }

}
