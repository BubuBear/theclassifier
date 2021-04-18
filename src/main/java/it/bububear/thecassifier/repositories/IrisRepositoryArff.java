package it.bububear.thecassifier.repositories;

import it.bububear.thecassifier.exceptions.IrisClassifierWekaDataSetLoadException;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

public class IrisRepositoryArff implements IrisRepository {

  private final String PATH_TO_ARFF_FILE;

  public IrisRepositoryArff(String path_to_arff_file) {
    PATH_TO_ARFF_FILE = path_to_arff_file;
  }

  @Override
  public Instances getDataSet() throws IrisClassifierWekaDataSetLoadException {
    ConverterUtils.DataSource source;
    try {
      source = new ConverterUtils.DataSource(PATH_TO_ARFF_FILE);
    } catch (Exception exception) {
      throw new IrisClassifierWekaDataSetLoadException(String.format("The following path: <<%s>> is incorrect, check for typo!", PATH_TO_ARFF_FILE), exception);
    }
    Instances data;
    try {
      data = source.getDataSet();
    } catch (Exception exception) {
      throw new IrisClassifierWekaDataSetLoadException("DataSet loading went wrong, contact the IT department", exception);
    }
    return data;
  }
}
