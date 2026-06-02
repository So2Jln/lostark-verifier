package com.example.demo;

import com.example.demo.domain.Raid;
import com.example.demo.repository.RaidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final RaidRepository raidRepository;

    @Override
    public void run(String ... args) throws Exception{
        raidRepository.save(new Raid("나이트메어 세르카",4500));
        raidRepository.save(new Raid("지평의 성당 3단계", 4000));
        raidRepository.save(new Raid("종막 카제로스 하드",3800));

        System.out.println(("로스트아크 레이드 커트라인 DB 생성"));
    }
}
