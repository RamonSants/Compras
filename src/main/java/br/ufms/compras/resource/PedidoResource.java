package br.ufms.compras.resource;

import br.ufms.compras.entity.Categoria;
import br.ufms.compras.entity.Pedido;
import br.ufms.compras.service.CategoriaService;
import br.ufms.compras.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pedidos")
@CrossOrigin("http://localhost:8080")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> buscarPedido(@PathVariable("id") Long id){
        Pedido pedido = pedidoService.buscarPedidoPorId(id);
        return ResponseEntity.ok().body(pedido);
    }
}
