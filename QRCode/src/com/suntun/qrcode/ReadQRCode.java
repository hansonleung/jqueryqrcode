package com.suntun.qrcode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;

public class ReadQRCode {

	public static void main(String[] args) throws Exception {

		File file = new File("D:/QRCode/QRCode.jpg");
		BufferedImage bufferedImage = ImageIO.read(file);
		
		QRCodeDecoder qrCodeDecoder = new QRCodeDecoder();
		
		String result = new String (qrCodeDecoder.decode( new QRCodeImege(bufferedImage)),"UTF-8");
		
		System.out.println("二维码解析结果："+result);

	}

}
