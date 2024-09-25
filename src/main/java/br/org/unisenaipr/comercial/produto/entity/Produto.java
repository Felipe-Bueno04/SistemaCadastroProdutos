package br.org.unisenaipr.comercial.produto.entity;

import java.io.Serializable;
import java.util.List;

import br.org.unisenaipr.comercial.fabricante.entity.Fabricante;
import br.org.unisenaipr.comercial.grupo.entity.Grupo;
import br.org.unisenaipr.comercial.subgrupo.entity.SubGrupo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tb_produto")
@SequenceGenerator(name = "SEQ_PRODUTO", sequenceName = "S_PRODUTO", allocationSize = 1)
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "produto_id", nullable = false)
	private Long id;

	@Column(name = "produto_nomesubgrupo", nullable = false, length = 150)
	private String nomeProduto;
	
	@Column(name = "produto_descricao", length = 200)
	private String descricaoProduto;

	@Column(name = "preco_custo", nullable = false)
    private double precoCusto;
	
	@Column(name = "preco_venda", nullable = false)
    private double precoVenda;
	
	@Column(name = "produto_peso")
	private String peso;
	
	
	@Column(name = "produto_qtd_comprada")
    private int qtdComprada;
	
	@Column(name = "produto_qtd_vendida")
    private int qtdVendida;
	
    @Transient
    private List<Produto> vendasdeprodutos;

    @ManyToOne
    @JoinColumn(name = "fabricante_id")
    private Fabricante fabricante;

    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Grupo grupo;
    
    @ManyToOne
    @JoinColumn(name = "subgrupo_id")
    private SubGrupo subGrupo;

    public Produto() {
    	
    }

	public Produto(Long id, String nomeProduto, String descricaoProduto, double precoCusto, double precoVenda, String peso, int qtdComprada, int qtdVendida, Fabricante fabricante, Grupo grupo, SubGrupo subGrupo) {
		super();
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.peso = peso;
		this.qtdComprada = qtdComprada;
		this.qtdVendida = qtdVendida;
		this.fabricante = fabricante;
		this.grupo = grupo;
		this.subGrupo = subGrupo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	
	public double getPrecoCusto() {
		return precoCusto;
	}
	
	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}
	
	public String getPeso() {
		return peso;
	}
	
	public void setPeso(String peso) {
		this.peso = peso;
	}

	public int getQtdComprada() {
		return qtdComprada;
	}

	public void setQtdCompra(int qtdComprada) {
		this.qtdComprada = qtdComprada;
	}

	public int getQtdVendida() {
		return qtdVendida;
	}
	
	public void setQtdVendida(int qtdVendida) {
		this.qtdVendida = qtdVendida;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	public Grupo getGrupo() {
		return grupo;
	}
	
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	public SubGrupo getSubGrupo() {
		return subGrupo;
	}
	
	public void setSubGrupo(SubGrupo subGrupo) {
		this.subGrupo = subGrupo;
	}


	public List<Produto> getVendasdeprodutos() {
		return vendasdeprodutos;
	}

	public void setVendasdeprodutos(List<Produto> vendasdeprodutos) {
		this.vendasdeprodutos = vendasdeprodutos;
	}
}