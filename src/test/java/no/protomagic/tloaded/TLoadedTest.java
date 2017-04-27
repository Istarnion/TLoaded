package no.protomagic.tloaded;

import java.net.URL;
import org.junit.Test;
import static org.junit.Assert.*;

public class TLoadedTest {

    @Test
    public void testLoadMap() {
        String file = TLoadedTest.class.getClassLoader().getResource("testMap.json").getFile();
        assertNotNull(file);

        TileMap map = TLoaded.loadTileMap(file);
        assertNotNull(map);

        assertTrue(map.layers.length == 3);
        assertTrue(map.layers[0].height == map.height);
        assertTrue(map.layers[0].data.length == map.width * map.height);
        assertTrue(map.nextObjectID == 1);

        TileSet tileSet = map.tileSets[0];
        assertTrue(tileSet.tileProperties.get(0).get(0).name.equals("name"));
    }
}

