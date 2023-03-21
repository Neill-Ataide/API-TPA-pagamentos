package uea.pagamentos_api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import uea.pagamentos_api.models.Categoria;
import uea.pagamentos_api.services.CategoriaService;

@RestController //Vai ser um endpoint
@RequestMapping("/categorias") //De onde ele vai ser o endpoint
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
		
	@PostMapping
	public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria) {
		Categoria categoriaSalva = categoriaService.criar(categoria);
		return ResponseEntity.ok().body(categoriaSalva);
	}
	
	@GetMapping
	public ResponseEntity<List<Categoria>> listar(){
		List<Categoria> categorias = categoriaService.listar();
		return ResponseEntity.ok().body(categorias);
	}
	
	@GetMapping(value = "/{codigo}")
	public ResponseEntity<Categoria> buscarPorCodigo(@PathVariable Long codigo){
		Categoria categoria = categoriaService.buscarPorCodigo(codigo);
		return ResponseEntity.ok().body(categoria);
	}
	
	@DeleteMapping(value = "/{codigo}")
	public ResponseEntity<Void> excluir(@PathVariable Long codigo){
		categoriaService.excluir(codigo);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{codigo}")
	public ResponseEntity<Categoria> atualizar(@Valid @PathVariable Long codigo, @RequestBody Categoria categoria){
		Categoria categoriaSalva = categoriaService.atualizar(codigo, categoria);
		return ResponseEntity.ok().body(categoriaSalva);
	}
	
}