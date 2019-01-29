import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {


	@FXML
	private BarChart<String, Integer> reputation;

	@FXML
	private CategoryAxis x;

	@FXML
	private NumberAxis y;

	@FXML
	private JFXTextField newFactName;

	@FXML
	private JFXTextField newFactRep;

	@FXML
	private Label goldAmount;

	@FXML
	private JFXTextField goldOp;

	@FXML
	private Label calendarLabel;

	int dayCounter = 1;

	@FXML
	public void initialize() {

		XYChart.Series series1 = new XYChart.Series();      
		series1.getData().add(new XYChart.Data("Imperiaux", 50));
		series1.getData().add(new XYChart.Data("Thalmor", 50));
		series1.getData().add(new XYChart.Data("Mercenaires", 50));
		series1.getData().add(new XYChart.Data("Sombrage", 50));     

		reputation.getData().addAll(series1);
	}

	@FXML
	void addNewfac(ActionEvent event) {
		String name = newFactName.getText();
		int value = Integer.parseInt(newFactRep.getText());

		XYChart.Series series1 = new XYChart.Series();      
		series1.getData().add(new XYChart.Data(name, value));
		reputation.getData().addAll(series1);


	}

	@FXML
	void removeGold(ActionEvent event) {
		int result = Integer.parseInt(goldAmount.getText());
		result -= Integer.parseInt(goldOp.getText());
		goldAmount.setText(Integer.toString(result));
		goldOp.setText("");
	}

	@FXML
	void addGold(ActionEvent event) {
		int result = Integer.parseInt(goldAmount.getText());
		result += Integer.parseInt(goldOp.getText());
		goldAmount.setText(Integer.toString(result));
		goldOp.setText("");
	}

	@FXML
	void nextDay(ActionEvent event) {

		String[] split = calendarLabel.getText().split(" ");
		String month = split[3];
		if(dayCounter == 30) {
			dayCounter = 1;
			switch(split[3]) {
			case "Primétoile":
				month = "Clairciel";
				break;
			case "Clairciel":
				month = "Semailles";
				break;
			case "Semailles":
				month = "Ondepluie";
				break;
			case "Ondepluie":
				month = "Plantaisons";
				break;
			case "Plantaisons":
				month = "MilAn";
				break;
			case "MilAn":
				month = "Hautzénith";
				break;
			case "Hautzénith":
				month = "Vifazur";
				break;
			case "Atrefeu":
				month = "Soufflegivre";
				break;
			case "Soufflegivre":
				month = "Sombreciel";
				break;
			case "Sombreciel":
				month = "Soirétoile";
				break;
			case "Soirétoile":
				month = "Primétoile";
				break;
			}
		}else {
			dayCounter++;
		}

		String result = "";


		switch(split[0]) {
		case "Morndas":
			result = "Tirdas "+dayCounter;
			break;
		case "Tirdas":
			result = "Middas "+dayCounter;
			break;
		case "Middas":
			result = "Turdas "+dayCounter;
			break;
		case "Turdas":
			result = "Fredas "+dayCounter;
			break;
		case "Fredas":
			result = "Loredas "+dayCounter;
			break;
		case "Loredas":
			result = "Sundas "+dayCounter;
			break;
		case "Sundas":
			result = "Morndas "+dayCounter;
			break;
		}

		result += " de "+month +" "+split[4];
		calendarLabel.setText(result);
	}

	@FXML
	void nextMonth(ActionEvent event) {

		String[] split = calendarLabel.getText().split(" ");
		String month = "";
		switch(split[3]) {
		case "Primétoile":
			month = "Clairciel";
			break;
		case "Clairciel":
			month = "Semailles";
			break;
		case "Semailles":
			month = "Ondepluie";
			break;
		case "Ondepluie":
			month = "Plantaisons";
			break;
		case "Plantaisons":
			month = "MilAn";
			break;
		case "MilAn":
			month = "Hautzénith";
			break;
		case "Hautzénith":
			month = "Vifazur";
			break;
		case "Vifazur":
			month = "Atrefeu";
			break;
		case "Atrefeu":
			month = "Soufflegivre";
			break;
		case "Soufflegivre":
			month = "Sombreciel";
			break;
		case "Sombreciel":
			month = "Soirétoile";
			break;
		case "Soirétoile":
			month = "Primétoile";
			break;
		}
		
		String result = split[0]+" "+split[1]+" "+split[2]+" "+month +" "+split[4];
		calendarLabel.setText(result);
	}

	@FXML
	void nextWeek(ActionEvent event) {

	}


}
