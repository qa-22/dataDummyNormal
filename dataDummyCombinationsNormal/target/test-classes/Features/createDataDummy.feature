Feature: Lending

  @data
  Scenario Outline: Generate Data Dummy Combinations
    Given Create Scenario "<Case1>""<Case2>""<Case3>"

    Examples:
      | Case1   | Case2   | Case3   |
      | APPFILE | REAFILE | PENGURUS |
