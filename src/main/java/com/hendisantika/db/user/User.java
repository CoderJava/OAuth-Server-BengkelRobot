package com.hendisantika.db.user;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pengguna")
public class User {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "user_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_value", value = "1")
            }
    )
    private long id;

    @Column
    private String username;

    @Column
    /*@JsonIgnore*/
    private String password;

    @Column
    private int age;

}
