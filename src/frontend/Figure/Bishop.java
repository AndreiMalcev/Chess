package frontend.Figure;

import frontend.Enum.COLOR;
import frontend.Enum.FIGURE;
import javafx.scene.control.Label;

public class Bishop extends Chessman {

    public Bishop(COLOR color) {
        super(color, FIGURE.BISHOP);
    }

    @Override
    boolean stroke(int x_prev, int y_prev, int x, int y) {
        return false;
    }
}
