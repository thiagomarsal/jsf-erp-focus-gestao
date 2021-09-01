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
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


/**
 * @author Thiago M. Farias
 * 
 */

/**
 * Declara que é havera uma entidade no BD. para persistencia.
 */
@Entity
public class OrdemServico implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrdemServico;
    
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCliente")
    @Fetch(FetchMode.JOIN)
    private Cliente cliente;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCondicaoPagamento")
    @Fetch(FetchMode.JOIN)
    private CondicaoPagamento condicaoPagamento;
    
    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ServicosSelecionados> servicosSelecionados;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario")
    @Fetch(FetchMode.JOIN)
    private Usuario usuario;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ContaReceber> contasReceber;
    
    @Column
	private Double totalVenda;
    
    @Column
	private Double desconto;
    
    @Column
	private Double totalServicos;
    
    @Column(nullable = true, length = 100)
	private String obs;

    public OrdemServico() {
        super();
    }

    /**
	 * @param fornecedor
	 * @param formaPagamento
	 * @param usuario
	 */
	public OrdemServico(Cliente cliente, CondicaoPagamento condicaoPagamento, Usuario usuario) {
		this.cliente = cliente;
		this.condicaoPagamento = condicaoPagamento;
		this.usuario = usuario;
	}

	@Transient
	public boolean isPedidoEmAberto() {
		return getStatusPedido() != null
				&& getStatusPedido().equals(StatusPedido.ABERTO);
	}

	/**
	 * @return the idOrdemServico
	 */
	public Long getIdOrdemServico() {
		return idOrdemServico;
	}

	/**
	 * @param idOrdemServico the idOrdemServico to set
	 */
	public void setIdOrdemServico(Long idOrdemServico) {
		this.idOrdemServico = idOrdemServico;
	}

	/**
	 * @return the dataEmissao
	 */
	public Date getDataEmissao() {
		return dataEmissao;
	}

	/**
	 * @param dataEmissao the dataEmissao to set
	 */
	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the condicaoPagamento
	 */
	public CondicaoPagamento getCondicaoPagamento() {
		return condicaoPagamento;
	}

	/**
	 * @param condicaoPagamento the condicaoPagamento to set
	 */
	public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}

	/**
	 * @return the statusPedido
	 */
	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	/**
	 * @param statusPedido the statusPedido to set
	 */
	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	/**
	 * @return the servicosSelecionados
	 */
	public List<ServicosSelecionados> getServicosSelecionados() {
		return servicosSelecionados;
	}

	/**
	 * @param servicosSelecionados the servicosSelecionados to set
	 */
	public void setServicosSelecionados(
			List<ServicosSelecionados> servicosSelecionados) {
		this.servicosSelecionados = servicosSelecionados;
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
	 * @return the contasReceber
	 */
	public List<ContaReceber> getContasReceber() {
		return contasReceber;
	}

	/**
	 * @param contasReceber the contasReceber to set
	 */
	public void setContasReceber(List<ContaReceber> contasReceber) {
		this.contasReceber = contasReceber;
	}

	/**
	 * @return the totalVenda
	 */
	public Double getTotalVenda() {
		return totalVenda;
	}

	/**
	 * @param totalVenda the totalVenda to set
	 */
	public void setTotalVenda(Double totalVenda) {
		this.totalVenda = totalVenda;
	}

	/**
	 * @return the desconto
	 */
	public Double getDesconto() {
		return desconto;
	}

	/**
	 * @param desconto the desconto to set
	 */
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	/**
	 * @return the totalServicos
	 */
	public Double getTotalServicos() {
		return totalServicos;
	}

	/**
	 * @param totalServicos the totalServicos to set
	 */
	public void setTotalServicos(Double totalServicos) {
		this.totalServicos = totalServicos;
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

}
