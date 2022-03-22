package auto_radnja;

import java.util.List;
import auto_radnja.gume.AutoGuma;
/**
 * Predstavlja interfejs radnje
 * 
 * Ima osnovne operacije za dodavanje gume, pronalazak guma i vracanje svih guma iz liste
 * 
 * 
 * @author Uros Soljaga
 * @version 0.2
 *
 */
public interface Radnja {
	/**
	 * Matoda koja dodaje gumu u listu
	 * 
	 * @param a Nova guma koja se dodaje kao AutoGuma
	 * 
	 * @throws java.lang.NullPointerException ako je uneta guma null
	 * @throws java.lang.RuntimeException ako guma vec postoji u listi
	 */
	void dodajGumu(AutoGuma a);
	
	
	/**
	 * Metoda koja pretrazuje listu po marki i modelu
	 * @param markaModel Marka i model kao String
	 * @return 
	 * <ul>
	 * 		<li> null - ako je unesen String null</li>
	 * 		<li> novaLista - Listu sa svim gumama sa istom markom i modelom kao LinkedList</li>
	 * </ul>
	 * 
	 */
	List<AutoGuma> pronadjiGumu(String markaModel);
	/**
	 * Metoda koja vraca sve gume
	 * @return gume Listu svih guma kao LinkedList
	 */
	List<AutoGuma> vratiSveGume();
}