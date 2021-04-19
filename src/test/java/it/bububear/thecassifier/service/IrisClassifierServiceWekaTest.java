package it.bububear.thecassifier.service;

import it.bububear.thecassifier.exceptions.IrisClassifierServiceCreationException;
import it.bububear.thecassifier.exceptions.IrisClassifierWekaBuildException;
import it.bububear.thecassifier.exceptions.IrisClassifyException;
import it.bububear.thecassifier.exceptions.IrisFeaturesFormatException;
import it.bububear.thecassifier.factories.IrisFeaturesFactory;
import it.bububear.thecassifier.repositories.IrisRepository;
import it.bububear.thecassifier.repositories.IrisRepositoryArff;
import it.bububear.thecassifier.valueobjects.IrisFeatures;
import it.bububear.thecassifier.valueobjects.IrisType;
import it.bububear.thecassifier.weka.IrisClassifier;
import it.bububear.thecassifier.weka.IrisClassifierTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import weka.classifiers.trees.J48;

import static org.assertj.core.api.Assertions.assertThat;

class IrisClassifierServiceWekaTest {

  private static final String TRAIN_DATASET_PATH = "src/test/resources/datasets/iris/iris_for_train.arff";
  private static final String TEST_DATASET_PATH = "src/test/resources/datasets/iris/iris_for_test.arff";
  IrisClassifierServiceWeka irisClassifierServiceWeka;
  private IrisRepository trainDataSetRepository;
  private IrisRepository testDataSetRepository;
  private IrisClassifier irisClassifier;

  @BeforeEach
  void loadIrisClassifier() throws IrisClassifierServiceCreationException, IrisClassifierWekaBuildException {
    trainDataSetRepository = new IrisRepositoryArff(TRAIN_DATASET_PATH);
    testDataSetRepository = new IrisRepositoryArff(TEST_DATASET_PATH);
    J48 j48TreeClassifier = new J48();
    String unprunedTreeOption = "-U";
    String[] options = {unprunedTreeOption};
    irisClassifier = new IrisClassifierTree(j48TreeClassifier, options);
    irisClassifierServiceWeka = new IrisClassifierServiceWeka(trainDataSetRepository, testDataSetRepository, irisClassifier);
  }

  /**
   * Input: 4.9,3.0,1.4,0.2 Output: -> Iris-setosa
   */
  @Test
  void classifyIrisSetosa() throws IrisFeaturesFormatException, IrisClassifyException {
    IrisFeatures irisFeatures = IrisFeaturesFactory.createIrisFeatures("4.9", "3.0", "1.4", "0.2");
    IrisType irisTypeExpected = new IrisType("Iris-setosa");
    IrisType irisTypeActual = irisClassifierServiceWeka.classify(irisFeatures);
    assertThat(irisTypeActual).isEqualTo(irisTypeExpected);
  }

  /**
   * Input: 7.0,3.2,4.7,1.4 Output: -> Iris-versicolor
   */
  @Test
  void classifyIrisVersicolor() throws IrisFeaturesFormatException, IrisClassifyException {
    IrisFeatures irisFeatures = IrisFeaturesFactory.createIrisFeatures("7.0", "3.2", "4.7", "1.4");
    IrisType irisTypeExpected = new IrisType("Iris-versicolor");
    IrisType irisTypeActual = irisClassifierServiceWeka.classify(irisFeatures);
    assertThat(irisTypeActual).isEqualTo(irisTypeExpected);
  }

  /**
   * Input: 6.3,3.3,6.0,2.5  Output: ->  Iris-virginica
   */
  @Test
  void classifyIrisVirginica() throws IrisFeaturesFormatException, IrisClassifyException {
    IrisFeatures irisFeatures = IrisFeaturesFactory.createIrisFeatures("6.3", "3.3", "6.0", "2.5");
    IrisType irisTypeExpected = new IrisType("Iris-virginica");
    IrisType irisTypeActual = irisClassifierServiceWeka.classify(irisFeatures);
    assertThat(irisTypeActual).isEqualTo(irisTypeExpected);
  }

}
