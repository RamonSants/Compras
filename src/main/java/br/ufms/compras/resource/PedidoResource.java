package br.ufms.compras.resource;

import br.ufms.compras.entity.Categoria;
import br.ufms.compras.entity.Pedido;
import br.ufms.compras.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categoria")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> testandoRest(@PathVariable("id") Long id){

        Pedido pedido = pedidoService.buscarPedidoPorId(id);

        return ResponseEntity.ok().body(pedido);
    }
}
