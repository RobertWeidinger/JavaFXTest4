package de.rmrw.ReversiKata.spikes;

import java.util.ArrayList;

import de.rmrw.ReversiKata.model.IFSpielModel;
import de.rmrw.ReversiKata.views.IFSpielView;
import de.rmrw.ReversiKata.views.SpielfeldFeldZustand;

public class SpielModel implements IFSpielModel {
	
	ArrayList<IFSpielView> views = null;
	SpielfeldFeldZustand zustand1 = null;
	SpielfeldFeldZustand zustand2 = null;

	public SpielModel() {
		views = new ArrayList<IFSpielView>();
		zustand1 = SpielfeldFeldZustand.LEER_UND_NICHT_BESETZBAR;
		zustand2 = SpielfeldFeldZustand.LEER_UND_NICHT_BESETZBAR;
		updateViews();
	}

	@Override
	public void besetzeFeld(int zeile, int spalte, int spielerNummer) {
		if (spalte==0)
			zustand1 = (spielerNummer==1) ? SpielfeldFeldZustand.BESETZT1 : SpielfeldFeldZustand.BESETZT2;
		else 
			zustand2 = (spielerNummer==1) ? SpielfeldFeldZustand.BESETZT1 : SpielfeldFeldZustand.BESETZT2;
		updateViews();
	}

	@Override
	public SpielfeldFeldZustand getFeldZustand(int zeile, int spalte) {
		if (spalte==0)
			return zustand1;
		return zustand2;
	}

	@Override
	public void addView(IFSpielView view) {
		views.add(view);
	}
	
	public void setFeldZustand(int zeile, int spalte, SpielfeldFeldZustand zustand){
		if (spalte==0)
			zustand1 = zustand;
		else
			zustand2 = zustand;
		updateViews();
	}

	private void updateViews() {
		for (IFSpielView spielView : views) {
			spielView.update();
		}
	}
	

}
