package game;

public class Consequencia {
	private boolean voltar = false;
	private boolean avancar = false;
	private boolean jogarNovamente = false;
	private boolean ficarSemJogar = false;
	private boolean voltarInicio = false;
		
	public Consequencia(String type) {
		setAtributos(type);
	}
	
	public void setAtributos(String type) {
		if (type.equalsIgnoreCase("voltar".trim())) this.voltar = true;
		if (type.equalsIgnoreCase("avancar".trim())) this.avancar = true;
		if (type.equalsIgnoreCase("jogarNovamente".trim())) this.jogarNovamente = true;
		if (type.equalsIgnoreCase("ficarSemJogar".trim())) this.ficarSemJogar = true;
		if (type.equalsIgnoreCase("voltarInicio".trim())) this.voltarInicio = true;
	}
	
	public String getTipoConsequencia() {
		String consequencia = "";
		
		if (voltar == true) consequencia = "Você terá que voltar algumas casas.";
		if (avancar == true) consequencia = "Você poderá avançar algumas casas.";
		if (jogarNovamente == true) consequencia = "Você ganhou o direito de jogar novamente.";
		if (ficarSemJogar == true) consequencia = "Infelizmente você passará uma rodada sem jogar.";
		if (voltarInicio == true) consequencia = "Que pena, você terá que voltar para o início.";
		
		return consequencia;
	}

	public boolean isVoltar() {
		return voltar;
	}

	public void setVoltar(boolean voltar) {
		this.voltar = voltar;
	}

	public boolean isAvancar() {
		return avancar;
	}

	public void setAvancar(boolean avancar) {
		this.avancar = avancar;
	}

	public boolean isJogarNovamente() {
		return jogarNovamente;
	}

	public void setJogarNovamente(boolean jogarNovamente) {
		this.jogarNovamente = jogarNovamente;
	}

	public boolean isFicarSemJogar() {
		return ficarSemJogar;
	}

	public void setFicarSemJogar(boolean ficarSemJogar) {
		this.ficarSemJogar = ficarSemJogar;
	}

	public boolean isVoltarInicio() {
		return voltarInicio;
	}

	public void setVoltarInicio(boolean voltarInicio) {
		this.voltarInicio = voltarInicio;
	}
}
