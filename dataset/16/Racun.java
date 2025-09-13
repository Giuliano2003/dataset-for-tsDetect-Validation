
package fon.rs.np.RentACarZajednickiMaven.domen;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 * Klasa koja predstavlja račun u sistemu Rent-a-Car.
 * Račun se koristi za izdavanje finansijskih dugovanja korisnika vezanih za iznajmljivanje vozila.
 * Svaki račun ima jedinstven identifikator, datum izdavanja, cenu bez PDV-a, iznos PDV-a, cenu sa PDV-om,
 * korisnika kome je izdat račun i listu stavki računa.
 * Nasleđuje apstraktnu klasu OpstiObjekat.
 * 
 * @author Boris Zivanovic
 */

public class Racun extends OpstiObjekat {
	/**
	 * Identifikator racuna
	 */
    private Long id;
    /**
     * Datum izdavanja racuna
     */
    private Date datumIzdavanja;
    /**
     * Cena bez PDV-a za iznajmljeno vozilo
     */
    private double cenaBezPDV;
    /**
     * PDV-a za iznajmljeno vozilo
     */
    private double PDV;
    /**
     * Cena sa PDV-om za iznajmljeno vozilo
     */
    private double cenaSaPDV;
    /**
     * Korisnik kome se izdaje racun
     */
    private Korisnik korisnik;
    /**
     * Lista stavki racuna koje se nalaze u racunu
     */
    private List<StavkaRacuna> stavkaRacuna;

    /**
     * Konstruktor koji inicijalizuje objekat Račun sa svim atributima.
     *
     * @param id                identifikator računa
     * @param datumIzdavanja    datum izdavanja računa
     * @param cenaBezPDV        cena bez PDV-a
     * @param PDV               iznos PDV-a
     * @param cenaSaPDV         cena sa PDV-om
     * @param korisnik          korisnik koji je izdao račun
     * @param stavkaRacuna      lista stavki računa
     */
    
    public Racun(Long id, Date datumIzdavanja, double cenaBezPDV, double PDV, double cenaSaPDV, Korisnik korisnik, List<StavkaRacuna> stavkaRacuna) {
        setId(id);
        setDatumIzdavanja(datumIzdavanja);
        setCenaBezPDV(cenaBezPDV);
        setPDV(PDV);
        setCenaSaPDV(cenaSaPDV);
        setKorisnik(korisnik);
        setStavkaRacuna(stavkaRacuna);
    }
    
    /**
     * Konstruktor koji inicijalizuje objekat Račun bez identifikatora.
     *
     * @param datumIzdavanja    datum izdavanja računa
     * @param cenaBezPDV        cena bez PDV-a
     * @param PDV               iznos PDV-a
     * @param cenaSaPDV         cena sa PDV-om
     * @param korisnik          korisnik koji je izdao račun
     * @param stavkaRacuna      lista stavki računa
     */
    
    public Racun(Date datumIzdavanja, double cenaBezPDV, double PDV, double cenaSaPDV, Korisnik korisnik, List<StavkaRacuna> stavkaRacuna) {
    	setDatumIzdavanja(datumIzdavanja);
        setCenaBezPDV(cenaBezPDV);
        setPDV(PDV);
        setCenaSaPDV(cenaSaPDV);
        setKorisnik(korisnik);
        setStavkaRacuna(stavkaRacuna);
    }
    
    /**
     * Konstruktor koji inicijalizuje objekat Račun sa datim identifikatorom.
     *
     * @param id identifikator računa
     */
    
    public Racun(Long id) {
        setId(id);
    }

    /**
     * Getter za ID racuna.
     * 
     * @return ID racuna
     */
    
    public Long getId() {
        return id;
    }

    /**
     * Setter za ID racuna.
     * 
     * @param id ID racuna
     * @throws IllegalArgumentException Ako je pruženi ID negativan.
     */
    
    public void setId(Long id) {
    	if(id < 0)
            throw new IllegalArgumentException("Id ne sme biti negativan broj");
        this.id = id;
    }

    /**
     * Getter za datum izdavanja racuna.
     * 
     * @return datum izdavanja racuna
     */
    
    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    /**
     * Setter za datum izdavanja racuna.
     * 
     * @param datumIzdavanja datum izdavanja racuna
     * @throws IllegalArgumentException Ako je pruženi datum posle trenutnog datuma
     */
    
    public void setDatumIzdavanja(Date datumIzdavanja) {
    	Date currentDate = new Date();
        if (datumIzdavanja.after(currentDate)) 
            throw new IllegalArgumentException("Datum ne sme biti posle danasnjeg!");
        this.datumIzdavanja = datumIzdavanja;
    }

    /**
     * Getter za cenu bez PDV-a.
     * 
     * @return cena bez PDV-a
     */
    
    public double getCenaBezPDV() {
        return cenaBezPDV;
    }

    /**
     * Setter za cenu bez PDV-a.
     * 
     * @param cenaBezPDV cena bez PDV-a
     * @throws IllegalArgumentException Ako je cena bez PDV-a negativna.
     */
    
    public void setCenaBezPDV(double cenaBezPDV) {
    	if(cenaBezPDV < 0)
            throw new IllegalArgumentException("Cena bez PDV-a ne sme biti negativan broj");
        this.cenaBezPDV = cenaBezPDV;
    }

    /**
     * Getter za PDV.
     * 
     * @return PDV
     */
    
    public double getPDV() {
        return PDV;
    }

    /**
     * Setter za PDV.
     * 
     * @param PDV PDV
     * @throws IllegalArgumentException Ako je iznos PDV-a negativan.
     */
    
    public void setPDV(double PDV) {
    	if(PDV < 0)
            throw new IllegalArgumentException("Pdv ne sme biti negativan broj");
        this.PDV = PDV;
    }

    /**
     * Getter za cenu sa PDV-om.
     * 
     * @return cena sa PDV-om
     */
    
    public double getCenaSaPDV() {
        return cenaSaPDV;
    }

    /**
     * Setter za cenu sa PDV-om.
     * 
     * @param cenaSaPDV cena sa PDV-om
     * @throws IllegalArgumentException Ako je puna cena negativna.
     */
    
    public void setCenaSaPDV(double cenaSaPDV) {
    	if(cenaSaPDV < 0)
            throw new IllegalArgumentException("Cena sa Pdv-om ne sme biti negativan broj");
        this.cenaSaPDV = cenaSaPDV;
    }

    /**
     * Getter za korisnika racuna.
     * 
     * @return korisnik racuna
     */
    
    public Korisnik getKorisnik() {
        return korisnik;
    }

    /**
     * Setter za korisnika racuna.
     * 
     * @param korisnik korisnik racuna
     * @throws IllegalArgumentException Ako je korisnik null ili ima nevažeće atribute.
     */
    
    public void setKorisnik(Korisnik korisnik) {
    	if(korisnik == null || korisnik.getId() == 0 || korisnik.getIme().equals("") || korisnik.getPrezime().equals("") || korisnik.getJMBG() == 0 || korisnik.getMesto() == null || korisnik.getDatumRodjenja() == null)
    		throw new IllegalArgumentException("Korisnik mora biti inicijalizovan");
        this.korisnik = korisnik;
    }

    /**
     * Getter za listu stavki racuna.
     * 
     * @return lista stavki racuna
     */
    
    public List<StavkaRacuna> getStavkaRacuna() {
        return stavkaRacuna;
    }

    /**
     * Setter za listu stavki racuna.
     * 
     * @param stavkaRacuna lista stavki racuna
     * @throws IllegalArgumentException ako je lista stavki prazna
     */
    
    public void setStavkaRacuna(List<StavkaRacuna> stavkaRacuna) {
    	if(stavkaRacuna.isEmpty())
    		throw new IllegalArgumentException("Lista ne sme biti prazna");
        this.stavkaRacuna = stavkaRacuna;
    }
    
    @Override
    public String vratiTabelu() {
        return "racun";
    }

    @Override
    public String vratiKolone() {
        return "";
    }

    @Override
    public String insertKolone() {
        return "datum_izdavanja,cena_bez_pdv, pdv, cena_sa_pdv, id_korisnika";
    }

    @Override
    public String dajVrednosti() {
        return "('" + getDatumIzdavanja() + "'," + getCenaBezPDV() + "," + getPDV() + "," + getCenaSaPDV() + "," + 
                getKorisnik().getId() + ")";
    }

    @Override
    public List<OpstiObjekat> dajListu(ResultSet rs) {
        return null;
    }

    @Override
    public String whereUslov() {
        return "";
    }

    @Override
    public String whereSelectUslov() {
        return "";
    }

    @Override
    public String izmenaObjekta() {
        return "";
    }
    
}
