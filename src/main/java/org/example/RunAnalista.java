package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RunAnalista {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduza o nome do ficheiro: ");
        String FicheiroaLer = scanner.nextLine();
        Analista analista = new Analista(FicheiroaLer);
        boolean menu = true;

        while (menu) {
            System.out.println("Opção Desejada: (letra 'x' | ficheiro 'x' nomeficheiroaguardar | terminar ");
            String input = scanner.nextLine();
            String[] escolha = input.split("\\s+");
            try {
            switch (escolha[0]) {
                    case "letra":
                        char LetraEscolhida = escolha[1].charAt(0);
                        int[] arrayaguardar = analista.quantasOcorrencias(LetraEscolhida);
                        try {
                            FileWriter writer = new FileWriter(LetraEscolhida + ".out");

                            int i = 0;
                            for (int element : arrayaguardar) {
                                writer.write(i + ": " + element + "\n");
                                i++;
                            }

                            writer.close();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Ficheiro " + LetraEscolhida + ".out guardado com sucesso.");
                        break;

                    case "ficheiro":
                        char LetraEscolhida2 = escolha[1].charAt(0);
                        String outputFile = escolha[2];
                        try {
                            analista.listaPalavras(LetraEscolhida2, outputFile);
                            System.out.println();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Ficheiro " + outputFile + ".out guardado com sucesso.");
                        break;

                    case "terminar":
                        System.out.println("Programa terminado");
                        menu = false;
                        break;
                }


            }catch(NullPointerException e){
                e.getStackTrace();
                System.out.println("Erro! Ficheiro a ler está vazio!");
                System.exit(0);
            }

        }
    }
}

