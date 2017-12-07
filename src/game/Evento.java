package game;

public abstract class Evento {
	protected String titulo;
	protected String descricao;
	protected Consequencia consequencia;
	protected int id;
	
	public abstract Consequencia getConsequencia();//rever isso aqui
	public abstract void setDescricao(String descricao);
	public abstract String getTitulo();
	public abstract String getDescricao();
}