package com.suntun.zxing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

/**
 * 解析二维码
 * @author Administrator
 *
 */
public class ReadQRCode {

	public static void main(String[] args) {
		
		try {
			MultiFormatReader formatReader = new  MultiFormatReader();
			
			File file = new File("D:/QRCode/QRCode.png");
			BufferedImage bufferedImage = ImageIO.read(file);
			BinaryBitmap image = new BinaryBitmap(new  HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));
			//定义二维码参数
			HashMap hints = new  HashMap();
			//设置二维码字符编码格式
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			Result result = formatReader.decode(image, hints);
			
			System.out.println("二维码解析结果："+result.toString());
			System.out.println("二维码格式类型："+result.getBarcodeFormat());
			System.out.println("二维码文本内容："+result.getText());
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
