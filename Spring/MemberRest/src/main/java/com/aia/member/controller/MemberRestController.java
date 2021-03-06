package com.aia.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aia.member.model.Member;
import com.aia.member.model.MemberEditRequest;
import com.aia.member.model.MemberRegRequest;
import com.aia.member.service.MemberDeleteServcie;
import com.aia.member.service.MemberEditService;
import com.aia.member.service.MemberListService;
import com.aia.member.service.MemberRegService;
import com.aia.member.service.MemberViewService;


@RestController
@RequestMapping("/members")
public class MemberRestController {

	@Autowired
	private MemberListService listService;
	
	@Autowired 
	private MemberRegService regService;
	
	@Autowired
	private MemberViewService viewServie;
	
	@Autowired
	private MemberEditService editService;
	
	@Autowired
	private MemberDeleteServcie delteService;
	
	//회원의 리스트 : Json 으로 응답 
	@GetMapping 		//Get 	|	/members
	public List<Member> getMemberList(){
		return listService.getMemberList();
	}
	
	// 회원 등록
	@PostMapping 		//Post 	|	/members
	public int reg(MemberRegRequest regRequest, HttpServletRequest request) {
		
		return regService.regMember(regRequest, request);
	}
	
	// 한 명의 회원 정보 보기
	@GetMapping("/{idx}")
	public Member getMember(
			@PathVariable("idx") int idx
			) {
		
		return viewServie.getMember(idx);
	}
	
	// 한 명의 회원 정보 수정
	//@PutMapping("/{idx}") 	//Put | /members/{idx}
	@PostMapping("/{idx}")
	public int edit(
			@PathVariable("idx") int idx,
			MemberEditRequest editRequest,
			HttpServletRequest request
			) {
		editRequest.setIdx(idx);
		
		return editService.editMember(editRequest, request);
	}
	
	// 한 명의 회원 정보 삭제 
	@DeleteMapping("/{idx}")
	public int delete(@PathVariable("idx") int idx) {
		return delteService.deleteMember(idx);
	}
	
}
