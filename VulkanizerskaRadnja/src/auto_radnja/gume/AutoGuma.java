package auto_radnja.gume;
/**
 * Klasa koja predstavlja gumu na autu
 * 
 * AutoGuma poseduje precnik, sirinu i visinu kao int vrednosti,
 * kao i markaModel kao String vrednost.
 *
 * 
 * @author Uros Soljaga
 * @version 0.1
 */

public class AutoGuma {
	
	/**
	 * Marka i model automobila kao String.
	 */
	private String markaModel = null;
	/**
	 * Precnik gume kao int.
	 */
	private int precnik = -1;
	/**
	 * Sirina gume kao int.
	 */
	private int sirina = -1;
	/**
	 * Visina gume kao int.
	 */
	private int visina = -1;

	/**
	 * Neparametrizovani kostruktor koji inicijalizuje objekat.
	 */
	public AutoGuma() {
		
	}

	/**
	 * Parametrizovani konstruktor koji inicijalizuje objekat i postavlja vrednosti za sve njene atribute.
	 * 
	 * @param markaModel Marka i model gume kao String.
	 * @param precnik Precnik gume kao int.
	 * @param sirina Sirina gume kao int.
	 * @param visina Visina gume kao int.
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}

	/**
	 * Vraca marku i model gume kao String.
	 * 
	 * @return Marka i model gume kao String.
	 */
	public String getMarkaModel() {
		return markaModel;
	}
	
	/**
	 * Postavlja marku i model gume na novu vrednost.
	 * 
	 * @param markaModel Marka i model gume kao String.
	 * 
	 * @throws java.lang.NullPointerException Ako je uneta marka i model null.
	 * @throws java.lang.IllegalArgumentException Ako je uneta marka i model kraca od 3 karaktera.
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length()<3)
			throw new IllegalArgumentException
			("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}
	
	/**
	 * Vraca precnik gume kao int.
	 * 
	 * @return Precnik gume kao int.
	 */
	public int getPrecnik() {
		return precnik;
	}
	
	/**
	 * Postavlja precnik gume na novu vrednost.
	 * 
	 * @param precnik Precnik gume kao String.
	 * 
	 * @throws java.lang.IllegalArgumentException Ako je unet precnik manji od 13 ili veci od 22.
	 */
	public void setPrecnik(int precnik) {
		if (precnik > 22 || precnik < 13)
			throw new IllegalArgumentException("Precnik van opsega");
		this.precnik = precnik;
	}
	
	/**
	 * Vraca sirinu gume kao int.
	 * 
	 * @return Sirina gume kao int.
	 */
	public int getSirina() {
		return sirina;
	}
	
	/**
	 * Postavlja sirinu gume na novu vrednost.
	 * 
	 * @param sirina Sirina gume kao String.
	 * 
	 * @throws java.lang.IllegalArgumentException Ako je uneta sirina manja od 135 ili veca od 355.
	 */
	public void setSirina(int sirina) {
		if (sirina > 355 || sirina < 135)
			throw new IllegalArgumentException("Sirina van opsega");
		this.sirina = sirina;
	}
	
	/**
	 * Vraca visinu gume kao int.
	 * 
	 * @return Visina gume kao int.
	 */
	public int getVisina() {
		return visina;
	}
	
	/**
	 * Postavlja visinu gume na novu vrednost.
	 * 
	 * @param visina Visina gume kao String.
	 * 
	 * 
	 * @throws java.lang.IllegalArgumentException Ako je uneta visina manja od 25 ili veca od 95.
	 */
	public void setVisina(int visina) {
		if (visina > 95 || visina < 25)
			throw new IllegalArgumentException("Visina van opsega");
		this.visina = visina;
	}
	
	/**
	 * Vraca String sa svim podacima o gumi.
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik +
				", sirina=" + sirina + ", visina=" + visina + "]";
	}
	
	/**
	 * Poredi dve gume i vraca true ako su iste, a false ako su razlicite.
	 * 
	 * Gume se porede po modelu i marki, profilu, sirini i visini i svi moraju da budu isti.
	 * 
	 * @return 
	 * <ul>
	 * 		<li>true ako su oba objekta klase AutoGuma i imaju istu marku i model, isti profil, visinu i sirinu</li>
	 * 		<li>false u svim ostalim slucajevima</li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}
}