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
    }
}

