package br.ufms.compras.resource;

import br.ufms.compras.entity.Categoria;
import br.ufms.compras.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
@CrossOrigin("http://localhost:8080")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> buscarCategoria(@PathVariable("id") Long id){ //get
        Categoria categoria = categoriaService.buscarCategoriaPorId(id);
        return ResponseEntity.ok().body(categoria);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> buscarCategorias(){ // get all
        List<Categoria> categorias = categoriaService.buscarCategorias();
        return ResponseEntity.ok().body(categorias);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/salvar")
    public ResponseEntity<?> salvar(@RequestBody Categoria categoria) {
        Categoria novaCategoria = categoriaService.salvar(categoria);
        return ResponseEntity.ok().body(novaCategoria);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
        Categoria categoria = categoriaService.buscarCategoriaPorId(id);

        categoriaService.deletar(categoria);
        return ResponseEntity.ok().body(categoria);
    }
}
