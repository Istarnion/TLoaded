package no.protomagic.tloaded;

import java.util.HashMap;
import org.json.simple.*;

public class TileSet {
    public int firstGID;

    public String image;

    public String name;

    public int tileWidth;
    public int tileHeight;

    public int imageWidth;
    public int imageHeight;

    public HashMap<String, Property> properties;

    public int margin;
    public int spacing;

    public int tileCount;
    public int columns;

    public TileSet() {}

    TileSet(JSONObject tileSetObj) {
        firstGID = JSONHelper.readInt(tileSetObj, "firstgid");

        image = JSONHelper.readString(tileSetObj, "image");

        name = JSONHelper.readString(tileSetObj, "name");

        tileWidth = JSONHelper.readInt(tileSetObj, "tilewidth");
        tileHeight = JSONHelper.readInt(tileSetObj, "tileheight");

        imageWidth = JSONHelper.readInt(tileSetObj, "imagewidth");
        imageHeight = JSONHelper.readInt(tileSetObj, "imageHeight");

        JSONObject propertiesData = JSONHelper.readObject(tileSetObj, "properties");
        if(propertiesData != null) {
            properties = new HashMap<>();
            for(Object o : propertiesData.keySet()) {
                properties.put((String)o, new Property(propertiesData.get(o)));
            }
        }

        margin = JSONHelper.readInt(tileSetObj, "margin");
        spacing = JSONHelper.readInt(tileSetObj, "spacing");

        tileCount = JSONHelper.readInt(tileSetObj, "tilecount");
        columns = JSONHelper.readInt(tileSetObj, "columns");
    }
}

