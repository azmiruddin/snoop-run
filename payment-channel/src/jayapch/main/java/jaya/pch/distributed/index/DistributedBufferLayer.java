package main.java.jaya.pch.distributed.index;


import main.java.jaya.pch.distributed.storage.block.DistributedBlockEntry;


/**
 * Created by Anh Le-Tuan
 * Email: anh.letuan@tu-berlin.de
 * <p>
 * Date: 27.03.19
 * TODO Description:
 */
public interface DistributedBufferLayer<R> { //extends BufferLayer<R>

    public DistributedBlockEntry<R, ?>[] remoteRequest(R keyRecord);

    public void updateRemote(DistributedBlockEntry<R, ?>[] blockEntries);

    public void updateRemote(DistributedBlockEntry<R, ?> blockEntry);
}
