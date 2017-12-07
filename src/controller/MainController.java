package controller;

import javafx.scene.control.Label;
import game.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox; 

public class MainController
{
	private static int numPlayer;
	@FXML
	private ChoiceBox<String> qntdPlayerChooser;
	@FXML
	private Button btIniciar;
	@FXML
	private Label errorLabelMessage;
	
	/**
	 * Inicializa o jogo com a quantidade de jogadores infromados pelo usuário, através do butão "Iniciar"
	 */
	public void btIniciar()
	{
		btIniciar.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				if (qntdPlayerChooser.getValue() == null)
					errorLabelMessage.setText("Escolha a quantidade de jogadores!");
				else
				{
					String player[] = qntdPlayerChooser.getValue().split(" ");
					numPlayer = Integer.parseInt(player[0]);
					Main.showAddPlayers();
				}
			}
		});		
	}
	
	public static int getNumPlayer()
	{
		return numPlayer;
	}
}
