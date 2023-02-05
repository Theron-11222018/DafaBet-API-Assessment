import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.commons.validator.GenericValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UnixDateTimeStampTestCases {


    private String endpoint = "https://helloacm.com/api/unix-timestamp-converter/?cached&s=";

    @BeforeClass
    public void setup() {
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Data For UnixTimeStampToDateString")
    @Story("Test Data For UnixTimeStampToDateString")
    @TmsLink("Test Data For UnixTimeStampToDateString")
    @Epic("Test Data For UnixTimeStampToDateString")
    @Test(dataProvider = "unixTimeStampToDateTestData")
    public void validatingUnixTimeStampToDateString(String timeStamp, String date) {
        Response response = given().get(endpoint + timeStamp);
        Assert.assertEquals(response.getBody().asString(), date);
        Assert.assertTrue(GenericValidator.isDate(response.getBody().asString(), "\"yyyy-MM-dd hh:mm:ss\"", true));
    }

    @DataProvider(name = "unixTimeStampToDateTestData")
    public Object[][] unixTimeStampToDateTestData() {
        return new Object[][]
                {
                        {"2221616666", "\"2040-05-26 03:44:26\""},
                        {"1451613801", "\"2016-01-01 02:03:21\""},
                        {"1451613555", "\"2016-01-01 01:59:15\""},
                        {"1", "\"1970-01-01 12:00:01\""},
                        {"0", "\"1970-01-01 12:00:00\""},
                };
    }


    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Data For Incorrect Values")
    @Story("Test Data For Incorrect Values")
    @TmsLink("Test Data For Incorrect Values")
    @Epic("Test Data For Incorrect Values")
    @Test(dataProvider = "incorrectValuesTestData")
    public void validatingIncorrectValues(String input) {
        Response response = given().get(endpoint + input);
        Assert.assertEquals(response.getBody().asString(), "false");
    }

    @DataProvider(name = "incorrectValuesTestData")
    public Object[][] incorrectValuesTestData() {
        return new Object[][]
                {
                        {"1451613abc"},
                        {""}
                };
    }
}