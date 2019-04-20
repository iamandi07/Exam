package UI;

import Service.RentalService;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RentalAddController {
    public Spinner spnId;
    public TextField txtRentalCarid;
    public TextField txtRentalDay;
    public TextField txtRentalDistance1;
    public Button btnRentalCar;
    public Button btnCancel;
    private RentalService service1;

    public void setService(RentalService service1) {
        this.service1 = service1;
    }

    public void btnAddClick(ActionEvent actionEvent) {
        try {
            String id = String.valueOf(spnId.getValue());
            String carid = txtRentalCarid.getText();
            String day = txtRentalDay.getText();
            String distance = txtRentalDistance1.getText();
            service1.upsert(id, carid, day, distance);
            btnCancelClick(actionEvent);
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }

    }


    public void btnCancelClick(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}