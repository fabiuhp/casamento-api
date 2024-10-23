package br.com.fabiopereira.casamento_api.services.implementations;

import br.com.fabiopereira.casamento_api.services.intefaces.IUploadService;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadServiceImp implements IUploadService {
    @Override
    public String uploadFile(MultipartFile arquivo) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
