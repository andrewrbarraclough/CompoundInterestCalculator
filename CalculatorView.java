import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;

public class CalculatorView extends Application {
  @FXML
  private GridPane GridPane;
  @FXML
  private Label balanceLabel;
  @FXML
  private TextField balanceField;
  @FXML
  private Label interestLabel;
  @FXML
  private TextField interestField;
  @FXML
  private Label calcPeriodLabel;
  @FXML
  private TextField calcPeriodField;
  @FXML
  private Label monthlyDepositLabel;
  @FXML
  private TextField monthlyDepositField;
  @FXML
  private Button calculateButton;
  @FXML
  private TextField futureValueField;
  @FXML
  private Label futureValueLabel;

  private volatile static CalculatorView instance = null;

  @FXML
  void initialize() {
    instance = this;
  }

  public synchronized static CalculatorView getInstance() {
    if (instance == null) {
      new Thread(() -> Application.launch(CalculatorView.class)).start();
      while (instance == null) {}
    }

    return instance;
  }

  @Override
  public void start(Stage primaryStage) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(new URL("file:///C:/Users/Andrew Barraclough/Documents/Programming/CompoundInterestCalculator/resources/calculatorView.fxml"));
    AnchorPane root = (AnchorPane) loader.load();
    Scene scene = new Scene(root, 1280, 720);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public double getInitialBalance() {
    return 0;
  }

  public double getInterestRate() {
    return 0;
  }

  public int getCalculationPeriod() {
    return 0;
  }

  public double getMonthlyDeposits() {
    return 0;
  }

  public void drawGraph(LinkedList<Node> list) {}
}
