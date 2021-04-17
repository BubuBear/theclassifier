package it.bububear.thecassifier.service;

import it.bububear.thecassifier.valueobjects.IrisFeatures;
import it.bububear.thecassifier.valueobjects.IrisType;

public interface IrisClassifierService {
  IrisType classify(IrisFeatures irisFeatures);
}
