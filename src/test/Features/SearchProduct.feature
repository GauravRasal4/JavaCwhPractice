Feature: Searching product on "Green-kart" landing and offers page
  @SearchProduct
  Scenario Outline: User search same product on landing page and Offers page and validating the same
    Given User is on GreenKart landing page
    When User search product with shortname <Name> at landing page and extracted the same product
    Then User search same product at offers page with shortname <Name>
    And validate that offers page product matches with landing page product

    Examples:
      | Name |
      | Tom  |
      | Beet |