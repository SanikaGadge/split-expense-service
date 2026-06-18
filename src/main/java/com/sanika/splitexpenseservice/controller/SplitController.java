package com.sanika.splitexpenseservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanika.splitexpenseservice.entity.Split;
import com.sanika.splitexpenseservice.repository.SplitRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/splits")
@RequiredArgsConstructor
public class SplitController {

    private final SplitRepository splitRepository;

    @GetMapping
    public List<Split> getAllSplits() {
        return splitRepository.findAll();
    }
}
