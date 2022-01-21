package zenan.test.imageuploader.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import zenan.test.imageuploader.service.CloudStorageService;
import zenan.test.imageuploader.service.StorageService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ImageUploadController {

    private final StorageService storageService;
    private final List<String> imageTypes = Arrays.asList("image/png", "image/jpeg");

    public ImageUploadController(CloudStorageService storageService) {
        this.storageService = storageService;
    }

    /**
     * Upload image
     * @param image image file
     * @return http response
     */
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> handleImageUpload(@RequestParam("image")MultipartFile image) {
        if (!imageTypes.contains(image.getContentType())) {
            return ResponseEntity.badRequest().body("Not an image");
        } else {
            String fileUrl = storageService.store(image);
            return ResponseEntity.ok("Image uploaded to " + fileUrl);
        }
    }
}
