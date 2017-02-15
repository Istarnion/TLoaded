package no.protomagic.tloaded;

import org.json.simple.*;

class JSONHelper {

    public static JSONObject readObject(JSONObject obj, String target) {
        Object o = obj.get(target);
        if(o != null && o instanceof JSONObject) {
            return (JSONObject)o;
        }
        else return null;
    }

    public static JSONArray readArray(JSONObject obj, String target) {
        Object o = obj.get(target);
        if(o != null && o instanceof JSONArray) {
            return (JSONArray)o;
        }
        else return null;
    }

    public static int readInt(JSONObject obj, String target) {
        Object o = obj.get(target);
        if(o != null && o instanceof Number) {
            return ((Number)o).intValue();
        }
        else return 0;
    }

    public static float readFloat(JSONObject obj, String target) {
        Object o = obj.get(target);
        if(o != null && o instanceof Number) {
            return ((Number)o).floatValue();
        }
        else return 0;
    }

    public static String readString(JSONObject obj, String target) {
        Object o = obj.get(target);
        if(o != null && o instanceof String) {
            return (String)o;
        }
        else return null;
    }
}

