package no.protomagic.tloaded;

import java.net.URL;
import org.junit.Test;
import java.io.*;
import static org.junit.Assert.*;

public class TLoadedTest {

    private String readFile(String path) {
        String fileContents = null;

        try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                        TLoadedTest.class.getClassLoader().
                        getResourceAsStream(path)))) {

            StringBuilder builder = new StringBuilder();
            br.lines().forEach(line -> builder.append(line));
            fileContents = builder.toString();
        }
        catch(IOException e) {
            assertTrue(false);
        }

        return fileContents;
    }

    @Test
    public void testLoadMap() {
        String file = readFile("testmap.json");

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

