/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * @author Thiago M. Farias
 * 
 */

@Entity
public class Estado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long idEstado;
	@Column(length = 3)
	private String sigla;
	@Column(nullable = false, length = 30)
	private String nome;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idPais")
	@Fetch(FetchMode.JOIN)
	private Pais pais;

	/**
	 * Constructor of the class
	 */
	public Estado() {
		super();
	}
	
	/**
	 * @param pais
	 */
	public Estado(Pais pais) {
		this.pais = pais;
	}

	/**
	 * @return the idEstado
	 */
	public Long getIdEstado() {
		return idEstado;
	}

	/**
	 * @param idEstado
	 *            the idEstado to set
	 */
	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	/**
	 * @return the sigla
	 */
	public String getSigla() {
		return sigla;
	}

	/**
	 * @param sigla
	 *            the sigla to set
	 */
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the pais
	 */
	public Pais getPais() {
		return pais;
	}

	/**
	 * @param pais
	 *            the pais to set
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
	}

}
