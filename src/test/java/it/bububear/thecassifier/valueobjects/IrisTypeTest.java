package it.bububear.thecassifier.valueobjects;

import it.bububear.thecassifier.exceptions.IrisUnknownTypeException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IrisTypeTest {

  @Test
  void creationOfIrisSetosaType() {
    String irisSetosaExpected = "Iris-setosa";
    IrisType irisTypeActual = new IrisType(irisSetosaExpected);
    assertThat(irisTypeActual.getIrisTypeValue()).isEqualTo(irisSetosaExpected);
  }

  @Test
  void creationOfIrisVersicolorType() {
    String irisVersicolorExpected = "Iris-versicolor";
    IrisType irisTypeActual = new IrisType(irisVersicolorExpected);
    assertThat(irisTypeActual.getIrisTypeValue()).isEqualTo(irisVersicolorExpected);
  }

  @Test
  void creationOfIrisVirginicaType() {
    String irisVirginicaExpected = "Iris-virginica";
    IrisType irisTypeActual = new IrisType(irisVirginicaExpected);
    assertThat(irisTypeActual.getIrisTypeValue()).isEqualTo(irisVirginicaExpected);
  }

  @Test
  void creationOfIrisUnknownType() {
    String irisUnknownInput = "nothing";
    boolean isExceptionIsTrough = false;
    try {
      new IrisType(irisUnknownInput);
    } catch (IrisUnknownTypeException e) {
      isExceptionIsTrough = true;
    }
    assertThat(isExceptionIsTrough).isTrue();
  }

  @Test
  void creationOfIrisSetosaTypeFromDouble() {
    String irisSetosaExpected = "Iris-setosa";
    double irisSetosaDoubleValue = 0.0;
    ClassificationOutput classificationOutputExpected = new ClassificationOutput(irisSetosaDoubleValue);
    IrisType irisTypeActual = new IrisType(classificationOutputExpected);
    assertThat(irisTypeActual.getIrisTypeValue()).isEqualTo(irisSetosaExpected);
  }

  @Test
  void creationOfIrisVersicolorTypeFromDouble() {
    String irisVersicolorExpected = "Iris-versicolor";
    double irisSetosaDoubleValue = 1.0;
    ClassificationOutput classificationOutputExpected = new ClassificationOutput(irisSetosaDoubleValue);
    IrisType irisTypeActual = new IrisType(classificationOutputExpected);
    assertThat(irisTypeActual.getIrisTypeValue()).isEqualTo(irisVersicolorExpected);
  }

  @Test
  void creationOfIrisVirginicaTypeFromDouble() {
    String irisVirginicaExpected = "Iris-virginica";
    double irisSetosaDoubleValue = 2.0;
    ClassificationOutput classificationOutputExpected = new ClassificationOutput(irisSetosaDoubleValue);
    IrisType irisTypeActual = new IrisType(classificationOutputExpected);
    assertThat(irisTypeActual.getIrisTypeValue()).isEqualTo(irisVirginicaExpected);
  }

}
