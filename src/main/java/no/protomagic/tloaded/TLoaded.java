package no.protomagic.tloaded;

import java.net.URL;
import java.io.*;
import org.json.simple.*;
import com.google.common.base.Charsets;

public class TLoaded {

    private TLoaded() {}

    public static TileMap loadTileMap(String path) {
        String jsonString;

        try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(TLoaded.class
                    .getClassLoader()
                    .getResourceAsStream(path)))) {

            StringBuilder builder = new StringBuilder();
            br.lines().forEach(line -> builder.append(line));
            jsonString = builder.toString();
        }
        catch(Exception e) {
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

