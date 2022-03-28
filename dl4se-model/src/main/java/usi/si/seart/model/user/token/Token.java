package usi.si.seart.model.user.token;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import usi.si.seart.model.user.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class Token {

    @Id
    @GeneratedValue
    Long id;

    @NotBlank
    @Size(min = 36, max = 36)
    @Column(unique = true)
    @Builder.Default
    String value = UUID.randomUUID().toString();

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id")
    User user;

    @NotNull
    @Future
    LocalDateTime expires;

    protected abstract LocalDateTime calculateExpiryDate();

    @PrePersist
    private void prePersist() {
        expires = calculateExpiryDate();
    }
}
