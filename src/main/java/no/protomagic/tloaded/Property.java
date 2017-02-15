package no.protomagic.tloaded;

import org.json.simple.*;

public class Property {

    enum Type {
        STRING,
        INT,
        FLOAT,
        BOOL,
        COLOR,
        FILE;

        static Type parse(String val) {
            if(val == null) return Type.STRING;
            try {
                return Type.valueOf(val.toUpperCase());
            }
            catch(Exception e) {
                return Type.STRING;
            }
        }
    }

    public String name;

    public Type type;

    public String value;

    public Property() {}

    Property(JSONObject propData) {
        name = JSONHelper.readString(propData, "name");
        type = Type.parse(JSONHelper.readString(propData, "type"));
        value = JSONHelper.readString(propData, "value");
        if(value == null) {
            value = Float.toString(JSONHelper.readFloat(propData, "value"));
        }
    }
}

