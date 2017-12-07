package controller;

import java.io.IOException;
import game.Consequencia;
import game.Evento;
import game.EventoPositivo;
import game.Player;
import game.Question;
import game.Tabuleiro;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class TabuleiroController {
	
	private Player currentPlayer;
	Tabuleiro tabuleiro;
	private boolean flagDadoGirado = false;
	private boolean flagEventoVisualizado = true;
	private static Evento evento;
	private static Consequencia consequencia;
	private ImageView redPointer;
	private ImageView bluePointer;
	private ImageView yelowPointer;
	private ImageView greenPointer;
	@FXML
	private GridPane gridCasas;
	@FXML
	private Button girarDado, visualizarEvento;
	@FXML
	private Label currentPlayerLabel, valorDoDadoLabel, ConseqLabel, valorCasaLabel;
	@FXML
	private TableView<Player> listaPlayersGrid;
	@FXML
	private TableColumn<Player, Number> idPlayersColumn;
	@FXML
	private TableColumn<Player, String> nomePlayersColumn;
	@FXML
	private TableColumn<Player, Number> positionPlayersColumn;
	@FXML
	private TableColumn<Player, Number> colorPlayer;
	@FXML
	private static ObservableList<Player> playersData;
	
	@FXML
	private void initialize()
	{
		currentPlayer = AddPlayersController.getPlayersData().get(0);
		tabuleiro = new Tabuleiro(AddPlayersController.getPlayersData());
		playersData = AddPlayersController.getPlayersData();
		listaPlayersGrid.setItems(playersData);
		
		configGridPane();
		renderColorTableCell();
		atualizarTela();
		inicializarImagensPonteiros();
	}
	
	private void atualizarTela()
	{
		currentPlayerLabel.setText(currentPlayer.getName());
		valorCasaLabel.setText(""+currentPlayer.getPosition());
	}
	
	private void configGridPane()
	{
		idPlayersColumn.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());
    	nomePlayersColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    	positionPlayersColumn.setCellValueFactory(cellData -> cellData.getValue().getPositionProperty());
    	colorPlayer.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());
    	
		ImageView back = new ImageView();
		back.setImage(new Image("/assets/GridPane-EcoWorld.jpg"));
	}
	/**
	 * Método que inicializa as imagens que são ponteiros dos avanços dos jogadores
	 * no gridPane
	 */
	private void inicializarImagensPonteiros()
	{	
		if (playersData.size()>=2)
		{
			redPointer = new ImageView();
			bluePointer = new ImageView();
			
			redPointer.setImage(new Image("/assets/red-pointer.png"));
			redPointer.setFitWidth(40);
			redPointer.setFitHeight(40);
			gridCasas.add(redPointer, 0, 0);
			
			bluePointer.setImage(new Image("/assets/blue-pointer.png"));
			bluePointer.setFitWidth(40);
			bluePointer.setFitHeight(40);
			bluePointer.setTranslateX(12);
			gridCasas.add(bluePointer, 0, 0);
		}
		if (playersData.size()>=3)
		{
			yelowPointer = new ImageView();
			
			yelowPointer.setImage(new Image("/assets/yelow-pointer.png"));
			yelowPointer.setFitWidth(40);
			yelowPointer.setFitHeight(40);
			yelowPointer.setTranslateX(24);
			gridCasas.add(yelowPointer, 0, 0);
		}
		if (playersData.size() == 4)
		{
			greenPointer = new ImageView();
			
			greenPointer.setImage(new Image("/assets/green-pointer.png"));
			greenPointer.setFitWidth(40);
			greenPointer.setFitHeight(40);
			greenPointer.setTranslateX(36);
			gridCasas.add(greenPointer, 0, 0);
		}
	}
	/**
	 * Botão que gira o dado
	 */
	public void girarDado() {
		girarDado.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				if (flagDadoGirado)
				{
					alert.setTitle("Alerta");
					alert.setContentText("Você já girou o Dado."
							+ "\nVisualize o evento da vez!");
					alert.showAndWait();
				}
				else
				{
					currentPlayer.rolarDado();
					valorDoDadoLabel.setText(""+currentPlayer.getDado().getNumAtual());
					setPlayerPosition(currentPlayer, currentPlayer.getDado().getNumAtual());
					setPositionImagemPonteiro(currentPlayer);
					valorCasaLabel.setText(""+currentPlayer.getPosition());
					flagDadoGirado=true;
					flagEventoVisualizado=false;
				}
			}
		});
	}
	/**
	 * Botão que exibe os eventos sorteados no dado
	 */
	public void visualizarEvento() {
		visualizarEvento.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event)
			{
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				if (flagEventoVisualizado)
				{
					alert.setTitle("Alerta");
					alert.setContentText("Você ainda não girou o dado.");
					alert.showAndWait();
				}
				else
				{					
					setEvento(tabuleiro.getEvento(currentPlayer.getPosition()));
									
					alertEvento(getUltimoEvento());
					
					if (getUltimoEvento() == null)
						currentPlayer = alternarEntrePlayers(null, currentPlayer);
					else if (evento instanceof Question)
					{
						alertQuestionResult(consequencia);
						aplicarConsequencia(consequencia, currentPlayer);
						setPositionImagemPonteiro(currentPlayer);
						currentPlayer = alternarEntrePlayers(consequencia, currentPlayer);
						
					}
					else
					{
						aplicarConsequencia(getUltimoEvento().getConsequencia(), currentPlayer);
						setPositionImagemPonteiro(currentPlayer);
						currentPlayer = alternarEntrePlayers(getUltimoEvento().getConsequencia(), currentPlayer);
					}
					
					atualizarTela();
					flagEventoVisualizado=true;
					flagDadoGirado=false;
				}				
			}
		});
	}
	/**
	 * Exibe um alerta para cada tipo de evento
	 * @param evento
	 */
	private void alertEvento(Evento evento)
	{
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		DialogPane dialogPane = new DialogPane();

		if (evento == null)
		{
			alert.setTitle("Alerta");
			alert.setContentText("Ótima jogada, não há eventos nesta casa.\nContinue cuidando do Meio Ambiente");
			alert.showAndWait();	
		}
		else if (evento instanceof EventoPositivo)
		{
			try
			{
				dialogPane.setContent(FXMLLoader.load(getClass().getResource("/views/AlertEventoPositivo.fxml")));
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			alert.setDialogPane(dialogPane);
			alert.showAndWait();
		}
		else if(evento instanceof Question)
		{
			try
			{
				dialogPane.setContent(FXMLLoader.load(getClass().getResource("/views/AlertEventoQuestion.fxml")));
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			alert.setDialogPane(dialogPane);
			alert.showAndWait();
		}
		else
		{
			try
			{
				dialogPane.setContent(FXMLLoader.load(getClass().getResource("/views/AlertEventoImprevisto.fxml")));
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			alert.setDialogPane(dialogPane);
			alert.showAndWait();;
		}		

	}
	/**
	 * Altera a posição dos playes de acordo com os resultados do jogo
	 * @param player
	 * @param incPosition
	 */
	private void setPlayerPosition(Player player, int incPosition)
	{
		if (player.getPosition() + incPosition <= 0 || incPosition == 0)
			player.setPositon(0);
		else if (player.getPosition() + incPosition > 62) {
			player.setPositon(62);
			alertCampeao();
		}
		else
			player.setPositon((player.getPosition()+incPosition));
	}
	/**
	 * Alterna entre os Players em cada rodada
	 * 
	 * @param consequencia
	 * @param currentPlayer
	 * @return
	 */
	private Player alternarEntrePlayers(Consequencia consequencia, Player currentPlayer) {
		if(consequencia == null) {
			return tabuleiro.proximoPlayer(currentPlayer);	  
		} else if (consequencia.isJogarNovamente()) {
			return currentPlayer;
		} else if (consequencia.isFicarSemJogar()) {
			currentPlayer.setPassaAVez(true);
			return tabuleiro.proximoPlayer(currentPlayer);
		}
		return tabuleiro.proximoPlayer(currentPlayer);
	}
	/**
	 * Aplica as consequencias de um determinado evento (Voltar/Avançar, ficar sem jogar, etc.)
	 * @param consequencia
	 * @param currentPlayer
	 */
	private void aplicarConsequencia(Consequencia consequencia, Player currentPlayer)
	{
		int casas = new Player ("", 1).rolarDado();
		if (consequencia.isAvancar())
		{
			setPlayerPosition(currentPlayer, casas);
			ConseqLabel.setText(currentPlayer.getName()+" avançou "+casas+" casas!");
		}
		else if (consequencia.isVoltar())
		{
			setPlayerPosition(currentPlayer, -casas);
			ConseqLabel.setText(currentPlayer.getName()+" voltou "+casas+" casas!");
		}
		else if (consequencia.isVoltarInicio())
		{
			setPlayerPosition(currentPlayer, 0);
			ConseqLabel.setText(currentPlayer.getName()+" voltou para o início!");
		}
		else if (consequencia.isJogarNovamente())
		{
			ConseqLabel.setText(currentPlayer.getName()+" jogará novamente!");
		}
	}
	/**
	 * Exibe um alerta informando que um determinado Player chegou ao fim e encerra a aplicação
	 */
	private void alertCampeao() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Parabéns!");
		alert.setHeaderText(currentPlayer.getName()+" VOCÊ VENCEU!");
		alert.setResizable(true);
		alert.getDialogPane().setMinSize(480, 320);
		alert.setContentText("Sua jornada foi longa, mas repleta de sabedoria. "
				+ "Você aprendeu muito sobre como suas ações podem afetar todo "
				+ "ambiente em que vive. Quando essas ações são positivas, o "
				+ "ambiente responde de forma positiva e você vive melhor, porém, "
				+ "quando suas ações afetam negativamente o meio ambiente, seu "
				+ "convívio também é afetado, e tudo se torna imprevisível. "
				+ "Espero que tenha aprendido muito com esse jogo e que você "
				+ "possa repensar suas ações daqui em diante. Felicides campeã(o).");
				
		ButtonType buttonFechar = new ButtonType("Sair da Aplicação");
		alert.getButtonTypes().remove(0);
		alert.getDialogPane().getButtonTypes().addAll(buttonFechar);
		
		alert.showAndWait().ifPresent(response -> {
			if (response == buttonFechar)
				System.exit(0);
		});
		System.exit(0);
	}
	/**
	 * Exibe um alerta se o player acertar ou errar uma determinada pergunta
	 * @param consequencia
	 */
	private void alertQuestionResult(Consequencia consequencia)
	{
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		if (consequencia.isAvancar())
		{
			alert.setTitle("Parabéns! Você acertou!");
			alert.setContentText(consequencia.getTipoConsequencia());
		}
		else if (consequencia.isVoltar())
		{
			alert.setTitle("Que pena! Você errou!");
			alert.setContentText(consequencia.getTipoConsequencia());
		}
		else if (consequencia.isFicarSemJogar())
		{
			alert.setTitle("Que pena! Você errou!");
			alert.setContentText(consequencia.getTipoConsequencia());
		}
		else if (consequencia.isJogarNovamente())
		{
			alert.setTitle("Parabéns! Você acertou!");
			alert.setContentText(consequencia.getTipoConsequencia());
		}
		alert.showAndWait();
	}
	/**
	 * Altera as posições de cada imagem ponteiro (vermelho, azul, verde e amarelo)
	 * @param currentPlayer
	 */
	private void setPositionImagemPonteiro(Player currentPlayer)
	{
		if (playersData.get(0).equals(currentPlayer))
		{
			gridCasas.getChildren().remove(redPointer);
			getGridPositions(redPointer, currentPlayer.getPosition());
		}
		else if (playersData.get(1).equals(currentPlayer))
		{
			gridCasas.getChildren().remove(bluePointer);
			getGridPositions(bluePointer, currentPlayer.getPosition());
		}
		else if(playersData.get(2).equals(currentPlayer))
		{
			gridCasas.getChildren().remove(yelowPointer);
			getGridPositions(yelowPointer, currentPlayer.getPosition());
		}
		else
		{
			gridCasas.getChildren().remove(greenPointer);
			getGridPositions(greenPointer, currentPlayer.getPosition());
		}	
	}
	/**
	 * Mostra as cores de cada player na tabela
	 */
	private void renderColorTableCell()
	{
		colorPlayer.setCellFactory( column  ->
		{
			return new TableCell<Player, Number>() {
				@Override
				protected void updateItem(Number item, boolean empty) {
					super.updateItem(item, empty);
					
					if (item == null)
					{
						setText("");
						setStyle("");
					} else
					{
						if (item.equals(1))
						{
							setStyle("-fx-background-color: red");
						} else if (item.equals(2))
						{
							setStyle("-fx-background-color: blue");
						}
						else if (item.equals(3))
						{
							setStyle("-fx-background-color: yellow");
						} else if (item.equals(4))
						{
							setStyle("-fx-background-color: green");
						}
					}
				}
			};
		});
	}
	/**
	 * Busca a posição na matriz [][] de um número x para alterar a posição dos
	 * ponteiros (vermelho, azul, marelo, verde)
	 * @param colorPointer
	 * @param position
	 */
	private void getGridPositions(ImageView colorPointer, int position)
	{
		boolean flag = false;
		int index = 1;
		int aux = 0;
		for(int i=0; i<8; i++)
		{
			if (i%2!=0) aux = 7;
			else aux = 0;
			for (int j=0; j<8; j++)
			{
				if (i==0 && j== 0) continue;
				if (i==7 && j==0)
				{
					index--;
					continue;
				}
				if (position == 0)
				{
					gridCasas.add(colorPointer, 0 , 0 );
					flag=true;
					break;
				}
				else if (index+aux == position) 
				{
					gridCasas.add(colorPointer, j , i );
				}
				if (i%2!=0) aux-=2;
				index++;
			}
			if(flag) break;
		}
	}
	
	public static Evento getUltimoEvento() {
		return evento;
	}
	
	private static void setEvento(Evento evento) {
		TabuleiroController.evento = evento;
	}
	
	public static void setConsequencia(Consequencia consequencia) {
		TabuleiroController.consequencia = consequencia;
	}
}
