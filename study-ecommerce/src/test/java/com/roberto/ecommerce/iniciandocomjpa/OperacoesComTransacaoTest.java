package com.roberto.ecommerce.iniciandocomjpa;

import com.roberto.ecommerce.EntityManagerTest;
import com.roberto.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperacoesComTransacaoTest extends EntityManagerTest {

    /*@Test
    public void impedirOperacaoComBancodeDados(){
        Produto produto = entityManager.find(Produto.class,1);

        entityManager.detach(produto);//Desatachou o Entity Manager

        entityManager.getTransaction().begin();
        produto.setNome("Kindle Paperwhite 2a Geração");
        entityManager.getTransaction().commit();

        entityManager.clear();//Preciso do código para limpar a memória que foi validado, e assim pedir ao entity manager para buscar novamente na base

        Produto produtoVerificacao = entityManager.find(Produto.class,produto.getId());
        Assert.assertEquals("Kindle",produtoVerificacao.getNome());
    }*/

    @Test
    public void mostrarDiferencaPersistMerge(){
        Produto produtoPersist = new Produto();

        produtoPersist.setId(5);
        produtoPersist.setNome("Smart Phone One Plus");
        produtoPersist.setDescricao("O Processador Mais Rápido");
        produtoPersist.setPreco(new BigDecimal(2000));

        entityManager.getTransaction().begin();
        entityManager.persist(produtoPersist);
        produtoPersist.setNome("Smartphone Two Plus"); //Aqui vai forçar o Update pois o código ficou na memória

        //entityManager.flush(); //Força para jogar a informação para o banco de dados

        entityManager.getTransaction().commit();

        entityManager.clear();//Preciso do código para limpar a memória que foi validado, e assim pedir ao entity manager para buscar novamente na base

        Produto produtoVerificacaoPersist = entityManager.find(Produto.class,produtoPersist.getId());
        Assert.assertNotNull(produtoVerificacaoPersist);



        Produto produtoMerge = new Produto();

        produtoMerge.setId(6);
        produtoMerge.setNome("Notebook Dell");
        produtoMerge.setDescricao("O melhor da Categoria");
        produtoMerge.setPreco(new BigDecimal(2000));

        entityManager.getTransaction().begin();
        produtoMerge =  entityManager.merge(produtoMerge); //Preciso daqui
        produtoMerge.setNome("Notebook Dell 2"); //Aqui vai forçar o Update pois o código ficou na memória

        //entityManager.flush(); //Força para jogar a informação para o banco de dados

        entityManager.getTransaction().commit();

        entityManager.clear();//Preciso do código para limpar a memória que foi validado, e assim pedir ao entity manager para buscar novamente na base

        Produto produtoVerificacaoMerge = entityManager.find(Produto.class,produtoMerge.getId());
        Assert.assertNotNull(produtoVerificacaoMerge);



    }


    @Test
    public void inserirObjetoComMerge(){
        Produto produto = new Produto();

        produto.setId(4);
        produto.setNome("Microfone Rode Videmic");
        produto.setDescricao("A melhor qualidade de som");
        produto.setPreco(new BigDecimal(1000));

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        //entityManager.flush(); //Força para jogar a informação para o banco de dados

        entityManager.getTransaction().commit();

        entityManager.clear();//Preciso do código para limpar a memória que foi validado, e assim pedir ao entity manager para buscar novamente na base

        Produto produtoVerificacao = entityManager.find(Produto.class,produto.getId());
        Assert.assertNotNull(produtoVerificacao);
    }


    @Test
    public void atualizarObjetoGerenciado(){
        Produto produto = entityManager.find(Produto.class,1);

        entityManager.getTransaction().begin();
        produto.setNome("Kindle Paperwhite 2a Geração");
        entityManager.getTransaction().commit();

        entityManager.clear();//Preciso do código para limpar a memória que foi validado, e assim pedir ao entity manager para buscar novamente na base

        Produto produtoVerificacao = entityManager.find(Produto.class,produto.getId());
        Assert.assertEquals("Kindle Paperwhite 2a Geração",produtoVerificacao.getNome());
    }

    @Test
    public void atualizarObjeto(){
        Produto produto = new Produto();

        produto.setId(1);
        produto.setNome("Kindle Paperwhite");
        produto.setDescricao("Conheça o novo Kindle");
        produto.setPreco(new BigDecimal(599));


        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();//Preciso do código para limpar a memória que foi validado, e assim pedir ao entity manager para buscar novamente na base

        Produto produtoVerificacao = entityManager.find(Produto.class,1);
        Assert.assertEquals("Kindle Paperwhite",produtoVerificacao.getNome());
    }


    @Test
    public void removerObjeto(){
        Produto produto = entityManager.find(Produto.class,3);

        entityManager.getTransaction().begin();
        entityManager.remove(produto);
        entityManager.getTransaction().commit();

        entityManager.clear(); //Não é necessário na asserção para operação de remoção pois já está fora da memória

        Produto produtoVerificacao = entityManager.find(Produto.class,3);
        Assert.assertNull(produtoVerificacao);
    }

    @Test
    public void inserirPrimeiroObjeto(){
        Produto produto = new Produto();

        produto.setId(2);
        produto.setNome("Câmera Canon");
        produto.setDescricao("A melhor definição para suas fotos");
        produto.setPreco(new BigDecimal(5000));

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        //entityManager.flush(); //Força para jogar a informação para o banco de dados

        entityManager.getTransaction().commit();

        entityManager.clear();//Preciso do código para limpar a memória que foi validado, e assim pedir ao entity manager para buscar novamente na base

        Produto produtoVerificacao = entityManager.find(Produto.class,produto.getId());
        Assert.assertNotNull(produtoVerificacao);
    }


    @Test
    public void abrirEFecharATransacao(){
        Produto produto = new Produto(); //Somente para não mostrar erros
        entityManager.getTransaction().begin();

        //entityManager.persist(produto);
        //entityManager.merge(produto);
        //entityManager.remove(produto);


        entityManager.getTransaction().commit();


    }

}
