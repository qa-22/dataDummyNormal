Feature: Lending

  @data
  Scenario Outline: Generate Data Dummy Combinations
    Given Create Scenario "<Case>"

    Examples:
      | Case    |
      | APPFILE |