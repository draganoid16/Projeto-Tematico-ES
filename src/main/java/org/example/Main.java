package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Analista analista = new Analista("C:\\Users\\Joao\\Desktop\\Trabalho Pratico\\hehe.txt");
        analista.quantasOcorrencias('e');

        }
    }
