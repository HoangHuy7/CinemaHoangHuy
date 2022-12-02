package com.example.cinemahoanghuy.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.util.Base64;


@Component
public class QRCodeUtil {
    public static String createBase64QRCode(String data, int with, int height) {
        String image = "";

        try {
            BitMatrix matrix = new MultiFormatWriter().encode(
                    data,
                    BarcodeFormat.QR_CODE,
                    with,
                    height
            );
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(matrix, "png", bos);
            image = Base64.getEncoder().encodeToString(bos.toByteArray()); // base64 encode
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
}
