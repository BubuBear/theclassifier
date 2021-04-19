package it.bububear.thecassifier.main;

import it.bububear.thecassifier.controllers.ConsoleController;
import it.bububear.thecassifier.exceptions.IrisClassifierServiceCreationException;
import it.bububear.thecassifier.exceptions.IrisClassifierWekaBuildException;
import it.bububear.thecassifier.repositories.IrisRepository;
import it.bububear.thecassifier.repositories.IrisRepositoryArff;
import it.bububear.thecassifier.service.IrisClassifierService;
import it.bububear.thecassifier.service.IrisClassifierServiceWeka;
import it.bububear.thecassifier.weka.IrisClassifier;
import it.bububear.thecassifier.weka.IrisClassifierTree;
import weka.classifiers.trees.J48;

import java.util.Scanner;

public class Application {

  private static String TRAIN_DATASET_PATH = "src/main/resources/datasets/iris/iris_for_train.arff";
  private static String TEST_DATASET_PATH = "src/main/resources/datasets/iris/iris_for_test.arff";

  public static void main(String[] args) throws IrisClassifierWekaBuildException, IrisClassifierServiceCreationException {
    TRAIN_DATASET_PATH = args[0];// this is also not for production use but we are learning so its fine!
    TEST_DATASET_PATH = args[1]; // this is also not for production use but we are learning so its fine
    IrisRepository trainDataSetRepository = new IrisRepositoryArff(TRAIN_DATASET_PATH);
    IrisRepository testDataSetRepository = new IrisRepositoryArff(TEST_DATASET_PATH);
    J48 j48TreeClassifier = new J48();
    String unprunedTreeOption = "-U";
    String[] options = {unprunedTreeOption};
    IrisClassifier irisClassifier = new IrisClassifierTree(j48TreeClassifier, options);
    IrisClassifierService irisClassifierService = new IrisClassifierServiceWeka(trainDataSetRepository, testDataSetRepository, irisClassifier);
    Scanner scanner = new Scanner(System.in);
    ConsoleController consoleController = new ConsoleController(irisClassifierService, scanner);
    consoleController.run();
  }

}
