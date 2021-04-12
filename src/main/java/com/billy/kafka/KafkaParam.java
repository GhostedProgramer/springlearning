package com.billy.kafka;

public class KafkaParam {

    private String key;

    private String value;

    public KafkaParam(String _key, String _value) {
        this.key = _key;
        this.value = _value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
