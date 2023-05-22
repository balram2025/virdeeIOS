package Runner.iOS;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = {"src/test/java/features/iOS/MyFeaturess/A1_CheckiN_EndToEnd.feature"},
        glue = {"support",
                "resources",
                "stepDefinitions"},
        tags = "@ios and @chrome",
        monochrome = true
)
public class TestRunner_Virdee_IOS extends AbstractTestNGCucumberTests {

}
