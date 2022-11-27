package usi.si.seart.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;
import usi.si.seart.dto.task.TaskSearchDto;
import usi.si.seart.model.task.Task;
import usi.si.seart.model.task.Task_;

import java.time.LocalDate;

public class TaskSearchDtoToSpecificationConverter implements Converter<TaskSearchDto, Specification<Task>> {

    @Override
    @NonNull
    public Specification<Task> convert(TaskSearchDto source) {
        Specification<Task> specification = Specification.where(null);
        if (source.hasUuid()) {
            Specification<Task> other = withUuidContaining(source.getUuid());
            specification = specification.and(other);
        }
        if (source.hasSubmittedMin()) {
            Specification<Task> other = withSubmittedAfter(source.getSubmittedMin());
            specification = specification.and(other);
        }
        if (source.hasSubmittedMax()) {
            Specification<Task> other = withSubmittedBefore(source.getSubmittedMax());
            specification = specification.and(other);
        }
        return specification;
    }

    private Specification<Task> withUuidContaining(String pattern) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Task_.UUID).as(String.class), "%" + pattern + "%");
    }

    private Specification<Task> withSubmittedAfter(LocalDate date) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(Task_.SUBMITTED).as(LocalDate.class), date);
    }

    private Specification<Task> withSubmittedBefore(LocalDate date) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(Task_.SUBMITTED).as(LocalDate.class), date);
    }
}
