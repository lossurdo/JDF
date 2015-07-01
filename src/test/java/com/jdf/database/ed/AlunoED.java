package com.jdf.database.ed;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.jdf.swing.helper.jtable.ColumnMetadataAlign;
import com.jdf.swing.helper.jtable.ColumnMetadataFormat;
import com.jdf.swing.helper.jtable.JTableColumnMetadata;

@Entity
@Table(name="aluno")
public class AlunoED implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JTableColumnMetadata(name="ID", size=35, align=ColumnMetadataAlign.CENTER)
	private Integer id;
	
	@JTableColumnMetadata(name="Nome do Aluno")
	private String nome;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="aluno_turma",
			joinColumns=@JoinColumn(name="aluno_id"),
			inverseJoinColumns=@JoinColumn(name="turma_id"))
	private Collection<TurmaED> listaTurmas;
	
	@Transient
	@JTableColumnMetadata(name = "Salário", size = 80, format = ColumnMetadataFormat.CURRENCY, align=ColumnMetadataAlign.RIGHT)
	private Double salario;

	@Transient
	@JTableColumnMetadata(name = "Dt.Nasc.", size = 120, format = ColumnMetadataFormat.DATE_MM_YYYY, align=ColumnMetadataAlign.CENTER)
	private Date dtNascimento;

	public AlunoED() {
		
	}

	public AlunoED(Integer id) {
		super();
		this.id = id;
	}

	public AlunoED(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public AlunoED(Integer id, String nome, Double salario) {
		super();
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}

	public AlunoED(Integer id, String nome, Double salario, Date dtNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.salario = salario;
		this.dtNascimento = dtNascimento;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlunoED other = (AlunoED) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void setListaTurmas(Collection<TurmaED> listaTurmas) {
		this.listaTurmas = listaTurmas;
	}

	public Collection<TurmaED> getListaTurmas() {
		return listaTurmas;
	}

	@Override
	public String toString() {
		return getNome();
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Double getSalario() {
		return salario;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}
		
}
