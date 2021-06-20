package sample.composer;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Composite extends Component {

    ArrayList <Component> array;

    public Composite() throws ComponentException {
        array=new ArrayList<>();
    }

    @Override
    public void add(Component component) throws ComponentException {
        array.add(component);
    }

    @Override
    public void remove(Component component) throws ComponentException {
        array.remove(component);
    }

    @Override
    public Component getChild(int index) throws ComponentException {
        return array.get(index);
    }

    public Component getLast() throws ComponentException{
        return array.get(array.size() - 1);
    }

    @Override
    public void draw(Pane pane) {
        if (array.isEmpty()) return;
        for (Component comp: array) comp.draw(pane);
    }

    @Override
    public void setStartX(double startX) {
        if (array.isEmpty()) return;
        for (Component comp: array) comp.setStartX(startX);
    }

    @Override
    public void setStartY(double startY) {
        if (array.isEmpty()) return;
        for (Component comp: array) comp.setStartY(startY);
    }

    @Override
    public void setWidth(double width) {
        if (array.isEmpty()) return;
        for (Component comp: array) comp.setWidth(width);
    }

    @Override
    public void setHeight(double height) {
        if (array.isEmpty()) return;
        for (Component comp: array) comp.setHeight(height);
    }

    @Override
    public double getStartX() {
        return 0;
    }

    @Override
    public double getStartY() {
        return 0;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }
}
