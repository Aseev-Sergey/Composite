package sample.composer;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Solution extends Component {

    private Rectangle sol;

    public Solution(){
        startX = 210;
        startY = 100;
        width = 100;
        height = width;
        nodeName = new Text(startX-50, startY-30, "Узел решения");
        sol = new Rectangle(width, width, Color.LIGHTGREY);
        sol.setX(startX - width / 2.0);
        sol.setY(startY);
        sol.setRotate(45);

    }

    public Solution(double startX, double startY){
        this.startX = startX;
        this.startY = startY;
        width = 100;
        height = width;
        nodeName = new Text(startX-50, startY-30, "Узел решения");
        sol = new Rectangle(width, width, Color.LIGHTGREY);
        sol.setX(startX - width / 2.0);
        sol.setY(startY);
        sol.setRotate(45);
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
        pane.getChildren().add(sol);
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
