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


/*
 * Declara que é havera uma entidade no BD. para persistencia.
 */
@Entity
public class Servico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idServico;
	@Column(nullable = true, length = 100)
	private String descricao;
	@Column(nullable = true, length = 100)
	private String obs;
	@Column(nullable = true, length = 10)
	private Double preco;

	public Servico() {
		super();
	}

	/**
	 * @return the idServico
	 */
	public Long getIdServico() {
		return idServico;
	}

	/**
	 * @param idServico
	 *            the idServico to set
	 */
	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the obs
	 */
	public String getObs() {
		return obs;
	}

	/**
	 * @param obs
	 *            the obs to set
	 */
	public void setObs(String obs) {
		this.obs = obs;
	}

	/**
	 * @return the preco
	 */
	public Double getPreco() {
		return preco;
	}

	/**
	 * @param preco
	 *            the preco to set
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idServico == null) ? 0 : idServico.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servico other = (Servico) obj;
		if (idServico == null) {
			if (other.idServico != null)
				return false;
		} else if (!idServico.equals(other.idServico))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Servico clone() throws CloneNotSupportedException {
		Servico s = new Servico();
		s.setIdServico(new Long(this.idServico.longValue()));
		s.setDescricao(this.descricao);
		s.setPreco(new Double(this.preco == null ? 0 : this.preco.floatValue()));
		s.setObs(this.obs);
		return s;
	}

}
