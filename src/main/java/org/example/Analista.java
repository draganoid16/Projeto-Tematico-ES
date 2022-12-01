package org.example;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner; // Import the Scanner class to read text files


public class Analista {
    String nomeficheiro;
    String conteudoficheiro;
    int palavrascomLetra[];

    public Analista(String nomeficheiro) {
        this.nomeficheiro = nomeficheiro;
        this.conteudoficheiro = lerFicheiro(nomeficheiro); //ler so uma vez por eficiencia
        this.palavrascomLetra = new int[6]; //alocar memoria a um array de 5
    }

    public String lerFicheiro(String nomeficheiro) {
        String content = "";
        try {
            content = new Scanner(new File(nomeficheiro)).useDelimiter("\\Z").next();
            System.out.println(content);
        } catch (FileNotFoundException | NoSuchElementException e) {
            e.getStackTrace();
            return null;
        }
        return content;
    }


    public int[] quantasOcorrencias(char c) {

        String[] words = conteudoficheiro.split("\\s+");
        System.out.println(words.length + " palavras.");

        //percorre array
        for (int i = 0; i < words.length; i++) {
            int count = (int) words[i].chars().filter(ch -> ch == c).count();
            System.out.println(count);
            switch (count) {
                case 0:
                    palavrascomLetra[0] += 1;
                    break;

                case 1:
                    palavrascomLetra[1] += 1;
                    break;

                case 2:
                    palavrascomLetra[2] += 1;
                    break;

                case 3:
                    palavrascomLetra[3] += 1;
                    break;

                case 4:
                    palavrascomLetra[4] += 1;
                    break;

                default:
                    palavrascomLetra[5] += 1;
                    break;
            }
        }
        System.out.println("\nteste guardar em array");
        System.out.println("0: " + palavrascomLetra[0]);
        System.out.println("1: " + palavrascomLetra[1]);
        System.out.println("2: " + palavrascomLetra[2]);
        System.out.println("3: " + palavrascomLetra[3]);
        System.out.println("4: " + palavrascomLetra[4]);
        System.out.println("5+: " + palavrascomLetra[5]);


        return palavrascomLetra;
    }

    public int listaPalavras(char c, String ficheiro) {
        try {
            String[] words = conteudoficheiro.split("\\s+");
            String palavraaguardar = "";
            int occurencias = 0;

            File meuFicheiro = new File(ficheiro + ".out");

            if (meuFicheiro.createNewFile()) {
                System.out.println("Ficheiro " + meuFicheiro.getName() + " gravado com sucesso.");
            } else {
                System.out.println("Ficheiro já existe.");
                return 0;
            }

            FileWriter myWriter = new FileWriter(ficheiro + ".out");

            for (int i = 0; i < words.length; i++) {

                if (words[i].startsWith(String.valueOf(c))) { //verifica se a palavra começa com o char especificado (teve que ser convertido para string)
                    palavraaguardar = words[i];
                    for (int x = 0; x < words.length; x++) {
                        if (Objects.equals(words[x], palavraaguardar)) {
                            occurencias++;
                        }

                    }


                    myWriter.write(palavraaguardar + " " + occurencias + "\n");
                    occurencias = 0;


                }

                /*
                String ficheirotemp = lerFicheiro(ficheiro + ".out");
                String[] palavrasguardadas = ficheirotemp.split("\\s+");
                String temppalavra = "";

                for (int f = 0; f < palavrasguardadas.length; f++) {
                    palavrasguardadas[f] = temppalavra;
                    if (temppalavra == palavraaguardar) {
                        occurencias = 0;
                        palavraaguardar = "";
                    }
                }
*/
            }

            myWriter.close();
        } catch (IOException e) {
            e.getStackTrace();
            return 0;
        }

        return 1;
    }


}

