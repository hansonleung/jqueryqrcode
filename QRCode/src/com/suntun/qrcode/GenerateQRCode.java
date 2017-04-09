package com.suntun.qrcode;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

public class GenerateQRCode {

	public static void main(String[] args) throws Exception {
		//定义用到的二维码版本号(1-40)
		int version = 7;
		//定义二维码图片的宽度
		//int width  =300;
		//计算宽高公式：67 + 12 * (版本号 - 1)
		int width  = 67 + 12 * (version - 1);
		
		//定义二维码图片的高度
		//int height = 300;
		//计算宽高公式：67 + 12 * (版本号 - 1)
		int height = 67 + 12 * (version - 1);
		
		Qrcode x = new Qrcode();
		//设置纠错等级
		x.setQrcodeErrorCorrect('M');
		//N代表数字，A代表a-z及A-Z，B代表其他字符
		x.setQrcodeEncodeMode('B');
		//设置版本号(1-40)
		x.setQrcodeVersion(version);
		String qrData = "http://www.imooc.com";
		//创建缓冲区图片
		BufferedImage bufferedImage  = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//画图
		Graphics2D gs =  bufferedImage.createGraphics();
		//设置背景色为白色
		gs.setBackground(Color.WHITE);
		//设置前景色为黑色
		gs.setColor(Color.BLACK);
		//清除画板内容
		gs.clearRect(0, 0, width, height);
		//设置偏移量
		int pixoff = 2;
		
		byte[] d = qrData.getBytes();
		if (d.length > 0 && d.length < 120) {
			boolean[][] s = x.calQrcode(d);

			for (int i = 0; i < s.length; i++) {
				for (int j = 0; j < s.length; j++) {
					if (s[j][i]) {
						gs.fillRect(j * 3+pixoff, i * 3+pixoff, 3, 3);
					}
				}
			}
		}
		
		gs.dispose();
		bufferedImage.flush();
		//存放二维码图片目录
		File file = new File("D:/QRCode/QRCode.jpg");
		//如果目录不存在，则创建目录
		if(!file.isDirectory())
		{
			file.mkdirs();
		}
		//输入二维码图片
		ImageIO.write(bufferedImage, "jpg", file);
		System.out.println("生成二维码成功：目录"+file.getPath());

	}

}
