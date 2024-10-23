package br.com.fabiopereira.casamento_api.services.intefaces;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadService {

    String uploadFile(MultipartFile arquivo);
}
