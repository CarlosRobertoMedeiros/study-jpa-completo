package com.roberto.exemplo.junit;

import org.junit.*;

public class EntendoJUnitTest {

    @BeforeClass
    public static void iniciarTestes(){
        System.out.println("Método CallBack Inicial = > iniciarTestes");

    }

    @AfterClass
    public static void encerrarTestes(){
        System.out.printf("Método CallBack Encerrando os testes => encerrarTestes" );
    }

    @Before
    public void iniciarTeste(){
        System.out.printf("Método CallBack Executando o iniciarTeste");
    }

    @After
    public void EncerrarTeste(){
        System.out.printf("Método CallBack Executando o EncerrarTeste");
    }

    @Test
    public void testandoAlgo(){
        System.out.println(" executando o testandoAlgo !");

    }

    @Test
    public void testandoOutaFuncao(){
        System.out.println(" executando o testandoOutaFuncao !");
    }

    @Test
    public void testandoAssercoes(){
        String nome = String.format("%s","Carlos Roberto");
        Assert.assertEquals("Carlos Roberto",nome);
    }

    @Test
    public void testandoStringVazia(){
        String str = String.format("%s","");
        Assert.assertTrue(str.isEmpty());
    }
}
