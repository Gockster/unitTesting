package com.example.demo.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    StudentRepository underTest;

    @Test
    void itShouldCheckIfStudentExistsEmail() {
        //given
        String email = "jam@gmail.com";
        Student student = new Student(
                "jamila", email, Gender.FEMALE);

        underTest.save(student);
        //when
        boolean expected = underTest.selectExistsEmail(email);

        //then
        assertThat(expected).isTrue();

    }
}