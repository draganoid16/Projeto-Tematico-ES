package org.example;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.NoSuchElementException;
import java.util.Scanner; // Import the Scanner class to read text files


public class Analista {
    String nomeficheiro;
    String conteudoficheiro;
    int palavrascomLetra[];

    public Analista(String nomeficheiro) {
        this.nomeficheiro = nomeficheiro;
        this.conteudoficheiro = lerFicheiro(nomeficheiro); //ler so uma vez por eficiencia
        this.palavrascomLetra = new int[5]; //alocar memoria a um array de 5
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
                    break;

                case 1:
                    palavrascomLetra[0] += 1;
                    break;

                case 2:
                    palavrascomLetra[1] += 1;
                    break;

                case 3:
                    palavrascomLetra[2] += 1;
                    break;

                case 4:
                    palavrascomLetra[3] += 1;
                    break;

                case 5:
                    palavrascomLetra[4] += 1;
                    break;

                default:
                    palavrascomLetra[4] += 1;
                    break;
            }
        }
        System.out.println("\nteste guardar em array");
        System.out.println("Array[0] quantas occurencias 1 letra: " + palavrascomLetra[0]);
        System.out.println("Array[1] quantas occurencias 2 letras: " + palavrascomLetra[1]);
        System.out.println("Array[2] quantas occurencias 3 letras: " + palavrascomLetra[2]);
        System.out.println("Array[3] quantas occurencias 4 letras: " + palavrascomLetra[3]);
        System.out.println("Array[4] quantas occurencias 5+ letras: " + palavrascomLetra[4]);

        return palavrascomLetra;
    }


}

