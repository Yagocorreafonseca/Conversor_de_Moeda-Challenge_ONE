package Principal;

import Modelos.Textos;
import Calculos.PesquisarAPI;
import Modelos.Moeda;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        int continuar = 1;

        Scanner leitura = new Scanner(System.in);
        Textos textos = new Textos();
        Moeda moeda = new Moeda();

        System.out.println(textos.getApresentacao1());
        try {
            while (true) {
                if (continuar == 1) {
                    System.out.println("________________________________________________________________");


                    System.out.println(textos.getApresentacao2());
                    moeda.setNome1(leitura.nextLine());
                    moeda.setNome1(moeda.getNome1().toUpperCase());

                    System.out.println(textos.getApresentacao3());
                    moeda.setNome2(leitura.nextLine());
                    moeda.setNome2(moeda.getNome2().toUpperCase());

                    System.out.println(textos.getApresentacao4());
                    moeda.setQuantidade(leitura.nextDouble());

                    leitura.nextLine();

                    String texto = PesquisarAPI.buscarCotacoes(moeda.getNome1(), moeda.getNome2(), moeda);

                    System.out.println(texto);

                    System.out.println(textos.getFinalizacao1());
                    continuar = leitura.nextInt();
                    leitura.nextLine();

                } else if (continuar == 2) {
                    break;
                } else {
                    System.out.println("Opção indisponível");
                    break;
                }
            }
            System.out.println("Processo finalizado");
        } catch (InputMismatchException e) {
            System.out.println("ERRO: tipo de valor incorreto inserido na quantidade.");
        }
    }
}