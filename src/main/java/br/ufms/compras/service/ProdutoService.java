package br.ufms.compras.service;

import br.ufms.compras.entity.Produto;
import br.ufms.compras.exception.ObjectNotFoundException;
import br.ufms.compras.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto getProduto(Long id) {
        Optional<Produto> p = produtoRepository.findById(id);
        return p.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado, Id: " + id
                + " Classe: " + Produto.class.getName()));
    }

    public void deletar(Produto produto) {
        produtoRepository.delete(produto);
    }

    public List<Produto> getProdutos() {
        return produtoRepository.findAll();
    }
}
