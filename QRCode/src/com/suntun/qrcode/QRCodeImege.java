package com.suntun.qrcode;

import java.awt.image.BufferedImage;

import jp.sourceforge.qrcode.data.QRCodeImage;

public class QRCodeImege implements QRCodeImage {

	BufferedImage bufferedImage;
	
	public  QRCodeImege(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return bufferedImage.getHeight();
	}

	@Override
	public int getPixel(int x, int y) {
		// TODO Auto-generated method stub
		return bufferedImage.getRGB(x, y);
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return bufferedImage.getWidth();
	}

}
