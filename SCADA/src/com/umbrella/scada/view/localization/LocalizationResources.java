package com.umbrella.scada.view.localization;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationResources {

	public LocalizationResources(){
		Locale spanishLocale = new Locale("es", "ES"); // Espa�ol - Espa�a
		Locale englishLocale = new Locale("en", "GB"); // Ingl�s - GB
		ResourceBundle SpanishResource = ResourceBundle.getBundle("com.umbrella.scada.view.localization.Resource", spanishLocale);
		ResourceBundle EnglishResource = ResourceBundle.getBundle("com.umbrella.scada.view.localization.Resource", englishLocale);
	}

}
