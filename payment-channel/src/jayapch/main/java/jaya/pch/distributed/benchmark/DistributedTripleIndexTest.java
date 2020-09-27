package main.java.jaya.pch.distributed.benchmark;


import main.java.jaya.pch.distributed.index.IPFSPhysicalLayer;
import main.java.jaya.pch.distributed.index.RedisBufferLayer;
import main.java.jaya.pch.distributed.storage.DistributedTripleStore;
import main.java.jaya.pch.distributed.storage.factory.BufferLayerFactory;
import main.java.jaya.pch.distributed.storage.factory.PhysicalLayerFactory;
import main.java.jaya.pch.distributed.storage.factory.ValidationServiceFactory;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by Anh Le-Tuan
 * Email: anh.letuan@tu-berlin.de
 * <p>
 * Date: 28.03.19
 * TODO Description:
 */
public class DistributedTripleIndexTest {

    public static void main(String[] args) {

        BufferLayerFactory bufferLayerFactory = (name) -> {
            //TODO host and port are subjects to be modified
            return new RedisBufferLayer(name, "localhost", 6379);
        };


        PhysicalLayerFactory physicalLayerFactory = () -> {
            //TODO IPAddress is subject to be modified.
            return new IPFSPhysicalLayer("/ip4/127.0.0.1/tcp/5001");
        };


        ValidationServiceFactory validationServiceFactory = () -> {
            //TODO create appropriated valiation service
            return new ValidationServiceTest();
        };


        DistributedTripleStore distributedTripleStore = new DistributedTripleStore(
                bufferLayerFactory, physicalLayerFactory, validationServiceFactory
        );


        //TODO Read all files from storage folder read file by file
        // Record time to commit each file.

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                File inputFile = new File(args[0]);
//                distributedTripleStore.parseFromFile(inputFile);
//
//            }
//        };
//
//        Runnable runnable1 = new Runnable() {
//            @Override
//            public void run() {
//                File inputFile = new File(args[1]);
//                distributedTripleStore.parseFromFile(inputFile);
//            }
//        };


//        new Thread(runnable).run();
//        new Thread(runnable1).run();

        //
        ExecutorService pool = Executors.newFixedThreadPool(8);

        for (String fn : args) {
            File inputFile = new File(fn);
            pool.execute(() -> {
                distributedTripleStore.parseFromFile(inputFile);
            });
        }

    }

}
