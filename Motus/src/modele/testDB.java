package modele;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

@SuppressWarnings("unused")
class testDB {

	@SuppressWarnings("deprecation")
	@Test
	void testReadDataBase() {
		Serveur serv = new Serveur();
		try {
			serv.readDataBase();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(serv.id, 1);
		Assert.assertEquals(serv.mot, "garage");
		Assert.assertEquals(serv.signification, "Abri destiné à recevoir des véhicules");
		Assert.assertEquals(serv.niveau, "automobile");

	}

}
