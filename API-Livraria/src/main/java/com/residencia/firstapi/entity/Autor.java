package com.residencia.firstapi.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

//anotação que diz que é uma entidade
@Entity
//nome da tabela no BD
@Table(name = "autor")
public class Autor {
	// me informa que vai ser uma PK
	@Id
	// como a PK vai ser gerada noBD
	// strategy me informa como vai ser gerada a PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// coluna do BD, tenho que passar o nome q vai aparecer no BD
	@Column(name = "autor_id")
	private Integer autorId;

	@Column(name = "autor_nome")
	private String autorNome;

	@OneToMany(mappedBy = "autor")
	@JsonIgnore
	private List<Livro> livroList;

	public List<Livro> getLivroList() {
		return livroList;
	}

	public void setLivroList(List<Livro> livroList) {
		this.livroList = livroList;
	}

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public String getAutorNome() {
		return autorNome;
	}

	public void setAutorNome(String autorNome) {
		this.autorNome = autorNome;
	}
//	public Autor() {}
//	public Autor(Integer autorId, String autorNome, List<Livro> livroList) {
//		super();
//		this.autorId = autorId;
//		this.autorNome = autorNome;
//		this.livroList = livroList;
//	}

	
}
