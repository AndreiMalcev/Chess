package frontend.Figure;

import frontend.Enum.COLOR;
import frontend.Enum.FIGURE;

public class King extends Chessman {

    public King(COLOR color) {
        super(color, FIGURE.KING);
    }

    @Override
    boolean stroke(int x_prev, int y_prev, int x, int y) {
        return false;
    }
}
