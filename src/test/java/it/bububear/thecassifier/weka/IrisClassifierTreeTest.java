package it.bububear.thecassifier.weka;

import it.bububear.thecassifier.exceptions.IrisClassifierWekaBuildException;
import it.bububear.thecassifier.valueobjects.AccuracyScore;
import it.bububear.thecassifier.valueobjects.ClassificationOutput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import weka.classifiers.trees.J48;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class IrisClassifierTreeTest {

  private IrisClassifierTree irisClassifierTree;

  @BeforeEach
  void setUp() throws Exception {
    J48 j48TreeClassifier = new J48();
    String unprunedTreeOption = "-U";
    String[] options = {unprunedTreeOption};
    try {
      j48TreeClassifier.setOptions(options);
    } catch (Exception exception) {
      throw new IrisClassifierWekaBuildException("Classifier Options are wrong, check if values are correct", exception);
    }
    irisClassifierTree = new IrisClassifierTree(j48TreeClassifier);
  }

  @Test
  void trainTest() throws Exception {
    Instances trainDataSet = getDataSet("src/test/resources/datasets/iris/iris_for_train.arff");
    Instances testDataSet = getDataSet("src/test/resources/datasets/iris/iris_for_test.arff");
    AccuracyScore accuracyScoreActual = irisClassifierTree.train(trainDataSet, testDataSet);
    double minGeneralAccuracyScoreExpected = 95.0;
    assertThat(accuracyScoreActual.getGeneralAccuracyScore()).isGreaterThanOrEqualTo(minGeneralAccuracyScoreExpected);
  }

  /**
   * Test case Input: 5.0,3.6,1.4,0.2 Output: Iris-setosa
   */
  @Test
  void classifyIrisSetosa() throws Exception {
    trainTest();//for real life it's awful but the project is for education purpose so its ok!
    Instances dataSet = getEmptyIrisDataSet();
    double[] irisSetosaFeatures = {5.0, 3.6, 1.4, 0.2};
    DenseInstance denseInstance = getDatasetRecordForClassifier(dataSet, irisSetosaFeatures);
    ClassificationOutput classificationOutput = irisClassifierTree.classify(denseInstance);
    double irisClassExpected = 0.0;
    assertThat(classificationOutput.getClassifiedClass()).isEqualTo(irisClassExpected);
  }

  /**
   * Test case Input: 6.3,3.3,4.7,1.6 Output: Iris-versicolor
   */
  @Test
  void classifyIrisVersicolor() throws Exception {
    trainTest();//for real life it's awful but the project is for education purpose so its ok!
    Instances dataSet = getEmptyIrisDataSet();
    double[] irisVersicolorFeatures = {6.3, 3.3, 4.7, 1.6};
    DenseInstance denseInstance = getDatasetRecordForClassifier(dataSet, irisVersicolorFeatures);
    ClassificationOutput classificationOutput = irisClassifierTree.classify(denseInstance);
    double irisClassExpected = 1.0;
    assertThat(classificationOutput.getClassifiedClass()).isEqualTo(irisClassExpected);
  }

  /**
   * Test case Input: 5.5,2.3,4.0,1.3 Output: Iris-versicolor
   */
  @Test
  void classifyIrisVersicolorAnother() throws Exception {
    trainTest();//for real life it's awful but the project is for education purpose so its ok!
    Instances dataSet = getEmptyIrisDataSet();
    double[] irisVersicolorFeatures = {5.5, 2.3, 4.0, 1.3};
    DenseInstance denseInstance = getDatasetRecordForClassifier(dataSet, irisVersicolorFeatures);
    ClassificationOutput classificationOutput = irisClassifierTree.classify(denseInstance);
    double irisClassExpected = 1.0;
    assertThat(classificationOutput.getClassifiedClass()).isEqualTo(irisClassExpected);
  }


  /**
   * Test case Input: 7.2,3.6,6.1,2.5 Output: Iris-virginica
   */
  @Test
  void classifyIrisVirginica() throws Exception {
    trainTest();//for real life it's awful but the project is for education purpose so its ok!
    Instances dataSet = getEmptyIrisDataSet();
    double[] irisVirginicaFeatures = {7.2, 3.6, 6.1, 2.5};
    DenseInstance denseInstance = getDatasetRecordForClassifier(dataSet, irisVirginicaFeatures);
    ClassificationOutput classificationOutput = irisClassifierTree.classify(denseInstance);
    double irisClassExpected = 2.0;
    assertThat(classificationOutput.getClassifiedClass()).isEqualTo(irisClassExpected);
  }


  private DenseInstance getDatasetRecordForClassifier(Instances dataSet, double[] irisSetosaFeatures) {
    DenseInstance denseInstance = new DenseInstance(1, irisSetosaFeatures);
    denseInstance.setDataset(dataSet);
    return denseInstance;
  }

  private Instances getEmptyIrisDataSet() {
    Attribute sepalLengthAttribute = new Attribute("sepallength");
    Attribute sepalWidthAttribute = new Attribute("sepalwidth");
    Attribute petalLengthAttribute = new Attribute("petallength");
    Attribute petalWidthAttribute = new Attribute("petalwidth");

    String irisSetosaClass = "Iris-setosa";
    String irisVersicolorClass = "Iris-versicolor";
    String irisVirginicaClass = "Iris-virginica";
    List<String> attributeClassList = Arrays.asList(irisSetosaClass, irisVersicolorClass, irisVirginicaClass);
    Attribute classAttribute = new Attribute("@@class@@", attributeClassList);

    ArrayList<Attribute> attributeList = new ArrayList<>();
    attributeList.add(sepalLengthAttribute);
    attributeList.add(sepalWidthAttribute);
    attributeList.add(petalLengthAttribute);
    attributeList.add(petalWidthAttribute);
    attributeList.add(classAttribute);

    Instances dataSet = new Instances("Instances", attributeList, 0);
    dataSet.setClassIndex(dataSet.numAttributes() - 1);
    return dataSet;
  }

  private Instances getDataSet(String pathToARFFFile) throws Exception {
    ConverterUtils.DataSource source = new ConverterUtils.DataSource(pathToARFFFile);
    Instances dataSet = source.getDataSet();
    if (dataSet.classIndex() == -1)
      dataSet.setClassIndex(dataSet.numAttributes() - 1);
    return dataSet;
  }
}
