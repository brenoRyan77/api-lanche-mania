package br.com.lanchemania.lanchemania.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "tb_cliente")
@SQLRestriction("ativo = true")
@SQLDelete(sql = "UPDATE tb_cliente SET ativo = false WHERE id = ?")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends ModeloGenerico{

    @Id
    @SequenceGenerator(name = "cliente_sequence", sequenceName = "cliente_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "cliente_sequence")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Email
    @Column(name = "numero", nullable = false, unique = true, length = 11)
    private String numero;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", nullable = false, foreignKey = @ForeignKey(name = "fk_cliente_endereco"))
    private Endereco endereco;
}
