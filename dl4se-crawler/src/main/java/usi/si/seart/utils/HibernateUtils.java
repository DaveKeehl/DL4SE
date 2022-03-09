package usi.si.seart.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import usi.si.seart.CrawlerProperties;
import usi.si.seart.model.GitRepo;
import usi.si.seart.model.Language;
import usi.si.seart.model.code.File;
import usi.si.seart.model.job.CrawlJob;
import usi.si.seart.model.job.Job;

import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@UtilityClass
public class HibernateUtils {

    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public CrawlJob getLastJob() {
        try (Session session = factory.openSession()) {
            Optional<CrawlJob> lastJobOptional = session.createQuery(
                    "SELECT c FROM CrawlJob c WHERE c.jobType = usi.si.seart.model.job.Job.CODE", CrawlJob.class
            ).uniqueResultOptional();

            if (lastJobOptional.isPresent()) {
                return lastJobOptional.get();
            } else {
                CrawlJob startJob = CrawlJob.builder()
                        .checkpoint(CrawlerProperties.startDate.atStartOfDay())
                        .jobType(Job.CODE)
                        .build();
                save(startJob);
                return getLastJob();
            }
        }
    }

    public Set<Language> getLanguages() {
        try (Session session = factory.openSession()) {
            return session.createQuery("SELECT l FROM Language l", Language.class)
                    .stream()
                    .collect(Collectors.toSet());
        }
    }

    public Optional<GitRepo> getRepo(String name) {
        try (Session session = factory.openSession()) {
            Optional<GitRepo> result = session.createQuery("SELECT r FROM GitRepo r WHERE r.name = :name", GitRepo.class)
                    .setParameter("name", name)
                    .uniqueResultOptional();
            return result.map(repo -> {
                Hibernate.initialize(repo.getLanguages());
                return repo;
            });
        }
    }

    public Optional<File> getFile(GitRepo repo, Path path) {
        try (Session session = factory.openSession()) {
            return session.createQuery("SELECT f FROM File f WHERE f.repo = :repo AND f.path = :path", File.class)
                    .setParameter("repo", repo)
                    .setParameter("path", path.toString())
                    .uniqueResultOptional();
        }
    }

    public void save(CrawlJob crawlJob) {
        saveOrUpdate(crawlJob);
    }

    public void save(GitRepo repo) {
        saveOrUpdate(repo);
    }

    public void save(File file) {
        saveOrUpdate(file);
    }

    private void saveOrUpdate(Object obj) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(obj);
            session.flush();
            transaction.commit();
            log.debug("Saved: {}", obj);
        } catch (Exception ex) {
            log.error("Error while persisting: {}", obj);
            log.error("Error stack trace:", ex);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public void delete(GitRepo repo) {
        deleteCascade(repo);
    }

    public void delete(File file) {
        deleteCascade(file);
    }

    private void deleteCascade(Object obj) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(obj);
            session.flush();
            transaction.commit();
            log.debug("Deleted: {}", obj);
        }
    }
}
