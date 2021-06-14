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
        arrows = new Arrows(new double[]{
                startX-10, startY+40,
                startX+10, startY+40,
                startX, startY+50
        }, new double[]{
                startX, startY+20, startX, startY+40
        }
        );



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
                pane.getChildren().add(arrows.getArrow());
                for (int i = 0; i < arrows.getArrayLine().length; i++){
                    pane.getChildren().add(arrows.getArrowLine(i));
                }
            case 1:
                pane.getChildren().add(nodeName);
            case 0:
                pane.getChildren().add(circle);
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
