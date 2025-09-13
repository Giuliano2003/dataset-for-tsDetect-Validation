package fon.rs.np.RentACarZajednickiMaven.domen;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class KorisnikTest {

	private Korisnik korisnik;
    private Mesto mesto;

    @BeforeEach
    public void setUp() {
        Long id = 1L;
        String ime = "Marko";
        String prezime = "Markovic";
        Long jmbg = 1234567890123L;
        String datumRodjenjaStr = "1990-01-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date datumRodjenja = null;
        try {
            datumRodjenja = sdf.parse(datumRodjenjaStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mesto = new Mesto(1L, "Beograd");

        korisnik = new Korisnik(id, ime, prezime, jmbg, datumRodjenja, mesto);
    }

    @AfterEach
    public void tearDown() {
        korisnik = null;
        mesto = null;
    }
    
    @Test
    public void testKonstruktorSaSvimAtributima() {
        Long id = korisnik.getId();
        String ime = korisnik.getIme();
        String prezime = korisnik.getPrezime();
        Long jmbg = korisnik.getJMBG();
        Date datumRodjenja = korisnik.getDatumRodjenja();
        Mesto mesto = korisnik.getMesto();

        assertNotNull(korisnik);
        assertEquals(id, korisnik.getId());
        assertEquals(ime, korisnik.getIme());
        assertEquals(prezime, korisnik.getPrezime());
        assertEquals(jmbg, korisnik.getJMBG());
        assertEquals(datumRodjenja, korisnik.getDatumRodjenja());
        assertEquals(mesto, korisnik.getMesto());
    }
    
    @Test
    public void testKonstruktorSaImenomIPrezimenom() {
        String ime = "Ana";
        String prezime = "Anic";
        Long jmbg = 9876543210987L;
        Date datumRodjenja = korisnik.getDatumRodjenja();

        Korisnik korisnik = new Korisnik(ime, prezime, jmbg, datumRodjenja, mesto);

        assertNotNull(korisnik);
        assertNull(korisnik.getId());
        assertEquals(ime, korisnik.getIme());
        assertEquals(prezime, korisnik.getPrezime());
        assertEquals(jmbg, korisnik.getJMBG());
        assertEquals(datumRodjenja, korisnik.getDatumRodjenja());
        assertEquals(mesto, korisnik.getMesto());
    }
    
    
    @Test
    public void testToString() {
        Korisnik korisnik = new Korisnik("Marko", "Markovic");
        String expectedString = "Marko Markovic";
        String actualString = korisnik.toString();
        assertEquals(expectedString, actualString);
    }
    
}