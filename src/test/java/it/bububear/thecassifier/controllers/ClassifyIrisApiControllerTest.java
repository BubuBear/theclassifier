package it.bububear.thecassifier.controllers;

import it.bububear.thecassifier.exceptions.IrisClassifyException;
import it.bububear.thecassifier.exceptions.IrisFeaturesFormatException;
import it.bububear.thecassifier.factories.IrisBeansFactory;
import it.bububear.thecassifier.factories.IrisFeaturesFactory;
import it.bububear.thecassifier.main.ApplicationSpringBoot;
import it.bububear.thecassifier.service.IrisClassifierService;
import it.bububear.thecassifier.valueobjects.IrisFeatures;
import it.bububear.thecassifier.valueobjects.IrisType;

import it.openapigenerator.theclassifier.models.InlineResponse200WebLayer;

import it.openapigenerator.theclassifier.models.IrisFeaturesWebLayer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {ApplicationSpringBoot.class, ClassifyIrisApiController.class, IrisBeansFactory.class})
@TestPropertySource(locations = "classpath:application.yml")
class ClassifyIrisApiControllerTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate testRestTemplate;

  @Mock
  IrisClassifierService irisClassifierService;


  @Test
  void classifyIrisApiController() throws IrisClassifyException {
    IrisType irisType = new IrisType("Iris-setosa");
    when(irisClassifierService.classify(any(it.bububear.thecassifier.valueobjects.IrisFeatures.class))).thenReturn(irisType);
    IrisFeaturesWebLayer irisFeaturesWebLayer = mockIrisFeaturesWebLayerIrisSetosaInput();
    ClassifyIrisApiController classifyIrisApiController = new ClassifyIrisApiController(irisClassifierService);
    ResponseEntity<InlineResponse200WebLayer> inlineResponse200Actual = classifyIrisApiController.postClassifyIris(irisFeaturesWebLayer);
    InlineResponse200WebLayer inlineResponse200Expected = new InlineResponse200WebLayer().irisType(InlineResponse200WebLayer.IrisTypeEnum.SETOSA);
    assertThat(inlineResponse200Actual.getBody()).isEqualTo(inlineResponse200Expected);
  }


  @Test
  void postClassifyIris() {
    String postClassifyIrisURL = String.format("http://localhost:%s/classify-iris", port);
    InlineResponse200WebLayer inlineResponse200Expected = new InlineResponse200WebLayer().irisType(InlineResponse200WebLayer.IrisTypeEnum.SETOSA);
    IrisFeaturesWebLayer irisFeatures = mockIrisFeaturesWebLayerIrisSetosaInput();
    InlineResponse200WebLayer inlineResponse200Actual = testRestTemplate.postForObject(postClassifyIrisURL, irisFeatures, InlineResponse200WebLayer.class);
    assertThat(inlineResponse200Actual).isEqualTo(inlineResponse200Expected);
  }

  @Test
  void mapIrisFeaturesWebLayerToIrisFeatures() throws IrisFeaturesFormatException {
    IrisFeatures irisFeaturesExpected = IrisFeaturesFactory.createIrisFeatures("4.9", "3.0", "1.4", "0.2");
    IrisFeaturesWebLayer irisFeatures = mockIrisFeaturesWebLayerIrisSetosaInput();
    IrisFeatures irisFeaturesActual = ClassifyIrisApiController.mapToIrisFeature(irisFeatures);
    assertThat(irisFeaturesActual).isEqualTo(irisFeaturesExpected);
  }

  @Test
  void mapToInlineResponse200WebLayer() {
    InlineResponse200WebLayer inlineResponse200WebLayerExpected = new InlineResponse200WebLayer();
    inlineResponse200WebLayerExpected.irisType(InlineResponse200WebLayer.IrisTypeEnum.SETOSA);
    IrisType irisType = new IrisType("Iris-setosa");
    InlineResponse200WebLayer inlineResponse200WebLayerActual = ClassifyIrisApiController.mapToInlineResponse200WebLayer(irisType);
    assertThat(inlineResponse200WebLayerActual).isEqualTo(inlineResponse200WebLayerExpected);
  }

  private IrisFeaturesWebLayer mockIrisFeaturesWebLayerIrisSetosaInput() {
    IrisFeaturesWebLayer irisFeatures = new IrisFeaturesWebLayer();
    irisFeatures.setSepallength(4.9);
    irisFeatures.setSepalwidth(3.0);
    irisFeatures.setPetallength(1.4);
    irisFeatures.setPetalwidth(0.2);
    return irisFeatures;
  }
}
