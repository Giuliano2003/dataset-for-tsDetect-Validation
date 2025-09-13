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
import asteroids.model.IllegalDurationException;

public class BulletTest {
	
	private static final double EPSILON = 0.0001;

	IFacade facade;
	World world;
	Ship ship;
	Bullet bullet;
	Bullet bullet2;
	Bullet bullet3;
	
	@Before
	public void setUp() throws ModelException {
		facade = new Facade();
		world = new World(1000,1000);
		ship = facade.createShip(100, 200, 10, 20, 30, Math.PI, 100);
		world.addEntity(ship);
		bullet = facade.createBullet(100, 100, 20, 30, 5);
		world.addEntity(bullet);
		bullet2 = facade.createBullet(400, 700, -10, 40, 5);
		ship.loadBullet(bullet2);
		bullet3 = facade.createBullet(400, 700, -10, 40, 5);
	}

	
	@Test
	public void testMove_LegalCase() throws ModelException {
		bullet.move(1);
		double xpos = bullet.getXPosition();
		double ypos = bullet.getYPosition();
		assertEquals(120, xpos, EPSILON);
		assertEquals(130, ypos, EPSILON);
	}
	

}