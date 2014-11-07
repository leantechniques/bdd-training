Feature: Purchase Stocks
  As an investor
  I need to purchase stocks
  In order to manage my portfolio

  Scenario: Buy stocks by amount
    Given "PFG" costs $52.24
    When I purchase $1000.00 of "PFG" stock
    Then I own 19 shares of "PFG" for $992.56

  Scenario: Buy stocks by number of shares
    Given "PFG" costs $52.24
    When I purchase 19 shares of "PFG"
    Then I own 19 shares of "PFG" for $992.56

  Scenario: Insufficient Funds
    Given "PFG" costs $52.24
    When I purchase $20.00 of "PFG" stock
    Then I own 0 shares of "PFG" for $0

#  Buy (symbol shares/dollars):  PIXR $1000
#  You purchased 23 shares of PIXR for $991.53.
#  Buy (symbol shares/dollars):  GOOG 3
#  You purchased 3 shares of GOOG for $887.55.
#  Buy (symbol shares/dollars):