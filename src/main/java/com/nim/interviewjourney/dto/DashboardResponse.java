package com.nim.interviewjourney.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DashboardResponse {

    private long totalApplications;
    private long applied;
    private long rejected;
    private long offerReceived;
}

        

