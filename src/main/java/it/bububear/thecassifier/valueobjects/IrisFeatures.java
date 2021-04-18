package it.bububear.thecassifier.valueobjects;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class IrisFeatures {
  @Setter(AccessLevel.NONE)
  private final SepalLength sepalLength;
  @Setter(AccessLevel.NONE)
  private final SepalWidth sepalWidth;
  @Setter(AccessLevel.NONE)
  private final PetalLength petalLength;
  @Setter(AccessLevel.NONE)
  private final PetalWidth petalWidth;
}
