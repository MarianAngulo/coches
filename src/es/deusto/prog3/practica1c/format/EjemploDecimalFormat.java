/**
 * This code has been adapted from this github repo:
 * https://github.com/unaguil/prog3-ejemplos-codigo/tree/master/tema1/tema1C
 * 
 * Thanks to: Unai Aguilera (https://github.com/unaguil) 
 */
package es.deusto.prog3.practica1c.format;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

// Este ejemplo muestra las clases de utilidad para 
// realizar el formateo adecuado en distintos datos según
// la localización.

public class EjemploDecimalFormat {

	public static void main(String[] args) {
		// Los _ se pueden usar para leer mejor los números largos
		double doubleNumber = 1_234_567.89;

		DecimalFormat dfLocale = new DecimalFormat();
		NumberFormat nfUS = DecimalFormat.getNumberInstance(Locale.US);
		DecimalFormat dfManual = new DecimalFormat("0");
		DecimalFormat dfManualConDecimales = new DecimalFormat("0.000");

		System.out.println("Formato local: " + dfLocale.format(doubleNumber));
		System.out.println("Formato US: " + nfUS.format(doubleNumber));
		System.out.println("Formato adhoc entero: " + dfManual.format(doubleNumber));
		System.out.println("Formato adhoc decimal: " + dfManualConDecimales.format(doubleNumber));
		
		//Ver documentación de java.util.Formatter
		System.out.println("Formato a través de " + String.format("String.format(): #%1$5d# vs. #%2$,12.1f#", 123, doubleNumber));
	}
}