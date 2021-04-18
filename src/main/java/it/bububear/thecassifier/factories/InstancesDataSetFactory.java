package it.bububear.thecassifier.factories;

import it.bububear.thecassifier.valueobjects.IrisFeatures;
import it.bububear.thecassifier.valueobjects.IrisType;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InstancesDataSetFactory {

  public final static String CLASS_ATTRIBUTE_NAME = "@@class@@";

  public static Instances createEmptyDataSet(List<String> attributesNames, List<String> classNames) {
    ArrayList<Attribute> attributeList = new ArrayList<>();
    attributesNames.forEach(attributeName -> attributeList.add(new Attribute(attributeName)));
    Attribute classAttribute = new Attribute(CLASS_ATTRIBUTE_NAME, classNames);
    attributeList.add(classAttribute);
    Instances dataSet = new Instances("Instances", attributeList, 0);
    int positionOfClassesAttribute = dataSet.numAttributes() - 1;
    dataSet.setClassIndex(positionOfClassesAttribute);
    return dataSet;
  }

  public static DenseInstance createNewRecordOfDataSetType(Instances dataSet, double[] attributesValueArray) {
    DenseInstance denseInstance = new DenseInstance(1, attributesValueArray);
    denseInstance.setDataset(dataSet);
    return denseInstance;
  }

  public static DenseInstance map(IrisFeatures irisFeatures) {
    List<String> irisAttributesNames = Arrays.asList(IrisFeatures.SEPAL_LENGTH_FEATURE_NAME, IrisFeatures.SEPAL_WIDTH_FEATURE_NAME, IrisFeatures.PETAL_LENGTH_FEATURE_NAME, IrisFeatures.PETAL_WIDTH_FEATURE_NAME);
    List<String> irisClassNames = Arrays.asList(IrisType.IRIS_SETOSA, IrisType.IRIS_VERSICOLOR, IrisType.IRIS_VIRGINICA);
    Instances dataSetTypeDefinition = InstancesDataSetFactory.createEmptyDataSet(irisAttributesNames, irisClassNames);
    double[] irisFeaturesValues = new double[4];
    irisFeaturesValues[0] = irisFeatures.getSepalLength().getValue();
    irisFeaturesValues[1] = irisFeatures.getSepalWidth().getValue();
    irisFeaturesValues[2] = irisFeatures.getPetalLength().getValue();
    irisFeaturesValues[3] = irisFeatures.getPetalWidth().getValue();
    return InstancesDataSetFactory.createNewRecordOfDataSetType(dataSetTypeDefinition, irisFeaturesValues);
  }

}
