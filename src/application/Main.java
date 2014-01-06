package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import de.rmrw.ReversiKata.spikes.SpielModel;
import de.rmrw.ReversiKata.spikes.SpielView;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			SpielModel model = new SpielModel();
			SpielView root = new SpielView(model);
			model.addView(root);
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
