package org.example;

import java.io.*;
import java.util.*;


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

    public Map listaPalavras (char c, String ficheiro) throws IOException {
        //cria um novo ficheiro
        File myObj = new File(ficheiro + ".out");

        // Create a map to store the words and their counts
        Map<String, Integer> words = new HashMap<>();
        String[] lineWords = conteudoficheiro.split("\\s+");

        // Loop over the words and add them to the map if they start with the specified character
        for (String word : lineWords) {
            if (word.startsWith(String.valueOf(c))) {
                words.put(word, words.getOrDefault(word, 0) + 1);
            }
        }

    // Write the words and their counts to the output file
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(ficheiro + ".out"))) {
            for (Map.Entry<String, Integer> entry : words.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }

        }
        return words;
    }

}




