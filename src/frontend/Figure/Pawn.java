package frontend.Figure;

import frontend.Enum.COLOR;
import frontend.Enum.FIGURE;

import static java.lang.Math.abs;

public class Pawn extends Chessman {
    private int color = 1;


    public Pawn(COLOR color) {
        super(color, FIGURE.PAWN);
        if (COLOR.WHITE.equals(color)) {
            this.color = -1;
        }
    }

    @Override
    boolean stroke(int x_prev, int y_prev, int x, int y) {
        if (color * (x - x_prev) > 0 && abs(x - x_prev) < 3) {
            return true;
        }
        return false;
    }
}
