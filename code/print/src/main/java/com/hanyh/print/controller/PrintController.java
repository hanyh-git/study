package com.hanyh.print.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.SimpleFormatter;


@Controller
@RequestMapping("/print")
public class PrintController {
    @GetMapping("/open")
    public String printIndex() {
        return "index";
    }

    @PostMapping("/upload")
    public String uploadMedia(@RequestBody MultipartFile[] files) throws IOException {
        String path = "D:/" + "print/" + System.currentTimeMillis() / 1000;
        File fileDirs = new File(path);
        if (!fileDirs.exists()) {
            fileDirs.mkdirs();
        }
        System.out.println(1);

        for (MultipartFile  media : files) {
            File file = new File(path +"/"+ media.getOriginalFilename());
            System.out.println(file.getAbsoluteFile());
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            FileInputStream in = (FileInputStream) media.getInputStream();

            byte[] bytes = new byte[1024];
            int i;
            while ((i = in.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, i);
            }
            fileOutputStream.close();
            in.close();
        }

        return "success";
    }
}

