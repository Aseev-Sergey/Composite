package sample.composer;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class End extends Component {

    private Circle outCircle;
    private Circle inCircle;
    private Circle fillCircle;

    public End(){
        startX = 210;
        startY = 100;
        height = 20;
        nodeName = new Text(startX-50, startY-30, "Финальный узел");
        outCircle = new Circle(startX, startY, height, Color.BLACK);
        inCircle = new Circle(startX, startY, height-5, Color.WHITE);
        fillCircle = new Circle(startX, startY, height-10, Color.BLACK);
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
    public void draw(Pane pane, int index) {
        switch (index){
            case 2:
            case 1:
                pane.getChildren().add(nodeName);
            case 0:
                pane.getChildren().addAll(outCircle, inCircle, fillCircle);
                break;
        }
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
}
