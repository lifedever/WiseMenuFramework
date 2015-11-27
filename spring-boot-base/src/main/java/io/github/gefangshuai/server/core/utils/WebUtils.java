package io.github.gefangshuai.server.core.utils;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.IOException;

/**
 * Created by gefangshuai on 2015/11/27.
 */
public class WebUtils {

    public static ResponseEntity<byte[]> loadImage(String absolutePath) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(FileUtils.readFileToByteArray(new File(absolutePath)),
                headers, HttpStatus.CREATED);
    }
}
