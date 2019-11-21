package com.dawei.demo.hadoop.mapper;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * @author by Dawei on 2019/11/20.
 */
public class MaxTemperatureMapper extends Mapper<LongWritable, Text, Text, IntWritable> {


}
