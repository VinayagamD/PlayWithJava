package com.vinaylogics.jdk16.features.records;

public record MyRecord(String name, int id) {
    public MyRecord {
        validateMyFields(id, name);
    }

    private void validateMyFields(int id, String name) {

    }
}
