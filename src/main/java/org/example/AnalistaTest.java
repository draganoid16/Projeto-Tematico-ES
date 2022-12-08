package org.example;

import org.example.Analista;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AnalistaTest {
    //testes para lerFicheiro
    @Test
    void assertFicheiroNaoExistente() {
        var analista = new Analista("ficheiroinexistente.txt");
        assertNull(analista.lerFicheiro("ficheiroinexistente.txt"));
    }

    @Test
    void assertConteudoDoFicheiroSeraNulo() {
        var analista = new Analista("testevazio.txt");
        assertNull(analista.lerFicheiro("testevazio.txt"));
    }

    /*@Test
    void assertFileNotFoundException(){
        var analista = new Analista("ficheiroinexistentesdadsadsadsadsa.txt");
        assertThrows(FileNotFoundException.class,
                () -> {
                analista.lerFicheiro("ficheiroinexistentedsadsasdasda.txt");
                });
    } teste não funciona porque já é apanhado no codigo, resolvido no codigo ao fazer este retornar nulo com os testes em cima
    */

    //testes para quantasOcurrencias
    @Test
    void assertArrayTemValorEsperado(){
        char c = 'e';
        int[] testeArray = {3,3,0,0,0};
        var analista = new Analista("hehe.txt");
        assertArrayEquals(testeArray, analista.quantasOcorrencias(c));
    }

    @Test
    void assertArrayTemValorEsperadoEmTodasAsPosicoes(){
        char c = 'e';
        int[] testeArray = {1,2,3,4,5};
        var analista = new Analista("testearraytodasasposicoes.txt");
        assertArrayEquals(testeArray, analista.quantasOcorrencias(c));
    }

    @Test
    void assertArrayNaoTemLetra(){
        char c = 'e';
        int[] testeArray = {0,0,0,0,0};
        var analista = new Analista("testearraysemletra.txt");
        assertArrayEquals(testeArray, analista.quantasOcorrencias(c));
    }

    //testes para ListaPalavras
    @Test
    void assertWordsStartingWithE() throws IOException {
        Map<String, Integer> words = new HashMap<>();
        words.put("existe", 2);
        var analista = new Analista("hehe.txt");

        assertEquals(words, analista.listaPalavras('e', "testelistapalavras.out") );

    }

    /*
        Test that the method returns a map containing all words that start with the specified character.
        Input: c = 'a', ficheiro = "input.txt"
        Output: words = { "apple": 2, "ant": 1 }
    Test that the method does not return words that do not start with the specified character.
        Input: c = 'b', ficheiro = "input.txt"
        Output: words = { "banana": 1, "blueberry": 2 }
    Test that the method correctly handles special characters in words.
        Input: c = '$', ficheiro = "input.txt"
        Output: words = { "$100": 1, "$$$": 2 }
    Test that the method correctly handles words with uppercase letters.
        Input: c = 'C', ficheiro = "input.txt"
        Output: words = { "Cats": 1, "Carrots": 2 }
    Test that the method correctly handles words with numbers.
        Input: c = '1', ficheiro = "input.txt"
        Output: words = { "123": 1, "1st": 2 }
    Test that the method correctly handles empty files.
        Input: c = 'x', ficheiro = "empty.txt"
        Output: words = { }
     */


}