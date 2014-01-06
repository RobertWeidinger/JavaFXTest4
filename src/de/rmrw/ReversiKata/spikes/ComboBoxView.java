package de.rmrw.ReversiKata.spikes;

import de.rmrw.ReversiKata.model.IFSpielModel;
import de.rmrw.ReversiKata.views.SpielfeldFeldZustand;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ComboBoxView extends VBox {

	private ComboBox<String> comboBox1 = null;

	private ComboBox<String> comboBox2 = null;
	
	private IFSpielModel model = null;


	public ComboBoxView(IFSpielModel model, double spacing) {
		super(spacing);
		setModel(model);
		
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
		this.getChildren().add(new Label("Zustand Feld links"));
		this.getChildren().add(comboBox1);

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
		this.getChildren().add(new Label("Zustand Feld rechts"));
		this.getChildren().add(comboBox2);
		
	}

	public ComboBox<String> getComboBox1() {
		return comboBox1;
	}

	public void setComboBox1(ComboBox<String> comboBox1) {
		this.comboBox1 = comboBox1;
	}

	public ComboBox<String> getComboBox2() {
		return comboBox2;
	}

	public void setComboBox2(ComboBox<String> comboBox2) {
		this.comboBox2 = comboBox2;
	}

	public IFSpielModel getModel() {
		return model;
	}

	public void setModel(IFSpielModel model) {
		this.model = model;
	}


	public void update(){
		comboBox1.setValue(model.getFeldZustand(0, 0).getName());
		comboBox2.setValue(model.getFeldZustand(0, 1).getName());
	}
	
}
