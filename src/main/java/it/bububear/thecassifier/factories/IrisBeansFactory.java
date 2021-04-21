package it.bububear.thecassifier.factories;

import it.bububear.thecassifier.exceptions.IrisClassifierServiceCreationException;
import it.bububear.thecassifier.exceptions.IrisClassifierWekaBuildException;
import it.bububear.thecassifier.repositories.IrisRepository;
import it.bububear.thecassifier.repositories.IrisRepositoryArff;
import it.bububear.thecassifier.service.IrisClassifierService;
import it.bububear.thecassifier.service.IrisClassifierServiceWeka;
import it.bububear.thecassifier.weka.IrisClassifier;
import it.bububear.thecassifier.weka.IrisClassifierTree;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import weka.classifiers.AbstractClassifier;
import weka.classifiers.trees.J48;

@Component
public class IrisBeansFactory {

  @Getter
  private final String trainDataSetPath;
  @Getter
  private final String testDataSetPath;

  @Autowired
  public IrisBeansFactory(@Value("${datasets.iris.train}") String trainDataSetPath, @Value("${datasets.iris.test}") String testDatasetPath) {
    this.trainDataSetPath = trainDataSetPath;
    this.testDataSetPath = testDatasetPath;
  }

  @Bean(name = "trainDataSetRepository")
  public IrisRepository createTrainDataSetRepository() {
    return new IrisRepositoryArff(trainDataSetPath);
  }

  @Bean(name = "testDataSetRepository")
  public IrisRepository createTestDataSetRepository() {
    return new IrisRepositoryArff(testDataSetPath);
  }

  @Bean
  public AbstractClassifier abstractClassifier(@Value("${weka.tree.j48.unpruned-option}") String unprunedTreeOption) throws IrisClassifierWekaBuildException {
    J48 j48TreeClassifier = new J48();
    String[] options = {unprunedTreeOption};
    try {
      j48TreeClassifier.setOptions(options);
    } catch (Exception exception) {
      throw new IrisClassifierWekaBuildException("Classifier Options are wrong, check if values are correct", exception);
    }
    return j48TreeClassifier;
  }

  @Bean
  public IrisClassifier createIrisClassifier(AbstractClassifier abstractClassifier) {
    return  new IrisClassifierTree(abstractClassifier);
  }

  @Bean
  public IrisClassifierService createIrisClassifierService(IrisRepository trainDataSetRepository, IrisRepository testDataSetRepository, IrisClassifier irisClassifier) throws IrisClassifierServiceCreationException {
    return new IrisClassifierServiceWeka(trainDataSetRepository, testDataSetRepository, irisClassifier);
  }
}
