package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AlertEventoImprevistoController
{
	@FXML
	private Label titleAlert, titleEventLabel, descriptionEventLabel, conseqEventLabel;
	
	@FXML
	private Button okButton;
	
	@FXML
	public void initialize()
	{
		titleEventLabel.setText(TabuleiroController.getUltimoEvento().getTitulo());
		descriptionEventLabel.setText(TabuleiroController.getUltimoEvento().getDescricao());
		conseqEventLabel.setText(TabuleiroController.getUltimoEvento().getConsequencia().getTipoConsequencia());
	}
	
	public void isOkClicked()
	{
		okButton.setOnAction(new EventHandler<ActionEvent>()
		{	
			@Override
			public void handle(ActionEvent event)
			{	
				close();	
			}
		});
	}
	
	public void close()
	{
		Stage stage = (Stage) okButton.getScene().getWindow();
		stage.close();
	}
}
