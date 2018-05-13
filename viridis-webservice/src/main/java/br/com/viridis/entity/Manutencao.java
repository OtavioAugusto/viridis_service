package br.com.viridis.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "manutencao")
@ToString(of = "idManutencao")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Manutencao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_manutencao")
	private Long idManutencao;
	
	@ManyToOne
	@JoinColumn(name = "id_equipamento_fk", referencedColumnName = "id_equipamento")
	private Equipamento equipamento;
	
	@ManyToOne
	@JoinColumn(name = "id_servico_fk", referencedColumnName = "id_servico")
	private Servico servico;
	
	@Column(name="data_manutencao")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataManutencao;
	
}
