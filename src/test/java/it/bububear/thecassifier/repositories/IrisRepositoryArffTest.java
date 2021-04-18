package it.bububear.thecassifier.repositories;

import it.bububear.thecassifier.factories.InstancesDataSetFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import weka.core.DenseInstance;
import weka.core.Instances;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class IrisRepositoryArffTest {

  private final String PATH_TO_ARFF_FILE = "src/test/resources/datasets/iris/test_repo.arff";
  private IrisRepositoryArff irisRepositoryArff;

  @BeforeEach
  void createIrisRepositoryArff() {
    irisRepositoryArff = new IrisRepositoryArff(PATH_TO_ARFF_FILE);
  }

  @Test
  void getDataSetRightNumberOfElements() throws Exception {
    Instances datasetExpected = createByHandExpectedDataSet();
    Instances dataSetActual = irisRepositoryArff.getDataSet();
    assertThat(dataSetActual.numInstances()).isEqualTo(datasetExpected.numInstances());
  }

  @Test
  void getDataSetRightValuesFirstRecord() throws Exception {
    Instances datasetExpected = createByHandExpectedDataSet();
    Instances dataSetActual = irisRepositoryArff.getDataSet();
    int indexOfInstanceToCompare = 0;
    int indexOfInstanceValueToCompare = 0;
    assertThat(dataSetActual.get(indexOfInstanceToCompare).value(indexOfInstanceValueToCompare)).isEqualTo(datasetExpected.get(indexOfInstanceToCompare).value(indexOfInstanceValueToCompare));
  }

  @Test
  void getDataSetRightValuesThirdRecord() throws Exception {
    Instances datasetExpected = createByHandExpectedDataSet();
    Instances dataSetActual = irisRepositoryArff.getDataSet();
    int indexOfInstanceToCompare = 2;
    int indexOfInstanceValueToCompare = 1;
    assertThat(dataSetActual.get(indexOfInstanceToCompare).value(indexOfInstanceValueToCompare)).isEqualTo(datasetExpected.get(indexOfInstanceToCompare).value(indexOfInstanceValueToCompare));
  }

  private Instances createByHandExpectedDataSet() {
    List<String> attributeNameList = Arrays.asList("firstfeature", "secondfeature");
    List<String> classNameList = Arrays.asList("First-class", "Second-class");
    Instances datasetExpected = InstancesDataSetFactory.createEmptyDataSet(attributeNameList, classNameList);
    double[] firstRecordOfTestRepoARFFFileValues = {5.1, 3.5};
    DenseInstance firstRecordOfTestRepoARFFFile = InstancesDataSetFactory.createNewRecordOfDataSetType(datasetExpected, firstRecordOfTestRepoARFFFileValues);
    datasetExpected.add(firstRecordOfTestRepoARFFFile);
    double[] secondRecordOfTestRepoARFFFileValues = {4.9, 3.0};
    DenseInstance secondRecordOfTestRepoARFFFile = InstancesDataSetFactory.createNewRecordOfDataSetType(datasetExpected, secondRecordOfTestRepoARFFFileValues);
    datasetExpected.add(secondRecordOfTestRepoARFFFile);
    double[] thirdRecordOfTestRepoARFFFileValues = {4.7, 3.2};
    DenseInstance thirdRecordOfTestRepoARFFFile = InstancesDataSetFactory.createNewRecordOfDataSetType(datasetExpected, thirdRecordOfTestRepoARFFFileValues);
    datasetExpected.add(thirdRecordOfTestRepoARFFFile);
    return datasetExpected;
  }
}
