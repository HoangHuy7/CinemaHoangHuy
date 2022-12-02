package com.example.cinemahoanghuy.api;

import com.example.cinemahoanghuy.util.QRCodeUtil;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.Base64;
import java.util.Map;

@RestController
@RequestMapping("/qr")
public class testQR {
    @GetMapping(value = "/test")
    public QrInfo getQrInfo(HttpServletRequest request) throws Exception {

        String url = "huy dep trai";
        URL url2 = new URL(request.getRequestURL().toString());

        String base = "https://www.facebook.com/huydeptraivodichvutru7";

        System.out.println(base);
        int imageSize = 200;
        String image = QRCodeUtil.createBase64QRCode(base,imageSize,imageSize);
        System.out.println(image.length());
        QrInfo qrInfo = new QrInfo();
        qrInfo.setUrl(url);
        qrInfo.setImage(image);
        return qrInfo;
    }
    @Data // lombok for brevity
    class QrInfo {

        private String url;
        private String image;

    }
}
