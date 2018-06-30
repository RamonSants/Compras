package br.ufms.compras.repository;

import br.ufms.compras.entity.Categoria;
import br.ufms.compras.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
