package it.bububear.thecassifier.repositories;

import it.bububear.thecassifier.exceptions.IrisClassifierWekaDataSetLoadException;
import weka.core.Instances;

public interface IrisRepository {
  Instances getDataSet() throws IrisClassifierWekaDataSetLoadException;
}
