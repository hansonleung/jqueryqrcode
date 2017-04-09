package com.suntun.zxing;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 生成二维码
 * @author Administrator
 *
 */
public class GenerateQRCode {

	public static void main(String[] args) {
		//定义二维码图片的宽度
		int width  =300;
		//定义二维码图片的高度
		int height = 300;

		//生成的二维码的图片格式
		String imageFormat = "png";
		//二维码详细信息
		String contents = "http://www.imooc.com";
		
		//定义二维码参数
		HashMap hints = new  HashMap();
		//设置二维码字符编码格式
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		//设置二维码的容错登录（从高到低H>L>M>Q,容错等级设置越高，则二维码能够存储的信息就越少，一般设置为M）
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		//设置二维码空白边框宽度，一般设置为2
		hints.put(EncodeHintType.MARGIN, 2);
		
		//生成二维码
		try {
			BitMatrix matrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height, hints);
			//存放二维码图片目录
			File file = new File("D:/QRCode/QRCode.png");
			//如果目录不存在，则创建目录
			if(!file.isDirectory())
			{
				file.mkdirs();
			}
			Path path = file.toPath();
			
			MatrixToImageWriter.writeToPath(matrix, imageFormat, path);
			System.out.println("生成二维码成功，目录："+path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
