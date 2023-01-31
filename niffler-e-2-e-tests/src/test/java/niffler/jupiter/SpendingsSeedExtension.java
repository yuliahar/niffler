package niffler.jupiter;

import niffler.model.Currency;
import niffler.model.Spending;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static niffler.config.AppConfigReader.appConfig;

public class SpendingsSeedExtension implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        String dir = System.getProperty("user.dir") + "/src/test/resources/data/spendings";

        try {
            List<Path> paths = Files.walk(Paths.get(dir), 1)
                    .filter(Files::isRegularFile)
                    .filter(path -> path.getFileName().toString().endsWith(".json"))
                    .collect(Collectors.toList());

            for (Path path : paths) {
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(new FileReader(String.valueOf(path)));
                JSONObject jsonObject = (JSONObject) obj;

                Spending spending = Spending.builder()
                        .spendDate((String) jsonObject.get("spendDate"))
                        .category((String) jsonObject.get("category"))
                        .currency(Currency.valueOf((String) jsonObject.get("currency")))
                        .amount((Double) jsonObject.get("amount"))
                        .description((String) jsonObject.get("description"))
                        .username((String) jsonObject.get("username"))
                        .build();

                given()
                        .contentType(JSON)
                        .body(spending)
                        .when().log().all()
                        .post(appConfig.spendUrl() + "/addSpend")
                        .then()
                        .statusCode(201);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}