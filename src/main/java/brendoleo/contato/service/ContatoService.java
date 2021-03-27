package brendoleo.contato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import brendoleo.contato.model.Contato;
import brendoleo.contato.repository.ContatoRepository;

@Service
public class ContatoService{

    private final ContatoRepository repository;
    
    @Autowired
    public ContatoService(ContatoRepository repository) {
        this.repository = repository;
    }
        
	public Contato salvar(Contato contato) {
		return repository.save(contato);
	}
	
	public List<Contato> listarTodos(){
        return repository.findAll();
    }
	
	public Contato listarPorId(Integer id) {
		return repository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado") );
	}
	
	public String listarPorTelefone(Integer id) {
		return repository.findById(id).get().getEmail();            
	}
	
	public List<Contato> listarDezContatosPorNome() {
		return repository.buscarPrimeirosDezContatosPorNome();
	}
	
	public String capturarContatosPorNome(String nome) {
		return repository.retornarDezPrimeirosContatosPorNome(nome);
	}
	
	public void excluir(Integer id) {
		repository.findById(id).map( contato -> {
            repository.delete(contato);
            return Void.TYPE;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado") );
	}
	
	public void editar(Integer id, Contato contatoAtualizado) {
		repository.findById(id)
        .map( contato -> {
        	contato.setNome(contatoAtualizado.getNome());
        	contato.setSobreNome(contatoAtualizado.getSobreNome());
        	contato.setCpf(contatoAtualizado.getCpf());
        	contato.setEmail(contatoAtualizado.getEmail());
        	contato.setTelefone(contatoAtualizado.getTelefone());
        	contato.setEndereco(contatoAtualizado.getEndereco());
            return repository.save(contato);
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado") );
	}

	
}
