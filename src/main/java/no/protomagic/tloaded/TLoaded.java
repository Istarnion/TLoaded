package no.protomagic.tloaded;

import java.net.URL;
import java.io.*;
import org.json.simple.*;
import com.google.common.base.Charsets;

public class TLoaded {

    private TLoaded() {}

    public static TileMap loadTileMap(String json) {
        Object mapObject = JSONValue.parse(json);
        if(mapObject != null && mapObject instanceof JSONObject) {
            TileMap map = new TileMap();
            map.load((JSONObject)mapObject);

            return map;
        }
        else return null;
    }
}

