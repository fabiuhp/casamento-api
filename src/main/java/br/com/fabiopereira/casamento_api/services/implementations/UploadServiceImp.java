package br.com.fabiopereira.casamento_api.services.implementations;

import br.com.fabiopereira.casamento_api.services.intefaces.IUploadService;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class UploadServiceImp implements IUploadService {
    @Override
    public String uploadFile(MultipartFile arquivo) {
        try {
            String caminho = "C:\\Users\\fabio\\Downloads\\arq";

            Path path = Paths.get(caminho + File.separator + arquivo.getOriginalFilename());
            Files.copy(arquivo.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Arquivo copiado");

            return path.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
