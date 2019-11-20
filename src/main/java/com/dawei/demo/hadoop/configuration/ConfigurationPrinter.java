package com.dawei.demo.hadoop.configuration;

import java.util.Map.Entry;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.Tool;

/**
 * @author by Dawei on 2019/11/20.
 */
public class ConfigurationPrinter extends Configured implements Tool {


    static {
        Configuration.addDefaultResource("hdfs-default.xml");
    }



    @Override
    public int run(String[] strings) throws Exception {
        Configuration configuration = getConf();
        for (Entry<String, String> configEntry : configuration) {
            System.out.println("key=" + configEntry.getKey() + ", value=" + configEntry.getValue());
        }


        return 0;
    }
}
