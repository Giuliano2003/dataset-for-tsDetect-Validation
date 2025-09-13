package fon.rs.np.RentACarZajednickiMaven.domen;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IznajmljivanjeTest {

	private Iznajmljivanje iznajmljivanje;
    
    private Date parseDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	@BeforeEach
	void setUp() throws Exception {
        iznajmljivanje = new Iznajmljivanje();
	}

	@AfterEach
	void tearDown() throws Exception {
		   iznajmljivanje = null;
	}

	 @Test
	    public void testKonstruktorSaId() {
	        Long id = 1L;
	        Mesto mesto = new Mesto(2L, "Kragujevac");
	        Korisnik noviKorisnik = new Korisnik(2L,"Petar","Petrovic",1234567891234L,new Date(),mesto);
	        KategorijaVozila kategorijaVozila = new KategorijaVozila(2L, "limuzina", 2000);
	        Vozilo novoVozilo = new Vozilo(2L,"NS123","Audi","A7",StatusVozila.SLOBODNO,kategorijaVozila);
	        Date datumIznajmljivanja = parseDate("2023-09-10");
	        Date datumVracanja = new Date();

	        Iznajmljivanje iznajmljivanje = new Iznajmljivanje(id, noviKorisnik, novoVozilo, datumIznajmljivanja, datumVracanja);

	        assertEquals(id, iznajmljivanje.getId());
	        assertEquals(noviKorisnik, iznajmljivanje.getKorisnik());
	        assertEquals(novoVozilo, iznajmljivanje.getVozilo());
	        assertEquals(datumIznajmljivanja, iznajmljivanje.getDatumIznajmljivanja());
	        assertEquals(datumVracanja, iznajmljivanje.getDatumVracanja());
	    }
	
	 @Test
	    public void testKonstruktorBezId() {
	        Mesto mesto = new Mesto(2L, "Kragujevac");
	        Korisnik korisnik = new Korisnik(2L,"Petar","Petrovic",1234567891234L,new Date(),mesto);
	        KategorijaVozila kategorijaVozila = new KategorijaVozila(2L, "limuzina", 2000);
	        Vozilo vozilo = new Vozilo(2L,"NS123","Audi","A7",StatusVozila.SLOBODNO,kategorijaVozila);
	        Date datumIznajmljivanja = parseDate("2023-09-11");
	        Date datumVracanja = parseDate("2023-10-11");

	        Iznajmljivanje iznajmljivanje = new Iznajmljivanje(korisnik, vozilo, datumIznajmljivanja, datumVracanja);

	        assertNull(iznajmljivanje.getId());
	        assertEquals(korisnik, iznajmljivanje.getKorisnik());
	        assertEquals(vozilo, iznajmljivanje.getVozilo());
	        assertEquals(datumIznajmljivanja, iznajmljivanje.getDatumIznajmljivanja());
	        assertEquals(datumVracanja, iznajmljivanje.getDatumVracanja());
	    }
	 
	 @Test
	    public void testKonstruktorSaIdIDatumima() {
	        Long id = 1L;
	        Date datumIznajmljivanja = new Date();
	        Date datumVracanja = new Date();

	        Iznajmljivanje iznajmljivanje = new Iznajmljivanje(id, datumIznajmljivanja, datumVracanja);

	        assertEquals(id, iznajmljivanje.getId());
	        assertNull(iznajmljivanje.getKorisnik());
	        assertNull(iznajmljivanje.getVozilo());
	        assertEquals(datumIznajmljivanja, iznajmljivanje.getDatumIznajmljivanja());
	        assertEquals(datumVracanja, iznajmljivanje.getDatumVracanja());
	    }
		 
}