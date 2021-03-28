package brendoleo.contato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import brendoleo.contato.model.Contato;
import brendoleo.contato.service.ContatoService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/contato")
//@CrossOrigin("http://localhost:4200")
@CrossOrigin("https://cadastro-contato.herokuapp.com")
public class ContatoController {
	
	private final ContatoService service;

    @Autowired
    public ContatoController(ContatoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Contato> listar(){
        return service.listarTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contato salvar( @RequestBody @Valid Contato contato ){
        return service.salvar(contato);
    }

    @GetMapping("{id}")
    public Contato listarPorId( @PathVariable Integer id ){
        return service.listarPorId(id);
    }
    
    @GetMapping("ident/{nome}")
    public String pesquisarPorNome(@PathVariable String nome ){
        return service.capturarContatosPorNome(nome);
    }
    
    @GetMapping("{id}/telefone")
    public String listarPorIdTelefone( @PathVariable Integer id ){
        return service.listarPorTelefone(id);
    }
    
    @GetMapping("nome")
    public List<Contato> listarDezContatosPorNome(){
        return service.listarDezContatosPorNome();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir( @PathVariable Integer id ){
    	service.excluir(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editar( @PathVariable Integer id, @RequestBody @Valid Contato contatoAtualizado ) {
    	service.editar(id, contatoAtualizado);
    }
}
