package de.rmrw.ReversiKata.view.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javafx.scene.paint.Color;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import de.rmrw.ReversiKata.model.IFSpielModel;
import de.rmrw.ReversiKata.views.JavaFXSpielfeldFeld2;
import de.rmrw.ReversiKata.views.JavaFXSpielfeldFeldProperties;
import de.rmrw.ReversiKata.views.JavaFXSpielfeldFeldView;
import de.rmrw.ReversiKata.views.SpielfeldFeldZustand;


public class JavaFXSpielfeldFeldViewTest {
	
	private static final Color ANGEDEUTETEFARBESPIELER2 = Color.LIGHTCORAL;
	private static final Color ANGEDEUTETEFARBESPIELER1 = Color.LIGHTBLUE;
	private static final Color FARBESPIELER2 = Color.RED;
	private static final Color FARBESPIELER1 = Color.BLUE;
	private static final Color GRUNDFARBE = Color.BEIGE;
	private IFSpielModel 				mockModel = null;
	private JavaFXSpielfeldFeldView 	spyFeld = null;
	
	private JavaFXSpielfeldFeldProperties 	spielfeldFeldProperties = null;
	private JavaFXSpielfeldFeld2 			mockFeldIntern = null;
	
	@Before
	public void setUp() throws Exception {
		mockModel = mock(IFSpielModel.class);
		spielfeldFeldProperties = new JavaFXSpielfeldFeldProperties(50,            // Groesse
																	GRUNDFARBE,   // Grundfarbe
																	FARBESPIELER1,    // Farbe Spieler1
																	FARBESPIELER2,     // Farbe Spieler2
																	ANGEDEUTETEFARBESPIELER1, // Angedeutete Farbe Sp1
																	ANGEDEUTETEFARBESPIELER2  // Angedeutete Farbe Sp2
																	);
		spyFeld = spy(new JavaFXSpielfeldFeldView(mockModel,     // Modell zum View
				1,             // Zeile
				0,             // Spalte
				spielfeldFeldProperties
				));
		mockFeldIntern = mock(JavaFXSpielfeldFeld2.class);
		Mockito.doReturn(mockFeldIntern).when(spyFeld).createJavaFXSpielfeldFeld2();
		spyFeld.init();
	}

	@Test
	public final void testKonstruktorUndInit() {
		Mockito.when(mockFeldIntern.getCircleColor()).thenReturn(Color.GOLD);
		Assert.assertEquals(Color.GOLD, spyFeld.getActiveColor());
	}
	
	@Test
	public final void testUpdate(){

		when(mockModel.getFeldZustand(1, 0)).thenReturn(SpielfeldFeldZustand.LEER_UND_BESETZBAR1);
		spyFeld.update();
		verify(mockFeldIntern).setZustand(SpielfeldFeldZustand.LEER_UND_BESETZBAR1);
	}
	
	@Test
	public final void testComponentChanges(){
		JavaFXSpielfeldFeldView spyFeld2 = spy(new JavaFXSpielfeldFeldView(mockModel,     // Modell zum View
				2,             // Zeile
				0,             // Spalte
				spielfeldFeldProperties
				));
		JavaFXSpielfeldFeld2 feldIntern2 = new JavaFXSpielfeldFeld2(spielfeldFeldProperties);
		Mockito.doReturn(feldIntern2).when(spyFeld2).createJavaFXSpielfeldFeld2();
		spyFeld2.init();
		
		when(mockModel.getFeldZustand(2, 0)).thenReturn(SpielfeldFeldZustand.LEER_UND_BESETZBAR2);
		
		spyFeld2.update();
		feldIntern2.onMousePressed();
		verify(mockModel).besetzeFeld(2, 0, 2);
	}
	
}
