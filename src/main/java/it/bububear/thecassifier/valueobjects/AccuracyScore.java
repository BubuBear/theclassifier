package it.bububear.thecassifier.valueobjects;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class AccuracyScore {
  @Setter(AccessLevel.NONE)
  private final double generalAccuracyScore;//not really useful in real life but for education purpose it's fine
}
