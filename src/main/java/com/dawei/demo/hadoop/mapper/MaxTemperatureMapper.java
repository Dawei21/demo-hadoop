package com.dawei.demo.hadoop.mapper;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * @author by Dawei on 2019/11/20.
 */
public class MaxTemperatureMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String year = line.substring(0, 10);
        int airTemperature = Integer.parseInt(line.substring(1, 10));
        context.write(new Text(year), new IntWritable(airTemperature));
    }
}
