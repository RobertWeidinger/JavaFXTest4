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
	private VBox vBox = null;
	private ComboBox<String> comboBox1 = null;
	private ComboBox<String> comboBox2 = null;
	
	private IFSpielModel model = null;
	
	public SpielView(IFSpielModel model) {
		this.setModel(model);
		setPadding(new Insets(40, 40, 40, 40));
		spielfeldView = new SpielfeldView(model);
		this.setCenter(spielfeldView);
		vBox = new VBox();
		this.setRight(vBox);
		vBox.setSpacing(10);
		
		// ComboBox1 einfügen
		comboBox1 = new ComboBox<String>();
		for (SpielfeldFeldZustand sffz : SpielfeldFeldZustand.values()) {
			comboBox1.getItems().add(sffz.getName());
		}
		comboBox1.setValue(SpielfeldFeldZustand.LEER_UND_NICHT_BESETZBAR.getName());
		comboBox1.valueProperty().addListener(new ChangeListener<String>() {
 
			@Override
			public void changed(ObservableValue<? extends String> arg0,
					String arg1, String arg2) {
				System.out.println("comboBox1.changed("+arg0+", "+arg1+", "+arg2+");");
				((SpielModel)getModel()).setFeldZustand(0, 0, SpielfeldFeldZustand.getZustandFromString(arg2));
			}    
        });
		vBox.getChildren().add(new Label("Zustand Feld links"));
		vBox.getChildren().add(comboBox1);

		// ComboBox2 einfügen
		comboBox2 = new ComboBox<String>();
		for (SpielfeldFeldZustand sffz : SpielfeldFeldZustand.values()) {
			comboBox2.getItems().add(sffz.getName());
		}
		comboBox2.setValue(SpielfeldFeldZustand.LEER_UND_NICHT_BESETZBAR.getName());
		comboBox2.valueProperty().addListener(new ChangeListener<String>() {
 
			@Override
			public void changed(ObservableValue<? extends String> arg0,
					String arg1, String arg2) {
				System.out.println("comboBox2.changed("+arg0+", "+arg1+", "+arg2+");");
				((SpielModel)getModel()).setFeldZustand(0, 1, SpielfeldFeldZustand.getZustandFromString(arg2));
			}    
        });
		vBox.getChildren().add(new Label("Zustand Feld rechts"));
		vBox.getChildren().add(comboBox2);

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
		comboBox1.setValue(model.getFeldZustand(0, 0).getName());
		comboBox2.setValue(model.getFeldZustand(0, 1).getName());
		spielfeldView.update();
	}

}
