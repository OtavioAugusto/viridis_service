package br.com.viridis.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "equipamento")
@ToString(of = "idEquipamento")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Equipamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_equipamento")
	private Long idEquipamento;
	
	@Column(name="nome_equipamento")
	private String nomeEquipamento;
	
	@Column(name="num_serie")
	private String numSerie;
	
	@Column(name="descricao")
	private String descricao;
	
	@OneToMany(mappedBy = "equipamento", fetch=FetchType.EAGER)
	@JsonBackReference
	private Collection<Manutencao> manutencoes;
}
