package com.umbrella.scada.view.localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationResources {
	ResourceBundle _spanishResource;
	ResourceBundle _englishResource;
	
	public static final String SPANISHLOCALE = "SP";
	public static final String ENGLISHLOCALE = "EN";

	public LocalizationResources(){
		Locale spanishLocale = new Locale("es", "ES"); // Espa�ol - Espa�a
		Locale englishLocale = new Locale("en", "GB"); // Ingl�s - GB
		_spanishResource = ResourceBundle.getBundle("com.umbrella.scada.view.localization.Resource", spanishLocale);
		_englishResource = ResourceBundle.getBundle("com.umbrella.scada.view.localization.Resource", englishLocale);
	}
	
	public String getLocal(String id, String locale){
		if(locale.compareTo(SPANISHLOCALE) == 0)
			return _spanishResource.getString(id);
		if(locale.compareTo(ENGLISHLOCALE) == 0)
			return _englishResource.getString(id);
		return null;
	}

}
