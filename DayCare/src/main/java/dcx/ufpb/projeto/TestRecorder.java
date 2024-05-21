package dcx.ufpb.projeto;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Para Testar o Gravador de Dados..................
 */

public class TestRecorder {


    public class TestaGravador {
        public static void main(String [] args){
            RecorderDataPokemon gravador = new RecorderDataPokemon();
            String nomeArquivo = "meusdados.txt";
            try {
                List<String> textoRecuperado = gravador.recuperaTextoDeArquivo(nomeArquivo);
                for (String s: textoRecuperado){
                    System.out.println(s);
                }
            } catch (IOException e){
                JOptionPane.showMessageDialog(null, "Não foi possível recuperar dados do arquivo "+ nomeArquivo);
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

            List<String> novosDados = new ArrayList<>();
            int quantasLinhas = Integer.parseInt(JOptionPane.showInputDialog("Quantas linhas tem o texto?"));
            for (int k=0; k< quantasLinhas; k++){
                String linhaLida = JOptionPane.showInputDialog("Digite a próxima linha");
                novosDados.add(linhaLida);
            }

            try {
                gravador.gravaTextoEmArquivo(novosDados, nomeArquivo);
                JOptionPane.showMessageDialog(null, "Dados gravados com sucesso");
            } catch (IOException e){
                JOptionPane.showMessageDialog(null, "Não foi possível gravar os dados");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }




        }
    }
}
