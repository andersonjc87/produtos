package br.com.produtos.entities;

import java.awt.Image;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "produtos")
@Entity
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idProdutos")
    private Long idProduto;

    @Column(name = "idCategoria")
    private Long idCategoria;

    @Column(name = "produto")
    private String produto;

    @Column(name = "preco")
    private BigDecimal preco;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "descriao")
    private String descricao;

    @Column(name = "foto")
    private Image foto;

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ProdutoEntity [Id Produto=");
        builder.append(idProduto);
        builder.append(", Id Categoria=");
        builder.append(idCategoria);
        builder.append(", Produto=");
        builder.append(produto);
        builder.append(", Preco=");
        builder.append(preco);
        builder.append(", Quantidade=");
        builder.append(quantidade);
        builder.append(", Descricao=");
        builder.append(descricao);
        builder.append(", Foto=");
        builder.append(foto);
        builder.append("]");
        return builder.toString();
    }

}
