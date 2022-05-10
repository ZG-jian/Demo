package com.sxt.Collection.List;

import java.util.Objects;

public class Abb implements Comparable<Abb> {
    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abb Abb = (Abb) o;
        return age == Abb.age &&
                name.equals(Abb.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Abb o) {
        return 0;
    }
}
