package com.cpbank.AML_API.models;

import lombok.Data;

import java.util.List;
@Data
public class AMLResponse {
    private String RiskLevel;
    private String ActionTaken;
    private List<String> RulesTriggered;
    private String ServiceName;
    private int TotalRulesScore;
    private String TrxnID;
}
