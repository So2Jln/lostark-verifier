package com.example.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class RaidCheckResult {
    private String raidName;
    private int cutPower;
    private int characterPower;
    private boolean canEnter;
    private String message;
}
