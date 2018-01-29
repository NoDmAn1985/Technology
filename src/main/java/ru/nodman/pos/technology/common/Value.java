package ru.nodman.pos.technology.common;

class Value {
    private String unit;
    private int value;
    private int decimalPlaces;

    Value(String unit, int value, int decimalPlaces) {
        this.unit = unit;
        this.value = value;
        this.decimalPlaces = decimalPlaces;
    }

    Value(String unit, int value) {
        this(unit, value, 0);
    }
}
