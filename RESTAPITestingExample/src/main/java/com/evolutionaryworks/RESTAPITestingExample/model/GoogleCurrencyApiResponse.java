package com.evolutionaryworks.RESTAPITestingExample.model;

import com.evolutionaryworks.RESTAPITestingExample.api.Currency;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoogleCurrencyApiResponse {
    private String lhs,rhs;
    private int lhsValue;
    private double rhsValue;
    private Currency lhsCurrency;
    private Currency rhsCurrency;
    private String error;
    private boolean icc;

    private static final String valueRegEx = "([0-9]+[.]*[0-9]*)(.+)";
    private static final Pattern pattern = Pattern.compile(valueRegEx);

    public String getLhs() {
        return lhs;
    }

    public GoogleCurrencyApiResponse setLhs(String lhs) {
        this.lhs = lhs;
        Matcher matcher = pattern.matcher(lhs);
        if(matcher.matches()) {
            this.lhsValue = Integer.parseInt(matcher.group(1));
            this.lhsCurrency = currency(matcher.group(2));
        }
        return this;
    }

    private Currency currency(String group) {
        if(group.contains("Indian"))
            return Currency.INR;
        if(group.contains("U.S. dollar"))
            return Currency.USD;
        throw new RuntimeException("Don't know currency for '"+group+"'");
    }

    public String getRhs() {
        return rhs;
    }

    public GoogleCurrencyApiResponse setRhs(String rhs) {
        this.rhs = rhs;
        Matcher matcher = pattern.matcher(rhs);
        if(matcher.matches()) {
            this.rhsValue = Double.parseDouble(matcher.group(1));
            this.rhsCurrency = currency(matcher.group(2));
        }
        return this;
    }

    public int getLhsValue() {
        return lhsValue;
    }

    public GoogleCurrencyApiResponse setLhsValue(int lhsValue) {
        this.lhsValue = lhsValue;
        return this;
    }

    public double getRhsValue() {
        return rhsValue;
    }

    public int getRhsValueAsInt() {
        return (int)rhsValue;
    }

    public GoogleCurrencyApiResponse setRhsValue(double rhsValue) {
        this.rhsValue = rhsValue;
        return this;
    }

    public Currency getLhsCurrency() {
        return lhsCurrency;
    }

    public GoogleCurrencyApiResponse setLhsCurrency(Currency lhsCurrency) {
        this.lhsCurrency = lhsCurrency;
        return this;
    }

    public Currency getRhsCurrency() {
        return rhsCurrency;
    }

    public GoogleCurrencyApiResponse setRhsCurrency(Currency rhsCurrency) {
        this.rhsCurrency = rhsCurrency;
        return this;
    }

    public String getError() {
        return error;
    }

    public GoogleCurrencyApiResponse setError(String error) {
        this.error = error;
        return this;
    }

    public boolean isIcc() {
        return icc;
    }

    public GoogleCurrencyApiResponse setIcc(boolean icc) {
        this.icc = icc;
        return this;
    }
}
