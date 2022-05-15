package dk.sdu.mmmi.cbse.enemysystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertFalse(enemyUnderTest.canShoot(-100));
    }
}