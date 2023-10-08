package com.router.scheduler;

import com.router.service.RouterService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RecordScheduler {

    private final RouterService routerService;

    public RecordScheduler(RouterService routerService) {
        this.routerService = routerService;
    }

    @Scheduled(cron = "*/10 * * * * ?")
    public void routeRecords() {
        System.out.println("Scheduler started.");
        routerService.routeUnprocessedRecords();
        System.out.println("Scheduler finished.");
    }

}
