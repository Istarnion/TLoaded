package no.protomagic.tloaded;

import java.util.HashMap;
import org.json.simple.*;

public class TileLayer {
    public String name;

    public int x;
    public int y;

    public int width;
    public int height;

    public float opacity;

    public boolean visible;

    public int offsetX;
    public int offsetY;

    public int[] data;

    public HashMap<String, Property> properties;

    public TileLayer() {}

    TileLayer(JSONObject layerData) {
        name = JSONHelper.readString(layerData, "name");

        x = JSONHelper.readInt(layerData, "x");
        y = JSONHelper.readInt(layerData, "y");

        width = JSONHelper.readInt(layerData, "width");
        height = JSONHelper.readInt(layerData, "height");

        opacity = JSONHelper.readFloat(layerData, "opacity");

        int vis = JSONHelper.readInt(layerData, "visible");
        if(vis > 0) visible = true;
        else visible = false;

        offsetX = JSONHelper.readInt(layerData, "offsetx");
        offsetY = JSONHelper.readInt(layerData, "offsety");

        JSONArray dataJSON = JSONHelper.readArray(layerData, "data");
        data = new int[dataJSON.size()];
        for(int i=0; i<data.length; ++i) {
            data[i] = ((Number)dataJSON.get(i)).intValue();
        }

        JSONObject propertiesData = JSONHelper.readObject(layerData, "properties");
        if(propertiesData != null) {
            properties = new HashMap<>();
            for(Object o : propertiesData.keySet()) {
                properties.put((String)o, new Property(propertiesData.get(o)));
            }
        }
    }
}

