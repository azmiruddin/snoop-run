package main.java.jaya.pch.distributed.index;

import main.java.jaya.pch.distributed.storage.block.DistributedBlockEntry;
import main.java.jaya.pch.distributed.storage.block.DistributedBlockIndex;
import main.java.jaya.pch.distributed.storage.block.PrivateDistributedBlockIndex;


/**
 * Created by Anh Le-Tuan
 * Email: anh.letuan@tu-berlin.de
 * <p>
 * Date: 09.04.19
 */
public abstract class DistributedBufferLayerSecure<R> implements  DistributedBufferLayer<R>{


    @Override
    public abstract DistributedBlockEntry<R, ?>[] remoteRequest(R keyRecord);



    @Override
    public void updateRemote(DistributedBlockEntry<R, ?>[] blockEntries) {
        for (DistributedBlockEntry blockEntry:blockEntries){
            updateRemote(blockEntry);
        }
    }

    @Override
    public void updateRemote(DistributedBlockEntry<R, ?> blockEntry) {
        DistributedBlockIndex blockIndex = blockEntry.getBlockIndex();

        if (!(blockIndex instanceof PrivateDistributedBlockIndex)){
            throw new IllegalArgumentException("Block Index must be private");
        }

        updateSecure(blockEntry);
    }


    protected abstract boolean updateSecure(DistributedBlockEntry<R, ?> prBlockEntry);
}
