package projectmicroservice.projectcrawl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

//    @Scheduled(fixedRate = 1000)
//    public void scheduleTaskWithFixedRate() {
//        try {
//            Thread.sleep(1000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        logger.info("Send email to producers to inform quantity sold items");
//    }

    public void scheduleTaskWithFixedDelay() {
    }

//    @Scheduled(fixedDelay = 2000, initialDelay = 1000)
//    public void scheduleTaskWithInitialDelay() {
//        logger.info("Send email to producers to inform quantity sold items");
//    }

    @Scheduled(cron = "30 20 13 * * 7")
    public void scheduleTaskWithCronExpression() {
        System.out.println("Tôi mốn tôi giỏi hơn");
    }
}
