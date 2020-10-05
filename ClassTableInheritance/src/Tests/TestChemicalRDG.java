package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import datasource.ChemicalRDG;

/**
 * 
 * @author Taryn Whitman
 * @author Marlee Lackey
 *
 */

public class TestChemicalRDG {

	/**
	 * test the constructor that makes an object from a tuple already stored in the
	 * database
	 */
	@Test
	public static void constructor1Test() {

		ChemicalRDG chemical = new ChemicalRDG(4, "idk");
		assertEquals(chemical.getChemicalID(), 4);
		assertEquals(chemical.getChemicalName(), "idk");
	}

	/**
	 * Test the find by methods for Chemical RDG
	 * 
	 */
	@Test
	public static void findersTest() {
		ChemicalRDG chem = ChemicalRDG.findByID(5);
		assertEquals(chem.getChemicalID(), 5);
		assertEquals(chem.getChemicalName(), "element2");

		ChemicalRDG chem1 = ChemicalRDG.findByName("acid1");
		assertEquals(chem1.getChemicalID(), 1);
		assertEquals(chem1.getChemicalName(), "acid1");
	}

	public static void runAllTheTests() {
		constructor1Test();
		findersTest();
	}

}