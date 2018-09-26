package com.ym.util;

import java.io.File;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

public class SystemUtil {
	/**
	 * 系统编码
	 */
	public static final String ENCODE = "UTF-8";

	/**
	 * 文件分割符
	 */
	public static final String SEPARATOR = File.separator;

	/**
	 * 文档模板相对路径
	 */
	public static final String DOCUMENT_TEMPLATE_PATH = SEPARATOR + "template";

	/**
	 * 临时上传附件
	 */
	public static final String DOCUMENT_TEMP_PATH = "tmp";

	/**
	 * 业务正式附件
	 */
	public static final String BUSINESS_PATH = "biz";

	/**
	 * 现势汇交附件
	 */
	public static final String PRESENT_PATH = "pres";

	/**
	 * 历史资料附件
	 */
	public static final String HISTORY_PATH = "hist";

	/**
	 * 默认附件根文件夹
	 */
	public static final String ATTACHMENT_FOLDER = "files";

	/**
	 * 默认名称分隔符
	 */
	public static final String DEF_DELIMITER = "/";

	/**
	 * 项目根路径，在启动时初始化
	 */
	private static String ROOT_PATH;

	/**
	 * 附件存放目录，在启动时初始化
	 */
	private static String ATTACHMENT_PATH;

	/**
	 * 获取webapp路径。
	 */
	public static String getRootPath() {
		return ROOT_PATH;
	}

	public static String setRootPath(String rootPath) {
		return SystemUtil.ROOT_PATH = rootPath;
	}

	/**
	 * 获取附件存放目录
	 */
	public static String getAttachmentPath() {
		return ATTACHMENT_PATH;
	}

	public static void setAttachmentPath(String attachmentPath) {
		ATTACHMENT_PATH = attachmentPath;
	}

	/**
	 * 根据业务号生生成相对存储路径。
	 */
	public static String getPathByYwh(String ywh) {
		StringBuilder path = new StringBuilder();
		if (StringUtils.hasText(ywh) && ywh.length() == 20) {
			LocalDate now = LocalDate.now();
			int year = now.getYear();
			path.append(SEPARATOR).append(ywh.substring(0, 2)).append(SEPARATOR).append(ywh.substring(2, 4))
					.append(SEPARATOR).append(ywh.substring(4, 6)).append(SEPARATOR).append(year).append(SEPARATOR)
					.append(ywh);
		}
		return path.toString();
	}

	public static boolean hasZh(String str) {
		String regEx = "[\u4e00-\u9fa5]";
		Pattern pat = Pattern.compile(regEx);
		Matcher matcher = pat.matcher(str);
		boolean flg = false;
		if (matcher.find()) {
			flg = true;
		}
		return flg;
	}
}
