package com.finance.tracker.controller;

import com.finance.tracker.dto.DashboardDTO;
import com.finance.tracker.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class DashboardController {

    private final DashboardService dashboardService;

    // Get dashboard data
    @GetMapping("/user/{userId}/month/{month}")
    public ResponseEntity<DashboardDTO> getDashboard(@PathVariable Long userId,
                                                      @PathVariable String month) {
        return ResponseEntity.ok(dashboardService.getDashboard(userId, month));
    }
}