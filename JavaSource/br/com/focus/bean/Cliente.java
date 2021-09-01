/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.focus.bean.superClasses.Entidade;

/**
 * @author Thiago M. Farias
 * 
 */

/**
 * Declara que é uma SubClasse.
 */
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
/**
 * Declara que é havera uma entidade no BD. para persistencia.
 */
@Entity
public class Cliente extends Entidade implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    @Column(nullable = true, length = 20)
    private String estadoCivil;
    @Column(nullable = true, length = 10)
    private String sexo;
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Column(nullable = true, length = 40)
    private String contato;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCidade")
    @Fetch(FetchMode.JOIN)
    private Cidade cidade;
    
    public Cliente() {
    	super();
    }

    public Cliente(Cidade cidade) {
        this.cidade = cidade;
    }
	/**
	 * @return the idCliente
	 */
	public Long getIdCliente() {
		return idCliente;
	}
	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	/**
	 * @return the estadoCivil
	 */
	public String getEstadoCivil() {
		return estadoCivil;
	}
	/**
	 * @param estadoCivil the estadoCivil to set
	 */
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}
	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}
	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	/**
	 * @return the contato
	 */
	public String getContato() {
		return contato;
	}
	/**
	 * @param contato the contato to set
	 */
	public void setContato(String contato) {
		this.contato = contato;
	}
	/**
	 * @return the cidade
	 */
	public Cidade getCidade() {
		return cidade;
	}
	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((idCliente == null) ? 0 : idCliente.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		return true;
	}
    
    
}
