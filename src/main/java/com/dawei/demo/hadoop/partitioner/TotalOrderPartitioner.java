package com.dawei.demo.hadoop.partitioner;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @author by Dawei on 2019/12/1.
 */
public class TotalOrderPartitioner extends Partitioner {

    @Override
    public int getPartition(Object o, Object o2, int i) {
        return 0;
    }

    public static String getPartitionFile(Configuration configuration) {
        return "Path";
    }

}
