package no.protomagic.tloaded;

import org.json.simple.*;

public class TileSet {
    public int firstGID;

    public String source;

    public String name;

    public int tileWidth;
    public int tileHeight;

    public int spacing;
    public int margin;

    public int tileCount;
    public int columns;

    public TileOffset tileOffset;

    public Property[] properties;

    public String image;

    public TileSet() {}

    TileSet(JSONObject obj) {
        JSONArray propertiesData = JSONHelper.readArray(obj, "properties");
        if(propertiesData != null) {
            properties = new Property[propertiesData.size()];
            for(int i=0; i<properties.length; ++i) {
                properties[i] = new Property((JSONObject)propertiesData.get(i));
            }
        }
    }
}

