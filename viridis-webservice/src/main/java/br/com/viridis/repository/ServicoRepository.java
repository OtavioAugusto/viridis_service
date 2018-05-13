package br.com.viridis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.cdi.Eager;

import br.com.viridis.entity.Servico;

@Eager
public interface ServicoRepository extends JpaRepository<Servico, Long>{

}
