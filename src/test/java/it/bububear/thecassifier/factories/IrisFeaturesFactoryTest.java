package it.bububear.thecassifier.factories;

import it.bububear.thecassifier.exceptions.IrisFeaturesFormatException;
import it.bububear.thecassifier.valueobjects.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

class IrisFeaturesFactoryTest {

  /**
   * Test record -> 4.9,3.0,1.4,0.2
   */
  @Test
  void createIrisFeaturesOK() throws IrisFeaturesFormatException {
    SepalLength sepalLength = new SepalLength(4.9);
    SepalWidth sepalWidth = new SepalWidth(3.0);
    PetalLength petalLength = new PetalLength(1.4);
    PetalWidth petalWidth = new PetalWidth(0.2);
    IrisFeatures irisFeaturesExpected = new IrisFeatures(sepalLength, sepalWidth, petalLength, petalWidth);
    IrisFeatures irisFeaturesActual = IrisFeaturesFactory.createIrisFeatures("4.9", "3.0", "1.4", "0.2");
    assertThat(irisFeaturesActual).isEqualTo(irisFeaturesExpected);
  }

  /**
   * Test record -> wrongValue,3.0,1.4,0.2
   * "Sepal length is not correct, try to fix it! (remember for double number use . and not , (i.e. 5.4))
   */
  @Test
  void createIrisFeaturesKO() {
    IrisFeaturesFormatException irisFeaturesFormatExceptionExpected = new IrisFeaturesFormatException("Sepal length is not correct, try to fix it! (remember for double number use . and not , (i.e. 5.4))");
    boolean isExceptionWasCaught = false;
    try {
      IrisFeaturesFactory.createIrisFeatures("Wrong", "3.0", "1.4", "0.2");
    } catch (IrisFeaturesFormatException irisFeaturesFormatException) {
      assertThat(irisFeaturesFormatException.getMessage()).isEqualTo(irisFeaturesFormatExceptionExpected.getMessage());
      isExceptionWasCaught = true;
    }
    if (!isExceptionWasCaught)
      fail("--> Exception has not been throw at all!");
  }
}
