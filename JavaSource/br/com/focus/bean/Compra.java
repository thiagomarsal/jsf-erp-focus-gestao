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
public class Compra implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompra;
	
	@Column(nullable = false, length = 20)
    private String numero;
	
    @Column(nullable = true, length = 5)
    private String serie;
    
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;
    
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFornecedor")
    @Fetch(FetchMode.JOIN)
    private Fornecedor fornecedor;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCondicaoPagamento")
    @Fetch(FetchMode.JOIN)
    private CondicaoPagamento condicaoPagamento;
    
    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProdutosSelecionados> produtosSelecionados;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario")
    @Fetch(FetchMode.JOIN)
    private Usuario usuario;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ContaPagar> contasPagar;
    
    @Column
	private Double baseIcms;
    
    @Column
	private Double valorIcms;
    
    @Column
	private Double baseIcmsSubstituicao;
    
    @Column
	private Double valorIcmsSubstituicao;
    
    @Column
	private Double valorFrete;
    
    @Column
	private Double valorSeguro;
    
    @Column
	private Double outrasDespesas;
    
    @Column
	private Double valorTotalIpi;
    
    @Column
	private Double totalCompra;
    
    @Column
	private Double desconto;
    
    @Column
	private Double totalProdutos;
    
    @Column(nullable = true, length = 100)
	private String obs;

    public Compra() {
        super();
    }

    /**
	 * @param fornecedor
	 * @param formaPagamento
	 * @param usuario
	 */
	public Compra(Fornecedor fornecedor, CondicaoPagamento condicaoPagamento, Usuario usuario) {
		this.fornecedor = fornecedor;
		this.condicaoPagamento = condicaoPagamento;
		this.usuario = usuario;
	}

	@Transient
	public boolean isPedidoEmAberto() {
		return getStatusPedido() != null
				&& getStatusPedido().equals(StatusPedido.ABERTO);
	}
	/**
	 * @return the idCompra
	 */
	public Long getIdCompra() {
		return idCompra;
	}


	/**
	 * @param idCompra the idCompra to set
	 */
	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}


	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}


	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}


	/**
	 * @return the serie
	 */
	public String getSerie() {
		return serie;
	}


	/**
	 * @param serie the serie to set
	 */
	public void setSerie(String serie) {
		this.serie = serie;
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
	 * @return the dataEntrada
	 */
	public Date getDataEntrada() {
		return dataEntrada;
	}


	/**
	 * @param dataEntrada the dataEntrada to set
	 */
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}


	/**
	 * @return the fornecedor
	 */
	public Fornecedor getFornecedor() {
		return fornecedor;
	}


	/**
	 * @param fornecedor the fornecedor to set
	 */
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
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
	 * @return the produtosCompra
	 */
	public List<ProdutosSelecionados> getProdutosSelecionados() {
		return produtosSelecionados;
	}


	/**
	 * @param produtosCompra the produtosCompra to set
	 */
	public void setProdutosSelecionados(List<ProdutosSelecionados> produtosSelecionados) {
		this.produtosSelecionados = produtosSelecionados;
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
	 * @return the baseIcms
	 */
	public Double getBaseIcms() {
		return baseIcms;
	}

	/**
	 * @param baseIcms the baseIcms to set
	 */
	public void setBaseIcms(Double baseIcms) {
		this.baseIcms = baseIcms;
	}

	/**
	 * @return the valorIcms
	 */
	public Double getValorIcms() {
		return valorIcms;
	}

	/**
	 * @param valorIcms the valorIcms to set
	 */
	public void setValorIcms(Double valorIcms) {
		this.valorIcms = valorIcms;
	}

	/**
	 * @return the baseIcmsSubstituicao
	 */
	public Double getBaseIcmsSubstituicao() {
		return baseIcmsSubstituicao;
	}

	/**
	 * @param baseIcmsSubstituicao the baseIcmsSubstituicao to set
	 */
	public void setBaseIcmsSubstituicao(Double baseIcmsSubstituicao) {
		this.baseIcmsSubstituicao = baseIcmsSubstituicao;
	}

	/**
	 * @return the valorIcmsSubstituica
	 */
	public Double getValorIcmsSubstituicao() {
		return valorIcmsSubstituicao;
	}

	/**
	 * @param valorIcmsSubstituica the valorIcmsSubstituica to set
	 */
	public void setValorIcmsSubstituicao(Double valorIcmsSubstituicao) {
		this.valorIcmsSubstituicao = valorIcmsSubstituicao;
	}

	/**
	 * @return the valorFrete
	 */
	public Double getValorFrete() {
		return valorFrete;
	}

	/**
	 * @param valorFrete the valorFrete to set
	 */
	public void setValorFrete(Double valorFrete) {
		this.valorFrete = valorFrete;
	}

	/**
	 * @return the valorSeguro
	 */
	public Double getValorSeguro() {
		return valorSeguro;
	}

	/**
	 * @param valorSeguro the valorSeguro to set
	 */
	public void setValorSeguro(Double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}

	/**
	 * @return the outrasDespesas
	 */
	public Double getOutrasDespesas() {
		return outrasDespesas;
	}

	/**
	 * @param outrasDespesas the outrasDespesas to set
	 */
	public void setOutrasDespesas(Double outrasDespesas) {
		this.outrasDespesas = outrasDespesas;
	}

	/**
	 * @return the valorTotalIpi
	 */
	public Double getValorTotalIpi() {
		return valorTotalIpi;
	}

	/**
	 * @param valorTotalIpi the valorTotalIpi to set
	 */
	public void setValorTotalIpi(Double valorTotalIpi) {
		this.valorTotalIpi = valorTotalIpi;
	}

	/**
	 * @return the totalCompra
	 */
	public Double getTotalCompra() {
		return totalCompra;
	}

	/**
	 * @param totalCompra the totalCompra to set
	 */
	public void setTotalCompra(Double totalCompra) {
		this.totalCompra = totalCompra;
	}

	/**
	 * @return the totalProdutos
	 */
	public Double getTotalProdutos() {
		return totalProdutos;
	}

	/**
	 * @param totalProdutos the totalProdutos to set
	 */
	public void setTotalProdutos(Double totalProdutos) {
		this.totalProdutos = totalProdutos;
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
	 * @return the contasPagar
	 */
	public List<ContaPagar> getContasPagar() {
		return contasPagar;
	}

	/**
	 * @param contasPagar the contasPagar to set
	 */
	public void setContasPagar(List<ContaPagar> contasPagar) {
		this.contasPagar = contasPagar;
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

}
