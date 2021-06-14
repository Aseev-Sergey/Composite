package sample.composer;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Composite extends Component {

    ArrayList <Component> array;

    public Composite() throws ComponentException {
        array=new ArrayList<>();
        add(new Begin());
        add(new Operation());
        add(new Solution());
        add(new End());
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

    @Override
    public void draw(Pane pane, int index) {
        if (array.isEmpty()) return;
        for (Component comp: array) comp.draw(pane, index);
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
}
