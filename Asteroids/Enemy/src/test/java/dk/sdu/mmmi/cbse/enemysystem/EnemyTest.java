package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.data.EntityType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {
    private Enemy enemyUnderTest;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        enemyUnderTest = new Enemy();
    }

    @Test
    void canShoot() {
        assertFalse(enemyUnderTest.canShoot(-100));
        assertFalse(enemyUnderTest.canShoot(99));
        assertTrue(enemyUnderTest.canShoot(1));
    }

    @Test
    void resetCooldown() {
        assertTrue(enemyUnderTest.canShoot(0));
        enemyUnderTest.resetCooldown();
        assertFalse(enemyUnderTest.canShoot(0));
        assertTrue(enemyUnderTest.canShoot(0.5f));
    }

    @Test
    void getEntityType() {
        assertNotSame(enemyUnderTest.getEntityType(), EntityType.ASTEROID);
        assertSame(enemyUnderTest.getEntityType(), EntityType.SHIP);
    }
}