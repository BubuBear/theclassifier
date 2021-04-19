package it.bububear.thecassifier.controllers;

import it.bububear.thecassifier.exceptions.IrisClassifyException;
import it.bububear.thecassifier.exceptions.IrisFeaturesFormatException;
import it.bububear.thecassifier.factories.IrisFeaturesFactory;
import it.bububear.thecassifier.service.IrisClassifierService;
import it.bububear.thecassifier.valueobjects.IrisFeatures;
import it.bububear.thecassifier.valueobjects.IrisType;

import java.util.Scanner;

public class ConsoleController {

  private final static String WELCOME_MSG = "Welcome to Iris Classifier";
  private final static String INSERT_FEATURES_MSG = "Please insert iris values in following order sepallength,sepalwidth,petallength,petalwidth for example: 5.1,3.5,1.4,0.2";
  private final static String ERROR_MSG = "Try to re-insert features in right way, for example: 5.1,3.5,1.4,0.2";
  private final IrisClassifierService irisClassifierService;
  private final Scanner scanner;

  public ConsoleController(IrisClassifierService irisClassifierService, Scanner scanner) {
    this.irisClassifierService = irisClassifierService;
    this.scanner = scanner;
  }

  public void run() {
    System.out.println(WELCOME_MSG);
    System.out.println(INSERT_FEATURES_MSG);
    while (scanner.hasNextLine()) {
      try {
        String output = makePrediction(scanner.nextLine());
        System.out.printf("############## Your iris type is: -->>>>***%s***<<<<--%n", output);
        System.out.println(INSERT_FEATURES_MSG);
      } catch (Exception exception) {
        System.out.println(ERROR_MSG);
      }
    }
  }

  public String makePrediction(String consoleLineInput) throws IrisFeaturesFormatException, IrisClassifyException {
    String[] features = consoleLineInput.split(",");
    IrisFeatures irisFeatures = IrisFeaturesFactory.createIrisFeatures(features[0], features[1], features[2], features[3]);
    IrisType classify = irisClassifierService.classify(irisFeatures);
    return classify.getIrisTypeValue();
  }

}
