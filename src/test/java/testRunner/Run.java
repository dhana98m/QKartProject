package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={".//Features/UI_Validation.feature",".//Features/Home_Elements_Count.feature",
		                   ".//Features/Page_Attributes.feature",".//Features/Login.feature",".//Features/Add_Items_To_Cart.feature"},
		         glue="stepDefinitions",
		         dryRun=false,
		         monochrome=true,
		         plugin= {"pretty"})
public class Run {

}
//Home_Elements_Count.feature
//UI_Validation.feature
//Page_Attributes.feature
//Login.feature
//Add_Items_To_Cart.feature