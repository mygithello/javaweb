package com.test.someutils.createword;

import java.io.IOException;

import java.io.Writer;

import java.util.Map;

import freemarker.template.Configuration;

import freemarker.template.Template;


public class WordUtil {

	private Configuration configuration = null;

	public WordUtil() {

		try {

			configuration = new Configuration();

			configuration.setDefaultEncoding("UTF-8");

		} catch (Exception e) {

			System.out.println(e.getMessage());

			e.printStackTrace();

		}

	}

	private Template getTemplate(String templatePath, String templateName)

	throws IOException {

		configuration.setClassForTemplateLoading(this.getClass(), templatePath);

		Template t = configuration.getTemplate(templateName);

		t.setEncoding("UTF-8");

		return t;

	}

	public void write(String templatePath, String templateName,

	Map<String, String> dataMap, Writer out) {

		try {

			Template t = getTemplate(templatePath, templateName);

			t.process(dataMap, out);

			out.close();

		} catch (Exception e) {

			System.out.println(e.getMessage());

			e.printStackTrace();

		}

	}

}
