package com.roberto.ecommerce.model;

import com.roberto.ecommerce.listener.GenericoListener;
import com.roberto.ecommerce.listener.GerarNotaFiscalListener;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@EntityListeners({GerarNotaFiscalListener.class , GenericoListener.class})
@Entity
@Table(name = "TB_Pedido", schema = "App")
@SequenceGenerator(name = "seq_id_pedido", sequenceName = "Seq_Id_Pedido", schema = "App" , initialValue = 10)
public class Pedido {

	@EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_pedido")
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itemPedidos;

    @Column(name = "data_criacao" , updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_ultima_atualizacao", insertable = false )
    private LocalDateTime dataUltimaAtualizacao;

    @Column(name = "data_conclusao")
    private LocalDateTime dataConclusao;

    @OneToOne(mappedBy = "pedido")
    private NotaFiscal notaFiscal;

    private BigDecimal total;

    @OneToOne(mappedBy = "pedido")
    private PagamentoCartao pagamentoCartao;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @Embedded
    private EnderecoEntregaPedido enderecoEntrega;

    public boolean isPago(){
        return StatusPedido.PAGO.equals(status);
    }

//    @PrePersist
//    @PreUpdate
    public void calcularTotal(){

        if (itemPedidos!=null){
            total = itemPedidos.stream()
                    .map(item -> item.getPrecoProduto()) //Trago o preco dos produtos
                    .reduce(BigDecimal.ZERO,BigDecimal::add); //Faço a soma do fluxo
        }

    }

    @PrePersist
    public void aoPersistir() {
        dataCriacao = LocalDateTime.now();
        calcularTotal();
    }

    @PreUpdate
    public void aoAtualizar() {
        dataUltimaAtualizacao = LocalDateTime.now();
        calcularTotal();
    }

    @PostPersist
    public void aposPersistir(){
        System.out.println("Após Persistir Pedido");
    }

    @PostUpdate
    public void aposAtualizar(){
        System.out.println("Após Atualizar Pedido");
    }

    @PreRemove
    public void antesDeRemover(){
        System.out.println("Antes de Remover");
    }

    @PostRemove
    public void depoisDeRemover(){
        System.out.println("Antes de Remover");
    }

    @PostLoad
    public void aoCarregar(){
        System.out.println("Após Carregar o Pedido");
    }

}

