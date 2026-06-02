package com.example.demo.service;

import com.example.demo.domain.Raid;
import com.example.demo.domain.dto.RaidCheckResult;
import com.example.demo.repository.RaidRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RaidVerifyService {
    private final RaidRepository raidRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    //private final String apiUrl = "https://developer-lostark.game.onstove.com";

    // 🎯 [주의] Bearer 뒤에 '공백 한 칸' 무조건 유지한 채 유저님의 진짜 API 키를 넣어주세요!
    //private final String apiKey = "Bearer ";

    public int getCharacterPowerFromLostArk(String characterName) {
        /*try {
            HttpHeaders headers = new HttpHeaders();
            String cleanKey = apiKey.replaceAll("\\s+", " ").trim();
            headers.set("Authorization", cleanKey);
            headers.setAccept(List.of(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<>(headers);

            // 주소 두 번 인코딩 억까 방지 안전장치 URI
            URI uri = UriComponentsBuilder.fromHttpUrl(apiUrl)
                    .path("/armories/characters/{characterName}")
                    .build()
                    .expand(characterName)
                    .encode()
                    .toUri();

            ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                String responseBody = response.getBody();

                // 🎯 [소름 돋는 해결사 파트]
                // 데이터 전체에서 "CombatPower":"5,029.14" 부분을 다이렉트로 타격합니다!
                if (responseBody.contains("\"CombatPower\":\"")) {
                    String[] split = responseBody.split("\"CombatPower\":\"");
                    if (split.length > 1) {
                        String powerStr = split[1].split("\"")[0]; // "5,029.14" 획득!

                        // 쉼표(,) 떼고 소수점(.) 앞자리 정수만 완벽하게 추출
                        String cleanPower = powerStr.replace(",", ""); // "5029.14"
                        String integerPart = cleanPower.split("\\.")[0]; // "5029"

                        return Integer.parseInt(integerPart); // 🎯 5029 정수 반환 성공!!!
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("🚨 최종 추출 중 에러: " + e.getMessage());
        }
        return 0;
    }

    public List<RaidCheckResult> checkAllRaids(String characterName) {
        int myPower = getCharacterPowerFromLostArk(characterName);

        List<Raid> allRaids = raidRepository.findAll();
        List<RaidCheckResult> results = new ArrayList<>();

        for (Raid raid : allRaids) {
            boolean canEnter = myPower >= raid.getCutLine();
            String message = canEnter ? "★입장 가능! 당장 출발하세요." : "❌컷 미달! 전투력이 부족합니다.";

            results.add(new RaidCheckResult(
                    raid.getName(),
                    raid.getCutLine(),
                    myPower,
                    canEnter,
                    message
            ));
        }
        return results;
    }*/
        return 5029;
    }
}


    /*
    public String verifyRaidEntrance(String characterName, String raidName){
        int memberCharacterPower = 4500;

        Raid targertRaid = raidRepository.findByName(raidName);

        if (targertRaid==null){
            return "존재하지 않는 레이드입니다.";
        }

        int requiredPowercut = targertRaid.getRequiredPower();
        if(memberCharacterPower>=requiredPowercut){
            return "[" + characterName + "]님은 " + raidName + " 입장이 가능합니다.";
        }
        else{
            return "[" + characterName + "님은 전투력이 부족하여 취업이 안될 확률이 높습니다";
        }*/
