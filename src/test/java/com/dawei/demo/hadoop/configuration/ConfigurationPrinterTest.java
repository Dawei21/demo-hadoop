package com.dawei.demo.hadoop.configuration;

import org.apache.hadoop.util.ToolRunner;
import org.junit.jupiter.api.Test;

/**
 * @author by Dawei on 2019/11/20.
 */
class ConfigurationPrinterTest {

    @Test
    void run() throws Exception {

        int run = ToolRunner.run(new ConfigurationPrinter(), null);

        System.exit(run);
    }
}