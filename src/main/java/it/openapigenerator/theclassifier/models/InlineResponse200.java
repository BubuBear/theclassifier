package it.openapigenerator.theclassifier.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InlineResponse200
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-04-21T18:32:32.660141400+02:00[Europe/Berlin]")
public class InlineResponse200   {
  /**
   * Gets or Sets irisType
   */
  public enum IrisTypeEnum {
    SETOSA("Iris-setosa"),
    
    VERSICOLOR("Iris-versicolor"),
    
    VIRGINICA("Iris-virginica");

    private String value;

    IrisTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static IrisTypeEnum fromValue(String value) {
      for (IrisTypeEnum b : IrisTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("iris-type")
  private IrisTypeEnum irisType;

  public InlineResponse200 irisType(IrisTypeEnum irisType) {
    this.irisType = irisType;
    return this;
  }

  /**
   * Get irisType
   * @return irisType
  */
  @ApiModelProperty(example = "Iris-setosa", required = true, readOnly = true, value = "")
  @NotNull


  public IrisTypeEnum getIrisType() {
    return irisType;
  }

  public void setIrisType(IrisTypeEnum irisType) {
    this.irisType = irisType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return Objects.equals(this.irisType, inlineResponse200.irisType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(irisType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("    irisType: ").append(toIndentedString(irisType)).append("\n");
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

