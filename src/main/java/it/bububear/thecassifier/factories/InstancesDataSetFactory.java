package it.bububear.thecassifier.factories;

import weka.core.Attribute;
import weka.core.Instances;

import java.util.ArrayList;
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

}
