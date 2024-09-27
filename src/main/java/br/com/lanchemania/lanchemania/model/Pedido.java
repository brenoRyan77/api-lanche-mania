package br.com.lanchemania.lanchemania.model;

import br.com.lanchemania.lanchemania.util.enumerate.StatusPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_pedido")
@SQLDelete(sql = "UPDATE tb_pedido SET ativo = false WHERE id = ?")
@SQLRestriction("ativo = true")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido extends ModeloGenerico {

    @Id
    @SequenceGenerator(name = "pedido_sequence", sequenceName = "pedido_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pedido_sequence")
    private Long id;

    @Column(name = "numero_pedido", nullable = false, unique = true)
    private Long numeroPedido;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false, foreignKey = @ForeignKey(name = "fk_pedido_cliente"))
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> itens = new ArrayList<>();

    @Column(name = "total", nullable = false)
    private Double total;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusPedido status;

    @PrePersist
    private void prePersist(){
        this.status = StatusPedido.RECEBIDO;
    }
}
