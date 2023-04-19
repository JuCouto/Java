package com.residencia.firstapi.controller;

import com.residencia.firstapi.entity.Livro;
import com.residencia.firstapi.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    private LivroService livroService;
    
    @GetMapping
    public ResponseEntity<List<Livro>> findAll(){
        return ResponseEntity.ok().body(livroService.findAll());
    }

    @GetMapping("/{id}")
    public Livro findById(@PathVariable(value = "id") Integer id){
        return livroService.findById(id);
    }

    @PostMapping
    public Livro save(@RequestBody Livro livro){
        return livroService.save(livro);
    }

    @PutMapping
    public Livro update( @RequestBody Livro livro) {
        return livroService.update(livro);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        livroService.delete(id);
    }
}