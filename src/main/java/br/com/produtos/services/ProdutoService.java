package br.com.produtos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.produtos.body.Produtos;
import br.com.produtos.entities.ProdutoEntity;
import br.com.produtos.exception.ProdutoNotFound;
import br.com.produtos.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Page<ProdutoEntity> getAll(Pageable pageable) {
        return repository.findAll(pageable);

    }

    public ProdutoEntity get(Long produtos) {
        Optional<ProdutoEntity> subEmitterOp = repository.findById(produtos);

        if (subEmitterOp.isPresent()) {
            return subEmitterOp.get();
        }

        return null;
    }

    public Object update(ProdutoEntity entity) {
        return this.repository.save(entity);
    }

    public ProdutoEntity insert(Produtos produtos) {
        return this.repository.save(convertToEntity(produtos));
    }

    public ProdutoEntity convertToEntity(Produtos produtos) {

        ProdutoEntity entity = new ProdutoEntity();

        entity.setIdProduto(produtos.getIdProduto());
        entity.setIdCategoria(produtos.getIdCategoria());
        entity.setProduto(produtos.getProduto());
        entity.setPreco(produtos.getPreco());
        entity.setQuantidade(produtos.getQuantidade());
        entity.setDescricao(produtos.getDescricao());
        entity.setFoto(produtos.getFoto());

        return entity;
    }

    public void delete(Long id) throws ProdutoNotFound {

        Optional<ProdutoEntity> entityOp = repository.findById(id);

        if (entityOp.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new ProdutoNotFound("Produtos not found");
        }

    }

}