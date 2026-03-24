package com.zera.departamentos.controllers;

import com.zera.departamentos.models.DepartamentoModel;
import com.zera.departamentos.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping
    public ResponseEntity<DepartamentoModel> criarDepartamento(@RequestBody DepartamentoModel dep){
        DepartamentoModel request = departamentoService.criarDepartamento(dep);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dep.getId())
                .toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoModel>> findAll(){
        List<DepartamentoModel> request = departamentoService.buscarTodosDepartamentos();
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping
    public ResponseEntity<?> deletar (@PathVariable Long id){
        departamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public DepartamentoModel buscarPorId(@PathVariable Long id){
        return departamentoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoModel> atualizarCliente(@PathVariable Long id, @RequestBody DepartamentoModel dep){
        DepartamentoModel model = departamentoService.atualizar(id, dep);
        return ResponseEntity.ok().body(model);
    }
}
