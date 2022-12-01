package org.example;

import org.example.Analista;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

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


}