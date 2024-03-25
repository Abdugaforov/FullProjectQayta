package com.example.beckend.Controller;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping
public class FileController {
    @GetMapping("/{name}")
    public void getFile(@PathVariable String name, HttpServletResponse response) throws IOException {
        FileInputStream inputStream = new FileInputStream("src/main/resources/photos/" + name);

        ServletOutputStream outputStream = response.getOutputStream();

        inputStream.transferTo(outputStream);

        inputStream.close();
        outputStream.close();
    }

    @PostMapping
    public String saveFile(@RequestParam MultipartFile file) throws IOException {
        String image = UUID.randomUUID() + file.getOriginalFilename();

        FileOutputStream outputStream =
                new FileOutputStream("src/main/resources/photos/" + image);
        outputStream.write(file.getBytes());
        outputStream.close();

        return image;
    }

    @DeleteMapping("/{name}")
    public void deleteFile(@PathVariable String name) {
        File file = new File("src/main/resources/photos/" + name);
        file.delete();
    }
}
