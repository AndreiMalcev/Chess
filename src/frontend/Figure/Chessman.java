package frontend.Figure;

import frontend.Address;
import frontend.Enum.COLOR;
import frontend.Enum.FIGURE;
import frontend.LoaderFigure;
import javafx.scene.control.Label;

public abstract class Chessman {
    private Label figure;

    Chessman(COLOR color, FIGURE nameFigure) {
        figure = new LoaderFigure(new Address(color, nameFigure).getAddress()).getLabel();
    }

    public Label getFigure(){
        return figure;
    }

    //может ли быть такой ход
    abstract boolean stroke(int x_prev, int y_prev, int x, int y);

}
