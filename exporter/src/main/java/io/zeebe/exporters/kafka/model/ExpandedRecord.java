package io.zeebe.exporters.kafka.model;

import io.camunda.zeebe.protocol.record.Record;
import io.camunda.zeebe.protocol.record.RecordValue;

public interface ExpandedRecord<T extends RecordValue> extends Record<T> {

    String getCustomField();

}
