package frontend.Figure;

import frontend.Enum.COLOR;
import frontend.Enum.FIGURE;

public class Knight extends Chessman {

    public Knight(COLOR color) {
        super(color, FIGURE.KNIGHT);
    }

    @Override
    boolean stroke(int x_prev, int y_prev, int x, int y) {
        return false;
    }
}
