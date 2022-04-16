package com.mall.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import net.coobird.thumbnailator.Thumbnails;

public class UploadFileUtils {

	static final int THUMB_WIDTH = 300;
	static final int THUMB_HEIGHT = 300;

	// 고유 파일명 세팅
	public static String fileUpload(String uploadPath, String fileName, byte[] fileData, String ymdPath) throws Exception {

		// 중복되지 않는 UUId 생성
		UUID uid = UUID.randomUUID();
		// "UUId" + "_" + "fileName" 패턴
		String newFileName = uid + "_" + fileName;
		String imgPath = uploadPath + ymdPath;

		File target = new File(imgPath, newFileName);
		FileCopyUtils.copy(fileData, target);

		String thumbFileName = "s_" + newFileName;
		File image = new File(imgPath + File.separator + newFileName);

		File thumbnail = new File(imgPath + File.separator + "s" + File.separator + thumbFileName);

		if (image.exists()) {
			thumbnail.getParentFile().mkdirs();
			Thumbnails.of(image).size(THUMB_WIDTH, THUMB_HEIGHT).toFile(thumbnail);
		}
		return newFileName;
	}

	// 년/월/일 형식의 디렉토리 생성
	public static String calcPath(String uploadPath) {
		// Calendar 객체 생성
		Calendar cal = Calendar.getInstance();
		
		// "/년/월/일" 경로 패턴 설정
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));

		// 실제 해당 경로가 존재하는지 판단 후 생성
		makeDir(uploadPath, yearPath, monthPath, datePath);
		makeDir(uploadPath, yearPath, monthPath, datePath + "\\s");

		return datePath;
	}

	// 디렉토리 존재여부 검사
	private static void makeDir(String uploadPath, String... paths) {

		if (new File(paths[paths.length - 1]).exists()) {
			return;
		}

		// yearPath -> monthPath -> dataPath 순으로
		for (String path : paths) {
			File dirPath = new File(uploadPath + path);

			// 더 깊은 곳의 디렉토리가 존재하지 않는다면
			if (!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
	}
}