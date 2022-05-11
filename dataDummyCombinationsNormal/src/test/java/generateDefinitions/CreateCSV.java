package generateDefinitions;

import CreateDataCSV.DataCSV;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class CreateCSV {

    @Given("Create Scenario {string}{string}{string}")
    public void create_scenario(String case1, String case2, String case3) throws IOException, InterruptedException {

        System.out.println("APPFILE Generating");
        DataCSV dataCSV = new DataCSV();
        dataCSV.dataDummy(case1, case2, case3);


    }
}

