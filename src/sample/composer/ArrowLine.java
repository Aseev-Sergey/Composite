package sample.composer;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class ArrowLine extends Component {

    private Line arrowLine;

    public ArrowLine(double startX, double startY){
        height = 20;
        width = 0;
        this.startX = startX;
        this.startY = startY;
        arrowLine = new Line(startX, startY, startX, startY+height);
    }

    public ArrowLine(double startX,  double startY, double endX, double endY){
        width = Math.abs(endX-startX);
        height = Math.abs(endY-startY);
        this.startX = startX;
        this.startY = startY;
        arrowLine = new Line(startX, startY, endX, endY);
    }

    public Line getArrowLine() {
        return arrowLine;
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
        pane.getChildren().add(arrowLine);
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
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }
}
