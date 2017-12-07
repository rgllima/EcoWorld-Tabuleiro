package game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application
{
	private static Stage primaryStage;
	private Pane rootLayout;

	@Override
	public void start(Stage primaryStage)
	{
		Main.primaryStage = primaryStage;
		primaryStage.setTitle("EcoWorld");

		initRootLayout();
	}
	/**
	 * Inicia o root layout (layout básico)
	 */
	private void initRootLayout()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/views/Main.fxml"));
//			loader.setLocation(Main.class.getResource("/views/Tabuleiro.fxml"));//retirar isso
			rootLayout = (Pane) loader.load();

			Scene scene = new Scene (rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	/**
	 * Exibe a tela de adição de players. É chamada na MainController
	 */
	public static void showAddPlayers()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/views/AddPlayers.fxml"));
			Pane addPlayer = (Pane) loader.load();

			Scene scene = new Scene(addPlayer);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * Exibe o tabuleiro. É chamada na AddPlayerController
	 */
	public static void showTabuleiro()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/views/Tabuleiro.fxml"));
			Pane tabuleiro = (Pane) loader.load();

			Scene scene = new Scene(tabuleiro);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * Run Application
	 * @param args
	 */
	public static void main(String[] args)
	{
		launch(args);
	}	
}
