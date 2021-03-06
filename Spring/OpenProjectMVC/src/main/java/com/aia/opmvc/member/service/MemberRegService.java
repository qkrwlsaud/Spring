package com.aia.opmvc.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aia.opmvc.jdbc.ConnectionProvider;
import com.aia.opmvc.member.dao.MemberDao;
import com.aia.opmvc.member.dao.MemberMybatisDao;
import com.aia.opmvc.member.model.Member;

@Service
public class MemberRegService {

	//@Autowired
	//MemberDao dao;
	
	MemberMybatisDao dao;
	
	@Autowired
	SqlSessionTemplate template;
	
	
	
	public int memberReg(HttpServletRequest request, Member member) {
		
		int resultCnt = 0;
		
		dao=template.getMapper(MemberMybatisDao.class);
		
			try {
				
				MultipartFile file = member.getPhoto();
				
				if(file != null && file.getSize()>0 && !file.isEmpty()) {
					
					
					String uri=request.getSession().getServletContext().getInitParameter("memberUphotoPath");
					System.out.println(uri);
					String realPath=request.getSession().getServletContext().getRealPath(uri);
					System.out.println(realPath);
					String newFileName = System.nanoTime()+"_"+file.getOriginalFilename();
					File saveFile = new File(realPath, newFileName);
					file.transferTo(saveFile);	
					
					member.setUploadPhoto(newFileName);
					
					System.out.println("파일 저장 완료 ");
					
				}else {
					System.out.println("파일 저장 실패");
				}
				
				
				resultCnt = dao.insertMember(member);
				
			}  catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
			
			return resultCnt;
		
	}

}