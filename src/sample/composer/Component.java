package sample.composer;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public abstract class Component {

    Text nodeName;
    double startX;
    double startY;
    double width;
    double height;

    public abstract void add (Component component) throws ComponentException;

    public abstract void remove (Component component) throws ComponentException;

    public abstract Component getChild (int index) throws ComponentException;

    public abstract void draw(Pane pane);

    public abstract void setStartX(double startX);

    public abstract void setStartY(double startY);

    public abstract void setWidth(double width);

    public abstract void setHeight(double height);

    public abstract double getStartX();

    public abstract double getStartY();

    public abstract double getWidth();

    public abstract double getHeight();

    @Override
    public String toString() {
        return nodeName.getText();
    }
}
