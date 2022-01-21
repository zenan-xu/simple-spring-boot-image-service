package zenan.test.imageuploader.service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    String store(MultipartFile image);

}
