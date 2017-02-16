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

    public String strVal;
    public int intVal;
    public float floatVal;
    public boolean boolVal;

    public Property() {}

    Property(Object propData) {
        if(propData == null) return;

        if(propData instanceof Number) {
            Number num = (Number)propData;
            if(num.floatValue() == num.intValue()) {
                type = Type.INT;
                intVal = num.intValue();
            }
            else {
                type = Type.FLOAT;
                floatVal = num.floatValue();
            }
        }
        else if(propData instanceof Boolean) {
            type = Type.BOOL;
            boolVal = (Boolean)propData;
        }
        else if(propData instanceof String) {
            // TODO: Differentiate between color, file and string
            type = Type.STRING;
            strVal = (String)propData;
        }
    }

    @Override
    public String toString() {
        String output = type.toString() + ": ";

        switch(type) {
            case BOOL: output += boolVal; break;
            case FLOAT: output += floatVal; break;
            case INT: output += intVal; break;
            case STRING: output += strVal; break;
            case COLOR: output += strVal; break;
            case FILE: output += strVal; break;
        }

        return output;
    }
}

