package zenan.test.imagetransformer.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageTransformerService {
    byte[] transformImageScale(MultipartFile image, double scale) throws IOException;
    byte[] transformImageSize(MultipartFile image, int width, int height) throws IOException;
}
