@OMT-7927
Feature: Validating etsy titles

  Scenario Outline: Validating etsy separate page title
    Given user navigates to the Etsy application
    When  user click on "<Section>" section
    Then user validate title is "<Title>"


    Examples:
      | Title                                         | Section                  |
      | The Best Mother's Day 2022 Gift Ideas \| Etsy | Mother's Day Gifts       |
      | Jewelry & Accessories \| Etsy                 | Jewelry and Accessories  |
      | Clothing & Shoes \| Etsy                      | Clothing and Shoes       |
      | Home & Living \| Etsy                         | Home and Living          |
      | Wedding & Party \| Etsy                       | Wedding and Party        |
      | Toys & Entertainment \| Etsy                  | Toys and Entertainment   |
      | Art & Collectibles \| Etsy                    | Art and Collectibles     |
      | Craft Supplies & Tools \| Etsy                | Craft Supplies and Tools |
      | The Etsy Gift Guide for 2022 \| Etsy          | Gifts and Gift Cards     |


