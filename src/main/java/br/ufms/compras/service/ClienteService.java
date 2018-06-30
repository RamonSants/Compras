package br.ufms.compras.service;

import br.ufms.compras.entity.Categoria;
import br.ufms.compras.entity.Cliente;
import br.ufms.compras.exception.ObjectNotFoundException;
import br.ufms.compras.repository.CategoriaRepository;
import br.ufms.compras.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscarClientePorId(Long id){

        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente == null){
            throw new ObjectNotFoundException("Objeto não encontrado, Id: " + id
                    + " classe: " + Cliente.class.getName());
        }
        return cliente.orElse(null); //ver com o higor essa bosta depois
        //return categoriaRepository.findOne(id);
    }

    public List<Cliente> buscarClientes() {

        return clienteRepository.findAll();
    }
}
