package org.example;

import java.util.Map;
import java.util.TreeMap;


/**
 * Cache-like data structure that handles storage of Records {long value, String name, double value}.
 * Can search records by any field within O(log(n)) time.
 */
public class Cache {
    private final Map<Long, Record> accountTree = new TreeMap<Long, Record>();
    private final Map<String, Record> nameTree = new TreeMap<String, Record>();
    private final Map<Double, Record> valueTree = new TreeMap<Double, Record>();

    /**
     * @return returns boolean - succesfullness of insertion
     */
    public boolean insertRecord(long account, String name, double value) {
        Record record = new Record(account, name, value);
        accountTree.putIfAbsent(account, record);
        nameTree.putIfAbsent(name, record);
        valueTree.putIfAbsent(value, record);
        return accountTree.containsValue(record);
    }

    /**
     * @return returns boolean - succesfullness of insertion
     */
    public boolean insertRecord(Record record) {
        if (record != null) {
            accountTree.putIfAbsent(record.account, record);
            nameTree.putIfAbsent(record.name, record);
            valueTree.putIfAbsent(record.value, record);
            return true;
        }
        return false;
    }

    /**
     * @return returns boolean - succesfullness of deletion
     */
    public boolean deleteRecord(Record record) {
        if (accountTree.containsValue(record)) {
            accountTree.remove(record.account);
            nameTree.remove(record.name);
            valueTree.remove(record.value);
            return true;
        }
        return false;
    }

    /**
     * @return returns boolean - succesfullness of the update
     */
    public boolean updateRecord(Record oldRecord, Record newRecord) {
        if (oldRecord == null || newRecord == null) return false;
        if (deleteRecord(oldRecord)) {
            insertRecord(newRecord);
            return true;
        }
        return false;
    }

    public Record getRecordFromAccount(long account) {
        return accountTree.get(account);
    }

    public Record getRecordFromName(String name) {
        return nameTree.get(name);
    }

    public Record getRecordFromValue(double value) {
        return valueTree.get(value);
    }

    public int size() {
        return accountTree.size();
    }
}
