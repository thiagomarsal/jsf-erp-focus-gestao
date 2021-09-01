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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Thiago M. Farias
 * 
 */

@Entity
public class Pais implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long idPais;
	@Column(unique=true, length = 3)
	private String ddi;
	@Column(unique=true, length = 4)
	private String sigla;
	@Column(unique=true, nullable = false, length = 30)
	private String nome;

	/**
	 * Constructor of the class
	 */
	public Pais() {
		super();
	}

	/**
	 * @return the idPais
	 */
	public Long getIdPais() {
		return idPais;
	}

	/**
	 * @param idPais
	 *            the idPais to set
	 */
	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}

	/**
	 * @return the ddi
	 */
	public String getDdi() {
		return ddi;
	}

	/**
	 * @param ddi
	 *            the ddi to set
	 */
	public void setDdi(String ddi) {
		this.ddi = ddi;
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
}
