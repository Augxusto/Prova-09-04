package rdg.gerenciador_produtos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rdg.gerenciador_produtos.models.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}
