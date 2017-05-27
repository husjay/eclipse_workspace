package com.husjay.zxing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class ZxingQRcode {
	
	public static void main(String[] args) {
		
		parseQRCode();
		
	}
	
	private static void parseQRCode() {
		
		try {
			MultiFormatReader formatReader = new MultiFormatReader();
			
			File file = new File("/Users/hsj/Documents/eclipse_workspace/qrcode/qrcode/zxcode.png");
			
			BufferedImage image = ImageIO.read(file);
			
			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
			
			HashMap hints = new HashMap();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			Result result = formatReader.decode(binaryBitmap, hints);
			
			System.out.println("qrcode = " + result.toString());
			System.out.println("qrcode format = " + result.getBarcodeFormat());
			System.out.println("qrcode text = " + result.getText());
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void generateQRCode() {
		int width = 300;
		int height = 300;
		String fromat = "png";
		String contents = "http://www.baidu.com";
		
		HashMap hints = new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		hints.put(EncodeHintType.MARGIN, 2);
		
		try {
			BitMatrix matrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height, hints);
			File file = new File("/Users/hsj/Documents/eclipse_workspace/qrcode/qrcode/code.png");
			MatrixToImageWriter.writeToFile(matrix, fromat, file);
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
