/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.bean.superClasses;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


/**
 * @author Thiago M. Farias
 * 
 */

@MappedSuperclass
public class Endereco implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(nullable = false, length = 40)
    private String logradouro;
    @Column(nullable = false, length = 10)
    private String numeroPredial;
    @Column(nullable = true, length = 100)
    private String complemento;
    @Column(nullable = false, length = 40)
    private String bairro;
    @Column(nullable = false, length = 10)
    private String cep;
	
    /**
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}
	/**
	 * @param logradouro the logradouro to set
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	/**
	 * @return the numeroPredial
	 */
	public String getNumeroPredial() {
		return numeroPredial;
	}
	/**
	 * @param numeroPredial the numeroPredial to set
	 */
	public void setNumeroPredial(String numeroPredial) {
		this.numeroPredial = numeroPredial;
	}
	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}
	/**
	 * @param complemento the complemento to set
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}
	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}
	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result
				+ ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result
				+ ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result
				+ ((numeroPredial == null) ? 0 : numeroPredial.hashCode());
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
		Endereco other = (Endereco) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (numeroPredial == null) {
			if (other.numeroPredial != null)
				return false;
		} else if (!numeroPredial.equals(other.numeroPredial))
			return false;
		return true;
	}
	
}
