package br.com.alura.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;

public class RefreshTopicoForm {
	
	
	@NotNull @NotEmpty @Length(min = 2)
	private String titulo;
	
	@NotNull @NotEmpty @Length(min = 2)
	private String mensagem;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Topico atualizar(Long id, TopicoRepository topicoRepository) {
		Topico refreshedTopico = topicoRepository.getOne(id);
		refreshedTopico.setMensagem(this.mensagem);
		refreshedTopico.setTitulo(this.titulo);
		
		return refreshedTopico;
	}
	
	
}