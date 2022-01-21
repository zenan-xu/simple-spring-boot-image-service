package zenan.test.imagetransformer.rest;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zenan.test.imagetransformer.service.ImageTransformerService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class ImageTransformerController {

    private final ImageTransformerService imageTransformerService;
    private final List<String> imageTypes = Arrays.asList("image/png", "image/jpeg");

    public ImageTransformerController(ImageTransformerService imageTransformerService) {
        this.imageTransformerService = imageTransformerService;
    }

    /**
     * Generate thumbnail image with scale
     * @param image original image
     * @param scale default 0.2, 20% of original image
     * @return http response with image in byte array
     * @throws IOException
     */
    @PostMapping(value = "/change-scale", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<byte[]> changeScale(@RequestParam("image")MultipartFile image,
                                              @RequestParam(defaultValue = "0.2") double scale) throws IOException {
        if (!imageTypes.contains(image.getContentType())) {
            return ResponseEntity.badRequest().build();
        } else {
            return new ResponseEntity<>(imageTransformerService.transformImageScale(image, scale), generateHeaders(image), HttpStatus.OK);
        }
    }

    /**
     * Generate thumbnail image with size
     * @param image original image
     * @param width default 200
     * @param height default 200
     * @return http response with image in byte array
     * @throws IOException
     */
    @PostMapping(value = "/change-size", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<byte[]> changeScale(@RequestParam("image")MultipartFile image,
                                              @RequestParam(defaultValue = "200") int width,
                                              @RequestParam(defaultValue = "200") int height) throws IOException {
        if (!imageTypes.contains(image.getContentType())) {
            return ResponseEntity.badRequest().build();
        } else {
            return new ResponseEntity<>(imageTransformerService.transformImageSize(image, width, height),generateHeaders(image), HttpStatus.OK);
        }
    }

    private HttpHeaders generateHeaders(MultipartFile image) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDisposition(ContentDisposition.builder("inline")
                .filename("thumbnail_" + image.getOriginalFilename())
                .build());
        return headers;
    }
}
