package br.ufms.compras.resource;

import br.ufms.compras.entity.Categoria;
import br.ufms.compras.exception.StandartError;
import br.ufms.compras.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> testandoRest(@PathVariable("id") Long id){

        Categoria categoria = categoriaService.buscarCategoriaPorId(id);

        return ResponseEntity.ok().body(categoria);
    }
}
