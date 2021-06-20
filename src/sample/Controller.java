package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
    public Button buttonOper;
    public Button buttonSol;
    public Button buttonBranch, buttonNo, buttonYes, buttonEnd;
    public Button buttonCycle, buttonBodiless, buttonBodyful;
    public Button buttonFinal;
    public ObservableList<Component> nodes;
    public Composite composite;
    private double startX;
    private double startY;
    private double leftPosX, rightPosX;
    private double leftPosY, rightPosY;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startX = 300;
        startY = 40;
        try {
            composite = new Composite();
            nodes = FXCollections.observableArrayList(new Begin(startX, startY),
                    new Operation(startX, startY), new Solution(startX, startY));
        } catch (ComponentException e) {
            e.printStackTrace();
        }
        listNode.setItems(nodes);
        listNode.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    public void chooseNode(MouseEvent mouseEvent) throws ComponentException {
        clearPane();
        listNode.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        int index = listNode.getSelectionModel().getSelectedIndex();
        if ((index >= 0) && (index < listNode.getItems().size())) {
            composite.add(nodes.get(index));
            clearPane();
            composite.draw(pane);
            listNode.setDisable(true);
            listNode.getSelectionModel().select(null);
            if(index < 2){
                activateNodesButton();
            }else
            {
                activateSol();
            }
        } else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Не выбран узел из списка");
            alert.showAndWait();
        }
    }
    

    public void clickClear(ActionEvent actionEvent) throws ComponentException {
        composite = new Composite();
        disableCycle();
        disableBranch();
        disableNodesButton();
        listNode.setDisable(false);
        clearPane();
    }

    private void clearPane(){
        pane.getChildren().clear();
    }

    public void clickClose(ActionEvent actionEvent) {
        Platform.exit();
    }


    public void clckAddOper(ActionEvent actionEvent) throws ComponentException {
        double posX = composite.getLast().getStartX();
        double posY = composite.getLast().getStartY() + composite.getLast().getHeight();
        posY = addDefaultArrow(posX, posY);
        composite.add(new Operation(posX, posY));
        clearPane();
        composite.draw(pane);
    }

    public double addDefaultArrow(double posX, double posY) throws ComponentException{
        composite.add(new ArrowLine(posX, posY));
        posY+= composite.getLast().getHeight();
        composite.add(new ArrowHead(posX, posY));
        posY+= composite.getLast().getHeight();
        return posY;
    }

    public void clickAddSol(ActionEvent actionEvent) throws ComponentException {
        double posX = composite.getLast().getStartX();
        double posY = composite.getLast().getStartY() + composite.getLast().getHeight();
        posY = addDefaultArrow(posX, posY);
        composite.add(new Solution(posX, posY+20));
        clearPane();
        composite.draw(pane);
        activateSol();
    }

    public void activateSol(){
        buttonBranch.setDisable(false);
        buttonCycle.setDisable(false);
        disableNodesButton();
    }

    public void clickSolIsBranch(ActionEvent actionEvent) throws ComponentException {
        double posX = composite.getLast().getStartX() - composite.getLast().getWidth()*Math.sqrt(2) / 2.0;
        double posY = composite.getLast().getStartY() + composite.getLast().getHeight()*Math.sqrt(2) / 2.0 - 20;
        composite.add(new ArrowLine(posX, posY, posX-20, posY));
        leftPosX = posX - 20;
        leftPosY = posY;
        posX+= composite.getLast().getWidth() + 120.7;
        composite.add(new ArrowLine(posX, posY, posX+20, posY));
        rightPosX = posX + 20;
        rightPosY = posY;
        clearPane();
        composite.draw(pane);
        activateBranch();
    }

    public void activateBranch(){
        buttonCycle.setDisable(true);
        buttonNo.setDisable(false);
        buttonYes.setDisable(false);
        buttonEnd.setDisable(false);
        buttonBranch.setDisable(true);
        disableNodesButton();
    }

    public void clickAddNo(ActionEvent actionEvent) throws ComponentException{
        composite.add(new ArrowLine(leftPosX, leftPosY, leftPosX, leftPosY+30));
        leftPosY = composite.getLast().getStartY() + composite.getLast().getHeight();
        leftPosY = addDefaultArrow(leftPosX, leftPosY);
        composite.add(new Operation(leftPosX, leftPosY));
        leftPosY+= composite.getLast().getHeight();
        clearPane();
        composite.draw(pane);
        buttonNo.setDisable(true);
    }

    public void clickAddYes(ActionEvent actionEvent) throws ComponentException {
        composite.add(new ArrowLine(rightPosX, rightPosY, rightPosX, rightPosY+30));
        rightPosY = composite.getLast().getStartY() + composite.getLast().getHeight();
        rightPosY = addDefaultArrow(rightPosX, rightPosY);
        composite.add(new Operation(rightPosX, rightPosY));
        rightPosY+= composite.getLast().getHeight();
        clearPane();
        composite.draw(pane);
        buttonYes.setDisable(true);
    }

    public void clickEndBranch(ActionEvent actionEvent) throws ComponentException{
        if(buttonYes.isDisable()){
            composite.add(new ArrowLine(rightPosX, rightPosY, rightPosX, rightPosY+20));
            rightPosY+= 20;
            composite.add(new ArrowLine(rightPosX, rightPosY, rightPosX - 90.7, rightPosY));
            rightPosX-= 90.7;
        }else{
            composite.add(new ArrowLine(rightPosX, rightPosY, rightPosX, rightPosY+140));
            rightPosY+= 140;
            composite.add(new ArrowLine(rightPosX, rightPosY, rightPosX - 90.7, rightPosY));
            rightPosX-= 90.7;
        }
        if(buttonNo.isDisable()){
            composite.add(new ArrowLine(leftPosX, leftPosY, leftPosX, leftPosY+20));
            leftPosY+= 20;
            composite.add(new ArrowLine(leftPosX, leftPosY, leftPosX + 90.7, leftPosY));
            leftPosX+= 90.7;
            composite.add(new ArrowLine(leftPosX, leftPosY));
            leftPosY+= composite.getLast().getHeight();
        } else{
            composite.add(new ArrowLine(leftPosX, leftPosY, leftPosX, leftPosY+140));
            leftPosY+= 140;
            composite.add(new ArrowLine(leftPosX, leftPosY, leftPosX + 90.7, leftPosY));
            leftPosX+= 90.7;
            composite.add(new ArrowLine(leftPosX, leftPosY));
            leftPosY+= composite.getLast().getHeight();
        }
        clearPane();
        composite.draw(pane);
        disableBranch();
        activateNodesButton();
    }

    public void disableBranch(){
        buttonNo.setDisable(true);
        buttonYes.setDisable(true);
        buttonEnd.setDisable(true);
    }

    public void clickSolIsCycle(ActionEvent actionEvent) throws ComponentException{
        double posX = composite.getLast().getStartX();
        double posY = composite.getLast().getStartY() + composite.getLast().getHeight()*Math.sqrt(2)-20;
        composite.add(new ArrowLine(posX, posY));
        clearPane();
        composite.draw(pane);
        activateCycle();

    }

    public void activateCycle(){
        buttonBranch.setDisable(true);
        buttonBodiless.setDisable(false);
        buttonBodyful.setDisable(false);
        buttonCycle.setDisable(true);
        disableNodesButton();
    }

    public void clickBodiless(ActionEvent actionEvent) throws ComponentException{
        double posX = composite.getLast().getStartX();
        double posY = composite.getLast().getStartY() + composite.getLast().getHeight();
        composite.add(new ArrowLine(posX, posY, posX - 90.7, posY));
        posX-= composite.getLast().getWidth();
        posY = composite.getLast().getStartY();
        composite.add(new ArrowLine(posX, posY, posX, posY - 90.7));
        posY-= composite.getLast().getHeight();
        composite.add(new ArrowLine(posX, posY, posX+20, posY));
        //right side
        posX = composite.getLast().getStartX() + composite.getLast().getWidth() + 140.7;
        posY = composite.getLast().getStartY();
        composite.add(new ArrowLine(posX, posY, posX+20, posY));
        posX+= composite.getLast().getWidth();
        composite.add(new ArrowLine(posX, posY, posX, posY + 100.7));
        posY = composite.getLast().getStartY() + composite.getLast().getHeight();
        composite.add(new ArrowLine(posX, posY, posX - 90.7, posY));
        posX-= composite.getLast().getWidth();
        composite.add(new ArrowLine(posX, posY));
        clearPane();
        composite.draw(pane);
        disableCycle();

    }

    public void disableCycle() throws ComponentException {
        buttonBodiless.setDisable(true);
        buttonBodyful.setDisable(true);
        activateNodesButton();
    }

    public void clickBodyful(ActionEvent actionEvent) throws ComponentException {
        double posX = composite.getLast().getStartX();
        double posY = composite.getLast().getStartY() + composite.getLast().getHeight();
        posY = addDefaultArrow(posX, posY);
        composite.add(new Operation(posX, posY));
        posX-= composite.getLast().getWidth() / 2.0;
        posY+= composite.getLast().getHeight() / 2.0;
        composite.add(new ArrowLine(posX, posY, posX-20, posY));
        posX-= composite.getLast().getWidth();
        composite.add(new ArrowLine(posX, posY, posX, posY-150.7));
        posY-= composite.getLast().getHeight();
        composite.add(new ArrowLine(posX, posY, posX+10, posY));
        //right side
        posX = composite.getLast().getStartX() + composite.getLast().getWidth() + 140.7;
        posY = composite.getLast().getStartY();
        composite.add(new ArrowLine(posX, posY, posX+20, posY));
        posX+= composite.getLast().getWidth();
        composite.add(new ArrowLine(posX, posY, posX, posY + 190.7));
        posY = composite.getLast().getStartY() + composite.getLast().getHeight();
        composite.add(new ArrowLine(posX, posY, posX - 90.7, posY));
        posX-= composite.getLast().getWidth();
        composite.add(new ArrowLine(posX, posY));
        clearPane();
        composite.draw(pane);
        disableCycle();
    }

    public void clickAddFinal(ActionEvent actionEvent) throws ComponentException{
        double posX = composite.getLast().getStartX();
        double posY = composite.getLast().getStartY() + composite.getLast().getHeight();
        posY = addDefaultArrow(posX, posY) + 20;
        composite.add(new End(posX, posY));
        clearPane();
        composite.draw(pane);
        disableNodesButton();
    }

    public void activateNodesButton(){
        buttonOper.setDisable(false);
        buttonSol.setDisable(false);
        buttonFinal.setDisable(false);
    }

    public void disableNodesButton(){
        buttonOper.setDisable(true);
        buttonSol.setDisable(true);
        buttonFinal.setDisable(true);
    }
}
