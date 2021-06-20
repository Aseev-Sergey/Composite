package sample.composer;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class Begin extends Component {

    private Circle circle;

    public Begin(){
        startX = 210;
        startY = 100;
        height = 20;
        nodeName = new Text(startX-50, startY-30, "Начальный узел");
        circle = new Circle(startX, startY, height, Color.BLACK);

    }

    public Begin(double startX, double startY){
        this.startX = startX;
        this.startY = startY;
        height = 20;
        nodeName = new Text(startX-50, startY-30, "Начальный узел");
        circle = new Circle(startX, startY, height, Color.BLACK);
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
        pane.getChildren().add(circle);
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
        return 0;
    }

    @Override
    public double getHeight() {
        return height;
    }
}
