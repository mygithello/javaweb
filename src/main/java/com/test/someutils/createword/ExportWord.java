package com.test.someutils.createword;

import java.io.FileOutputStream;

import java.io.OutputStreamWriter;

import java.io.Writer;

import java.util.HashMap;

import java.util.Map;

/**
 * 
 * @author Carry
 *
 */
public class ExportWord {

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("name", "黑狗");

		map.put("age", "12345");

		WordUtil handler = new WordUtil();

		Writer out;

		try {

			out = new OutputStreamWriter(new FileOutputStream(
					"E:\\testModel.doc"),

			"UTF-8");// 生成文件的保存路径

			handler.write("/", "wordTest.xml", map, out);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
