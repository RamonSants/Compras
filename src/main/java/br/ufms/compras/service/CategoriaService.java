package br.ufms.compras.service;

import br.ufms.compras.entity.Categoria;
import br.ufms.compras.exception.ObjectNotFoundException;
import br.ufms.compras.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscarCategoriaPorId(Long id){

        Optional<Categoria> categoria = categoriaRepository.findById(id);

        if(categoria == null){
            throw new ObjectNotFoundException("Objeto não encontrado, Id: " + id
                    + " classe: " + Categoria.class.getName());
        }

        return categoria.orElse(null); //ver com o higor essa bosta depois
        //return categoriaRepository.findOne(id);
    }
}
