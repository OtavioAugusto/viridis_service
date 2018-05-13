package br.com.viridis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.cdi.Eager;

import br.com.viridis.entity.Manutencao;

@Eager
public interface ManutencaoRepository extends JpaRepository<Manutencao, Long>{

}
