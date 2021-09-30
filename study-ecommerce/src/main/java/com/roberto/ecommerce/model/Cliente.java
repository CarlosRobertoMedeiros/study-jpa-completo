package com.roberto.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_Cliente" , schema = "App")
public class Cliente {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "seq_id_cliente")
    @SequenceGenerator(name = "seq_id_cliente", sequenceName = "Seq_Id_Cliente" , schema = "App" , initialValue = 10)
    private Integer id;

    private String nome;

    @ElementCollection
    @CollectionTable(name = "TB_Cliente_Contato", joinColumns = @JoinColumn(name = "cliente_id"))
    @MapKeyColumn(name = "tipo")
    @Column(name = "descricao")
    private Map<String, String> contatos;

    @Transient
    private String primeiroNome;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

    @PostLoad
    public void configurarPrimeiroNome(){
        if (nome!=null && !nome.isBlank()){
            int index = nome.indexOf(" ");
            if (index > -1){
                primeiroNome = nome.substring(0,index);
            }
        }

    }


}
