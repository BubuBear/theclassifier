package it.bububear.thecassifier.valueobjects;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class IrisFeatures {
  @Setter(AccessLevel.NONE)
  private SepalLength sepalLength;
  @Setter(AccessLevel.NONE)
  private SepalWidth sepalWidth;
  @Setter(AccessLevel.NONE)
  private PetalLength petalLength;
  @Setter(AccessLevel.NONE)
  private PetalWidth petalWidth;
}
