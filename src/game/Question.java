package game;

import java.util.Map;

public class Question extends Evento {
	private int id;
	private Consequencia consequenciaErro;
	private Map<String, Boolean> alternativas;
	
	public Question(String descricao, Map<String, Boolean> alternativas, Consequencia acerto, Consequencia erro, int id){
		this.descricao = descricao;
		this.alternativas = alternativas;
		this.consequencia = acerto;
		this.consequenciaErro = erro;
		this.id = id;
	}

	@Override
	public Consequencia getConsequencia() {
		return consequencia;
	}
	
	public Map<String, Boolean> getAlternativas(){
		return alternativas;
	}
	
	public Consequencia validaResposta(String resposta) {
		if (alternativas.get(resposta)) return consequencia;
		return consequenciaErro;
	}
	
	@Override
	public String getTitulo() {
		return titulo;
	}
	
	@Override
	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Consequencia getConsequenciaAcerto() {
		return consequencia;
	}
	
	public Consequencia getConsequenciaErro() {
		return consequenciaErro;
	}
	
	public int getId() {
		return id;
	}

}
