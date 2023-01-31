package niffler.test;

import com.codeborne.selenide.Selenide;

import niffler.jupiter.SpendingsSeedExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static niffler.config.AppConfigReader.appConfig;

@ExtendWith(SpendingsSeedExtension.class)
public class NifflerSpengingsTest{
	@Test
	@DisplayName("Filter spendings by today")
	void  shouldTestFilterSpendingsTableByToday (){
		System.out.println("Test: filter spendings table by today");

		Selenide.open(appConfig.frontendUrl());
		$("a[href*='redirect']").click();
		$("input[name='username']").setValue("user");
		$("input[name='password']").setValue("user");
		$("button[type='submit']").click();
		$(".main-content__section-history h2").scrollTo();
		$x("//button[contains(text(), \"Today\")]").click();

		$("table.spendings-table + div").shouldHave(text("No spendings provided yet!"));
	}
}
