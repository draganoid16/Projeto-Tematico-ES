package org.example;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


public class Analista {
    String nomeficheiro;
    int palavrascomLetra[];

    public Analista(String nomeficheiro) {
        this.nomeficheiro = nomeficheiro;
        this.palavrascomLetra = new int[5]; //alocar memoria a um array de 5
    }

    public void quantasOcorrencias(char c){
        try {
            String content = new Scanner(new File(nomeficheiro)).useDelimiter("\\Z").next();
            System.out.println(content);
            if (content == null || content.isEmpty()) {
                System.exit(0);
            }

            String[] words = content.split("\\s+");
            System.out.println(words.length + " palavras.");

            //percorre array
            for (int i=0; i< words.length;i++) {
                int count = (int) words[i].chars().filter(ch -> ch == c).count();
                System.out.println(count);
                switch(count){
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
                }
            }
            System.out.println("\nteste guardar");
            System.out.println(palavrascomLetra[0]);
            System.out.println(palavrascomLetra[1]);
            System.out.println(palavrascomLetra[2]);
            System.out.println(palavrascomLetra[3]);
            System.out.println(palavrascomLetra[4]);
        }
        catch(FileNotFoundException e){
            System.out.println("Ficheiro não encontrado.");
        }


    }
}
