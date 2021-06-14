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
        arrows = new Arrows(new double[]{
                startX-10, startY+80,
                startX+10, startY+80,
                startX, startY+90
        }, new double[]{
                startX, startY+60, startX, startY+80
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
                pane.getChildren().add(oper);
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
