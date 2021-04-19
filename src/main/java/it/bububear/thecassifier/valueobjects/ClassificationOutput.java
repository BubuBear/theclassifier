package it.bububear.thecassifier.valueobjects;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class ClassificationOutput {
  @Setter(AccessLevel.NONE)
  private final double classifiedClass;
}
