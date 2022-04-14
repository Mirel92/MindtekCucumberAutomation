@OMT-7932 @regression
Feature: Validating pizza application functionalities

  Scenario Outline: Validating place order functionality
    Given user navigates to pizza application
    When user creates pizza order with data
      | Pizza        | <Pizza>        |
      | Toppings 1   | <Toppings 1>   |
      | Toppings 2   | <Toppings 2>   |
      | Quantity     | <Quantity>     |
      | Name         | <Name>         |
      | Email        | <Email>        |
      | Phone        | <Phone>        |
      | Payment Type | <Payment Type> |
    Then user validates that order is created  with success message "Thank you for your order! TOTAL: " " <Pizza>"

    Examples:
      | Pizza                        | Toppings 1 | Toppings 2   | Quantity | Name        | Email           | Phone     | Payment Type   |
      | Small 6 Slices - no toppings | Mushrooms  | Extra cheese | 1        | Patel Harsh | patel@gmail.com | 123456789 | Credit Card    |
      | Large 10 Slices - 2 toppings | Mushrooms  | Extra cheese | 2        | John Doe    | doe@gmail.com   | 123452389 | Cash on Pickup |
      | Medium 8 Slices - 2 toppings | Olives     | Salami       | 3        | Kim Yan     | kim@gmail.com   | 178456789 | Credit Card    |
