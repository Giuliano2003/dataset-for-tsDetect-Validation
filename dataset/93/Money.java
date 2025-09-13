package com.example.evosuite.advanced;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Objects;

/** Valore monetario immutabile con valuta ISO e conversioni via MoneyExchange. */
public final class Money {
    private final BigDecimal amount;
    private final String currency;

    public Money(BigDecimal amount, String currency) {
        this.amount = amount.setScale(9, RoundingMode.HALF_UP); // precisione interna
        this.currency = Objects.requireNonNull(currency);
        if (amount == null) throw new NullPointerException("amount");
        if (!currency.matches("^[A-Z]{3}$")) throw new IllegalArgumentException("ISO 4217");
    }

    public static Money of(String currency, double value) {
        return new Money(BigDecimal.valueOf(value), currency);
    }

    public BigDecimal amount() { return amount; }
    public String currency() { return currency; }

    public Money add(Money other) {
        ensureSame(other);
        return new Money(this.amount.add(other.amount), currency);
    }

    public Money subtract(Money other) {
        ensureSame(other);
        return new Money(this.amount.subtract(other.amount), currency);
    }

    private void ensureSame(Money other) {
        if (!this.currency.equals(other.currency))
            throw new IllegalArgumentException("currency mismatch");
    }

    public Money convertTo(String target, MoneyExchange ex) {
        if (this.currency.equals(target)) return this;
        BigDecimal rate = ex.rate(this.currency, target);
        BigDecimal converted = this.amount.multiply(rate);
        int scale = ex.scaleFor(target);
        return new Money(converted.setScale(scale, RoundingMode.HALF_UP), target);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money m = (Money) o;
        return currency.equals(m.currency) && amount.compareTo(m.amount) == 0;
    }
    @Override public int hashCode() { return Objects.hash(currency, amount.stripTrailingZeros()); }
    @Override public String toString() { return currency + " " + amount.stripTrailingZeros().toPlainString(); }

    /** Cambio semplice con mappa di tassi diretti e scale per valuta. */
    public static class MoneyExchange {
        private final Map<String, Map<String, BigDecimal>> rates;
        private final Map<String, Integer> scales;

        public MoneyExchange(Map<String, Map<String, BigDecimal>> rates, Map<String, Integer> scales) {
            this.rates = rates; this.scales = scales;
        }

        public BigDecimal rate(String from, String to) {
            if (from.equals(to)) return BigDecimal.ONE;
            Map<String, BigDecimal> m = rates.get(from);
            if (m == null || !m.containsKey(to)) throw new IllegalArgumentException("no rate");
            return m.get(to);
        }

        public int scaleFor(String currency) {
            return scales.getOrDefault(currency, 2);
        }
    }
}
