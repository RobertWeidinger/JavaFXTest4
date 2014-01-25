package de.rmrw.ReversiKata.spikes.test;

import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.rmrw.ReversiKata.spikes.ComboBoxView;
import de.rmrw.ReversiKata.spikes.SpielModel;
import de.rmrw.ReversiKata.spikes.SpielView;
import de.rmrw.ReversiKata.spikes.SpielfeldView;
import de.rmrw.ReversiKata.views.JavaFXSpielfeldFeld;
import de.rmrw.ReversiKata.views.SpielfeldFeldZustand;
import JavaFXUnitTestHelpers.JavaFXThreadingRule;

public class TestSpielView_WithRule {
	
	@org.junit.Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();

	private SpielModel spielModel= null;
	private SpielView spielView = null;

	
	@Before
	public void setUp() throws Exception {
 	   	Stage primaryStage = new Stage();
		try {
		spielModel = new SpielModel();
		spielView = new SpielView(spielModel);
		spielModel.addView(spielView);
		Scene scene = new Scene(spielView,600,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void testInitialization() {
		SpielfeldView spielfeldView = spielView.getSpielfeldView();
		JavaFXSpielfeldFeld feld1 = spielfeldView.getFeld1();
		Assert.assertEquals(Color.TRANSPARENT,feld1.getCircleColor());
	}

	
	@Test
	public final void testWechsleZustand() {
		SpielfeldView spielfeldView = spielView.getSpielfeldView();
		JavaFXSpielfeldFeld feld1 = spielfeldView.getFeld1();
		ComboBoxView comboBoxView =  spielView.getComboBoxView();
		ComboBox<String> comboBox1 = comboBoxView.getComboBox1();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		comboBox1.setValue(SpielfeldFeldZustand.BESETZT1.getName());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(Color.BLUE,feld1.getCircleColor());
	}
	

}
