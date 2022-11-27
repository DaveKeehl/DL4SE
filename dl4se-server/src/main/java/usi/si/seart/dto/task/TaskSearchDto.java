package usi.si.seart.dto.task;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class TaskSearchDto {

    String uuid;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate submittedMin;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate submittedMax;

    public boolean hasUuid() {
        return uuid != null && !uuid.isBlank();
    }

    public boolean hasSubmittedMin() {
        return submittedMin != null;
    }

    public boolean hasSubmittedMax() {
        return submittedMax != null;
    }
}
