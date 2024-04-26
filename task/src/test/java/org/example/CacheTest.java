package org.example;

import junit.framework.TestCase;

public class CacheTest extends TestCase {
    Cache cache;

    public void testInsertRecord() {
        cache.insertRecord(1,"test", 1.0);
        assertEquals(1, cache.size());
    }

    public void testInsertRecordObject() {
        Record record = new Record(1, "test", 1.0);
        cache.insertRecord(record);
        assertEquals(1, cache.size());
    }

    public void testDeleteRecord() {
        Record record = new Record(1, "test", 1.0);
        cache.insertRecord(record);
        assertEquals(1, cache.size());
        cache.deleteRecord(record);
        assertEquals(0, cache.size());
    }

    public void testGetRecordFromAccount() {
        Record record = new Record(1, "test", 1.0);
        cache.insertRecord(record);
        assertEquals(record, cache.getRecordFromAccount(record.account));
    }

    public void testGerRecordFromName() {
        Record record = new Record(1, "test", 1.0);
        cache.insertRecord(record);
        assertEquals(record, cache.getRecordFromName(record.name));
    }

    public void testGetRecordFromValue() {
        Record record = new Record(1, "test", 1.0);
        cache.insertRecord(record);
        assertEquals(record, cache.getRecordFromValue(record.value));
    }

    public void testUpdateRecord() {
        Record recordOld = new Record(1, "test", 1.0);
        Record recordNew = new Record(2, "test2", 2.0);
        cache.insertRecord(recordOld);
        assertEquals(cache.getRecordFromAccount(recordOld.account), recordOld);
        cache.updateRecord(recordOld, recordNew);
        assertEquals(cache.getRecordFromAccount(recordNew.account), recordNew);
    }

    public void setUp() throws Exception {
        super.setUp();
        cache = new Cache();
    }
}