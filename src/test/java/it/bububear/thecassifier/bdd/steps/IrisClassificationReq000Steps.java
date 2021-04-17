package it.bububear.thecassifier.bdd.steps;

import com.thoughtworks.gauge.Step;

import static org.junit.jupiter.api.Assertions.fail;

public class IrisClassificationReq000Steps {
  @Step("Alice must open the application")
  public void loadApplication() {
    fail(); //TODO implement me
  }

  @Step("When Alice insert sepal length: <5.1>, sepal width:<3.5>, petal length:<1.4>, petal width:<0.2>")
  public void insertInputData(String sepalLength, String sepalWidth, String petalLength, String petalWidth) {
    fail(); //TODO implement me
  }

  @Step("And when Alice start classify process")
  public void classifyIris() {
    fail(); //TODO implement me
  }

  @Step("Then Alice will see the following iris-type: <Iris-setosa>")
  public void testIrisSubtype(String expectedIrisType) {
    fail(); //TODO implement me
  }

  @Step("Then Alice will see the the following error message <Sepal Lenght Input is not correct, fix it! (remember for double number use . and not , (i.e. 5.4))>")
  public void testErrorMessage(String expectedErrorMessage) {
    fail(); //TODO implement me
  }
}
