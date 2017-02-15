package no.protomagic.tloaded;

import java.net.URL;
import java.io.File;
import org.json.simple.*;
import com.google.common.io.Files;
import com.google.common.base.Charsets;

public class TLoaded {

    private TLoaded() {}

    public static TileMap loadTileMap(URL url) {
        String jsonString;

        try {
            File file = new File(url.getFile());
            jsonString = Files.toString(file, Charsets.UTF_8);
        } catch(Exception e) {
            return null;
        }

        Object mapObject = JSONValue.parse(jsonString);
        if(mapObject != null && mapObject instanceof JSONObject) {
            TileMap map = new TileMap();
            map.load((JSONObject)mapObject);

            return map;
        }
        else return null;
    }
}

