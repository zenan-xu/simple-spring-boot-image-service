package zenan.test.imageuploader.service;

import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class CloudStorageService implements StorageService {

    @Value("${gcs-resource.bucket}")
    private String bucket;

    @Value("${gcs-resource.path}")
    private String path;

    private final Storage storage;

    public CloudStorageService(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String store(MultipartFile image) {
            try {
                BlobInfo blobInfo = storage.get(bucket).create(path + image.getOriginalFilename(), image.getBytes());
                return blobInfo.getMediaLink(); // Return file url
            }catch(IllegalStateException | IOException e){
                throw new RuntimeException(e);
            }
    }

}
