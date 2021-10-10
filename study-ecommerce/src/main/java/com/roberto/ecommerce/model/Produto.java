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
@EntityListeners({GenericoListener.class})
@Entity
@Table(name = "Tb_Produto", schema = "App",
    uniqueConstraints = {@UniqueConstraint(name = "uk_produto_name", columnNames = "nome")},
    indexes = {@Index(name = "idx_nome", columnList = "nome")}
)
public class Produto {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "Seq_Id_Produto" , schema = "App" , initialValue = 10)
    private Integer id;

    @Column(name = "data_criacao" , updatable = false, nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_ultima_atualizacao", insertable = false)
    private LocalDateTime dataUltimaAtualizacao;

    @Column(length = 100, nullable = false) //padrão sem color column nome varchar(255)
    private String nome;

    @Column(columnDefinition = "varchar2(275)")
    private String descricao;

    @Column(precision = 19, scale = 2) //Ou seja preço decimal(19,2)
    private BigDecimal preco;

    @ManyToMany
    @JoinTable(name = "TB_Produto_Categoria",
            joinColumns = @JoinColumn(name = "produto_id" ),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias;

    @OneToOne(mappedBy = "produto")
    private Estoque estoque;

    @ElementCollection
    @CollectionTable(name = "TB_Produto_Tag", joinColumns = @JoinColumn(name = "produto_id"))
    @Column(name = "tag",length = 50, nullable = false)
    private List<String> tags;

    @ElementCollection
    @CollectionTable(name = "TB_Produto_Atributo", joinColumns = @JoinColumn(name = "produto_id"))
    private List<Atributo> atributos;


    @Lob
    private byte[] fotoProduto;

}
