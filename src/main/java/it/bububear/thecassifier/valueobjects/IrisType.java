package it.bububear.thecassifier.valueobjects;

import it.bububear.thecassifier.exceptions.IrisUnknownTypeException;
import it.bububear.thecassifier.weka.IrisClassifier;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class IrisType {

  public static final String IRIS_SETOSA = "Iris-setosa";
  public static final String IRIS_VERSICOLOR = "Iris-versicolor";
  public static final String IRIS_VIRGINICA = "Iris-virginica";

  @Setter(AccessLevel.NONE)
  private String irisTypeValue;


  public IrisType(String irisTypeInput) throws IrisUnknownTypeException {
    switch (irisTypeInput) {
      case IRIS_SETOSA:
        irisTypeValue = IRIS_SETOSA;
        break;
      case IRIS_VERSICOLOR:
        irisTypeValue = IRIS_VERSICOLOR;
        break;
      case IRIS_VIRGINICA:
        irisTypeValue = IRIS_VIRGINICA;
        break;
      default:
        throw new IrisUnknownTypeException(String.format("The following: %s is NOT an iris type", irisTypeInput));
    }
  }

  public IrisType(ClassificationOutput classificationOutput) {
    double irisDoubleValue = classificationOutput.getClassifiedClass();
    if (irisDoubleValue == IrisClassifier.IRIS_SETOSA_DOUBLE_VALUE)
      irisTypeValue = IRIS_SETOSA;
    else if (irisDoubleValue == IrisClassifier.IRIS_VERSICOLOR_DOUBLE_VALUE)
      irisTypeValue = IRIS_VERSICOLOR;
    else if (irisDoubleValue == IrisClassifier.IRIS_VIRGINICA_DOUBLE_VALUE)
      irisTypeValue = IRIS_VIRGINICA;
    else
      throw new IrisUnknownTypeException(String.format("The following: %s is NOT an iris type", irisDoubleValue));
  }

}
