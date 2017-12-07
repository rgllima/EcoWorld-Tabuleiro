package controller;

import game.Main;
import game.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AddPlayersController
{
	private int indexPlayers = 1;
    private static ObservableList<Player> playersData = FXCollections.observableArrayList();
	
	@FXML
	private Button btAddJogador;
	@FXML
	private Button iniciarDisputa;
	@FXML
	private TextField tfAddJogador;
	@FXML
	private TableView<Player> tableJogadores;
	@FXML
	private TableColumn<Player, Number> idPlayersColumn;
	@FXML
	private TableColumn<Player, String> namePlayersColumn;
	@FXML
	private Label jogadorN, alertMessage;
	
    
    @FXML
    private void initialize()
    {
    	idPlayersColumn.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());
    	namePlayersColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    }
	/**
	 * Botão de Adicionar os jogadores ao tabuleiro
	 */
	public void adicionarJogador()
	{
		btAddJogador.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				if (tfAddJogador.getText().trim().isEmpty())
				{
					alertMessage.setText("Nome do Jogador não Pode ser Vazio!");
				}
				else if (playersData.size()>=MainController.getNumPlayer())
				{
					alertMessage.setText("Você só pode adicionar "+MainController.getNumPlayer()+" jogadores!");
				}
				else
				{
					if (isPlayerExist(tfAddJogador.getText()))
					{
						alertMessage.setText("Adicione jogadores com nomes diferentes!");
					}
					else
					{
						playersData.add(new Player (tfAddJogador.getText(), indexPlayers));
						alertMessage.setText("");
						indexPlayers++;
						if (playersData.size()>=MainController.getNumPlayer())
							jogadorN.setText("Concluído");
						else
							jogadorN.setText(indexPlayers+"º Jogador");
						tfAddJogador.clear();
						tableJogadores.setItems(getPlayersData());
					}
				}
			}
		});	
	}
	/**
	 * Botão que inicia o jogo;
	 */
	public void runGame()
	{
		iniciarDisputa.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				if (playersData.size()<MainController.getNumPlayer())
					alertMessage.setText("Adicione todos os jogadores!");
				else
					Main.showTabuleiro();
			}
		});
	}
	
	public static ObservableList<Player> getPlayersData()
	{
		return playersData;
	}
	
	private boolean isPlayerExist(String nome)
	{
		for (Player player : playersData)
		{
			if (player.getName().equalsIgnoreCase(nome))
				return true;
		}
		return false;
	}
}
