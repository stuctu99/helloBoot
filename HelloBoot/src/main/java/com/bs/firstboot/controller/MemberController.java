package com.bs.firstboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bs.firstboot.model.dto.Member;
import com.bs.firstboot.model.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberController {
	
	private final MemberService service;
	
	@GetMapping
	public List<Member> selectMemberAll(){
		return service.selectMemberAll();
	}
	
	@PostMapping
	public int insertMember(@RequestBody Member member) {
		System.out.println(member);
		return service.insertMember(member);
	}
	
	@PutMapping("/{id}")
	public int updateMember(@PathVariable String id, @RequestBody Member member) {
		return service.updateMember(member);
	}
	
	@DeleteMapping("/{id}")
	public int deleteMember(@PathVariable String id) {
		return service.deleteMember(id);
	}
}
