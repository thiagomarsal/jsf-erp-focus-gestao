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
import javax.persistence.ManyToOne;

/**
 * @author Thiago M. Farias
 * 
 */

/*
 * Declara que é havera uma entidade no BD. para persistencia.
 */
@Entity
public class ServicosSelecionados implements Serializable {
		
		/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long idServicosSelecionados;
	@Column(nullable = true, length = 70)
	private String descricao;
	@Column(nullable = true)
	private Double preco;
	@ManyToOne
	private Servico servico;
	/**
	 * @return the idServicosSelecionados
	 */
	public Long getIdServicosSelecionados() {
		return idServicosSelecionados;
	}
	/**
	 * @param idServicosSelecionados the idServicosSelecionados to set
	 */
	public void setIdServicosSelecionados(Long idServicosSelecionados) {
		this.idServicosSelecionados = idServicosSelecionados;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * @return the preco
	 */
	public Double getPreco() {
		return preco;
	}
	/**
	 * @param preco the preco to set
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	/**
	 * @return the servico
	 */
	public Servico getServico() {
		return servico;
	}
	/**
	 * @param servico the servico to set
	 */
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((idServicosSelecionados == null) ? 0
						: idServicosSelecionados.hashCode());
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
		ServicosSelecionados other = (ServicosSelecionados) obj;
		if (idServicosSelecionados == null) {
			if (other.idServicosSelecionados != null)
				return false;
		} else if (!idServicosSelecionados.equals(other.idServicosSelecionados))
			return false;
		return true;
	}


}
