package org.example;


public class App 
{
    public static void main( String[] args ) {
        Cache cache = new Cache();
        cache.insertRecord(12, "nikita", 123.0);
        cache.insertRecord(56, "varya", 11223.0);
        cache.insertRecord(23, "roma", 11234.0);
        cache.insertRecord(new Record(1523, "Kill", 123.5234));

        System.out.println(cache.getRecordFromName("varya"));
        System.out.println(cache.getRecordFromValue(11234.0));
        System.out.println(cache.getRecordFromAccount(1523));

        System.out.println(cache.deleteRecord(cache.getRecordFromAccount(12)));
        System.out.println(cache.getRecordFromAccount(12));
    }
}
