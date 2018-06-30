package br.ufms.compras.resource;

import br.ufms.compras.entity.Cliente;
import br.ufms.compras.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clientes")
@CrossOrigin("http://localhost:8080")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> buscarCliente(@PathVariable("id") Long id){
        Cliente cliente = clienteService.buscarClientePorId(id);
        return ResponseEntity.ok().body(cliente);
    }
}
