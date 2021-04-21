package it.bububear.thecassifier.weka;

import it.bububear.thecassifier.exceptions.IrisClassifierWekaBuildException;
import it.bububear.thecassifier.exceptions.IrisClassifierWekaClassifyException;
import it.bububear.thecassifier.valueobjects.AccuracyScore;
import it.bububear.thecassifier.valueobjects.ClassificationOutput;
import weka.classifiers.AbstractClassifier;
import weka.classifiers.evaluation.Evaluation;
import weka.core.DenseInstance;
import weka.core.Instances;

public class IrisClassifierTree implements IrisClassifier {

  private final AbstractClassifier tree;

  public IrisClassifierTree(AbstractClassifier tree) throws IrisClassifierWekaBuildException {
    this.tree = tree;
  }

  @Override
  public AccuracyScore train(Instances trainDataSet, Instances testDataset) throws IrisClassifierWekaBuildException {
    try {
      tree.buildClassifier(trainDataSet);
    } catch (Exception exception) {
      throw new IrisClassifierWekaBuildException("Classifier build process is failed, check log for the solution", exception);
    }
    double accuracyScore;
    try {
      Evaluation modelEvaluation = new Evaluation(trainDataSet);
      modelEvaluation.evaluateModel(tree, testDataset);
      accuracyScore = modelEvaluation.pctCorrect();
    } catch (Exception exception) {
      throw new IrisClassifierWekaBuildException("Classifier validation process failed, check log error", exception);
    }
    return new AccuracyScore(accuracyScore);
  }

  @Override
  public ClassificationOutput classify(DenseInstance singleRecord) throws IrisClassifierWekaClassifyException {
    try {
      double irisClass = tree.classifyInstance(singleRecord);
      return new ClassificationOutput(irisClass);
    } catch (Exception exception) {
      throw new IrisClassifierWekaClassifyException("During classification of Instance occurred an error, check stack trace", exception);
    }
  }

}
