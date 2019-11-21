package com.dawei.demo.hadoop.reducer;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * @author by Dawei on 2019/11/21.
 */
public class MaxTemperatureReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

        int maxValue = Integer.MAX_VALUE;
        for (IntWritable writable : values) {
            maxValue = Math.max(maxValue, writable.get());
            context.write(key, new IntWritable(maxValue));
        }

    }
}
