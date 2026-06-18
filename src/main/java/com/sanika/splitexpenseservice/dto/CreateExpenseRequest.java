package com.sanika.splitexpenseservice.dto;

import java.util.List;

import com.sanika.splitexpenseservice.enums.SplitType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateExpenseRequest {
    private Double amount;
    private String description;
    private Long paidBy;
    private Long groupId;
    private SplitType splitType; 

    private List<Long> participants;

}
