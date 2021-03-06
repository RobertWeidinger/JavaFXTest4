package de.rmrw.ReversiKata.view.test;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.paint.Color;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.rmrw.ReversiKata.views.JavaFXSpielfeldFeld2;
import de.rmrw.ReversiKata.views.JavaFXSpielfeldFeldProperties;
import de.rmrw.ReversiKata.views.SpielfeldFeldZustand;


public class JavaFXSpielfeldFeld2Test {
	
	private static final Color ANGEDEUTETEFARBESPIELER2 = Color.LIGHTCORAL;
	private static final Color ANGEDEUTETEFARBESPIELER1 = Color.LIGHTBLUE;
	private static final Color FARBESPIELER2 = Color.RED;
	private static final Color FARBESPIELER1 = Color.BLUE;
	private static final Color GRUNDFARBE = Color.BEIGE;
	private JavaFXSpielfeldFeld2 feld = null;
	
	private JavaFXSpielfeldFeldProperties 	spielfeldFeldProperties = null;
	private boolean changed=false;
	
	@Before
	public void setUp() throws Exception {
		spielfeldFeldProperties = new JavaFXSpielfeldFeldProperties(50,            // Groesse
																	GRUNDFARBE,   // Grundfarbe
																	FARBESPIELER1,    // Farbe Spieler1
																	FARBESPIELER2,     // Farbe Spieler2
																	ANGEDEUTETEFARBESPIELER1, // Angedeutete Farbe Sp1
																	ANGEDEUTETEFARBESPIELER2  // Angedeutete Farbe Sp2
																	);
		feld = new JavaFXSpielfeldFeld2(spielfeldFeldProperties
										);
		feld.addListener(new ChangeListener<SpielfeldFeldZustand>() {
 
			@Override
			public void changed(
					ObservableValue<? extends SpielfeldFeldZustand> observable,
					SpielfeldFeldZustand oldValue, SpielfeldFeldZustand newValue) {
				changed=true;
				
			}    
        });
	}

	@Test
	public final void testKonstruktor() {
		Assert.assertEquals(Color.TRANSPARENT, feld.getCircleColor());
	}
	
	@Test
	public final void testOnMouseEnterAndExit() {
		feld.onMouseEnter();
		Assert.assertEquals(Color.TRANSPARENT, feld.getCircleColor());
		feld.onMouseExited();
		
		//when(mockModel.getFeldZustand(0, 0)).thenReturn(SpielfeldFeldZustand.LEER_UND_BESETZBAR1);
		feld.setZustand(SpielfeldFeldZustand.LEER_UND_BESETZBAR1);
		feld.onMouseEnter();
		Assert.assertEquals(ANGEDEUTETEFARBESPIELER1, feld.getCircleColor());
		feld.onMouseExited();
		Assert.assertEquals(Color.TRANSPARENT, feld.getCircleColor());

//		when(mockModel.getFeldZustand(0, 0)).thenReturn(SpielfeldFeldZustand.LEER_UND_BESETZBAR2);
		feld.setZustand(SpielfeldFeldZustand.LEER_UND_BESETZBAR2);
		feld.onMouseEnter();
		Assert.assertEquals(ANGEDEUTETEFARBESPIELER2, feld.getCircleColor());
		feld.onMouseExited();
		Assert.assertEquals(Color.TRANSPARENT, feld.getCircleColor());

//		when(mockModel.getFeldZustand(0, 0)).thenReturn(SpielfeldFeldZustand.BESETZT1);
		feld.setZustand(SpielfeldFeldZustand.BESETZT1);
		Assert.assertEquals(FARBESPIELER1, feld.getCircleColor());
		feld.onMouseEnter();
		Assert.assertEquals(FARBESPIELER1, feld.getCircleColor());
		feld.onMouseExited();
		Assert.assertEquals(FARBESPIELER1, feld.getCircleColor());
	}
	
	@Test
	public final void testOnMousePressed() {
		feld.onMousePressed();
//		verify(mockModel, times(0)).besetzeFeld(anyInt(),anyInt(),anyInt());
		Assert.assertFalse(changed);
		
//		when(mockModel.getFeldZustand(0, 0)).thenReturn(SpielfeldFeldZustand.LEER_UND_BESETZBAR2);
		feld.setZustand(SpielfeldFeldZustand.LEER_UND_BESETZBAR2);
		feld.onMousePressed();
//		verify(mockModel).besetzeFeld(0,0,2);
		Assert.assertTrue(changed);
		Assert.assertEquals(SpielfeldFeldZustand.BESETZT2, feld.getZustand());
	}
	
}
