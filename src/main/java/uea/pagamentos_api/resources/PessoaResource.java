package uea.pagamentos_api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import uea.pagamentos_api.dto.ResumoPessoaDto;
import uea.pagamentos_api.models.Endereco;
import uea.pagamentos_api.models.Pessoa;
import uea.pagamentos_api.repositories.filters.PessoaFilter;
import uea.pagamentos_api.services.PessoaService;

@RestController //Vai ser um endpoint
@RequestMapping("/pessoas") //De onde ele vai ser o endpoint
public class PessoaResource {
	
	@Autowired
	private PessoaService pessoaService;
		
	@PostMapping
	public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = pessoaService.criar(pessoa);
		return ResponseEntity.ok().body(pessoaSalva);
	}
	
	@GetMapping
	public ResponseEntity<Page<ResumoPessoaDto>> resumir(PessoaFilter pessoaFilter, Pageable pageable){
		Page<ResumoPessoaDto> resumos = pessoaService.resumir(pessoaFilter, pageable);
		return ResponseEntity.ok().body(resumos);
	}
	
	@GetMapping(value = "/{codigo}")
	public ResponseEntity<Pessoa> buscarPorCodigo(@PathVariable Long codigo){
		Pessoa pessoa = pessoaService.buscarPorCodigo(codigo);
		return ResponseEntity.ok().body(pessoa);
	}
	
	@DeleteMapping(value = "/{codigo}")
	public ResponseEntity<Void> excluir(@PathVariable Long codigo){
		pessoaService.excluir(codigo);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{codigo}")
	public ResponseEntity<Pessoa> atualizar(@Valid @PathVariable Long codigo, @RequestBody Pessoa pessoa){
		Pessoa pessoaSalva = pessoaService.atualizar(codigo, pessoa);
		return ResponseEntity.ok().body(pessoaSalva);
	}
	
	@PutMapping(value = "/{codigo}/ativo")
	public ResponseEntity<Pessoa> atualizarPropAtivo(@PathVariable Long codigo, @RequestBody Boolean ativo){
		Pessoa pessoaSalva = pessoaService.atualizarPropAtivo(codigo, ativo);
		return ResponseEntity.ok().body(pessoaSalva);
	}
	
	@PutMapping(value = "/{codigo}/endereco")
	public ResponseEntity<Pessoa> atualizarPropEndereco(@PathVariable Long codigo, @RequestBody Endereco endereco){
		Pessoa pessoaSalva = pessoaService.atualizarPropEndereco(codigo, endereco);
		return ResponseEntity.ok().body(pessoaSalva);
	}
	
}