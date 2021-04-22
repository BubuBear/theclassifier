package it.bububear.thecassifier.controllers;

import it.bububear.thecassifier.exceptions.IrisClassifyException;
import it.bububear.thecassifier.factories.IrisFeaturesFactory;
import it.bububear.thecassifier.service.IrisClassifierService;
import it.bububear.thecassifier.valueobjects.IrisFeatures;
import it.bububear.thecassifier.valueobjects.IrisType;
import it.openapigenerator.theclassifier.apis.ClassifyIrisApi;
import it.openapigenerator.theclassifier.models.InlineResponse200WebLayer;
import it.openapigenerator.theclassifier.models.IrisFeaturesWebLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassifyIrisApiController implements ClassifyIrisApi {

  private final IrisClassifierService irisClassifierService;

  @Autowired
  public ClassifyIrisApiController(IrisClassifierService irisClassifierService) {
    this.irisClassifierService = irisClassifierService;
  }

  @Override
  public ResponseEntity postClassifyIris(IrisFeaturesWebLayer irisFeatures) {
    try {
      IrisType classify = irisClassifierService.classify(mapToIrisFeature(irisFeatures));
      return new ResponseEntity<>(mapToInlineResponse200WebLayer(classify), HttpStatus.FOUND);
    } catch (IrisClassifyException exception) {
      return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);//this is an education code =)
    }
  }

  public static IrisFeatures mapToIrisFeature(IrisFeaturesWebLayer irisFeatures) {
    return IrisFeaturesFactory.createIrisFeatures(irisFeatures.getSepallength(), irisFeatures.getSepalwidth(), irisFeatures.getPetallength(), irisFeatures.getPetalwidth());
  }

  public static InlineResponse200WebLayer mapToInlineResponse200WebLayer(IrisType irisType) {
    InlineResponse200WebLayer inlineResponse200WebLayer = new InlineResponse200WebLayer();
    InlineResponse200WebLayer.IrisTypeEnum irisTypeEnum = InlineResponse200WebLayer.IrisTypeEnum.fromValue(irisType.getIrisTypeValue());
    inlineResponse200WebLayer.irisType(irisTypeEnum);
    return inlineResponse200WebLayer;
  }

}
