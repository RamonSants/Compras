package br.ufms.compras.service;

import br.ufms.compras.entity.Categoria;
import br.ufms.compras.entity.Produto;
import br.ufms.compras.exception.ObjectNotFoundException;
import br.ufms.compras.repository.CategoriaRepository;
import br.ufms.compras.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public Categoria buscarCategoriaPorId(Long id){

        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if(categoria == null){
            throw new ObjectNotFoundException("Objeto não encontrado, Id: " + id
                    + " classe: " + Categoria.class.getName());
        }
        return categoria.orElse(null); //ver com o higor essa bosta depois
        //return categoriaRepository.findOne(id);
    }

    public List<Categoria> buscarCategorias(){

        return categoriaRepository.findAll();
        //return categoriaRepository.findOne(id);
    }

    public Categoria salvar(Categoria categoria) {
        Categoria categoriaSalva = categoriaRepository.save(categoria);

        List<Produto> produtos = categoria.getProdutos();
        produtos.forEach(produto -> produto.getCategorias().add(categoriaSalva));

        produtoRepository.saveAll(categoria.getProdutos());
        return categoriaSalva;
    }

    public void deletar(Categoria categoria) {

        List<Produto> produtos = categoria.getProdutos();
        produtos.forEach(produto -> produtoRepository.delete(produto));
        categoriaRepository.delete(categoria);
    }
}
