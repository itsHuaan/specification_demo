package org.example.specification_demo.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
}
