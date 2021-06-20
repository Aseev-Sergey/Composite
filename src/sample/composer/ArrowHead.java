package sample.composer;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;

public class ArrowHead extends Component{

    private Polygon arrowHead;

    public ArrowHead(double startX, double startY){
        height = 10;
        this.startX = startX;
        this.startY = startY;
        arrowHead = new Polygon(new double[]{
                startX-10, startY,
                startX+10, startY,
                startX, startY+height
        });
    }

    public Polygon getArrowHead() {
        return arrowHead;
    }

    @Override
    public void add(Component component) throws ComponentException {

    }

    @Override
    public void remove(Component component) throws ComponentException {

    }

    @Override
    public Component getChild(int index) throws ComponentException {
        return null;
    }

    @Override
    public void draw(Pane pane) {
        pane.getChildren().add(arrowHead);
    }

    @Override
    public void setStartX(double startX) {

    }

    @Override
    public void setStartY(double startY) {

    }

    @Override
    public void setWidth(double width) {

    }

    @Override
    public void setHeight(double height) {

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
