package com.roberto.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@SecondaryTable(name = "TB_Cliente_Detalhe",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "cliente_id"))
@Entity
@Table(name = "TB_Cliente" ,
       schema = "App",
       uniqueConstraints = {@UniqueConstraint(name = "unq_cpf", columnNames = {"cpf"})},
       indexes = {@Index(name = "idx_nome", columnList = "cpf") }
)
public class Cliente extends EntidadeBaseInteger{

    private String nome;

    private String cpf;

    @ElementCollection
    @CollectionTable(name = "TB_Cliente_Contato", joinColumns = @JoinColumn(name = "cliente_id"))
    @MapKeyColumn(name = "tipo")
    @Column(name = "descricao")
    private Map<String, String> contatos;

    @Transient
    private String primeiroNome;

    @Column(table = "TB_Cliente_Detalhe")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(name = "data_nascimento", table = "TB_Cliente_Detalhe")
    private LocalDate dataNascimento;

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
