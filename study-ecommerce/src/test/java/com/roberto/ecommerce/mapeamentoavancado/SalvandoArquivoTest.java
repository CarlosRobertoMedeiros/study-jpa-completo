package com.roberto.ecommerce.mapeamentoavancado;

import com.roberto.ecommerce.EntityManagerTest;
import com.roberto.ecommerce.model.NotaFiscal;
import com.roberto.ecommerce.model.Pedido;
import com.roberto.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

public class SalvandoArquivoTest extends EntityManagerTest {

    @Test
    public void salvarFotoArquivo() {
        Produto produto = entityManager.find(Produto.class, 1);

        entityManager.getTransaction().begin();
        produto.setFotoProduto(carregarFoto());
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, 1);
        Assert.assertNotNull(produtoVerificacao.getFotoProduto());
        Assert.assertTrue(produtoVerificacao.getFotoProduto().length > 0);

    }



    @Test
    public void salvarXmlNota() {

        Pedido pedido = entityManager.find(Pedido.class, 1);

        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setPedido(pedido);
        notaFiscal.setDataEmissao(new Date());
        notaFiscal.setXml(carregarNotaFiscal());

        entityManager.getTransaction().begin();
        entityManager.persist(notaFiscal);
        entityManager.getTransaction().commit();

        entityManager.clear();

        NotaFiscal notaFiscalVerificacao = entityManager.find(NotaFiscal.class, notaFiscal.getId());
        Assert.assertNotNull(notaFiscalVerificacao.getXml());
        Assert.assertTrue(notaFiscalVerificacao.getXml().length > 0);

        /**
         * Código que salva arquivo

        try {

            OutputStream outputStream = new FileOutputStream(
                    Files.createFile(Paths.get(
                            System.getProperty("user.home") + "/xml.xml")).toFile());
            outputStream.write(notaFiscal.getXml());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
         */

    }

    private byte[] carregarFoto() {
        return carregarArquivo("/kindle.jpg");
    }

    private static byte[] carregarNotaFiscal() {
        return carregarArquivo("/nota-fiscal.xml");
    }

    private static byte[] carregarArquivo(String nome) {
        try {
            return SalvandoArquivoTest.class.getResourceAsStream(nome).readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
