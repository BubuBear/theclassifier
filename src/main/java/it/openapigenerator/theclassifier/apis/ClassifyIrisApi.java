package it.openapigenerator.theclassifier.apis;

import it.openapigenerator.theclassifier.models.InlineResponse200WebLayer;
import it.openapigenerator.theclassifier.models.InlineResponse400WebLayer;
import it.openapigenerator.theclassifier.models.IrisFeaturesWebLayer;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-04-22T18:11:11.362482500+02:00[Europe/Berlin]")
@Validated
@Api(value = "classify-iris", description = "the classify-iris API")
public interface ClassifyIrisApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /classify-iris
     * This endpoint invoce operation which given iris features return features type
     *
     * @param irisFeaturesWebLayer The body request contains the actual iris measures (optional)
     * @return Example response (status code 200)
     *         or Example response (status code 400)
     *         or Example response (status code 404)
     *         or Example response (status code 500)
     *         or Example response (status code 501)
     */
    @ApiOperation(value = "", nickname = "postClassifyIris", notes = "This endpoint invoce operation which given iris features return features type", response = InlineResponse200WebLayer.class, tags={ "iris-features", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Example response", response = InlineResponse200WebLayer.class),
        @ApiResponse(code = 400, message = "Example response", response = InlineResponse400WebLayer.class),
        @ApiResponse(code = 404, message = "Example response", response = InlineResponse400WebLayer.class),
        @ApiResponse(code = 500, message = "Example response", response = InlineResponse400WebLayer.class),
        @ApiResponse(code = 501, message = "Example response", response = InlineResponse400WebLayer.class) })
    @PostMapping(
        value = "/classify-iris",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<InlineResponse200WebLayer> postClassifyIris(@ApiParam(value = "The body request contains the actual iris measures"  )  @Valid @RequestBody(required = false) IrisFeaturesWebLayer irisFeaturesWebLayer) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"iris-type\" : \"Iris-setosa\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
