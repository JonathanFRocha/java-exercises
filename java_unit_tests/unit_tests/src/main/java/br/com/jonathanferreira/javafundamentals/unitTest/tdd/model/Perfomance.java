package br.com.jonathanferreira.javafundamentals.unitTest.tdd.model;

import java.math.BigDecimal;

public enum Perfomance {
    BAD {
        @Override
        public BigDecimal percentReadjustment() {
            return new BigDecimal("0.03");
        }
    },
    OK {
        @Override
        public BigDecimal percentReadjustment() {
            return new BigDecimal("0.15");
        }
    },
    GREAT {
        @Override
        public BigDecimal percentReadjustment() {
            return new BigDecimal("0.20");
        }
    };

    public abstract BigDecimal percentReadjustment();
}
