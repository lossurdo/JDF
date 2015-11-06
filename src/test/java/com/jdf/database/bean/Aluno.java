package com.jdf.database.bean;

import com.jdf.swing.helper.jtable.ColumnMetadataAlign;
import com.jdf.swing.helper.jtable.ColumnMetadataFormat;
import com.jdf.swing.helper.jtable.JTableColumnMetadata;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

public class Aluno implements Serializable {

	@JTableColumnMetadata(name="ID", size=35, align=ColumnMetadataAlign.CENTER)
	private Integer id;
	
	@JTableColumnMetadata(name="Nome do Aluno")
	private String nome;
	
	private Collection<Turma> listaTurmas;
	
	@JTableColumnMetadata(name = "Salário", size = 80, format = ColumnMetadataFormat.CURRENCY, align=ColumnMetadataAlign.RIGHT)
	private Double salario;

	@JTableColumnMetadata(name = "Dt.Nasc.", size = 120, format = ColumnMetadataFormat.DATE_MM_YYYY, align=ColumnMetadataAlign.CENTER)
	private Date dtNascimento;

	public Aluno() {
		
	}

	public Aluno(Integer id) {
		super();
		this.id = id;
	}

	public Aluno(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Aluno(Integer id, String nome, Double salario) {
		super();
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}

	public Aluno(Integer id, String nome, Double salario, Date dtNascimento) {
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
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void setListaTurmas(Collection<Turma> listaTurmas) {
		this.listaTurmas = listaTurmas;
	}

	public Collection<Turma> getListaTurmas() {
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
