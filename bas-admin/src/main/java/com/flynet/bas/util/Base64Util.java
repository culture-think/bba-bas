/* <p>文件名称: Base64Util.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2016-2026</p>
 * <p>公    司: 沈阳唬哈科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2018年2月6日</p>
 * <p>完成日期：2018年2月6日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：下午6:06:45
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;

/**
 * Base64文件工具类
 * 
 * @author zhanghuafeng
 */
@SuppressWarnings("restriction")
public class Base64Util {
	// public static void main(String[] args) throws IOException {
	// String strImg = convert2Base64("D:\\tupian\\new.jpg");
	// System.out.println(strImg);
	// convert2File(strImg, "D:\\tupian\\new.jpg");
	// }

	// 图片转化成base64字符串
	public static String convert2Base64(String filePath) throws IOException {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		InputStream in = null;
		byte[] data = null;

		in = new FileInputStream(filePath);
		data = new byte[in.available()];
		in.read(data);
		in.close();
		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	}

	// base64字符串转化成图片
	public static void convert2File(String imgStr, String filePath) throws IOException { // 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) { // 图像数据为空
			imgStr = "";
		}

		BASE64Decoder decoder = new BASE64Decoder();
		// Base64解码
		byte[] b = decoder.decodeBuffer(imgStr);
		for (int i = 0; i < b.length; ++i) {
			if (b[i] < 0) {// 调整异常数据
				b[i] += 256;
			}
		}
		OutputStream out = new FileOutputStream(filePath);
		out.write(b);
		out.flush();
		out.close();

		return;
	}

}
