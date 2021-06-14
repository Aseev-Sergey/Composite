package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import sample.composer.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Pane pane;
    public ListView<Component> listNode;
    public ListView<String> listLvl;
    public ObservableList<Component> nodes;
    public ObservableList<String> lvls;
    public Composite composite;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            composite = new Composite();
            nodes = FXCollections.observableArrayList(composite.getChild(0), composite.getChild(1),
                    composite.getChild(2), composite.getChild(3));
        } catch (ComponentException e) {
            e.printStackTrace();
        }
        lvls = FXCollections.observableArrayList("1 уровень", "2 уровень", "3 уровень");
        listNode.setItems(nodes);
        listNode.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listLvl.setItems(lvls);
        listLvl.setDisable(true);
    }

    public void addNode(MouseEvent mouseEvent) throws ComponentException {
        clearPane();
        listNode.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listLvl.setDisable(false);
        listLvl.getSelectionModel().select(0);
        int index = listNode.getSelectionModel().getSelectedIndex();
        if ((index >= 0) && (index < listNode.getItems().size())) {
            composite.getChild(index).draw(pane, 0);
        } else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Не выбран узел из списка");
            alert.showAndWait();
        }
    }

    public void choseLvl(MouseEvent mouseEvent) throws ComponentException {
        clearPane();
        int indexNode = listNode.getSelectionModel().getSelectedIndex();
        int indexLvl = listLvl.getSelectionModel().getSelectedIndex();
        composite.getChild(indexNode).draw(pane, indexLvl);
    }

    public void clickClear(ActionEvent actionEvent) {
        clearPane();
    }

    private void clearPane(){
        pane.getChildren().clear();
    }

    public void clickClose(ActionEvent actionEvent) {
        Platform.exit();
    }



}
