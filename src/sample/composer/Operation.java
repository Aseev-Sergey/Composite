package sample.composer;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Operation extends Component {

    private Rectangle oper;

    public Operation(){
        startX = 210;
        startY = 100;
        width = 120;
        height = 60;
        nodeName = new Text(startX-50, startY-30, "Узел управления");
        oper = new Rectangle( width, height, Color.LIGHTGREY);
        oper.setX(startX-60);
        oper.setY(startY);
        oper.setArcWidth(50);
        oper.setArcHeight(50);

    }

    public Operation(double startX, double startY){
        this.startX = startX;
        this.startY = startY;
        width = 120;
        height = 60;
        nodeName = new Text(startX-50, startY-30, "Узел управления");
        oper = new Rectangle( width, height, Color.LIGHTGREY);
        oper.setX(startX-60);
        oper.setY(startY);
        oper.setArcWidth(50);
        oper.setArcHeight(50);
    }

    @Override
    public void add(Component component) throws ComponentException {
        throw new ComponentException();
    }

    @Override
    public void remove(Component component) throws ComponentException {
        throw new ComponentException();
    }

    @Override
    public Component getChild(int index) throws ComponentException {
        throw new ComponentException();
    }

    @Override
    public void draw(Pane pane) {
        pane.getChildren().add(oper);
    }

    @Override
    public void setStartX(double startX) {
        this.startX = startX;
    }

    @Override
    public void setStartY(double startY) {
        this.startY = startY;
    }

    @Override
    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getStartX() {
        return startX;
    }

    @Override
    public double getStartY() {
        return startY;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }
}
