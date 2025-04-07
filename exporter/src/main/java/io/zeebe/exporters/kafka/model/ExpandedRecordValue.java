package io.zeebe.exporters.kafka.model;

import com.google.gson.JsonParser;
import io.camunda.zeebe.protocol.record.Record;
import io.camunda.zeebe.protocol.record.RecordType;
import io.camunda.zeebe.protocol.record.RecordValue;
import io.camunda.zeebe.protocol.record.RejectionType;
import io.camunda.zeebe.protocol.record.ValueType;
import io.camunda.zeebe.protocol.record.intent.Intent;

public class ExpandedRecordValue<T extends RecordValue> implements ExpandedRecord<T> {

    Record<T> baseRecord;
    String customField;

    public ExpandedRecordValue(Record<T> baseRecord, String customField) {
        this.baseRecord = baseRecord;
        this.customField = customField;
    }

    @Override
    public String getCustomField() {
        return customField == null ? null : customField;
    }

    @Override
    public long getPosition() {
        return baseRecord.getPosition();
    }

    @Override
    public long getSourceRecordPosition() {
        return baseRecord.getSourceRecordPosition();
    }

    @Override
    public long getKey() {
        return baseRecord.getKey();
    }

    @Override
    public long getTimestamp() {
        return baseRecord.getTimestamp();
    }

    @Override
    public Intent getIntent() {
        return baseRecord.getIntent();
    }

    @Override
    public int getPartitionId() {
        return baseRecord.getPartitionId();
    }

    @Override
    public RecordType getRecordType() {
        return baseRecord.getRecordType();
    }

    @Override
    public RejectionType getRejectionType() {
        return baseRecord.getRejectionType();
    }

    @Override
    public String getRejectionReason() {
        return baseRecord.getRejectionReason();
    }

    @Override
    public String getBrokerVersion() {
        return baseRecord.getBrokerVersion();
    }

    @Override
    public ValueType getValueType() {
        return baseRecord.getValueType();
    }

    @Override
    public T getValue() {
        return baseRecord.getValue();
    }

    @Override
    public Record<T> clone() {
        return baseRecord.clone();
    }

    @Override
    public String toJson() {
//        return convertJsonSerializableObjectToJson(this);
//        return baseRecord.toJson();
        var jsonObject = JsonParser.parseString(baseRecord.toJson()).getAsJsonObject();
        jsonObject.addProperty("elementName", customField);
        return jsonObject.toString();
    }

//    public static String convertJsonSerializableObjectToJson(final JsonSerializable recordValue) {
//        try {
//            return JSON_OBJECT_MAPPER.writeValueAsString(recordValue);
//        } catch (JsonProcessingException var2) {
//            JsonProcessingException e = var2;
//            throw new RuntimeException(e);
//        }
//    }
}