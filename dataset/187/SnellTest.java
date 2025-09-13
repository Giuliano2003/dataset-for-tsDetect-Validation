import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;
public class PetTest {
	  private PetCadastro petCadastro;
    private PetArmazena petArmazena;
    Pet pet1;
    
    @Before
    public void init() {
    	 petArmazena =  new PetArmazena();
    	 petCadastro = new PetCadastro(petArmazena);
    }
    
    @Test
    public void CamposEmBranco() {
    	assertTrue(petArmazena.getPets().isEmpty());
    }
  
    
    @Test
    public void testSalvarPet() {
        petArmazena.salvarPet(pet1);
        assertEquals(1, petArmazena.getPets().size());
        assertFalse(petArmazena.getPets().isEmpty());
        
    }
}