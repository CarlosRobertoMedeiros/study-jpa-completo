package com.roberto.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_Categoria" , schema = "App",
        uniqueConstraints = {@UniqueConstraint(name = "unq_name", columnNames = "nome")}
)
public class Categoria {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "seq_id_categoria")
    @SequenceGenerator(name = "seq_id_categoria", sequenceName = "Seq_Id_Categoria" , schema = "App" , initialValue = 10)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "categoria_pai_id")
    private Categoria categoriaPai;

    @OneToMany(mappedBy = "categoriaPai")
    private List<Categoria> categorias;

    @ManyToMany(mappedBy = "categorias")
    private List<Produto> produtos;
}
