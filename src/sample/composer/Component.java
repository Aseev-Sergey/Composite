package sample.composer;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public abstract class Component {

    Text nodeName;
    Arrows arrows, arrows1;
    double startX;
    double startY;
    double width;
    double height;

    public abstract void add (Component component) throws ComponentException;

    public abstract void remove (Component component) throws ComponentException;

    public abstract Component getChild (int index) throws ComponentException;

    public abstract void draw(Pane pane, int index);

    public abstract void setStartX(double startX);

    public abstract void setStartY(double startY);

    public abstract void setWidth(double width);

    public abstract void setHeight(double height);

    @Override
    public String toString() {
        return nodeName.getText();
    }
}
