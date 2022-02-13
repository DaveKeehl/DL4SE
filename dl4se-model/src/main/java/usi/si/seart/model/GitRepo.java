package usi.si.seart.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import usi.si.seart.model.code.File;
import usi.si.seart.model.code.Function;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "git_repo")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GitRepo {

    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false, length = 140)
    String name;

    String license;

    @Column(name = "is_fork", nullable = false)
    Boolean isFork;

    @Column(nullable = false)
    Long commits;

    @Column(nullable = false)
    Long contributors;

    @Column(nullable = false)
    Long issues;

    @Column(nullable = false)
    Long stars;

    @Column(name = "last_update", columnDefinition = "TIMESTAMP", nullable = false)
    LocalDateTime lastUpdate;

    @Column(name = "last_commit_sha", nullable = false, length = 40)
    String lastCommitSHA;

    @Column(name = "is_deleted", nullable = false, columnDefinition = "boolean default false")
    Boolean isDeleted = false;

    @OneToMany(mappedBy = "repo", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @Singular
    List<File> files;

    @OneToMany(mappedBy = "repo", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @Singular
    List<Function> functions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GitRepo gitRepo = (GitRepo) o;
        return id != null && Objects.equals(id, gitRepo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
