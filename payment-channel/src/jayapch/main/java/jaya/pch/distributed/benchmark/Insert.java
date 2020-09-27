package main.java.jaya.pch.distributed.benchmark;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import main.java.jaya.pch.distributed.connector.BlockEntryValidationService;
import main.java.jaya.pch.distributed.index.DistributedBufferLayerSecure;
import main.java.jaya.pch.distributed.index.DistributedPhysicalLayer;
import main.java.jaya.pch.distributed.index.IPFSPhysicalLayer;
import main.java.jaya.pch.distributed.index.RedisBufferLayer;
import main.java.jaya.pch.distributed.storage.DistributedTripleIndex;
import main.java.jaya.pch.distributed.storage.block.OpenDistributedBlockIndex;

/**
 * Created by Anh Le-Tuan
 * Email: anh.letuan@tu-berlin.de
 * <p>
 * Date: 10.04.19
 */
public class Insert {

    public static void main(String[] args) {
        buildIndexTest();
    }

    public static void buildIndexTest() {
//        String IPFSAdress = "/ip4/127.0.0.1/tcp/5001";
        String index = "spo";

        String ethereum = System.getenv("ETHHOST");
        String contractAddress = System.getenv("CONTRACT");
        String fundersAddress = System.getenv("FUNDER");

        String redishost = System.getenv("REDIS_HOST");
        int redisport = Integer.valueOf(System.getenv("REDIS_PORT"));

        String IPFSAdress = System.getenv("IPFS");

        Web3j web3j = Web3j.build(new HttpService(ethereum));

        BlockEntryValidationService blockEntryValidationService = new BlockEntryValidationService(web3j, contractAddress,fundersAddress);

        DistributedBufferLayerSecure<long[]> bufferLayer = new RedisBufferLayer("spo", redishost, redisport);
        DistributedPhysicalLayer<long[], OpenDistributedBlockIndex> physicalLayer = new IPFSPhysicalLayer(IPFSAdress);
        DistributedTripleIndex distributedTripleIndex = new DistributedTripleIndex("spo",
                bufferLayer,
                physicalLayer,
                blockEntryValidationService);


        for (long i = 0; i < 10; i++) {
            for (long j = 0; j < 10; j++) {
                for (long k = 0; k < 100; k++) {
                    distributedTripleIndex.add(i, j, k);
                }
            }
        }

        distributedTripleIndex.commit();

    }

}
