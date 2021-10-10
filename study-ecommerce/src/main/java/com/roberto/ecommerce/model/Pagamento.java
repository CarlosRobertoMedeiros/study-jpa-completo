package com.roberto.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Tb_Pagamento", schema = "App")
public abstract class Pagamento {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "SQ")
    //@SequenceGenerator(name="SQ", sequenceName="SQ", allocationSize = 1)
    private Long id;

    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @Enumerated(EnumType.STRING)
    @Column(length = 30,nullable = false)
    private StatusPagamento status;



}
