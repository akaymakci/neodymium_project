package template.cucumber.tests;

import com.xceptance.neodymium.NeodymiumCucumberRunner;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(NeodymiumCucumberRunner.class)
@CucumberOptions(features = "src/test/java/template/cucumber/features", glue = "template", monochrome = true, plugin =
    {
        "pretty", // console output
        "html:target/cucumber-report/", // html report
    })
public class RunAllFeaturesTest
{
}
