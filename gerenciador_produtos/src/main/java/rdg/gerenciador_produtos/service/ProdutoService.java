package rdg.gerenciador_produtos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rdg.gerenciador_produtos.models.ProdutoModel;
import rdg.gerenciador_produtos.repositories.ProdutoRepository;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoModel criarProduto(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

    public List<ProdutoModel> BuscarTodos() {
        return produtoRepository.findAll();
    }

    public ProdutoModel BuscarPorId(Long id) {
        return produtoRepository.findById(id).get();
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

    public ProdutoModel atualizar(Long id, ProdutoModel produtoModel) {
        ProdutoModel newProduto = produtoRepository.findById(id).get();
        newProduto.setNome(produtoModel.getNome());
        newProduto.setDescricao(produtoModel.getDescricao());
        newProduto.setPreco(produtoModel.getPreco());
        newProduto.setStatus(produtoModel.getStatus());
        return produtoRepository.save(newProduto);
    }
}
