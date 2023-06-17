import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class WeekNumberCalculator extends Application {

    @Override
    public void start(Stage primaryStage) {

        Label dateLabel = new Label("Введите дату в формате ДД.ММ.ГГГГ:");
        TextField dateTextField = new TextField();
        Button calculateButton = new Button("Получить номер недели");
        Label resultLabel = new Label();

        calculateButton.setOnAction(event -> {
            try {
                String dateString = dateTextField.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate date = LocalDate.parse(dateString, formatter);

                WeekFields weekFields = WeekFields.of(Locale.getDefault());
                int weekNumber = date.get(weekFields.weekOfWeekBasedYear());

                resultLabel.setText("Номер недели: " + weekNumber);
            } catch (Exception e) {
                resultLabel.setText("Ошибка: неверный формат даты.");
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(dateLabel, 0, 0);
        gridPane.add(dateTextField, 1, 0);
        gridPane.add(calculateButton, 1, 1);
        gridPane.add(resultLabel, 1, 2);

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Вычисление номера недели");
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);

        // создаём документацию с помощью javadoc
        javadoc WeekNumberCalculator.java();
    }
}