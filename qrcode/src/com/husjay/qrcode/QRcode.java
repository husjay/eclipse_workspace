/**
 * 
 */
package com.husjay.qrcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;

import com.swetake.util.Qrcode;

/**
 * @author hsj
 *
 */
public class QRcode {

	public static void main(String[] args) {
		try {
			encode();
			decode();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void encode() throws IOException {

		Qrcode x = new Qrcode();

		// 纠错等级
		x.setQrcodeErrorCorrect('M');

		// N代表数字、A代表a-Z、B代表其它字符
		x.setQrcodeEncodeMode('B');

		// 版本
		x.setQrcodeVersion(7);

		int width = 67 + 12 * (7 -1), height = 67 + 12 * (7 -1);
		BufferedImage bufferedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		Graphics2D gs = bufferedImage.createGraphics();
		gs.setBackground(Color.WHITE);
		gs.setColor(Color.BLACK);
		gs.clearRect(0, 0, width, height);

		int pixoff = 2; // 偏移量

		String qrData = "www.baidu.com";
		byte[] d = qrData.getBytes("gb2312");
		if (d.length > 0 && d.length < 120) {
			boolean[][] s = x.calQrcode(d);

			for (int i = 0; i < s.length; i++) {
				for (int j = 0; j < s.length; j++) {
					if (s[j][i]) {
						gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
					}
				}
			}
		}
		
		gs.dispose();
		bufferedImage.flush();
		
		File file = new File("/Users/hsj/Documents/eclipse_workspace/qrcode/qrcode/qrcode.png");
		ImageIO.write(bufferedImage, "png", file);

	}

	public static void decode() throws IOException {
		
		File file = new File("/Users/hsj/Documents/eclipse_workspace/qrcode/qrcode/qrcode.png");
		
		BufferedImage bufferedImage = ImageIO.read(file);
		
		QRCodeDecoder codeEncoder = new QRCodeDecoder();
		
		String result = new String(codeEncoder.decode(new MyQRCodeImage(bufferedImage)), "gb2312");
		
		System.out.println(result);
	}

}
