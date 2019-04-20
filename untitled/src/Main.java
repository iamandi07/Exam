import Domain.*;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.CarService;
import Service.RentalService;
import UI.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UI/sample.fxml"));
        Parent root = fxmlLoader.load();

        Controller controller =  fxmlLoader.getController();

        IValidator<Car> carValidator =  new CarValidator();
        IValidator<Rental> rentalValidator = new RentalValidator();

        IRepository<Car> carRepository = new InMemoryRepository<>(carValidator);
        IRepository<Rental> rentalRepository = new InMemoryRepository<>(rentalValidator);

        CarService carService = new CarService(carRepository);
        carService.upsert("1", "opel", "123", "200");
        carService.upsert("2", "Eclair", "15", "250");

        RentalService rentalService = new RentalService(rentalRepository);
        rentalService.upsert("1", "dacia", "123", "200");
        rentalService.upsert("2", "betfair", "15", "250");
        controller.setServices(carService, rentalService);

        primaryStage.setTitle("Car manager");
        primaryStage.setScene(new Scene(root, 650, 500));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
