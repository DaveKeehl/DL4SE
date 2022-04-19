package usi.si.seart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import usi.si.seart.model.task.Status;
import usi.si.seart.model.task.Task;
import usi.si.seart.model.user.User;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t WHERE t.user = :user " +
            "AND t.status IN (usi.si.seart.model.task.Status.QUEUED, usi.si.seart.model.task.Status.EXECUTING)")
    Set<Task> findActiveByUser(@Param("user") User user);

    @Query("SELECT COUNT(t) FROM Task t WHERE t.user = :user " +
            "AND t.status IN (usi.si.seart.model.task.Status.QUEUED, usi.si.seart.model.task.Status.EXECUTING)")
    Long countActiveByUser(@Param("user") User user);

    Optional<Task> findFirstByStatusOrderBySubmitted(Status status);

    default Optional<Task> findFirstExecuting() {
        return findFirstByStatusOrderBySubmitted(Status.EXECUTING);
    }

    default Optional<Task> findFirstQueued() {
        return findFirstByStatusOrderBySubmitted(Status.QUEUED);
    }

    Optional<Task> findByUuid(@NotNull UUID uuid);

    List<Task> findByFinishedBetween(LocalDateTime lower, LocalDateTime upper);

    default List<Task> findExpiredInactiveTasks() {
        LocalDateTime currentHour = LocalDateTime.now(ZoneOffset.UTC).truncatedTo(ChronoUnit.HOURS);
        LocalDateTime oneWeekAgoUpper = currentHour.minusWeeks(1);
        LocalDateTime oneWeekAgoLower = oneWeekAgoUpper.minusHours(1);
        return findByFinishedBetween(oneWeekAgoLower, oneWeekAgoUpper);
    }
}
