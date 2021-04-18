package it.bububear.thecassifier.valueobjects;

import it.bububear.thecassifier.exceptions.IrisUnknownTypeException;
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

}
