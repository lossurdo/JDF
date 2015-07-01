package com.jdf.database.ed;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="turma")
public class TurmaED implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String nome;

	@ManyToMany(mappedBy="listaTurmas", fetch=FetchType.EAGER)
	private Collection<AlunoED> listaAlunos;
	
	public TurmaED() {
		// TODO Auto-generated constructor stub
	}

	public TurmaED(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
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
		TurmaED other = (TurmaED) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void setListaAlunos(Collection<AlunoED> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}

	public Collection<AlunoED> getListaAlunos() {
		return listaAlunos;
	}

	@Override
	public String toString() {
		return getNome();
	}

}