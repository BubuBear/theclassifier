package it.bububear.thecassifier.factories;

import it.bububear.thecassifier.exceptions.*;
import it.bububear.thecassifier.repositories.IrisRepository;
import it.bububear.thecassifier.service.IrisClassifierService;
import it.bububear.thecassifier.valueobjects.IrisFeatures;
import it.bububear.thecassifier.valueobjects.IrisType;
import it.bububear.thecassifier.weka.IrisClassifier;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import weka.classifiers.AbstractClassifier;
import weka.classifiers.trees.J48;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = IrisBeansFactory.class)
@TestPropertySource(locations = "classpath:application.yml")
class IrisBeansFactoryTest {

  private static final String TRAIN_DATASET_PATH = "src/main/resources/datasets/iris/iris_for_train.arff";
  private static final String TEST_DATASET_PATH = "src/main/resources/datasets/iris/iris_for_test.arff";

  @Value("${startup}")
  String startupPropertiesField;

  @Autowired
  IrisBeansFactory irisBeansFactory;

  @Autowired
  @Qualifier("trainDataSetRepository")
  IrisRepository trainDataSetRepository;

  @Autowired
  @Qualifier("testDataSetRepository")
  IrisRepository testDataSetRepository;

  @Autowired
  AbstractClassifier abstractClassifier;

  @Value("${weka.tree.j48.unpruned-option}")
  String wekaTreeJ48Unpruned;

  @Autowired
  IrisClassifier irisClassifier;

  @Autowired
  IrisClassifierService irisClassifierService;

  @Test
  void rightApplicationProperties() {
    String valueWrittenInsideApplicationPropertiesFile = "ok";
    assertThat(startupPropertiesField).isEqualTo(valueWrittenInsideApplicationPropertiesFile);
  }

  @Test
  void irisBeansFactoryRightTrainPath() {
    IrisBeansFactory irisBeansFactory = new IrisBeansFactory(TRAIN_DATASET_PATH, null);
    String pathActual = irisBeansFactory.getTrainDataSetPath();
    assertThat(pathActual).isEqualTo(TRAIN_DATASET_PATH);
  }

  @Test
  void trainDataSetRepository() {
    IrisRepository trainDataSetRepositoryConcrete = irisBeansFactory.createTrainDataSetRepository();
    assertThat(trainDataSetRepositoryConcrete).isNotNull();
  }

  @Test
  void trainDataSetRepositoryHaveData() throws IrisClassifierWekaDataSetLoadException {
    assertThat(trainDataSetRepository.getDataSet()).isNotNull();
  }

  @Test
  void irisBeansFactoryRightTestPath() {
    IrisBeansFactory irisBeansFactory = new IrisBeansFactory(null, TEST_DATASET_PATH);
    String pathActual = irisBeansFactory.getTestDataSetPath();
    assertThat(pathActual).isEqualTo(TEST_DATASET_PATH);
  }

  @Test
  void testDataSetRepository() {
    IrisRepository testDataSetRepositoryConcrete = irisBeansFactory.createTestDataSetRepository();
    assertThat(testDataSetRepositoryConcrete).isNotNull();
  }

  @Test
  void testDataSetRepositoryHaveData() throws IrisClassifierWekaDataSetLoadException {
    assertThat(testDataSetRepository.getDataSet()).isNotNull();
  }

  @Test
  void abstractClassifierIsNotNull() throws IrisClassifierWekaBuildException {
    String unprunedTreeOption = "-U";
    AbstractClassifier abstractClassifier = irisBeansFactory.abstractClassifier(unprunedTreeOption);
    assertThat(abstractClassifier).isNotNull();
  }

  @Test
  void wekaTreeJ48Unpruned() {
    String wekaTreeJ48UnprunedExpected = "-U";
    assertThat(wekaTreeJ48Unpruned).isEqualTo(wekaTreeJ48UnprunedExpected);
  }

  @Test
  void abstractClassifierIsJ46() {
    assertThat(abstractClassifier.getClass()).isEqualTo(J48.class);
  }

  @Test
  void createIrisClassifier() {
    AbstractClassifier abstractClassifier = new J48();
    IrisClassifier irisClassifier = irisBeansFactory.createIrisClassifier(abstractClassifier);
    assertThat(irisClassifier).isNotNull();
  }

  @Test
  void createIrisClassifierService() throws IrisClassifierServiceCreationException {
    IrisClassifierService irisClassifierService = irisBeansFactory.createIrisClassifierService(trainDataSetRepository, testDataSetRepository, irisClassifier);
    assertThat(irisClassifierService).isNotNull();
  }

  /**
   * 5.1,3.5,1.4,0.2 -> Iris-setosa
   */
  @Test
  void createIrisClassifierClassify() throws IrisFeaturesFormatException, IrisClassifyException {
    IrisFeatures irisFeatures = IrisFeaturesFactory.createIrisFeatures("5.1", "3.5", "1.4", "0.2");
    String irisTypeExpected = "Iris-setosa";
    IrisType irisTypeActual = irisClassifierService.classify(irisFeatures);
    assertThat(irisTypeActual.getIrisTypeValue()).isEqualTo(irisTypeExpected);
  }

}
