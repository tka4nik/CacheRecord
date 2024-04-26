package org.example;

import java.util.Objects;

public class Record {
    public long account;
    public String name;
    public double value;

    public Record(long account, String name, double value) {
        this.account = account;
        this.name = name;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return account == record.account && Double.compare(value, record.value) == 0 && Objects.equals(name, record.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, name, value);
    }

    @Override
    public String toString() {
        return "Record{" +
                "account=" + account +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
