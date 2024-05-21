package dcx.ufpb.projeto;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import static javax.swing.JOptionPane.*;

/**
 * Código Main do Programa {DayCare Pokemon}, Programa para deixar seus pokemons descansando
 * em uma creche.
 * ░░░░█░▀▄░░░░░░░░░░▄▄███▀░░
 * ░░░░█░░░▀▄░▄▄▄▄▄░▄▀░░░█▀░░
 * ░░░░░▀▄░░░▀░░░░░▀░░░▄▀░░░░
 * ░░░░░░░▌░▄▄░░░▄▄░▐▀▀░░░░░░
 * ░░░░░░▐░░█▄░░░▄█░░▌▄▄▀▀▀▀█
 * ░░░░░░▌▄▄▀▀░▄░▀▀▄▄▐░░░░░░█
 * ░░░▄▀▀▐▀▀░░░░░░░▀▀▌▄▄▄░░░█
 * ░░░█░░░▀▄░░░░░░░▄▀░░░░█▀▀▀
 * ░░░░▀▄░░▀░░▀▀▀░░▀░░░▄█░░░░: "Pika-Pikachu"
 */


//>>>Main do Código.......................................................<<<
public class MainDayCarePokemon {
    public static void main(String[] args) {
        DayCareSystem sistema = new DayCareSystem();
        RecorderPokemon gravaPokemon = new RecorderPokemon();
        try {
            sistema.setListaDadosPokemons(sistema.carregarPokemon());
        } finally {
        }

        //>>>Icones do Programa.........................................
        ImageIcon iconPB = new ImageIcon("./src/main/resources/PokeBall.png");
        ImageIcon iconGB = new ImageIcon("./src/main/resources/GreatBall.png");
        ImageIcon iconUB = new ImageIcon("./src/main/resources/UltraBall.png");
        ImageIcon iconMB = new ImageIcon("./src/main/resources/MasterBall.png");
        ImageIcon iconPK = new ImageIcon("./src/main/resources/Pikachu.png");
        ImageIcon iconPR = new ImageIcon("./src/main/resources/PremierBall.png");

        //>>>Imagem Inicial............................................
        int mensagem = PressStartImage.showMensage();

        //>>>Parte Principal do Main.........................................
        boolean Continue = true;
        while (Continue) {
            String opcao = JOptionPane.showInputDialog(null, "Digite uma opção:\n1.Cadastrar Pokemon\n2.Procurar Pokemon\n3.Listar Pokemons do Sistema\n4.Backup De Dados\n5.Remover Dados Pokemon\n6.Sair", "~Bem Vindo ao DayCare Pokemon🏠~", DEFAULT_OPTION);

            //>>>Cadastrar Treinadores e Dados Pokemons no Sistema..........................................<<<
            if (opcao.equals("1")) {
                String nomeDoTreinador = (String) JOptionPane.showInputDialog(null, "Digite seu nome Treinador: ", "1.Cadastramento", JOptionPane.DEFAULT_OPTION, iconPB, null, null);
                String especieDoPokemon = (String) JOptionPane.showInputDialog(null, "Digite a Espécie do Pokemon: ", "1.Cadastramento", JOptionPane.DEFAULT_OPTION, iconPB, null, null);
                String nivelDoPokemon = (String) JOptionPane.showInputDialog(null, "Digite o Nível do Pokemon: ", "1.Cadastramento", JOptionPane.DEFAULT_OPTION, iconPB, null, null);
                String sexoDoPokemon = (String) JOptionPane.showInputDialog(null, "Digite o Sexo do Pokemon: ", "1.Cadastramento", JOptionPane.DEFAULT_OPTION, iconPB, null, null);
                try {
                    sistema.cadastraPokemon(nomeDoTreinador, especieDoPokemon, nivelDoPokemon, sexoDoPokemon);
                    JOptionPane.showMessageDialog(null, "Informações sobre seu Pokemon cadastradas com sucesso.");
                } catch (AlreadyRegisteredPokemon e) {
                    JOptionPane.showMessageDialog(null, "Não foi possível cadastrar. Veja se seu Pokemon já está cadastrado.");
                    e.printStackTrace();
                }

            //>>>Pesquisar Parâmetros no Sistema.....................................<<<
            } else if (opcao.equals("2")) {
                ArrayList<Pokemon> ResultadoDaBusca = new ArrayList<>();
                String nomeDoTreinador = (String) JOptionPane.showInputDialog(null,"Digite o 'Nome' do Treinador: ", "2.Pesquisa Pokemon", Integer.parseInt(String.valueOf(DEFAULT_OPTION)), iconGB, null, null);
                String especieDoPokemon = (String) JOptionPane.showInputDialog(null,"Digite a 'Especie' do Pokemon: ", "2.Pesquisa Pokemon", Integer.parseInt(String.valueOf(DEFAULT_OPTION)), iconGB, null, null);
                String nivelDoPokemon = (String) JOptionPane.showInputDialog(null,"Digite o 'Nível' do Pokemon: ", "2.Pesquisa Pokemon", Integer.parseInt(String.valueOf(DEFAULT_OPTION)), iconGB, null, null);
                String sexoDoPokemon = (String) JOptionPane.showInputDialog(null,"Digite o 'Sexo' do Pokemon ", "2.Pesquisa Pokemon", Integer.parseInt(String.valueOf(DEFAULT_OPTION)), iconGB, null, null);
                ResultadoDaBusca = sistema.pesquisaPokemons(nomeDoTreinador, especieDoPokemon, nivelDoPokemon, sexoDoPokemon);

                for (Pokemon p: ResultadoDaBusca){
                    JOptionPane.showMessageDialog(null, p.toString());
                }

            //>>>Listar todos os Dados Cadastrados.....................................<<<
            } else if (opcao.equals("3")) {
                if (sistema.getListaDadosPokemons().size() == 0) {
                    JOptionPane.showMessageDialog(null, "Não há nenhum dado registrado no sistema");

                } else {
                    String lista = String.valueOf(((DayCareSystem) sistema).getListaDadosPokemons());
                    JOptionPane.showMessageDialog(null, lista, "3.Lista de Pokemons:", Integer.parseInt(String.valueOf(DEFAULT_OPTION)), iconUB);
                }


            //>>>Backup dos Dados...........................................................<<<
            } else if (opcao.equals("4")) {
                try {
                    gravaPokemon.gravaPokemon(sistema.getListaDadosPokemons());
                    JOptionPane.showMessageDialog(null, "Informações gravadas com sucesso.", "4.Backup Dos Dados", Integer.parseInt(String.valueOf(DEFAULT_OPTION)), iconPR);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Não foi possível gravar os dados do Pokemon.", null, ERROR_MESSAGE);
                    e.printStackTrace();
                }


            //>>>Apagar todos os Dados No Sistema...........................................................................<<<
            } else if (opcao.equals("5")) { //>>>Apagar todos os Dados No Sistema........................................<<<

                String nomeDoTreinador = (String) JOptionPane.showInputDialog(null, "Insira o 'Nome' do treinador: ", "5.Apagar Dados Pokemons", JOptionPane.DEFAULT_OPTION, iconMB, null, null);
                String especieDoPokemon = (String) JOptionPane.showInputDialog(null, "Insira a 'Espécie' do pokemon: ", "5.Apagar Dados Pokemons", JOptionPane.DEFAULT_OPTION, iconMB, null, null);
                try {
                    sistema.apagarPokemonsDoSistema(nomeDoTreinador, especieDoPokemon);
                    JOptionPane.showMessageDialog(null, "Informações sobre o Pokemon foram removidas com sucesso.");
                } catch (NonAlreadyRegistered e) {
                    JOptionPane.showMessageDialog(null, "Informações sobre o Pokemon não foram cadastradas no sistema.");
                    e.printStackTrace();
                }

            //>>>Sair do Programa...............................................................<<<
            } else if (opcao.equals("6")) {
                //sair
                JOptionPane.showMessageDialog(null, "-Até Mais e Volte Sempre!👋 ", "", Integer.parseInt(String.valueOf(DEFAULT_OPTION)), iconPK);
                Continue = false;

                }
            }
    }
}