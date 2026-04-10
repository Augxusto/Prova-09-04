package rdg.gerenciador_produtos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import rdg.gerenciador_produtos.enums.StatusProduto;

@Entity
@Getter
@Setter
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private StatusProduto status;

    public ProdutoModel() {
    }
}
