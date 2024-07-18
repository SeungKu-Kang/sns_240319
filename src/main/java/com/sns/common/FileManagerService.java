package com.sns.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManagerService {

	// 실제 업로드 된 이미지가 저장될 서버의 경로
	public static final String FILE_UPLOAD_PATH = "D:\\강승구\\6_spring_project\\SNS\\sns_workspace\\images/";
	
	// input : MultipartFile , userLoginId
	// output: String (이미지 경로)
	public String uploadFile(MultipartFile file, String loginId) {
		// 폴더 (디렉토리) 생성
		String directoryName = loginId + "_" + System.currentTimeMillis();
		
		//
		String filePath = FILE_UPLOAD_PATH + directoryName + "/";
		
		// 폴더 생성
		File directory = new File(filePath);
		if (directory.mkdir() == false) {
			// 폴더 생성 실패시 경로를 null로 리턴
			return null;
		}
		
		// 파일 업로드
		try {
			byte[] bytes = file.getBytes();
			// ★★★★★★★★★ 한글명으로 된 이미지는 업로드 불가하므로 나중에 영문자로 바꾸기
			Path path = Paths.get(filePath + file.getOriginalFilename());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		// 파일 업로드가 성공하면 이미지 url path를 리턴
		return "images/" + directoryName + "/" + file.getOriginalFilename();
				
	}
}
