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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

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
public class Funcionario extends Entidade implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFuncionario;
	@Column(length = 15)
    private String ctps;
    @Column(nullable = true, length = 20)
    private String estadoCivil;
    @Column(nullable = true, length = 10)
    private String sexo;
    @Column(nullable = true, length = 10)
    private Double comissao;
    @Column(nullable = true, length = 10)
    private Double salario;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAdmissao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDemissao;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCargo")
    @Fetch(FetchMode.JOIN)
    private Cargo cargo;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCidade")
    @Fetch(FetchMode.JOIN)
    private Cidade cidade;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUsuario")
    @Fetch(FetchMode.JOIN)
    private Usuario usuario;

    public Funcionario() {
        super();
    }

    public Funcionario(Cidade cidade, Cargo cargo, Usuario usuario) {
        this.cidade = cidade;
        this.cargo = cargo;
        this.usuario = usuario;
    }

	/**
	 * @return the idUsuario
	 */
	public Long getIdFuncionario() {
		return idFuncionario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
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
	 * @return the comissao
	 */
	public Double getComissao() {
		return comissao;
	}

	/**
	 * @param comissao the comissao to set
	 */
	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	/**
	 * @return the salario
	 */
	public Double getSalario() {
		return salario;
	}

	/**
	 * @param salario the salario to set
	 */
	public void setSalario(Double salario) {
		this.salario = salario;
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
	 * @return the dataAdmissao
	 */
	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	/**
	 * @param dataAdmissao the dataAdmissao to set
	 */
	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	/**
	 * @return the dataDemissao
	 */
	public Date getDataDemissao() {
		return dataDemissao;
	}

	/**
	 * @param dataDemissao the dataDemissao to set
	 */
	public void setDataDemissao(Date dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	/**
	 * @return the cargo
	 */
	public Cargo getCargo() {
		return cargo;
	}

	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
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

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the ctps
	 */
	public String getCtps() {
		return ctps;
	}

	/**
	 * @param ctps the ctps to set
	 */
	public void setCtps(String ctps) {
		this.ctps = ctps;
	}
	
}
