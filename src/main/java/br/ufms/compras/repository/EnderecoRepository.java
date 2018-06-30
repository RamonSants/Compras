package br.ufms.compras.repository;

import br.ufms.compras.entity.Categoria;
import br.ufms.compras.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
