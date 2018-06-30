package br.ufms.compras.repository;

import br.ufms.compras.entity.Categoria;
import br.ufms.compras.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
