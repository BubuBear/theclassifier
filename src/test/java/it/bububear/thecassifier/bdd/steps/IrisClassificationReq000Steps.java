package it.bububear.thecassifier.bdd.steps;

import com.thoughtworks.gauge.Step;
import it.bububear.thecassifier.exceptions.IrisFeaturesFormatException;
import it.bububear.thecassifier.factories.IrisFeaturesFactory;
import it.bububear.thecassifier.service.IrisClassifierService;
import it.bububear.thecassifier.service.IrisClassifierServiceSimple;
import it.bububear.thecassifier.valueobjects.IrisFeatures;
import it.bububear.thecassifier.valueobjects.IrisType;

import static org.assertj.core.api.Assertions.assertThat;

public class IrisClassificationReq000Steps {

  private IrisFeatures irisFeatures;
  private IrisClassifierService irisClassifierService;
  private IrisType classifiedIrisType;
  private IrisFeaturesFormatException irisFeaturesFormatException;

  @Step("Alice must open the application")
  public void loadApplication() {
    irisClassifierService = new IrisClassifierServiceSimple();
  }

  @Step("When Alice insert sepal length: <5.1>, sepal width:<3.5>, petal length:<1.4>, petal width:<0.2>")
  public void insertInputData(String sepalLength, String sepalWidth, String petalLength, String petalWidth) {
    try {
      irisFeatures = IrisFeaturesFactory.createIrisFeatures(sepalLength, sepalWidth, petalLength, petalWidth);
    } catch (IrisFeaturesFormatException capturedIrisFeaturesFormatException) {
      irisFeaturesFormatException = capturedIrisFeaturesFormatException;
    }
  }

  @Step("And when Alice start classify process")
  public void classifyIris() {
    classifiedIrisType = irisClassifierService.classify(irisFeatures);
  }

  @Step("Then Alice will see the following iris-type: <Iris-setosa>")
  public void testIrisSubtype(String expectedIrisType) {
    IrisType irisTypeExpected = new IrisType(expectedIrisType);
    assertThat(classifiedIrisType).isEqualTo(irisTypeExpected);
  }

  @Step("Then Alice will see the the following error message <Sepal Length Input is not correct, fix it! (remember for double number use . and not , (i.e. 5.4))>")
  public void testErrorMessage(String expectedErrorMessage) {
    IrisFeaturesFormatException irisFeaturesFormatExceptionExpected = new IrisFeaturesFormatException(expectedErrorMessage);
    assertThat(irisFeaturesFormatException).isEqualTo(irisFeaturesFormatExceptionExpected);
  }
}
