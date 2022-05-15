package dk.sdu.mmmi.cbse.lifeprocessersystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class LifeProcesserTest {
    private World world;
    private LifeProcesser lifeProcesser;
    private GameData gameData;
    @BeforeEach
    void setUp() {
        lifeProcesser = new LifeProcesser();
        gameData = new GameData();
        world = new World();
    }

    /**
     * Test if the LifeProcesser removes entries with 0 life.
     */
    @org.junit.jupiter.api.Test
    void process() {
        Entity entity = new Entity();
        world.addEntity(entity);
        lifeProcesser.process(gameData, world);
        Entity found = world.getEntity(entity.getID());
        LifePart lifePart = new LifePart(0, 0);
        found.add(lifePart);
        assertNotNull(found);
        lifeProcesser.process(gameData, world);
        Entity notFound = world.getEntity(entity.getID());
        assertNull(notFound);
    }
}