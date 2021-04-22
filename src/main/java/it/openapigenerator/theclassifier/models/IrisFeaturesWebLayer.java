package it.openapigenerator.theclassifier.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * IrisFeaturesWebLayer
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-04-22T18:11:11.362482500+02:00[Europe/Berlin]")
public class IrisFeaturesWebLayer   {
  @JsonProperty("sepallength")
  private Double sepallength;

  @JsonProperty("sepalwidth")
  private Double sepalwidth;

  @JsonProperty("petallength")
  private Double petallength;

  @JsonProperty("petalwidth")
  private Double petalwidth;

  public IrisFeaturesWebLayer sepallength(Double sepallength) {
    this.sepallength = sepallength;
    return this;
  }

  /**
   * Get sepallength
   * minimum: 0
   * maximum: 20
   * @return sepallength
  */
  @ApiModelProperty(example = "5.1", required = true, value = "")
  @NotNull

@DecimalMin(value="0",inclusive=false) @DecimalMax("20") 
  public Double getSepallength() {
    return sepallength;
  }

  public void setSepallength(Double sepallength) {
    this.sepallength = sepallength;
  }

  public IrisFeaturesWebLayer sepalwidth(Double sepalwidth) {
    this.sepalwidth = sepalwidth;
    return this;
  }

  /**
   * Get sepalwidth
   * minimum: 0
   * maximum: 20
   * @return sepalwidth
  */
  @ApiModelProperty(example = "3.5", required = true, value = "")
  @NotNull

@DecimalMin(value="0",inclusive=false) @DecimalMax("20") 
  public Double getSepalwidth() {
    return sepalwidth;
  }

  public void setSepalwidth(Double sepalwidth) {
    this.sepalwidth = sepalwidth;
  }

  public IrisFeaturesWebLayer petallength(Double petallength) {
    this.petallength = petallength;
    return this;
  }

  /**
   * Get petallength
   * minimum: 0
   * maximum: 20
   * @return petallength
  */
  @ApiModelProperty(example = "1.4", required = true, value = "")
  @NotNull

@DecimalMin(value="0",inclusive=false) @DecimalMax("20") 
  public Double getPetallength() {
    return petallength;
  }

  public void setPetallength(Double petallength) {
    this.petallength = petallength;
  }

  public IrisFeaturesWebLayer petalwidth(Double petalwidth) {
    this.petalwidth = petalwidth;
    return this;
  }

  /**
   * Get petalwidth
   * minimum: 0
   * maximum: 20
   * @return petalwidth
  */
  @ApiModelProperty(example = "0.2", required = true, value = "")
  @NotNull

@DecimalMin(value="0",inclusive=false) @DecimalMax("20") 
  public Double getPetalwidth() {
    return petalwidth;
  }

  public void setPetalwidth(Double petalwidth) {
    this.petalwidth = petalwidth;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IrisFeaturesWebLayer irisFeatures = (IrisFeaturesWebLayer) o;
    return Objects.equals(this.sepallength, irisFeatures.sepallength) &&
        Objects.equals(this.sepalwidth, irisFeatures.sepalwidth) &&
        Objects.equals(this.petallength, irisFeatures.petallength) &&
        Objects.equals(this.petalwidth, irisFeatures.petalwidth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sepallength, sepalwidth, petallength, petalwidth);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IrisFeaturesWebLayer {\n");
    
    sb.append("    sepallength: ").append(toIndentedString(sepallength)).append("\n");
    sb.append("    sepalwidth: ").append(toIndentedString(sepalwidth)).append("\n");
    sb.append("    petallength: ").append(toIndentedString(petallength)).append("\n");
    sb.append("    petalwidth: ").append(toIndentedString(petalwidth)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

