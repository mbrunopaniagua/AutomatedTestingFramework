package com.ing;

import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    public void test() {
        Person p1 = Person.builder().withName("Mario").withSurname("Bruno").build();
        Person p2 = Person.builder().withName("Mario").withSurname("Bruno").withPhoneNumber("111222333").build();
    }

}