package br.ufms.compras.service;

import br.ufms.compras.entity.Cliente;
import br.ufms.compras.entity.Pedido;
import br.ufms.compras.exception.ObjectNotFoundException;
import br.ufms.compras.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido buscarPedidoPorId(Long id){

        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if(pedido == null){
            throw new ObjectNotFoundException("Objeto não encontrado, Id: " + id
                    + " classe: " + Pedido.class.getName());
        }
        return pedido.orElse(null); //ver com o higor essa bosta depois
        //return categoriaRepository.findOne(id);
    }

    public List<Pedido> buscarPedidos() {

        return pedidoRepository.findAll();
    }
}
