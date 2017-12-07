package controller;

import java.util.ArrayList;
import java.util.List;
import game.Question;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class AlertEventoQuestionController
{
	private List<String> alternativas;
	private String resposta;
	
	@FXML
	private Label titleAlert, titleAlertLabel, alertLabel;
	
	@FXML
	private RadioButton alternativa1Radio, alternativa2Radio, alternativa3Radio, alternativa4Radio;
	
	@FXML
	private Button buttonResposta;
	
	@FXML
	public void initialize()
	{
		alternativas = new ArrayList<>(((Question) TabuleiroController.getUltimoEvento()).getAlternativas().keySet());
		
		titleAlertLabel.setText(((Question) TabuleiroController.getUltimoEvento()).getDescricao());
		
		alternativa1Radio.setText(alternativas.get(0));
		alternativa2Radio.setText(alternativas.get(1));
		alternativa3Radio.setText(alternativas.get(2));
		alternativa4Radio.setText(alternativas.get(3));
		
		alternativa1Radio.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event) {
				alternativa2Radio.setSelected(false);
				alternativa3Radio.setSelected(false);
				alternativa4Radio.setSelected(false);
				resposta = alternativas.get(0);
			}
		});
		
		alternativa2Radio.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event) {
				alternativa1Radio.setSelected(false);
				alternativa3Radio.setSelected(false);
				alternativa4Radio.setSelected(false);
				resposta = alternativas.get(1);
			}
		});
		
		alternativa3Radio.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event) {
				alternativa2Radio.setSelected(false);
				alternativa1Radio.setSelected(false);
				alternativa4Radio.setSelected(false);
				resposta = alternativas.get(2);
			}
		});
		
		alternativa4Radio.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event) {
				alternativa2Radio.setSelected(false);
				alternativa3Radio.setSelected(false);
				alternativa1Radio.setSelected(false);
				resposta = alternativas.get(3);
			}
		});
		
	}
	
	public void enviarResposta()
	{
		buttonResposta.setOnAction(new EventHandler<ActionEvent>()
		{	
			@Override
			public void handle(ActionEvent event)
			{	
				if (!alternativa1Radio.isSelected() &&
						!alternativa2Radio.isSelected() &&
						!alternativa3Radio.isSelected() &&
						!alternativa4Radio.isSelected())
				{
					alertLabel.setText("Antes de enviar, escolha uma das opções acima!");
				} else
				{
					TabuleiroController.setConsequencia(((Question)TabuleiroController.getUltimoEvento()).validaResposta(resposta));
					close();
				}
			}
		});
	}
	
	public void close()
	{
		Stage stage = (Stage) buttonResposta.getScene().getWindow();
		stage.close();
	}
}
