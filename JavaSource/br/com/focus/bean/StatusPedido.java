package br.com.focus.bean;



public enum StatusPedido {
	
	ABERTO("Aberto"),
	CONCLUIDO("Concluido"),
	CANCELADO("Cancelado");
	
	private StatusPedido(String descricao){
		this.descricao = descricao;
	}
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
