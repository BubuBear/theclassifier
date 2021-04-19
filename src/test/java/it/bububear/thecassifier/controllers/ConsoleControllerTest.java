package it.bububear.thecassifier.controllers;

import it.bububear.thecassifier.exceptions.IrisClassifyException;
import it.bububear.thecassifier.exceptions.IrisFeaturesFormatException;
import it.bububear.thecassifier.service.IrisClassifierService;
import it.bububear.thecassifier.valueobjects.IrisFeatures;
import it.bububear.thecassifier.valueobjects.IrisType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ConsoleControllerTest {

  @Mock
  Scanner scanner;
  @Mock
  IrisClassifierService irisClassifierService;

  ConsoleController consoleController;

  String consoleLineInput = "5.1,3.5,1.4,0.2";
  String consoleLineOutputExpected = "Iris-setosa";


  @BeforeEach
  void loadController() throws IrisClassifyException {
    consoleController = new ConsoleController(irisClassifierService, scanner);
    Mockito.when(scanner.hasNextBoolean()).thenReturn(true);
    Mockito.when(scanner.nextLine()).thenReturn(consoleLineInput);
    Mockito.when(irisClassifierService.classify(any(IrisFeatures.class))).thenReturn(new IrisType(consoleLineOutputExpected));
  }

  @Test
  void rightPrediction() throws IrisFeaturesFormatException, IrisClassifyException {
    String consoleOutputActual = consoleController.makePrediction(consoleLineInput);
    assertThat(consoleOutputActual).isEqualTo(consoleLineOutputExpected);
  }

}
