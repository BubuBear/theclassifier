package it.bububear.thecassifier.factories;

import org.junit.jupiter.api.Test;
import weka.core.Instances;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InstancesDataSetFactoryTest {


  @Test
  void createEmptyDatasetFactoryRightNumberOfAttributes() {

    String expectedAttributeNameNumberOne = "numberOneAttribute";
    String expectedAttributeNameNumberTwo = "numberTwoAttribute";
    List<String> expectedAttributesNamesList = Arrays.asList(expectedAttributeNameNumberOne, expectedAttributeNameNumberTwo);
    String expectedClassNameNumberOne = "numberOneClass";
    String expectedClassNameNumberTwo = "numberTwoClass";
    String expectedClassNameNumberThree = "numberTwoThree";
    List<String> expectedClassNamesList = Arrays.asList(expectedClassNameNumberOne, expectedClassNameNumberTwo, expectedClassNameNumberThree);
    Instances dataSetActual = InstancesDataSetFactory.createEmptyDataSet(expectedAttributesNamesList, expectedClassNamesList);
    int numberOfAttributes = expectedAttributesNamesList.size();
    int numberOfClassAttributes = 1;
    int numberOfExpectedAttributes = numberOfAttributes + numberOfClassAttributes;
    assertThat(dataSetActual.numAttributes()).isEqualTo(numberOfExpectedAttributes);
  }

  @Test
  void createEmptyDatasetFactoryRightNumberOfClasses() {
    String expectedAttributeNameNumberOne = "numberOneAttribute";
    String expectedAttributeNameNumberTwo = "numberTwoAttribute";
    List<String> expectedAttributesNamesList = Arrays.asList(expectedAttributeNameNumberOne, expectedAttributeNameNumberTwo);
    String expectedClassNameNumberOne = "numberOneClass";
    String expectedClassNameNumberTwo = "numberTwoClass";
    String expectedClassNameNumberThree = "numberTwoThree";
    List<String> expectedClassNamesList = Arrays.asList(expectedClassNameNumberOne, expectedClassNameNumberTwo, expectedClassNameNumberThree);
    Instances dataSetActual = InstancesDataSetFactory.createEmptyDataSet(expectedAttributesNamesList, expectedClassNamesList);
    assertThat(dataSetActual.numClasses()).isEqualTo(expectedClassNamesList.size());
  }

  @Test
  void createEmptyDatasetFactoryCorrectAttribute() {
    String expectedAttributeNameNumberOne = "numberOneAttribute";
    String expectedAttributeNameNumberTwo = "numberTwoAttribute";
    List<String> expectedAttributesNamesList = Arrays.asList(expectedAttributeNameNumberOne, expectedAttributeNameNumberTwo);
    String expectedClassNameNumberOne = "numberOneClass";
    String expectedClassNameNumberTwo = "numberTwoClass";
    String expectedClassNameNumberThree = "numberTwoThree";
    List<String> expectedClassNamesList = Arrays.asList(expectedClassNameNumberOne, expectedClassNameNumberTwo, expectedClassNameNumberThree);
    Instances dataSetActual = InstancesDataSetFactory.createEmptyDataSet(expectedAttributesNamesList, expectedClassNamesList);
    assertThat(dataSetActual.attribute(expectedAttributeNameNumberOne).name()).isEqualTo(expectedAttributeNameNumberOne);
  }

  @Test
  void createEmptyDatasetFactoryCorrectClass() {
    String expectedAttributeNameNumberOne = "numberOneAttribute";
    String expectedAttributeNameNumberTwo = "numberTwoAttribute";
    List<String> expectedAttributesNamesList = Arrays.asList(expectedAttributeNameNumberOne, expectedAttributeNameNumberTwo);
    String expectedClassNameNumberOne = "numberOneClass";
    String expectedClassNameNumberTwo = "numberTwoClass";
    String expectedClassNameNumberThree = "numberTwoThree";
    List<String> expectedClassNamesList = Arrays.asList(expectedClassNameNumberOne, expectedClassNameNumberTwo, expectedClassNameNumberThree);
    Instances dataSetActual = InstancesDataSetFactory.createEmptyDataSet(expectedAttributesNamesList, expectedClassNamesList);
    assertThat(dataSetActual.attribute(InstancesDataSetFactory.CLASS_ATTRIBUTE_NAME).name()).isEqualTo(InstancesDataSetFactory.CLASS_ATTRIBUTE_NAME);
  }

}
