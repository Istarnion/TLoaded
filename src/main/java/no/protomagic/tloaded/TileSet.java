package no.protomagic.tloaded;

import java.util.HashMap;
import java.util.ArrayList;
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
    public ArrayList<ArrayList<Property>> tileProperties;

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

        tileProperties = new ArrayList<ArrayList<Property>>(tileCount);
        for(int i=0; i<tileCount; ++i) {
            tileProperties.add(new ArrayList<Property>());
        }
        JSONObject tilePropertiesData = JSONHelper.readObject(tileSetObj, "tileproperties");
        if(tilePropertiesData != null) {
            JSONObject tilePropertiesTypeData = JSONHelper.readObject(tileSetObj, "tilepropertytypes");

            for(Object key : tilePropertiesData.keySet()) {
                int tile = -1;
                try {
                    tile = Integer.parseInt((String)key);
                }
                catch(NumberFormatException e) {
                    break;
                }

                JSONObject propData = (JSONObject)tilePropertiesData.get(key);
                JSONObject typesData = (JSONObject)tilePropertiesTypeData.get(key);

                if(
                        propData != null && typesData != null &&
                        propData.keySet().equals(typesData.keySet()) &&
                        tile >= 0 && tile < tileCount) {
                    readTileProperties(tileProperties.get(tile), propData, typesData);
                }
            }
        }
    }

    private void readTileProperties(ArrayList<Property> tileProps, JSONObject propsData, JSONObject typesData) {
        for(Object key : propsData.keySet()) {
            try {
                Property prop = new Property();

                prop.name = (String)key;

                String type = (String)typesData.get(key);
                Object val = propsData.get(key);
                switch(type) {
                    case "string":
                        prop.type = Property.Type.STRING;
                        prop.strVal = (String)val;
                        break;
                    case "int":
                        prop.type = Property.Type.INT;
                        prop.intVal = ((Number)val).intValue();
                        break;
                    case "float":
                        prop.type = Property.Type.FLOAT;
                        prop.floatVal = ((Number)val).floatValue();
                        break;
                    case "bool":
                        prop.type = Property.Type.BOOL;
                        prop.boolVal = (boolean)val;
                        break;
                    case "color":
                        prop.type = Property.Type.COLOR;
                        prop.strVal = (String)val;
                        break;
                    case "file":
                        prop.type = Property.Type.FILE;
                        prop.strVal = (String)val;
                        break;
                }

                tileProps.add(prop);
            }
            catch(Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}

