package com.dawei.demo.hadoop.driver;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * @author by Dawei on 2019/11/22.
 */
class MaxTemperatureDriverTest {

    @Test
    void run() throws Exception {

        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "file:///");
        configuration.set("mapreduce.framework.name", "local");
        configuration.setInt("mapreduce.task.io.sort.mb", 1);

        Path input = new Path("input/ncdc/micro");
        Path output = new Path("output");

        FileSystem fileSystem = FileSystem.getLocal(configuration);
        fileSystem.delete(output, true);

        MaxTemperatureDriver maxTemperatureDriver = new MaxTemperatureDriver();
        maxTemperatureDriver.setConf(configuration);

        int exitCode = maxTemperatureDriver.run(new String[]{
            input.toString(), output.toString()
        });

        Assert.assertEquals(exitCode, 0);




    }
}