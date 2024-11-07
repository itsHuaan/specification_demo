package org.example.specification_demo.utils;

import org.example.specification_demo.entities.UserEntity;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {
    public static Specification<UserEntity> firstName(String firstName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("firstName"), firstName);
    }

    public static Specification<UserEntity> emailEndsWithGmail() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("email"), "%@gmail.com");
    }
}
