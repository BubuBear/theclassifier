package it.bububear.thecassifier.bdd.steps;

import com.thoughtworks.gauge.Step;
import it.bububear.thecassifier.exceptions.IrisClassifierServiceCreationException;
import it.bububear.thecassifier.exceptions.IrisClassifierWekaBuildException;
import it.bububear.thecassifier.exceptions.IrisClassifyException;
import it.bububear.thecassifier.exceptions.IrisFeaturesFormatException;
import it.bububear.thecassifier.factories.IrisFeaturesFactory;
import it.bububear.thecassifier.repositories.IrisRepository;
import it.bububear.thecassifier.repositories.IrisRepositoryArff;
import it.bububear.thecassifier.service.IrisClassifierService;
import it.bububear.thecassifier.service.IrisClassifierServiceWeka;
import it.bububear.thecassifier.valueobjects.IrisFeatures;
import it.bububear.thecassifier.valueobjects.IrisType;
import it.bububear.thecassifier.weka.IrisClassifier;
import it.bububear.thecassifier.weka.IrisClassifierTree;
import weka.classifiers.trees.J48;

import static org.assertj.core.api.Assertions.assertThat;

public class IrisClassificationReq000Steps {

  private IrisFeatures irisFeatures;
  private IrisClassifierService irisClassifierService;
  private IrisType classifiedIrisType;
  private IrisFeaturesFormatException irisFeaturesFormatException;
  private static final String TRAIN_DATASET_PATH = "src/test/resources/datasets/iris/iris_for_train.arff";
  private static final String TEST_DATASET_PATH = "src/test/resources/datasets/iris/iris_for_test.arff";
  private IrisRepository trainDataSetRepository;
  private IrisRepository testDataSetRepository;
  private IrisClassifier irisClassifier;

  @Step("Alice must open the application")
  public void loadApplication() throws IrisClassifierServiceCreationException, IrisClassifierWekaBuildException {
    irisFeaturesFormatException = null;
    trainDataSetRepository = new IrisRepositoryArff(TRAIN_DATASET_PATH);
    testDataSetRepository = new IrisRepositoryArff(TEST_DATASET_PATH);
    J48 j48TreeClassifier = new J48();
    String unprunedTreeOption = "-U";
    String[] options = {unprunedTreeOption};
    try {
      j48TreeClassifier.setOptions(options);
    } catch (Exception exception) {
      throw new IrisClassifierWekaBuildException("Classifier Options are wrong, check if values are correct", exception);
    }
    irisClassifier = new IrisClassifierTree(j48TreeClassifier);
    irisClassifierService = new IrisClassifierServiceWeka(trainDataSetRepository, testDataSetRepository, irisClassifier);
  }

  @Step("When Alice insert sepal length: <5.1>, sepal width:<3.5>, petal length:<1.4>, petal width:<0.2>")
  public void insertInputData(String sepalLength, String sepalWidth, String petalLength, String petalWidth) {
    try {
      irisFeatures = IrisFeaturesFactory.createIrisFeatures(sepalLength, sepalWidth, petalLength, petalWidth);
    } catch (IrisFeaturesFormatException capturedIrisFeaturesFormatException) {
      irisFeaturesFormatException = capturedIrisFeaturesFormatException;
    }
  }

  @Step("And when Alice start classify process")
  public void classifyIris() throws IrisClassifyException {
    if (irisFeaturesFormatException == null)
      classifiedIrisType = irisClassifierService.classify(irisFeatures);
  }

  @Step("Then Alice will see the following iris-type: <Iris-setosa>")
  public void testIrisSubtype(String expectedIrisType) {
    IrisType irisTypeExpected = new IrisType(expectedIrisType);
    assertThat(classifiedIrisType).isEqualTo(irisTypeExpected);
  }

  @Step("Then Alice will see the the following error message <Sepal Length Input is not correct, fix it! (remember for double number use . and not , (i.e. 5.4))>")
  public void testErrorMessage(String expectedErrorMessage) {
    IrisFeaturesFormatException irisFeaturesFormatExceptionExpected = new IrisFeaturesFormatException(expectedErrorMessage);
    assertThat(irisFeaturesFormatException.getMessage()).isEqualTo(irisFeaturesFormatExceptionExpected.getMessage());
  }
}
