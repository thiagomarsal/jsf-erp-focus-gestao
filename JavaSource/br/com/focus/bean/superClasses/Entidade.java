/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.bean.superClasses;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Thiago M. Farias
 * 
 */
@MappedSuperclass
public class Entidade implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//@Column(nullable = false)
	@Temporal(TemporalType.DATE )
    private Date dataCadastro;
	//@Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataAtualizacao;
    @Column(length = 100)
    private String apelidoNomeFantasia;
    @Column(nullable = false, length = 100)
    private String nomeRazaoSocial;
    @Column(length = 15)
    private String cpfCnpj;
    @Column(length = 15)
    private String rgInscricao;
    @Column(length = 15)
    private String telefone;
    @Column(length = 15)
    private String fax;
    @Column(length = 15)
    private String celular;
    @Column(length = 60)
    private String email;
    @Column(length = 60)
    private String site;
    @Column(length = 200)
    private String obs;
    @Embedded
    private Endereco endereco;

    /**
	 * @return the dataCadastro
	 */
	public Date getDataCadastro() {
		return dataCadastro;
	}
	/**
	 * @param dataCadastro the dataCadastro to set
	 */
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	/**
	 * @return the dataAtualizacao
	 */
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	/**
	 * @param dataAtualizacao the dataAtualizacao to set
	 */
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	/**
	 * @return the apelidoNomeFantasia
	 */
	public String getApelidoNomeFantasia() {
		return apelidoNomeFantasia;
	}
	/**
	 * @param apelidoNomeFantasia the apelidoNomeFantasia to set
	 */
	public void setApelidoNomeFantasia(String apelidoNomeFantasia) {
		this.apelidoNomeFantasia = apelidoNomeFantasia;
	}
	/**
	 * @return the nomeRazaoSocial
	 */
	public String getNomeRazaoSocial() {
		return nomeRazaoSocial;
	}
	/**
	 * @param nomeRazaoSocial the nomeRazaoSocial to set
	 */
	public void setNomeRazaoSocial(String nomeRazaoSocial) {
		this.nomeRazaoSocial = nomeRazaoSocial;
	}
	/**
	 * @return the cpfCnpj
	 */
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	/**
	 * @param cpfCnpj the cpfCnpj to set
	 */
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	/**
	 * @return the rgInscricao
	 */
	public String getRgInscricao() {
		return rgInscricao;
	}
	/**
	 * @param rgInscricao the rgInscricao to set
	 */
	public void setRgInscricao(String rgInscricao) {
		this.rgInscricao = rgInscricao;
	}
	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}
	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}
	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}
	/**
	 * @param celular the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the site
	 */
	public String getSite() {
		return site;
	}
	/**
	 * @param site the site to set
	 */
	public void setSite(String site) {
		this.site = site;
	}
	/**
	 * @return the obs
	 */
	public String getObs() {
		return obs;
	}
	/**
	 * @param obs the obs to set
	 */
	public void setObs(String obs) {
		this.obs = obs;
	}
	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}
	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
				+ ((apelidoNomeFantasia == null) ? 0 : apelidoNomeFantasia
						.hashCode());
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((cpfCnpj == null) ? 0 : cpfCnpj.hashCode());
		result = prime * result
				+ ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result
				+ ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result
				+ ((nomeRazaoSocial == null) ? 0 : nomeRazaoSocial.hashCode());
		result = prime * result + ((obs == null) ? 0 : obs.hashCode());
		result = prime * result
				+ ((rgInscricao == null) ? 0 : rgInscricao.hashCode());
		result = prime * result + ((site == null) ? 0 : site.hashCode());
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
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
		Entidade other = (Entidade) obj;
		if (apelidoNomeFantasia == null) {
			if (other.apelidoNomeFantasia != null)
				return false;
		} else if (!apelidoNomeFantasia.equals(other.apelidoNomeFantasia))
			return false;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (cpfCnpj == null) {
			if (other.cpfCnpj != null)
				return false;
		} else if (!cpfCnpj.equals(other.cpfCnpj))
			return false;
		if (dataAtualizacao == null) {
			if (other.dataAtualizacao != null)
				return false;
		} else if (!dataAtualizacao.equals(other.dataAtualizacao))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (nomeRazaoSocial == null) {
			if (other.nomeRazaoSocial != null)
				return false;
		} else if (!nomeRazaoSocial.equals(other.nomeRazaoSocial))
			return false;
		if (obs == null) {
			if (other.obs != null)
				return false;
		} else if (!obs.equals(other.obs))
			return false;
		if (rgInscricao == null) {
			if (other.rgInscricao != null)
				return false;
		} else if (!rgInscricao.equals(other.rgInscricao))
			return false;
		if (site == null) {
			if (other.site != null)
				return false;
		} else if (!site.equals(other.site))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
    
}
