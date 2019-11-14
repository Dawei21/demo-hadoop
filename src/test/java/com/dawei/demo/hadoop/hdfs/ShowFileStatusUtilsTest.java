package com.dawei.demo.hadoop.hdfs;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

/**
 * @author by Dawei on 2019/11/14.
 */
class ShowFileStatusUtilsTest {



    private FileSystem fileSystem;


    @Test(expected = FileNotFoundException.class)
    private void fileNotFoundForNonExistentFile() throws IOException {
        fileSystem.getFileStatus(new Path("no-in-path"));
        FSDataOutputStream outputStream = fileSystem.create(new Path("/a"));
        outputStream.flush();
        long pos = outputStream.getPos();
        outputStream.sync();
        outputStream.close();
    }

}