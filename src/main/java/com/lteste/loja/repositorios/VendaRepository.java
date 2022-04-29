package com.lteste.loja.repositorios;

import com.lteste.loja.entidades.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda,Long> {
}
