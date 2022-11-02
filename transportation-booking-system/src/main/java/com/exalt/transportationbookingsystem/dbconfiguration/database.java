package com.exalt.transportationbookingsystem.dbconfiguration;

import com.aerospike.client.AerospikeClient;
import com.aerospike.mapper.tools.AeroMapper;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// Singleton design pattern for database
public class database {

    public static AeroMapper mapper;
    //private constructor provides the actual connection to database server
    private database(){
        try (InputStream input = new FileInputStream("D:/Exalt/Training/Sample Project/transportation-booking-system/src/main/resources/config.properties")){
            Properties prop = new Properties();
            prop.load(input);

            AerospikeClient client = new AerospikeClient(prop.getProperty("aerospike.host"),
                Integer.parseInt(prop.getProperty("aerospike.port")));
            //java object mapping
            mapper = new AeroMapper.Builder(client).build();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //inner class that provides thread safe
    //Bill Pugh approach
    private static class databaseHolder {
        private static final database instanceHolder = new database();
    }

    // The method that controls access to the singleton instance
    public static database getInstance(){
        return databaseHolder.instanceHolder;
    }

}
