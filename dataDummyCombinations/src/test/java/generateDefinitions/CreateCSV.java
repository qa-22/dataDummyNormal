package generateDefinitions;

import CreateDataCSV.DataCSV;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class CreateCSV {

    @Given("Create Scenario {string}")
    public void create_scenario(String tCase) throws IOException, InterruptedException {
        if (tCase.contains("APPFILE")) {
            DataCSV dataCSV = new DataCSV();
            dataCSV.dataDummy();
        } else if (tCase.contains("REAFILE")) {
            System.out.println("REAFILE");

        } else if (tCase.contains("PENGURUS")) {
            System.out.println("PENGURUS");
        }
    }
}
