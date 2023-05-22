package Runner.Android;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = {"src/test/java/features/Android/MyFeatures"},
        glue = {"support",
                "resources",
                "stepDefinitions/Android"},
        tags = "@android",
        monochrome = true
)
public class TestRunner_virdee_Android extends AbstractTestNGCucumberTests  {

}
