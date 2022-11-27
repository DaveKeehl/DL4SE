package usi.si.seart.dto.user;

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
public class UserSearchDto {

    String uid;
    String email;
    String organisation;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate registeredMin;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate registeredMax;

    public boolean hasUid() {
        return uid != null && !uid.isBlank();
    }

    public boolean hasEmail() {
        return email != null && !email.isBlank();
    }

    public boolean hasOrganisation() {
        return organisation != null && !organisation.isBlank();
    }

    public boolean hasRegisteredMin() {
        return registeredMin != null;
    }

    public boolean hasRegisteredMax() {
        return registeredMax != null;
    }
}
