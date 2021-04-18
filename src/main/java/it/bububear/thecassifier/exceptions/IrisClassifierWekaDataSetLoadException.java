package it.bububear.thecassifier.exceptions;

public class IrisClassifierWekaDataSetLoadException extends Exception {
  public IrisClassifierWekaDataSetLoadException(String message, Exception exception) {
    super(message, exception);
  }
}
