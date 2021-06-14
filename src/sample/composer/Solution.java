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
        nodeName = new Text(startX-50, startY-30, "Узел решения");
        sol = new Rectangle(width, width, Color.LIGHTGREY);
        sol.setX(startX - width / 2.0);
        sol.setY(startY);
        sol.setRotate(45);
        arrows = new Arrows(new double[]{
                startX-100.7, startY+90,
                startX-80.7, startY+90,
                startX-90.7, startY+100
        }, new double[]{
                startX-70.7, startY+50, startX-90.7, startY+50,
                startX-90.7, startY+50, startX-90.7, startY+90
        }
        );
        arrows1 = new Arrows(new double[]{
                startX+100.7, startY+90,
                startX+80.7, startY+90,
                startX+90.7, startY+100
        }, new double[]{
                startX+70.7, startY+50, startX+90.7, startY+50,
                startX+90.7, startY+50, startX+90.7, startY+90
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
                pane.getChildren().add(arrows1.getArrow());
                for (int i = 0; i < arrows1.getArrayLine().length; i++){
                    pane.getChildren().add(arrows1.getArrowLine(i));
                }
            case 1:
                pane.getChildren().add(nodeName);
            case 0:
                pane.getChildren().add(sol);
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
