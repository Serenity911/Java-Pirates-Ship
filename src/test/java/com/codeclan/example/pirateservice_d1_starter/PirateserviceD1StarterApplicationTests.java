package com.codeclan.example.pirateservice_d1_starter;

import com.codeclan.example.pirateservice_d1_starter.models.Pirate;
import com.codeclan.example.pirateservice_d1_starter.models.Ship;
import com.codeclan.example.pirateservice_d1_starter.repositories.PirateRepository;
import com.codeclan.example.pirateservice_d1_starter.repositories.ShipRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PirateserviceD1StarterApplicationTests {

	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	public Ship ship;

	@Before
	public void before(){
		ship = new Ship("The Black Pearl");
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void saveShip(){
		shipRepository.save(ship);
		Ship shipSaved = shipRepository.findById(ship.getId()).get();
		assertEquals(ship.getShipName(), shipSaved.getShipName() );
	}


	@Test
	public void createSinglePirateAndSave(){
        shipRepository.save(ship);

        Pirate pirate = new Pirate("Jack", "Sparrow", 32, ship);
		pirateRepository.save(pirate);
	}

}
