// Noah Thompson
// 21 April 2026
// Point.java

package paradigms.classes;

import java.util.Objects;
import java.lang.Math;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other){
        // non-null
        if(other == null)
            return false;
        // don't even bother! they have different types
        if(getClass() != other.getClass())
            return false;

        Point point = (Point) other; // casting to Point
        double dist1 = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
        double dist2 = Math.sqrt(Math.pow(point.x, 2) + Math.pow(point.y, 2));

        return dist1 == dist2;
    }

    @Override
    public int hashCode(){
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }

}