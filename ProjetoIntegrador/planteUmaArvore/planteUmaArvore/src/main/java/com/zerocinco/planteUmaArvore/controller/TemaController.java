package com.zerocinco.planteUmaArvore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zerocinco.planteUmaArvore.model.PlanteUmaArvore;
import com.zerocinco.planteUmaArvore.repository.TemaRepository;

@RestController
@RequestMapping("/tema")
@CrossOrigin("*")

public class TemaController {
	
	@Autowired															// Injeção de dependência.		
	private TemaRepository trepository;
	
	@GetMapping
	public ResponseEntity<List<PlanteUmaArvore>> GetAll(){             // Retorna uma lista com todos temas
		return ResponseEntity.ok(trepository.findAll());	
	}

	@GetMapping("/{id}")
	public ResponseEntity<PlanteUmaArvore> GetById(@PathVariable long id){     //@Path variable pesquisa pelo id informado
		return trepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))							//Retorna caso ok			
				.orElse(ResponseEntity.notFound().build());						//Retorna caso a opção acima estiver vazia	
	}
	
	@PostMapping
	public ResponseEntity<PlanteUmaArvore> post (@RequestBody PlanteUmaArvore tema){    //Modela um tema pelo corpo
		return ResponseEntity.status(HttpStatus.CREATED).body(trepository.save(tema));   // Retorna status de criado caso finalizado com sucesso
		
	}
	
	@PutMapping
	public ResponseEntity<PlanteUmaArvore> put (@RequestBody PlanteUmaArvore tema){   //Modela uma atualiação de tema
		return ResponseEntity.status(HttpStatus.OK).body(trepository.save(tema));	 // Retorna um ok caso finalizado com sucesso	
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {										//Não exibe retorno		
		trepository.deleteById(id);													// Deleta por id informado		
		
	}
	
}
