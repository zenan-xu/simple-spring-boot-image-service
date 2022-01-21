package zenan.test.imagetransformer.service;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
@Slf4j
public class ImageTransformerServiceImpl implements ImageTransformerService {

    @Override
    public byte[] transformImageScale(MultipartFile image, double scale) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Thumbnails.of(image.getInputStream()).scale(scale).toOutputStream(outputStream);
        log.info("Image transformed with scale {}", scale);
        return outputStream.toByteArray();
    }

    @Override
    public byte[] transformImageSize(MultipartFile image, int width, int height) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Thumbnails.of(image.getInputStream()).size(width, height).toOutputStream(outputStream);
        log.info("Image transformed with size {}x{}", width, height);
        return outputStream.toByteArray();
    }
}
