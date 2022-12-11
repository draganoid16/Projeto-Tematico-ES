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
        int[] testeArray = {11,3,3,0,0,0};
        var analista = new Analista("hehe.txt");
        assertArrayEquals(testeArray, analista.quantasOcorrencias(c));
    }

    @Test
    void assertArrayTemValorEsperadoEmTodasAsPosicoes(){
        char c = 'e';
        int[] testeArray = {0,1,2,3,4,5};
        var analista = new Analista("testearraytodasasposicoes.txt");
        assertArrayEquals(testeArray, analista.quantasOcorrencias(c));
    }

    @Test
    void assertArrayNaoTemLetra(){
        char c = 'e';
        int[] testeArray = {2,0,0,0,0,0};
        var analista = new Analista("testearraysemletra.txt");
        assertArrayEquals(testeArray, analista.quantasOcorrencias(c));
    }

    //testes para ListaPalavras
    @Test
    void assertPalavrasQueComecamComE() throws IOException {
        Map<String, Integer> words = new HashMap<>();
        words.put("existe", 2);
        var analista = new Analista("hehe.txt");

        assertEquals(words, analista.listaPalavras('e', "testelistapalavras.out") );

    }
    @Test
    void assertPalavrasQueComecamComLetraQueGuardaNada() throws IOException {
        Map<String, Integer> words = new HashMap<>();
        var analista = new Analista("hehe.txt");

        assertEquals(words, analista.listaPalavras('u', "testelistapalavras.out") );

    }
    @Test
    void assertPalavrasQueComecamComCaracteresEspeciais() throws IOException {
        Map<String, Integer> words = new HashMap<>();
        var analista = new Analista("casostestelistapalavras.txt");
        words.put("$dollar", 2);
        assertEquals(words, analista.listaPalavras('$', "casostestelistapalavras.txt") );

    }

    @Test
    void assertPalavrasQueComecamComCaracteresUpperCase() throws IOException {
        Map<String, Integer> words = new HashMap<>();
        var analista = new Analista("casostestelistapalavras.txt");
        words.put("Canario", 1);
        assertEquals(words, analista.listaPalavras('C', "casostestelistapalavras.txt") );
    }

    @Test
    void assertPalavrasQueComecamComNumeros() throws IOException {
        Map<String, Integer> words = new HashMap<>();
        var analista = new Analista("casostestelistapalavras.txt");
        words.put("1233", 3);
        assertEquals(words, analista.listaPalavras('1', "casostestelistapalavras.txt") );
    }

}