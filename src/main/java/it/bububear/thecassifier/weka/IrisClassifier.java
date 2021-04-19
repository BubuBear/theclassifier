package it.bububear.thecassifier.weka;

import it.bububear.thecassifier.exceptions.IrisClassifierWekaBuildException;
import it.bububear.thecassifier.exceptions.IrisClassifierWekaClassifyException;
import it.bububear.thecassifier.valueobjects.AccuracyScore;
import it.bububear.thecassifier.valueobjects.ClassificationOutput;
import weka.core.DenseInstance;
import weka.core.Instances;

public interface IrisClassifier {

  double IRIS_SETOSA_DOUBLE_VALUE = 0.0;
  double IRIS_VERSICOLOR_DOUBLE_VALUE = 1.0;
  double IRIS_VIRGINICA_DOUBLE_VALUE = 2.0;

  ClassificationOutput classify(DenseInstance singleRecord) throws IrisClassifierWekaClassifyException;

  AccuracyScore train(Instances data, Instances testDataset) throws IrisClassifierWekaBuildException;
}
