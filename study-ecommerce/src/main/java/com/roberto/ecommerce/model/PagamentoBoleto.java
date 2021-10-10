package com.roberto.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_Pagamento_Boleto", schema = "App")
public class PagamentoBoleto extends Pagamento{

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "seq_id_pgto_boleto")
    @SequenceGenerator(name = "seq_id_pgto_boleto", sequenceName = "Seq_Id_Pagamento_Boleto" , schema = "App" , initialValue = 10)
    private Long id;

    @Column(name = "codigo_barras",length = 100,nullable = false)
    private String codigoBarras;
}
