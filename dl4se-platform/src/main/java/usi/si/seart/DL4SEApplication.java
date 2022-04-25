package usi.si.seart;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
@SpringBootApplication
@AllArgsConstructor(onConstructor_ = @Autowired)
public class DL4SEApplication {

    Path fileStorageDirPath;

    public static void main(String[] args) {
        SpringApplication.run(DL4SEApplication.class, args);
    }

    @SneakyThrows
    @PostConstruct
    private void createFileStorageDirectory() {
        if (Files.notExists(fileStorageDirPath)) {
            log.info("File storage directory: '{}' not found! Initializing new one...", fileStorageDirPath);
            Files.createDirectory(fileStorageDirPath);
        } else {
            log.info("File storage directory: '{}'", fileStorageDirPath);
        }
    }
}
