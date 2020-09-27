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
public class Search {

    public static void main(String[] args) {
        buildIndexTest();
    }

    public static void buildIndexTest() {
//        String IPFSAdress = "/ip4/127.0.0.1/tcp/5001";
        String index = "spo";

//        String ethereum = "http://0.0.0.0:8500";
//        String contractAddress = "0x235596ab6d7CE35D4Ee6A4d0bbAdc463400605F8";
//        String fundersAddress = "0xb28c1c55bc91fba0e0878ed47c6331c9763aafe8";

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

        distributedTripleIndex.search(new long[]{0, 0, 0});
    }

}
