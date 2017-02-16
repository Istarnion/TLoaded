package no.protomagic.tloaded;

import java.util.HashMap;
import org.json.simple.*;

public class TileMap {

    public int version;

    public int width;
    public int height;

    public int tileWidth;
    public int tileHeight;

    public int nextObjectID;

    public TileLayer[] layers;

    public Orientation orientation;
    public RenderOrder renderOrder;

    public TileSet[] tileSets;

    public String backgroundColor;

    public HashMap<String, Property> properties;

    void load(JSONObject mapObj) {
        version = JSONHelper.readInt(mapObj, "version");

        width = JSONHelper.readInt(mapObj, "width");
        height = JSONHelper.readInt(mapObj, "height");

        tileWidth = JSONHelper.readInt(mapObj, "tilewidth");
        tileHeight = JSONHelper.readInt(mapObj, "tileheight");

        nextObjectID = JSONHelper.readInt(mapObj, "nextobjectid");

        JSONArray layersData = JSONHelper.readArray(mapObj, "layers");
        layers = new TileLayer[layersData.size()];
        for(int i=0; i<layers.length; ++i) {
            layers[i] = new TileLayer((JSONObject)layersData.get(i));
        }

        orientation = Orientation.parse(JSONHelper.readString(mapObj, "orientation"));
        renderOrder = RenderOrder.parse(JSONHelper.readString(mapObj, "renderorder"));

        JSONArray tilesetsData = JSONHelper.readArray(mapObj, "tilesets");
        tileSets = new TileSet[tilesetsData.size()];
        for(int i=0; i<tileSets.length; ++i) {
            tileSets[i] = new TileSet((JSONObject)tilesetsData.get(i));
        }

        backgroundColor = JSONHelper.readString(mapObj, "backgroundcolor");

        JSONObject propertiesData = JSONHelper.readObject(mapObj, "properties");
        if(propertiesData != null) {
            properties = new HashMap<>();
            for(Object o : propertiesData.keySet()) {
                properties.put((String)o, new Property(propertiesData.get(o)));
            }
        }
    }
}

