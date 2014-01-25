package de.rmrw.ReversiKata.spikes;

import de.rmrw.ReversiKata.model.IFSpielModel;
import de.rmrw.ReversiKata.views.JavaFXSpielfeldFeld;
import de.rmrw.ReversiKata.views.JavaFXSpielfeldFeld2;
import de.rmrw.ReversiKata.views.JavaFXSpielfeldFeldProperties;
import de.rmrw.ReversiKata.views.JavaFXSpielfeldFeldView;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class SpielfeldView extends GridPane {

	private static final Color ANGEDEUTETEFARBESPIELER2 = Color.LIGHTCORAL;
	private static final Color ANGEDEUTETEFARBESPIELER1 = Color.LIGHTBLUE;
	private static final Color FARBESPIELER2 = Color.RED;
	private static final Color FARBESPIELER1 = Color.BLUE;
	private static final Color GRUNDFARBE = Color.DARKGRAY;
	private JavaFXSpielfeldFeldView feld1;
	private JavaFXSpielfeldFeldView feld2;

	public SpielfeldView(IFSpielModel model) {
		super();
		this.setHgap(4);
		this.setVgap(4);
	
		feld1 = new JavaFXSpielfeldFeldView(model,         // Modell zum View
										0,             // Zeile
										0,             // Spalte
										new JavaFXSpielfeldFeldProperties( 30,            // Groesse
																			GRUNDFARBE,    // Grundfarbe
																			FARBESPIELER1,     // Farbe Spieler1
																			FARBESPIELER2,     // Farbe Spieler2
																			ANGEDEUTETEFARBESPIELER1, // Angedeutete Farbe Sp1
																			ANGEDEUTETEFARBESPIELER2  // Angedeutete Farbe Sp2
																			)
								);
		feld1.init();
		getChildren().add(feld1);
		GridPane.setColumnIndex(feld1, 0);
		GridPane.setRowIndex(feld1, 0);

		feld2 =  new JavaFXSpielfeldFeldView(model,         // Modell zum View
										0,             // Zeile
										1,             // Spalte
										new JavaFXSpielfeldFeldProperties( 30,            // Groesse
												GRUNDFARBE,    // Grundfarbe
												FARBESPIELER1,     // Farbe Spieler1
												FARBESPIELER2,     // Farbe Spieler2
												ANGEDEUTETEFARBESPIELER1, // Angedeutete Farbe Sp1
												ANGEDEUTETEFARBESPIELER2  // Angedeutete Farbe Sp2
												)
										);
		feld2.init();
		getChildren().add(feld2);
		GridPane.setColumnIndex(feld2, 1);
		GridPane.setRowIndex(feld2, 0);

	}
	
	public JavaFXSpielfeldFeldView getFeld1() {
		return feld1;
	}

	public JavaFXSpielfeldFeldView getFeld2() {
		return feld2;
	}

	public void update(){
		System.out.println("SpielfeldView.update()");
		for (Node n : getChildren()) {
			((JavaFXSpielfeldFeldView)n).update();
		}
	}

}
