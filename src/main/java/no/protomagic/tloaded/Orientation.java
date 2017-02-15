package no.protomagic.tloaded;

public enum Orientation {
    ORTHOGONAL,
    ISOMETRIC,
    STAGGERED,
    HEXAGONAL;

    static Orientation parse(String val) {
        if(val == null) return Orientation.ORTHOGONAL;
        try {
            return Orientation.valueOf(val.toUpperCase());
        }
        catch(Exception e) {
            return Orientation.ORTHOGONAL;
        }
    }
}

