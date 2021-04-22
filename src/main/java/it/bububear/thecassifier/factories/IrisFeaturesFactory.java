package it.bububear.thecassifier.factories;

import it.bububear.thecassifier.exceptions.IrisFeaturesFormatException;
import it.bububear.thecassifier.valueobjects.*;

public class IrisFeaturesFactory {
  public static IrisFeatures createIrisFeatures(String sepalLength, String sepalWidth, String petalLength, String petalWidth) throws IrisFeaturesFormatException {
    SepalLength sepalLengthExtracted = extractSepalLength(sepalLength);
    SepalWidth sepalWidthExtracted = extractSepalWidth(sepalWidth);
    PetalLength petalLengthExtracted = extractPetalLength(petalLength);
    PetalWidth petalWidthExtracted = extractPetalWidth(petalWidth);
    return new IrisFeatures(sepalLengthExtracted, sepalWidthExtracted, petalLengthExtracted, petalWidthExtracted);
  }

  public static IrisFeatures createIrisFeatures(Double sepalLength, Double sepalWidth, Double petalLength, Double petalWidth)  {
    SepalLength sepalLengthExtracted = new SepalLength(sepalLength);
    SepalWidth sepalWidthExtracted = new SepalWidth(sepalWidth);
    PetalLength petalLengthExtracted = new PetalLength(petalLength);
    PetalWidth petalWidthExtracted = new PetalWidth(petalWidth);
    return new IrisFeatures(sepalLengthExtracted, sepalWidthExtracted, petalLengthExtracted, petalWidthExtracted);
  }

  private static SepalLength extractSepalLength(String sepalLengthString) throws IrisFeaturesFormatException {
    SepalLength sepalLength;
    try {
      sepalLength = new SepalLength(Double.parseDouble(sepalLengthString));
    } catch (NumberFormatException e) {
      throw new IrisFeaturesFormatException(IrisFeaturesFormatException.WRONG_SEPAL_LENGTH_MSG);
    }
    return sepalLength;
  }

  private static SepalWidth extractSepalWidth(String sepalWidthString) throws IrisFeaturesFormatException {
    SepalWidth sepalWidth;
    try {
      sepalWidth = new SepalWidth(Double.parseDouble(sepalWidthString));
    } catch (NumberFormatException e) {
      throw new IrisFeaturesFormatException(IrisFeaturesFormatException.WRONG_SEPAL_WIDTH_MSG);
    }
    return sepalWidth;
  }

  private static PetalLength extractPetalLength(String petalLengthString) throws IrisFeaturesFormatException {
    PetalLength petalLength;
    try {
      petalLength = new PetalLength(Double.parseDouble(petalLengthString));
    } catch (NumberFormatException e) {
      throw new IrisFeaturesFormatException(IrisFeaturesFormatException.WRONG_PETAL_LENGTH_MSG);
    }
    return petalLength;
  }

  private static PetalWidth extractPetalWidth(String petalWidthString) throws IrisFeaturesFormatException {
    PetalWidth petalWidth;
    try {
      petalWidth = new PetalWidth(Double.parseDouble(petalWidthString));
    } catch (NumberFormatException e) {
      throw new IrisFeaturesFormatException(IrisFeaturesFormatException.WRONG_PETAL_WIDTH_MSG);
    }
    return petalWidth;
  }
}
