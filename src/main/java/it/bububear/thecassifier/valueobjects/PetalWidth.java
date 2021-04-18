package it.bububear.thecassifier.valueobjects;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class PetalWidth {
  @Setter(AccessLevel.NONE)
  private final double value;
}
