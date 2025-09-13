package asteroids.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import asteroids.model.Ship;
import asteroids.model.World;
import asteroids.facade.Facade;
import asteroids.part2.facade.IFacade;
import asteroids.util.ModelException;
import asteroids.model.Bullet;
import asteroids.model.IllegalBulletException;
import asteroids.model.IllegalDurationException;

public class ShipTest {

	private static final double EPSILON = 0.0001;

    private static final double INITIAL_SPEED = 250;


	IFacade facade;
	World world;
	Ship ship;
	Ship ship2;

	@Before
	public void setUp() throws ModelException {
		facade = new Facade();
		world = new World(1000,1000);
		ship = facade.createShip(100, 200, 10, 20, 30, Math.PI, 100);
		world.addEntity(ship);
		Ship ship2 = facade.createShip(200,200,-10,20,30,Math.PI, 100);
		world.addEntity(ship2);
	}

	
	@Test
	public void testMove_LegalCase() throws ModelException {
		ship.move(1);
		double xpos = ship.getXPosition();
		double ypos = ship.getYPosition();
		assertEquals(110, xpos, EPSILON);
		assertEquals(220, ypos, EPSILON);
	}
	
	@Test(expected = IllegalDurationException.class)
	public void testMove_IllegalCaseNegativeDuration() throws ModelException {
		ship.move(-1);
	}
	
	@Test
	public void testTurn() throws ModelException {
		ship.turn(4.5*Math.PI);
		assertEquals(1.5*Math.PI, ship.getOrientation(), EPSILON);
		ship.turn(-7.5*Math.PI);
		assertEquals(0, ship.getOrientation(), EPSILON);
	}
	

}
