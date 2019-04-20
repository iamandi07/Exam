package UI;

import Domain.Car;
import Service.CarService;

import Domain.Rental;
import Service.RentalService;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {


    public TableView tableViewCar;
    public TableColumn tableColumnId;
    public TableColumn tableColumnModel;
    public TableColumn tableColumnDistance;
    public TableColumn tableColumnPrice;
    public Label name;

    public CarService service;


    private ObservableList<Car> cars = FXCollections.observableArrayList();


    public void setServices(CarService service, RentalService service1) {
        this.service = service;
        this.service1 = service1;
    }

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            cars.addAll(service.getAll());
            tableViewCar.setItems(cars);
        });
    }


    public void btnCarAddClick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("carAdd.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 600, 200);
            Stage stage = new Stage();
            stage.setTitle("Add agenda");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            CarAddController controller = fxmlLoader.getController();
            controller.setService(service);
            stage.showAndWait();
            cars.clear();
            cars.addAll(service.getAll());
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window: Agenda.", e);
        }

    }



    public TableView tableViewRental;
    public TableColumn tableColumnId1;
    public TableColumn tableColumnCarid;
    public TableColumn tableColumnDay;
    public TableColumn tableColumnDistance1;
    public TextField txtLongestDay;

    public RentalService service1;


    private ObservableList<Rental> rentals = FXCollections.observableArrayList();


    @FXML
    private void initialize1() {

        Platform.runLater(() -> {
            rentals.addAll(service1.getAll());
            tableViewRental.setItems(rentals);
        });
    }


    public void btnRentalAddClick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("rentalAdd.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 600, 200);
            Stage stage = new Stage();
            stage.setTitle("Add rental");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            RentalAddController controller = fxmlLoader.getController();
            controller.setService(service1);
            stage.showAndWait();
            rentals.clear();
            rentals.addAll(service1.getAll());
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window: Rental.", e);
        }

    }
    public void btnRentalLongestEventClick(ActionEvent actionEvent) {
        String a = txtLongestDay.getText();

        int day = Integer.MIN_VALUE;
        List<Rental> all = service1.getAll();
        for (Rental i : all) {
            int temp = Integer.parseInt(i.getDay());
            if (temp>day && i.getDay().equals(a)) {
                day=temp;
            }
        }
        name.setText(day+"");
    }

}