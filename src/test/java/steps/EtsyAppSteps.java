package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EtsyAppHomePage;
import pages.EtsyAppSearchPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;
import java.util.Locale;

public class EtsyAppSteps {
    WebDriver driver = Driver.getDriver();
    EtsyAppHomePage etsyAppHomePage = new EtsyAppHomePage();
    EtsyAppSearchPage searchPage = new EtsyAppSearchPage();

    @Given("user navigates to the Etsy application")
    public void user_navigates_to_the_Etsy_application() {
        driver.get(ConfigReader.getProperty("EtsyURL"));

    }

    @When("user searches for {string}")
    public void user_searches_for(String itemName) {
        etsyAppHomePage.searchBox.sendKeys(itemName + Keys.ENTER);


    }

    @When("user applies price filter over {int}")
    public void user_applies_price_filter_over(Integer price) {
        searchPage.Allfilter.click();
        searchPage.priceRadioButton.click();
        searchPage.applyButton.click();


    }

    @Then("user validates the items price is equal or over {double}")
    public void user_validates_the_items_price_is_equal_or_over(Double price) throws InterruptedException {
        List<WebElement> prices = searchPage.prices;

        Thread.sleep(3000);

        for (WebElement element : prices) { //it will loop as many times as the number of elements

            String priceStr = element.getText().replace(",", "");//"1,800.00"--->"1800.00"

            double doublePrice = Double.parseDouble(priceStr);
            System.out.println(doublePrice);
            Assert.assertTrue(doublePrice >= price);//price wrom reature ==1000.00

        }

    }

    @Then("user validates search result items contain keyword {string} or {string}")
    public void userValidatesSearchResultItemsContainKeyword(String item1, String item2) {
        List<WebElement> itemNames = searchPage.itemNames;

        for (int i = 0; i < itemNames.size(); i++) {
            String newItemName = itemNames.get(i).getText();
            boolean condition = newItemName.toLowerCase(Locale.ROOT).contains(item1) || newItemName.toLowerCase(Locale.ROOT).contains(item2);
            if (condition) {
                StringBuilder str = new StringBuilder();
                str.append(newItemName);
                System.out.println(str);
                Assert.assertTrue(str.toString().toLowerCase(Locale.ROOT).contains(item1) || str.toString().toLowerCase(Locale.ROOT).contains(item2));
            }
        }
    }

    @When("user click on {string} section")
    public void userClickOnSection(String section) {
        if (section.equalsIgnoreCase("Mother's Day Gifts")) {
            etsyAppHomePage.mothersDayGift.click();
        } else if (section.equalsIgnoreCase("Jewelry and Accessories")) {
            etsyAppHomePage.jewelryAndAccessories.click();
        } else if (section.equalsIgnoreCase("Clothing and Shoes")) {
            etsyAppHomePage.clothingAndShoes.click();
        } else if (section.equalsIgnoreCase("Home and Living")) {
            etsyAppHomePage.homeAndLiving.click();
        } else if (section.equalsIgnoreCase("Wedding and Party")) {
            etsyAppHomePage.weddingAndParty.click();
        } else if (section.equalsIgnoreCase("Toys and Entertainment")) {
            etsyAppHomePage.toysAndEntertainment.click();
        } else if (section.equalsIgnoreCase("Art and Collectibles")) {
            etsyAppHomePage.artAndCollectibles.click();
        } else if (section.equalsIgnoreCase("Craft Supplies and Tools")) {
            etsyAppHomePage.craftAndSupplies.click();
        } else if (section.equalsIgnoreCase("Gifts and Gift Cards")) {
            etsyAppHomePage.giftsAbdGiftCards.click();
        }


    }

    @Then("user validate title is {string}")
    public void userValidateTitleIs(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }
}