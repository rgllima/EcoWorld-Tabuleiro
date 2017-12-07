package game;

public class EventoPositivo extends Evento {
	
	public EventoPositivo(String titulo, String descricao, Consequencia consequencia, int id) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.consequencia = consequencia;
		this.id = id;
	}
	@Override
	public Consequencia getConsequencia() {
		return consequencia;
	}
	
	@Override
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public String getTitulo() {
		return titulo;
	}
	@Override
	public String getDescricao() {
		return descricao;
	}

}
