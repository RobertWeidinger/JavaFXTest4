package de.rmrw.ReversiKata.spikes;

import de.rmrw.ReversiKata.model.IFSpielModel;
import de.rmrw.ReversiKata.views.JavaFXSpielfeldFeld;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class SpielfeldView extends GridPane {

	private static final Color ANGEDEUTETEFARBESPIELER2 = Color.LIGHTCORAL;
	private static final Color ANGEDEUTETEFARBESPIELER1 = Color.LIGHTBLUE;
	private static final Color FARBESPIELER2 = Color.RED;
	private static final Color FARBESPIELER1 = Color.BLUE;
	private static final Color GRUNDFARBE = Color.DARKGRAY;
	private JavaFXSpielfeldFeld feld1;
	private JavaFXSpielfeldFeld feld2;

	public SpielfeldView(IFSpielModel model) {
		super();
		this.setHgap(4);
		this.setVgap(4);
	
		feld1 = new JavaFXSpielfeldFeld(model,         // Modell zum View
								0,             // Zeile
								0,             // Spalte
								30,            // Groesse
								GRUNDFARBE,    // Grundfarbe
								FARBESPIELER1,     // Farbe Spieler1
								FARBESPIELER2,     // Farbe Spieler2
								ANGEDEUTETEFARBESPIELER1, // Angedeutete Farbe Sp1
								ANGEDEUTETEFARBESPIELER2  // Angedeutete Farbe Sp2
								);
		getChildren().add(feld1);
		GridPane.setColumnIndex(feld1, 0);
		GridPane.setRowIndex(feld1, 0);

		feld2 =  new JavaFXSpielfeldFeld(model,         // Modell zum View
										0,             // Zeile
										1,             // Spalte
										30,            // Groesse
										GRUNDFARBE,    // Grundfarbe
										FARBESPIELER1,     // Farbe Spieler1
										FARBESPIELER2,     // Farbe Spieler2
										ANGEDEUTETEFARBESPIELER1, // Angedeutete Farbe Sp1
										ANGEDEUTETEFARBESPIELER2  // Angedeutete Farbe Sp2
										);
		getChildren().add(feld2);
		GridPane.setColumnIndex(feld2, 1);
		GridPane.setRowIndex(feld2, 0);

	}
	
	public JavaFXSpielfeldFeld getFeld1() {
		return feld1;
	}

	public JavaFXSpielfeldFeld getFeld2() {
		return feld2;
	}

	public void update(){
		System.out.println("SpielfeldView.update()");
		for (Node n : getChildren()) {
			((JavaFXSpielfeldFeld)n).update();
		}
	}

}
