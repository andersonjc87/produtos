package br.com.produtos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.produtos.body.Produtos;
import br.com.produtos.entities.ProdutoEntity;
import br.com.produtos.exception.ProdutoNotFound;
import br.com.produtos.services.ProdutoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(path = "brasilprev")
public final class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @ResponseBody
    @ApiOperation(value = "Buscar todo os produtos")
    @GetMapping(path = "/produtos")
    public ResponseEntity<?> getAll(Pageable pageable) {

        Page<ProdutoEntity> produtos = service.getAll(pageable);

        if (produtos == null) {
            return (ResponseEntity<?>) ResponseEntity.noContent();
        }
        return ResponseEntity.ok(produtos);

    }

    @ResponseBody
    @ApiOperation(value = "buscar por id de Produto")
    @GetMapping(path = "/produtos/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {

        ProdutoEntity produtos = service.get(id);

        if (produtos == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(produtos);

    }

    @RequestBody
    @ApiOperation(value = "Adicionar produto")
    @PostMapping(path = "/produtos/adicionar")
    public ResponseEntity<?> post(Produtos produtos) {

        try {
            return ResponseEntity.ok(service.insert(produtos));

        } catch (Exception e) {

            return ResponseEntity.status(500).build();
        }

    }

    @RequestBody
    @ApiOperation(value = "Atualizar Produto")
    @PutMapping(path = "/produtos/{id}")
    public ResponseEntity<?> put(@PathVariable("id") Long id, Produtos produtos) {

        ProdutoEntity entity = service.get(id);

        try {
            return ResponseEntity.ok(service.update(entity));

        } catch (Exception e) {

            return ResponseEntity.status(500).build();
        }

    }

    @RequestBody
    @ApiOperation(value = "excluir produto")
    @DeleteMapping(path = "/produtos/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return ResponseEntity.status(200).build();
        } catch (ProdutoNotFound e) {
            return ResponseEntity.noContent().build();
        }
    }

}
