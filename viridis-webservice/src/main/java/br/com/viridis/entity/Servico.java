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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "servico")
@ToString(of = "idServico")
public class Servico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_servico")
	private Long idServico;
	
	@Column(name="nome_servico")
	private String nomeServico;
	
	@OneToMany(mappedBy = "servico", fetch=FetchType.EAGER)
	@JsonBackReference
	private Collection<Manutencao> manutencoes;

}
