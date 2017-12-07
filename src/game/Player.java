package game;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Player {
	private final StringProperty name;
	private final IntegerProperty id;
	private IntegerProperty position;
	
	private boolean passaAVez;
	private Dado dado;
	
	
	public Player(String name, Integer id) {
		this.name = new SimpleStringProperty(name);
		this.id = new SimpleIntegerProperty(id);
		this.position = new SimpleIntegerProperty(0);
		passaAVez = false;
		dado = new Dado();
	}
	
	public int rolarDado() {
		return dado.girarDado();
	}
	
	public String getName() {
		return name.get();
	}
	
	public int getId() {
		return id.get();
	}
	
	public StringProperty getNameProperty() {
		return name;
	}
	
	public IntegerProperty getIdProperty() {
		return id;
	}
	
	public IntegerProperty getPositionProperty() {
		return position;
	}

	public boolean getPassaAVez() {
		return passaAVez;
	}
	
	public void setPassaAVez(boolean type) {
		this.passaAVez = type;
	}
	
	public int getPosition() {
		return position.get();
	}
	
	public void setPositon(int position) {
		this.position.set(position);
	}
	
	public Dado getDado() {
		return dado;
	}
	
}
