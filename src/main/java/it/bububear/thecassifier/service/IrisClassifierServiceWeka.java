package it.bububear.thecassifier.service;

import it.bububear.thecassifier.exceptions.*;
import it.bububear.thecassifier.factories.InstancesDataSetFactory;
import it.bububear.thecassifier.repositories.IrisRepository;
import it.bububear.thecassifier.valueobjects.ClassificationOutput;
import it.bububear.thecassifier.valueobjects.IrisFeatures;
import it.bububear.thecassifier.valueobjects.IrisType;
import it.bububear.thecassifier.weka.IrisClassifier;
import weka.core.DenseInstance;


public class IrisClassifierServiceWeka implements IrisClassifierService {


  private final IrisClassifier irisClassifier;

  public IrisClassifierServiceWeka(IrisRepository testDataSetRepository, IrisRepository trainDataSetRepository, IrisClassifier irisClassifier) throws IrisClassifierServiceCreationException {
    this.irisClassifier = irisClassifier;
    try {
      irisClassifier.train(testDataSetRepository.getDataSet(), trainDataSetRepository.getDataSet());
    } catch (IrisClassifierWekaBuildException | IrisClassifierWekaDataSetLoadException exception) {
      throw new IrisClassifierServiceCreationException("During classification train process an error occurred", exception);
    }
  }

  @Override
  public IrisType classify(IrisFeatures irisFeatures) throws IrisClassifyException {
    DenseInstance irisRecordToClassify = InstancesDataSetFactory.map(irisFeatures);
    try {
      ClassificationOutput irisTypeClassificationOutput = irisClassifier.classify(irisRecordToClassify);
      return new IrisType(irisTypeClassificationOutput);
    } catch (IrisClassifierWekaClassifyException exception) {
      throw new IrisClassifyException("During classify process somewhat went wrong, wait for 5 minutes and retry otherwise contact IT department", exception);
    }
  }

}
