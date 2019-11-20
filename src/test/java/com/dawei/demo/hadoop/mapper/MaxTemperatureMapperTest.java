package com.dawei.demo.hadoop.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import org.junit.jupiter.api.Test;


/**
 * @author by Dawei on 2019/11/20.
 */
class MaxTemperatureMapperTest {

    @Test
    void processesValidRecord() {

        Text value = new Text("004301199099999195005158004+68750");
        new MapDriver<LongWritable, Text, Text, IntWritable>()
    }
}