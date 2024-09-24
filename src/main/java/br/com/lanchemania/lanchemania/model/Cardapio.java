package br.com.lanchemania.lanchemania.model;

import br.com.lanchemania.lanchemania.util.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "tb_cardapio")
@SQLDelete(sql = "UPDATE tb_cardapio SET ativo = true WHERE id = ?")
@SQLRestriction("ativo = true")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cardapio extends ModeloGenerico{

    @Id
    @SequenceGenerator(name = "cardapio_sequence", sequenceName = "cardapio_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "cardapio_sequence")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "imagem", nullable = false, columnDefinition = "TEXT")
    private String imagem;

    @Column(name = "categoria", nullable = false)
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column(name = "preco", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double preco;

}
