package jumper;

import coordinate.Coordinate;

public class Jumper {
    public Coordinate start;
    public Coordinate end;
    public String name;

    public Jumper(Coordinate start, Coordinate end) {
        this.start = start;
        this.end = end;

        if (start.getRow() > end.getRow())
            this.name = "ladder";
        else
            this.name = "snake";
    }

    public String getJumperName() {
        return this.name;
    }
}
