package pageObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
		// read json to String
		String jsonContent = FileUtils.readFileToString(
				new File(System.getProperty("user.dir") + "\\src\\data\\Logindata.json"), StandardCharsets.UTF_8);

		// String to HashMap Jackson Datbind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;

	}
}

//<listeners>
//<listener   class-name="tests.Listeners"/>
//</listeners>

//cd C:\Users\mahelmy\Downloads\allure-2.35.1\allure-2.35.1\bin
//allure.bat serve C:\Users\mahelmy\eclipse-workspace\SampleWebShop\allure-results
//----
//allure.bat generate C:\Users\mahelmy\eclipse-workspace\SampleWebShop\allure-results -o C:\Users\mahelmy\eclipse-workspace\SampleWebShop\allure-report --clean