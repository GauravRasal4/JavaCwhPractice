Feature: Searching product on "Green-kart" landing and offers page
  @PlaceOrder
  Scenario Outline: User search same product on landing page and Offers page and validating the same
    Given User is on GreenKart landing page
    When User search product with shortname <Name> at landing page and extracted the same product
    And Added "3" items for same product into cart and proceed to checkout
    Then User verify that same product <Name> visible in checkout page
    And User apply promo code and place order successfully

    Examples:
      | Name |
      | Tom  |