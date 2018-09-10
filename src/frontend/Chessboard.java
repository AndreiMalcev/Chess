package frontend;

import frontend.Enum.COLOR;
import frontend.Figure.*;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static frontend.Enum.CONST.LENGTH;
import static frontend.Enum.CONST.SIZE;

class Chessboard {
    private GridPane chessBoard;
    private Cell[][] cell;

    private Chessman new_figure(String nameFigure, COLOR color) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> figureClass = Class.forName(nameFigure);
        System.out.println(nameFigure);
        Constructor<?> constructor = figureClass.getConstructor(COLOR.class);
        return (Chessman) constructor.newInstance(color);
    }


    private void load_figure() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //пешки
        for (int i = 0; i < SIZE; i++) {
            cell[i][1].put(new Pawn(COLOR.BLACK).getFigure());
            cell[i][SIZE - 2].put(new Pawn(COLOR.WHITE).getFigure());
        }
        int k = 0;
        String[] ORDER = {Rook.class.getName(), Knight.class.getName(),
                Bishop.class.getName(), Queen.class.getName(), King.class.getName()}; //порядок фигур относительно белых слева направо
        for (String figure : ORDER) {
            if (!(figure.equals(Queen.class.getName()) || figure.equals(King.class.getName()))) {
                cell[k][0].put(new_figure(figure, COLOR.BLACK).getFigure());
                cell[SIZE - 1 - k][0].put(new_figure(figure, COLOR.BLACK).getFigure());
                cell[k][SIZE - 1].put(new_figure(figure, COLOR.WHITE).getFigure());
                cell[SIZE - 1 - k][SIZE - 1].put(new_figure(figure, COLOR.WHITE).getFigure());
            } else {
                cell[k][0].put(new_figure(figure, COLOR.BLACK).getFigure());
                cell[k][SIZE - 1].put(new_figure(figure, COLOR.WHITE).getFigure());
            }
            ++k;
        }
    }

    Chessboard() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        chessBoard = new GridPane();
        chessBoard.setAlignment(Pos.BASELINE_LEFT);
        cell = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ((i + j) % 2 != 0) {
                    cell[i][j] = new Cell(COLOR.BLACK);
                } else {
                    cell[i][j] = new Cell(COLOR.WHITE);
                }
                chessBoard.add(cell[i][j].getCell(), i, j);
            }
        }
        load_figure();

        chessBoard.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            private Cell pred_cell;
            private Coordinate pred_coord;
            @Override
            public void handle(MouseEvent event) {
                int x = (int) event.getX() / LENGTH;
                int y = (int) event.getY()/ LENGTH;
                if (cell[x][y].have_figure()) {
                    if (pred_cell != null) {
                        pred_cell.deleteGreen();
                    }
                    cell[x][y].figure();
                    pred_cell = cell[x][y];
                }
                if (cell[x][y].have_figure()) {
                        pred_coord = new Coordinate(x, y);
                }
                if (!cell[x][y].have_figure() && pred_coord != null) {

                    cell[x][y].put(pred_cell.deleteFigure());
                }
            }
        });
    }

    GridPane getChessBoard() {
        return chessBoard;
    }

    private class Coordinate {
        int x;
        int y;
        Coordinate (int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
