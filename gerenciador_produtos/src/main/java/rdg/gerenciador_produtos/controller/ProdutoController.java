package rdg.gerenciador_produtos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rdg.gerenciador_produtos.models.ProdutoModel;
import rdg.gerenciador_produtos.service.ProdutoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoModel> criarProduto(@RequestBody ProdutoModel produtoModel) {
        ProdutoModel request = produtoService.criarProduto(produtoModel);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produtoModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> findAll() {
        List<ProdutoModel> request = produtoService.BuscarTodos();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ProdutoModel buscarPorId(@PathVariable Long id) {
        return produtoService.BuscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoModel> atualizar(@PathVariable Long id, @RequestBody ProdutoModel produtoModel) {
        ProdutoModel request = produtoService.atualizar(id, produtoModel);
        return ResponseEntity.ok().body(request);
    }
}
