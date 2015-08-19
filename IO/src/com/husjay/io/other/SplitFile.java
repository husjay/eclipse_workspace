package com.husjay.io.other;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SplitFile {
	//文件名
	private String fileName;
	//文件大小
	private long length;
	//文件路径
	private String filePath;
	//文件块分割大小
	private long blockSize;
	//文件分割块数
	private int size;
	//文件块路径、名称
	private List<String> blockPath;
	
	public SplitFile() {
		blockPath = new ArrayList<String>();
	}
	public SplitFile(String filePath) {
		this(filePath, 1024);
	}
	public SplitFile(String filePath, long blockSize) {
		this();
		this.filePath = filePath;
		this.blockSize = blockSize;
		init();
	}
	
	/**
	 * 初始化操作，计算块数、确定文件名
	 */
	public void init() {
		File src = null;
		//健壮性
		if(null == filePath || !(src = new File(filePath)).exists()) {
			return;
		}
		if(src.isDirectory()) {
			return;
		}
		//文件名
		this.fileName = src.getName();
		
		//计算块数
		this.length = src.length();
		//修正块大小
		if(this.blockSize > length) {
			this.blockSize = length;
		}
		//计算块数
		size = (int)Math.ceil(length*1.0/this.blockSize);
		initPathName(src.getParent().toString()+"/Demo");
	}
	
	private void initPathName(String destPath) {
		for(int i=0; i<this.size; i++) {
			this.blockPath.add(destPath+"/"+this.fileName+".part"+i);
		}
	}
	
	/**
	 * 文件分割
	 * 1 起始位置
	 * 2 实际大小
	 * @param destPath 分割文件的目录
	 */
	public void split(String destPath) {
		//确定文件路径
		initPathName(destPath);
		split();
	}
	public void split() {
		
		long beginPos = 0;	//起始点
		long actualBlockSize = blockSize;	//实际大小
		
		for(int i=0; i<size; i++) {
			if(i == size-1) {
				//最后一块
				actualBlockSize = this.length - beginPos;
			}
			splitDetail(i, beginPos, actualBlockSize);
			beginPos += actualBlockSize;	//下一次的起点
		}
	}
	/**
	 * 文件的分割 输入 输出
	 * 文件拷贝
	 * @param idx 第几块
	 * @param beginPos 起始点
	 * @param actualBiockSize 实际大小
	 */
	private void splitDetail(int idx, long beginPos, long actualBlockSize) {
		//创建源
		File src = new File(this.filePath);	//源文件
		File dest = new File(this.blockPath.get(idx)); 	//目标文件
		
		//选择流
		RandomAccessFile raf =  null;	//输入流
		BufferedOutputStream bos = null;	//输出流
		try {
			raf = new RandomAccessFile(src,"r");
			bos = new BufferedOutputStream(new FileOutputStream(dest));
			
			//读取文件
			raf.seek(beginPos);
			//缓冲区
			byte[] flush = new byte[1024];
			int len = 0;
			while(-1 != (len = raf.read(flush))) {
				
				if(actualBlockSize -len >= 0) {	//查看是否足够写
					//写出
					bos.write(flush, 0, len);
					actualBlockSize -= size;
				} else { //写出最后一次的剩余量
					bos.write(flush, 0, (int)actualBlockSize);
					break;
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				raf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * 文件的合并
	 */
	public void merge(String destPath) {
		//创建源
		File dest = new File(destPath);
		BufferedOutputStream bos = null;	//输出流
		try {
			//选择流
			BufferedInputStream bis = null;
			bos = new BufferedOutputStream(new FileOutputStream(dest, true));	//追加
			for(int i=0; i<this.blockPath.size(); i++) {
				bis = new BufferedInputStream(new FileInputStream(new File(this.blockPath.get(i))));
				//缓冲区
				byte[] flush = new byte[1024];
				int len = 0;
				while(-1 != (len = bis.read(flush))) {
					bos.write(flush, 0, len);
				}
				bos.flush();
				bis.close();
			}
		} catch(Exception e) {
			
		} finally {
			try {
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/*
	 * 文件的合并
	 * 使用SequenceInputStream
	 * 把多个流合并成一个流，之后再写入文件
	 */
	public void merge1(String destPath) {
		//创建源
		File dest = new File(destPath);
		
		BufferedOutputStream bos = null;	//输出流
		SequenceInputStream sis = null;		//输入流
		//创建容器
		Vector<InputStream> vi = new Vector<InputStream>();
		
		try {
			//选择流
			for(int i=0; i<this.blockPath.size(); i++) {
				vi.add(new BufferedInputStream(new FileInputStream(new File(this.blockPath.get(i)))));
			}
			bos = new BufferedOutputStream(new FileOutputStream(dest, true));	//追加
			sis = new SequenceInputStream(vi.elements());
			//缓冲区
			byte[] flush = new byte[1024];
			int len = 0;
			while(-1 != (len = sis.read(flush))) {
				bos.write(flush, 0, len);
			}
			bos.flush();
			sis.close();
		} catch(Exception e) {
			
		} finally {
			try {
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		SplitFile split = new SplitFile("/Users/hsj/test/Demo.java", 100);
		//System.out.println(split.size);
		
		split.split();
		
		split.merge1("/Users/hsj/test/Demo/Demo.java");
	}
}
