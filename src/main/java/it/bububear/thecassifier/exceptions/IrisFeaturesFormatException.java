package it.bububear.thecassifier.exceptions;

public class IrisFeaturesFormatException extends Exception {
  public final static String WRONG_SEPAL_LENGTH_MSG = "Sepal length is not correct, try to fix it! (remember for double number use . and not , (i.e. 5.4))";
  public final static String WRONG_SEPAL_WIDTH_MSG = "Sepal width is not correct, try to fix it! (remember for double number use . and not , (i.e. 5.4))";
  public final static String WRONG_PETAL_LENGTH_MSG = "Petal length is not correct, try to fix it! (remember for double number use . and not , (i.e. 5.4))";
  public final static String WRONG_PETAL_WIDTH_MSG = "Petal width is not correct, try to fix it! (remember for double number use . and not , (i.e. 5.4))";

  public IrisFeaturesFormatException(String exceptionMessage) {
    super(exceptionMessage);
  }
}
