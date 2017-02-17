package no.protomagic.tloaded;

import java.net.URL;
import org.junit.Test;
import static org.junit.Assert.*;

public class TLoadedTest {

    @Test
    public void testLoadMap() {
        URL url = TLoadedTest.class.getClassLoader().getResource("testmap.json");
        assertNotNull(url);

        TileMap map = TLoaded.loadTileMap(url);
        assertNotNull(map);

        assertTrue(map.layers.length == 2);
        assertTrue(map.layers[0].height == map.height);
        assertTrue(map.layers[0].data.length == map.width * map.height);
        assertTrue(map.nextObjectID == 1);
        assertTrue(map.tileSets[0].name.equals("gloomdungeon"));
    }
}

