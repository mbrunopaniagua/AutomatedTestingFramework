package com.ing;

public final class Person {
    private final String name;
    private final String surname;
    private final String phoneNumber;

    private Person(String name, String surname, String phoneNumber) {
        if (name == null) throw new IllegalArgumentException();
        if (surname == null) throw new IllegalArgumentException();
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    private Person(String name, String surname) {
        this(name, surname, null);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static AddName builder() {
        return name -> surname -> {
            return new AddPhoneNumber() {
                @Override
                public Builder withPhoneNumber(String phoneNumber) {
                    return new Builder() {
                        @Override
                        public Person build() {
                            return new Person(name, surname, phoneNumber);
                        }
                    };
                }

                @Override
                public Person build() {
                    return new Person(name, surname);
                }
            };
        };
        /*return new AddName() {
            @Override
            public AddSurname withName(String name) {
                return new AddSurname() {
                    @Override
                    public AddPhoneNumber withSurname(String surname) {
                        return new AddPhoneNumber() {
                            @Override
                            public Builder withPhoneNumber(String phoneNumber) {
                                return new Builder() {
                                    @Override
                                    public Person build() {
                                        return new Person(name, surname, phoneNumber);
                                    }
                                };
                            }

                            @Override
                            public Person build() {
                                return new Person(name, surname);
                            }
                        };
                    }
                };
            }
        };*/
    }

    @FunctionalInterface
    public interface AddName {
        AddSurname withName(String name);
    }

    @FunctionalInterface
    public interface AddSurname {
        AddPhoneNumber withSurname(String surname);
    }

    public interface AddPhoneNumber {
        Builder withPhoneNumber(String phoneNumber);
        Person build();
    }

    @FunctionalInterface
    public interface Builder {
        Person build();
    }
}
