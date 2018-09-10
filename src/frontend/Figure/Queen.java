package frontend.Figure;

import frontend.Enum.COLOR;
import frontend.Enum.FIGURE;

public class Queen extends  Chessman {

    public Queen(COLOR color) {
        super(color, FIGURE.QUEEN);
    }


    @Override
    boolean stroke(int x_prev, int y_prev, int x, int y) {
        return false;
    }
}
