package usi.si.seart.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;
import usi.si.seart.dto.user.UserSearchDto;
import usi.si.seart.model.user.User;
import usi.si.seart.model.user.User_;

import java.time.LocalDate;

public class UserSearchDtoToSpecificationConverter implements Converter<UserSearchDto, Specification<User>> {
    
    @Override
    @NonNull
    public Specification<User> convert(UserSearchDto source) {
        Specification<User> specification = Specification.where(null);
        if (source.hasUid()) {
            Specification<User> other = withUidContaining(source.getUid());
            specification = specification.and(other);
        }
        if (source.hasEmail()) {
            Specification<User> other = withEmailContaining(source.getEmail());
            specification = specification.and(other);
        }
        if (source.hasOrganisation()) {
            Specification<User> other = withOrganisationContaining(source.getOrganisation());
            specification = specification.and(other);
        }
        if (source.hasRegisteredMin()){
            Specification<User> other = withRegisteredAfter(source.getRegisteredMin());
            specification = specification.and(other);
        }
        if (source.hasRegisteredMax()){
            Specification<User> other = withRegisteredBefore(source.getRegisteredMax());
            specification = specification.and(other);
        }
        return specification;
    }

    private Specification<User> withUidContaining(String pattern) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(User_.UID), "%" + pattern + "%");
    }

    private Specification<User> withEmailContaining(String pattern) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(User_.EMAIL), "%" + pattern + "%");
    }

    private Specification<User> withOrganisationContaining(String pattern) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(User_.ORGANISATION), "%" + pattern + "%");
    }

    private Specification<User> withRegisteredAfter(LocalDate date) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(User_.REGISTERED).as(LocalDate.class), date);
    }

    private Specification<User> withRegisteredBefore(LocalDate date) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(User_.REGISTERED).as(LocalDate.class), date);
    }
}
