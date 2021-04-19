package it.bububear.thecassifier.valueobjects;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class IrisFeatures {

  public static final String SEPAL_LENGTH_FEATURE_NAME = "sepallength";
  public static final String SEPAL_WIDTH_FEATURE_NAME = "sepalwidth";
  public static final String PETAL_LENGTH_FEATURE_NAME = "petallength";
  public static final String PETAL_WIDTH_FEATURE_NAME = "petalwidth";

  @Setter(AccessLevel.NONE)
  private final SepalLength sepalLength;
  @Setter(AccessLevel.NONE)
  private final SepalWidth sepalWidth;
  @Setter(AccessLevel.NONE)
  private final PetalLength petalLength;
  @Setter(AccessLevel.NONE)
  private final PetalWidth petalWidth;

}
