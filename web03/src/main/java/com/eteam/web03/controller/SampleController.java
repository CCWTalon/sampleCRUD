package com.eteam.web03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eteam.web03.service.SampleService;
import com.eteam.web03.vo.Sample;

@Controller
public class SampleController {
	
	@Autowired
	private SampleService sampleService;
	
	// 1. 입력 폼
	@GetMapping("addSample")
	public String addSample() {
		
		return "addSample";	// view이름은 template폴더에 addSample.html
	}
	
	// 2. 입력 액션
	@PostMapping("addSample")
	public String addSample( // 매핑 주소가 중복되는 것을 방지하기 위해 메소드에 화면에서 받아온 sampleName을
							 // RequestParam을 이용하여 String타입의 sampleName변수에 담아온다.
			  @RequestParam(value="sampleName") String sampleName) {
		// Controller가 잘 작동 되었는지 콘솔창에서 확인한다.
		System.out.print("addSample Action");
		// sampleService클래스의 addSample메서드에 String타입의 sampleName변수를 넣고 호출한다.
		sampleService.addSample(sampleName);
		
		// sampleList 주소로 값을 redirect한다.
		return "redirect:/sampleList";
	}
	
	// 3. 목록
	@GetMapping("/sampleList")
	public String sampleList(Model model) { // SampleList를 조회하기 위해 Model클래스의 model변수를 담고 호출한다.
		// sampleService클래스의 getSampleList메서드 호출
		List<Sample> list = sampleService.getSampleList();
		// Model 인터페이스의 메서드인 addAttribute메서드를 사용해 list객체를 list이름으로 추가한다.
		model.addAttribute("list", list);
		// List가 잘 호출되었는지 확인한다.
		System.out.println("Request : /sampleList");
		
		// sampleList주소 값을 리턴한다.
		return "sampleList";
	}
	
	// 4. 삭제 액션
	@GetMapping("sampleDelete")
	public String sampleDelete( // 삭제 동작을 하기 위해 필요한 sampleId값을
								// RequestParam Annotation을 사용해 값을 받아와 int타입의 변수로 선언한다.
			@RequestParam(value="sampleId") int sampleId) {
		// int타입의 result 변수에 sampleService클래스의 removeSample메서드에 sampleId값을 넣고 호출하고 주소 값을 담는다.
		int result = sampleService.removeSample(sampleId);
		// result변수가 1이 나온다면 호출 성공, 0이라면 호출이 실패한다.
		System.out.print(result + "Delete Result");
		
		// 결과 값을 가지고 sampleList주소로 redirect한다.
		return "redirect:/sampleList";
	}
	// 5. 수정 폼
	@GetMapping("/modifySample")
	public String modifySample( // 수정 화면으로 넘어가기 위해 필요한 sampleId 값을
								// RequestParam Annotation을 사용해 값을 받아와 int타입의 변수로 선언
								// sampleId 값을 기반으로 하나의 목록을 가져와야 하므로 Model클래스의 model변수도 같이 선언한다.
			@RequestParam(value="sampleId") int sampleId, Model model) {
		// Sample클래스의 객체참조변수 sample에 sampleService클래스의 getSampleOne메서드에 sampleId의 값을 넣고 호출한 뒤 그 주소값을 담는다.
		Sample sample = sampleService.getSampleOne(sampleId);
		// Model인터페이스의 메서드인 addAttribute메서드를 사용해 sample객체를 sample이름으로 추가한다.
		model.addAttribute("sample", sample);
		
		// modifySample주소 값을 리턴한다.
		return "modifySample";
	}
	
	// 6. 수정 액션
	@PostMapping("/modifySample")
	public String modifySample( // 수정을 완료하기 위해 화면에서 sampleName의 값을 받아와 String타입의 변수로 선언
			@RequestParam(value="sampleName") String sampleName) {
		// int타입의 result변수에 sampleService클래스의 modifySample메서드에 sampleName값을 넣고 호출하고 주소 값을 담는다.
		int result = sampleService.modifySample(sampleName);
		// result변수가 1이 나온다면 호출 성공, 0이라는 호출이 실패한다.
		System.out.println(result + "Modify Result");
		
		// 결과 값을 가지고 sampleList주소로 redirect한다.
		return "redirect:/sampleList";
	}
}
