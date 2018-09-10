package frontend;

import frontend.Enum.COLOR;
import frontend.Figure.Chessman;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import static frontend.Enum.CONST.LENGTH;


public class Cell {
    private StackPane cell;
    private COLOR color;

    Cell (COLOR color) {
        cell = new StackPane();
        if (COLOR.WHITE.equals(color)){
            cell.setStyle(COLOR.WHITE.getColor());
            this.color = COLOR.WHITE;
        }
        else {
            cell.setStyle(COLOR.BLACK.getColor());
            this.color = COLOR.BLACK;
        }
        cell.setPrefSize(LENGTH, LENGTH);
    }

    public void put(Node figure) {
        cell.getChildren().add(figure);
    }

    public void figure(){
        System.out.println(color.getColor());
        cell.setStyle(color.getColor() + "-fx-border-color: green;" + "-fx-effect: dropshadow(gaussian, green, 5, 0, 0 ,0);");
    }

    public boolean have_figure(){
        return !cell.getChildren().isEmpty();
    }

  /*  public Chessman getFigure() {
        return cell.getChildren();
    }*/

    public StackPane getCell() {
        return cell;
    }

    public void deleteGreen() {
        cell.setStyle(color.getColor());
    }

    public Node deleteFigure() {
        if (have_figure()) {
            return cell.getChildren().remove(0);
        }
        return null;
    }
}
