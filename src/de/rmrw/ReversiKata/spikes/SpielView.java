package de.rmrw.ReversiKata.spikes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import de.rmrw.ReversiKata.model.IFSpielModel;
import de.rmrw.ReversiKata.views.IFSpielView;
import de.rmrw.ReversiKata.views.SpielfeldFeldZustand;

public class SpielView extends BorderPane implements IFSpielView {

	private SpielfeldView spielfeldView = null;
	private ComboBoxView comboBoxView = null;
	
	private IFSpielModel model = null;
	
	public SpielView(IFSpielModel model) {
		this.setModel(model);
		setPadding(new Insets(40, 40, 40, 40));
		spielfeldView = new SpielfeldView(model);
		this.setCenter(spielfeldView);
		comboBoxView = new ComboBoxView(model, 10);
		
		this.setRight(comboBoxView);
	}

	public IFSpielModel getModel() {
		return model;
	}

	private void setModel(IFSpielModel _model) {
		this.model = _model;
	}

	@Override
	public void update() {
		System.out.println("SpielView.update()");
		spielfeldView.update();
		comboBoxView.update();
	}

}
