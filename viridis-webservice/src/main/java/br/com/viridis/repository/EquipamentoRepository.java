package br.com.viridis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.cdi.Eager;

import br.com.viridis.entity.Equipamento;

@Eager
public interface EquipamentoRepository extends JpaRepository<Equipamento, Long>{

}