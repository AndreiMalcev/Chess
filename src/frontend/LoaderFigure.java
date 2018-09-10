package frontend;

import afester.javafx.svg.SvgLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.apache.batik.bridge.SVGImageElementBridge;

import java.io.InputStream;
import static frontend.Enum.CONST.LENGTH;
import static frontend.Enum.CONST.SCALE_FIGURE;


public class LoaderFigure {

    private Label figure;


    public LoaderFigure(String name) {
        InputStream input = getClass().getResourceAsStream("image/" + name +".svg");
        SvgLoader svgLoader = new SvgLoader();
        Group root = svgLoader.loadSvg(input);
        root.setScaleX(SCALE_FIGURE);
        root.setScaleY(SCALE_FIGURE);
        figure = new Label();
        figure.setPrefSize(LENGTH, LENGTH);
        figure.setAlignment(Pos.CENTER);
        figure.setGraphic(root);
    }

    public Label getLabel(){
        return figure;
    }
}
