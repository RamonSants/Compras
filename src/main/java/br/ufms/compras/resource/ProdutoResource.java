package br.ufms.compras.resource;

import br.ufms.compras.entity.Produto;
import br.ufms.compras.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
@CrossOrigin("http://localhost:8080")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        List<Produto> produtos = produtoService.getProdutos();
        return ResponseEntity.ok().body(produtos);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
        Produto p = produtoService.getProduto(id);

        produtoService.deletar(p);
        return ResponseEntity.ok().body(p);
    }
}
