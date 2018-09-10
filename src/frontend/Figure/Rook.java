package frontend.Figure;

import frontend.Enum.COLOR;
import frontend.Enum.FIGURE;

public class Rook extends Chessman {

    public Rook(COLOR color){
        super(color, FIGURE.ROOK);
    }

    @Override
    boolean stroke(int x_prev, int y_prev, int x, int y) {
        return false;
    }
}
