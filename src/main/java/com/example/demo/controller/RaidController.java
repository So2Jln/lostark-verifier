package com.example.demo.controller;

import com.example.demo.domain.dto.RaidCheckResult;
import com.example.demo.service.RaidVerifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RaidController {
    private final RaidVerifyService raidVerifyService;

    @GetMapping("/api/check")
    public String checkMyCharacter(@RequestParam("name") String name) {
            // 테스터 유저님이 입력한 닉네임을 콘솔에 찍어봅니다.
            System.out.println("🛸 [미니 서버 요청 수신] 닉네임: " + name);

            // 복잡한 레이드 리스트 대신, 우리가 고정한 웅장한 전투력 5029를
            // 브라우저 화면에 보기 좋게 문자열로 쾅 박아서 뱉어줍니다!
            return "⚔️ [로아 전투력 검증 미니서버 작동 완료 v2] " + name + "님의 전투력은 '5029' 입니다! 레이드 입장 가능!";
}



    /*@GetMapping("/api/check")
    public String verifyRaid(
            @RequestParam String characterName,
            @RequestParam String raidName){
        return raidVerifyService.verifyRaidEntrance(characterName,raidName);
    }*/
}
