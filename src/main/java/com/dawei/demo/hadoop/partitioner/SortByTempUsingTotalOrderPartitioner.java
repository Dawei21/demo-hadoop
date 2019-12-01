package com.dawei.demo.hadoop.partitioner;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile.CompressionType;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;
import org.apache.hadoop.mapreduce.lib.partition.InputSampler;
import org.apache.hadoop.mapreduce.lib.partition.InputSampler.RandomSampler;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * 对所有数据排序分区
 * @author by Dawei on 2019/12/1.
 */
public class SortByTempUsingTotalOrderPartitioner extends Configured implements Tool{


    @Override
    public int run(String[] strings) throws Exception {
        Job job = new Job();


        job.setInputFormatClass(SequenceFileInputFormat.class);
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputFormatClass(SequenceFileOutputFormat.class);

        SequenceFileOutputFormat.setCompressOutput(job, true);
        SequenceFileOutputFormat.setOutputCompressorClass(job, GzipCodec.class);
        SequenceFileOutputFormat.setOutputCompressionType(job, CompressionType.BLOCK);

        job.setPartitionerClass(TotalOrderPartitioner.class);

        //样本比例  最大样本数 最大分区数
        InputSampler.Sampler<IntWritable, Text> sampler = new RandomSampler<>(0.1, 10000, 10);

        InputSampler.writePartitionFile(job, sampler);

//        //Add to DistributedCache
//        Configuration configuration = job.getConfiguration();
//        String partitionFile = TotalOrderPartitioner.getPartitionFile(configuration);
//
//        URI partitionFileUri = new URI(partitionFile);
//        DistributedCache.addFileToClassPath(new Path(partitionFileUri), configuration, null);
//        job.addCacheFile(partitionFileUri);

        return job.waitForCompletion(true) ? 0 : 1;
    }


    public static void main(String[] args) throws Exception {
        int exitCode = ToolRunner.run(new SortByTempUsingTotalOrderPartitioner(), args);
        System.exit(exitCode);
    }

}
