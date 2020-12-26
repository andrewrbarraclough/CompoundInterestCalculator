import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
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
  private Button clearButton;
  @FXML
  private TextField futureValueField;
  @FXML
  private Label futureValueLabel;
  @FXML
  private StackedBarChart<String, Double> stackedBarChart;

  XYChart.Series<String, Double> initialBalance;
  XYChart.Series<String, Double> totalDeposits;
  XYChart.Series<String, Double> totalInterest;

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
    loader.setLocation(new URL("file:resources/calculatorView.fxml"));
    AnchorPane root = (AnchorPane) loader.load();
    Scene scene = new Scene(root, 1280, 720);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public void addCalcObserver(Observer f) {
    calculateButton.setOnAction(event -> f.notifyObservers());
  }

  public void addClearObserver(Observer f) {
    clearButton.setOnAction(event -> f.notifyObservers());
  }

  public double getInitialBalance() {
    return Double.parseDouble(balanceField.getText());
  }

  public double getInterestRate() {
    return (Double.parseDouble(interestField.getText()) / 100);
  }

  public int getCalculationPeriod() {
    return Integer.parseInt(calcPeriodField.getText());
  }

  public double getMonthlyDeposits() {
    return Double.parseDouble(monthlyDepositField.getText());
  }

  public void drawGraph(LinkedList<Node> list) {
    while (!stackedBarChart.getData().isEmpty()) {
      stackedBarChart.getData().remove(stackedBarChart.getData().size() - 1);
    }

    initialBalance = new XYChart.Series<>();
    totalDeposits = new XYChart.Series<>();
    totalInterest = new XYChart.Series<>();

    initialBalance.setName("Initial Balance");
    totalDeposits.setName("Total Deposits");
    totalInterest.setName("Total Interest");

    for (int i = 1; i < list.size(); i++) {
      initialBalance.getData().add(new XYChart.Data<>(Integer.toString(i), list.get(0).getBalance()));
      totalDeposits.getData().add(new XYChart.Data<>(Integer.toString(i), list.get(i).getTotalDeposits()));
      totalInterest.getData().add(new XYChart.Data<>(Integer.toString(i), list.get(i).getTotalInterest()));
    }

    stackedBarChart.getData().addAll(initialBalance, totalDeposits, totalInterest);
  }

  public void clear() {
    initialBalance.getData().clear();
    totalDeposits.getData().clear();
    totalInterest.getData().clear();

    while (!stackedBarChart.getData().isEmpty()) {
      stackedBarChart.getData().remove(stackedBarChart.getData().size() - 1);
    }
  }
}