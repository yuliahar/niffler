package niffler.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureId;
import niffler.jupiter.ScreenshotExtension;
import niffler.jupiter.User;
import niffler.jupiter.UsersExtension;
import niffler.model.UserModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.$;
import static niffler.jupiter.User.UserType.ADMIN;
import static niffler.config.AppConfigReader.appConfig;
import static niffler.jupiter.User.UserType.COMMON;

@ExtendWith({ScreenshotExtension.class, UsersExtension.class})
public class NifflerLoginTest {
    public static final String URL = appConfig.frontendUrl();

    @AllureId("1")
    @Test
    void mainPageShouldBeDisplayedAfterSuccessLogin(@User(userType = ADMIN) UserModel user) {
        System.out.println("#### Test 1 " + user.toString());
        Allure.step("Check login", () -> {
            Selenide.open(URL);
            $("a[href*='redirect']").click();
            $("input[name='username']").setValue(user.getUsername());
            $("input[name='password']").setValue(user.getPassword());
            $("button[type='submit']").click();
            $(".header__title").shouldBe(Condition.visible)
                    .shouldHave(Condition.text("Niffler. The coin keeper."));
        });
    }

    @AllureId("2")
    @Test
    void mainPageShouldBeDisplayedAfterSuccessLogin0(@User(userType = ADMIN) UserModel user) {
        System.out.println("#### Test 2 " + user.toString());
        Allure.step("Check login", () -> {
            Selenide.open(URL);
            $("a[href*='redirect']").click();
            $("input[name='username']").setValue(user.getUsername());
            $("input[name='password']").setValue(user.getPassword());
            $("button[type='submit']").click();
            $(".header__title").shouldBe(Condition.visible)
                    .shouldHave(Condition.text("Niffler. The coin keeper."));
        });
    }

    @AllureId("3")
    @Test
    void mainPageShouldBeDisplayedAfterSuccessLogin1(@User UserModel user) {
        System.out.println("#### Test 3 " + user.toString());
        Allure.step("Check login", () -> {
            Selenide.open(URL);
            $("a[href*='redirect']").click();
            $("input[name='username']").setValue(user.getUsername());
            $("input[name='password']").setValue(user.getPassword());
            $("button[type='submit']").click();
            $(".header__title").shouldBe(Condition.visible)
                    .shouldHave(Condition.text("Niffler. The coin keeper."));
        });
    }

    @AllureId("4")
    @Test
    void mainPageShouldBeDisplayedAfterSuccessLogin2(@User UserModel user) {
        System.out.println("#### Test 4 " + user.toString());
        Allure.step("Check login", () -> {
            Selenide.open(URL);
            $("a[href*='redirect']").click();
            $("input[name='username']").setValue(user.getUsername());
            $("input[name='password']").setValue(user.getPassword());
            $("button[type='submit']").click();
            $(".header__title").shouldBe(Condition.visible)
                    .shouldHave(Condition.text("Niffler. The coin keeper."));
        });
    }

    @AllureId("5")
    @Test
    void mainPageShouldBeDisplayedAfterSuccessLogin3(@User UserModel user) {
        System.out.println("#### Test 5 " + user.toString());
        Allure.step("Check login", () -> {
            Selenide.open(URL);
            $("a[href*='redirect']").click();
            $("input[name='username']").setValue(user.getUsername());
            $("input[name='password']").setValue(user.getPassword());
            $("button[type='submit']").click();
            $(".header__title").shouldBe(Condition.visible)
                    .shouldHave(Condition.text("Niffler. The coin keeper."));
        });
    }

    @AllureId("6")
    @Test
    void mainPageShouldBeDisplayedAfterSuccessLogin4(@User(userType = COMMON) UserModel userFirst,
                @User(userType = COMMON) UserModel userSecond) {

        System.out.println("#### Test 6 " + userFirst.toString());
        System.out.println("#### Test 6 " + userSecond.toString());

        Allure.step("Check login via user " + userFirst , () -> {
            Selenide.open(URL);
            $("a[href*='redirect']").click();
            $("input[name='username']").setValue(userFirst.getUsername());
            $("input[name='password']").setValue(userFirst.getPassword());
            $("button[type='submit']").click();
            $(".header__title").shouldBe(Condition.visible)
                    .shouldHave(Condition.text("Niffler. The coin keeper."));
            $(".button-icon_type_logout").click();
        });
    }
}
