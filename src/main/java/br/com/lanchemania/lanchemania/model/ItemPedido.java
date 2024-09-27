package br.com.lanchemania.lanchemania.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "tb_item_pedido")
@SQLRestriction("ativo = true")
@SQLDelete(sql = "UPDATE tb_item_pedido SET ativo = false WHERE id = ?")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedido extends ModeloGenerico {

    @Id
    @SequenceGenerator(name = "item_pedido_sequence", sequenceName = "item_pedido_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "item_pedido_sequence")
    private Long id;

    @Column(name = "observacao", columnDefinition = "TEXT")
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false, foreignKey = @ForeignKey(name = "fk_item_pedido_pedido"))
    private Pedido pedido;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "subtotal", nullable = false)
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "cardapio_id", nullable = false, foreignKey = @ForeignKey(name = "fk_item_pedido_cardapio"))
    private Cardapio cardapio;
}
