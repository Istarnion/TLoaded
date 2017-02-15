package no.protomagic.tloaded;

public enum RenderOrder {
    RIGHT_DOWN,
    RIGHT_UP,
    LEFT_DOWN,
    LEFT_UP;

    static RenderOrder parse(String val) {
        if(val == null) return RenderOrder.RIGHT_DOWN;
        try {
            return RenderOrder.valueOf(val.toUpperCase());
        }
        catch(Exception e) {
            return RenderOrder.RIGHT_DOWN;
        }
    }
}

