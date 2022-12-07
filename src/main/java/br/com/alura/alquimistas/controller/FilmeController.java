package br.com.alura.alquimistas.controller;


import br.com.alura.alquimistas.model.Filme;
import br.com.alura.alquimistas.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping
    public List<Filme> listar(@RequestParam(required = false) String genero){
        List<Filme> filmes;
        if(genero == null){
            filmes = filmeRepository.findAll();
        }else{
            filmes = filmeRepository.findByGenero(genero);
        }
        return filmes;
    }

    @GetMapping("/{id}")
    public Optional<Filme> encontrarPorId(@PathVariable Long id){
        Optional<Filme> filme = filmeRepository.findById(id);
        return filme;
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        Optional<Filme> filme = filmeRepository.findById(id);
        if(filme.isPresent()){
            filmeRepository.deleteById(id);
        }
    }



//    @GetMapping("/nome/{nome}")
//    public Optional<Filme> encontrarPorNome(@PathVariable String nome){
//        Optional<Filme> filme = filmeRepository.findByNome(nome);
//        return filme;
//    }

}
