package com.roberto.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_Pagamento_Cartao", schema = "App")
public class PagamentoCartao extends Pagamento{

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "seq_id_pgto_cartao")
    @SequenceGenerator(name = "seq_id_pgto_cartao", sequenceName = "Seq_Id_Pagamento_Cartao" , schema = "App" , initialValue = 10)
    @Column(name = "pedido_id")
    private Integer id;

    @Column(name = "Nu_Cartao")
    private String numeroCartao;
}
