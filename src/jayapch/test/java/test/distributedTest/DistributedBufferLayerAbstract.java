package test.java.test.distributedTest;

import dev.insight.rdf4led.storage.BufferLayerAbstract;
import main.java.jaya.pch.distributed.index.DistributedBufferLayer;


/**
 * Created by Anh Le-Tuan
 * Email: anh.letuan@tu-berlin.de
 * <p>
 * Date: 27.03.19
 * TODO Description:
 */
public abstract class DistributedBufferLayerAbstract<R> extends BufferLayerAbstract<R> implements DistributedBufferLayer<R> {
//
//    protected BufferLayerService<R> bufferLayerService;
//    protected ValidationService validationService;
//
//    protected DistributedBufferLayerAbstract(BufferLayerService<R> bufferLayerService,
//                                             ValidationService validationService)
//    {
//        this.bufferLayerService = bufferLayerService;
//        this.validationService = validationService;
//    }
//
//
//
//    @Override
//    protected void sync() {
//    }
//
//
//
//    @Override
//    protected abstract Comparator<BlockEntry<R, ?>> getComparator();
//
//
//
//    @Override
//    public abstract boolean init();
//
//
//    @Override
//    public DistributedBlockEntry<R, ?>[] remoteRequest(R keyRecord){
//        return bufferLayerService.remoteRequest(keyRecord);
//    }
//
//
//
//    @Override
//    public DistributedBlockEntry<R, OpenDistributedBlockIndex>[] validateBlockEntries(DistributedBlockEntry<R, PrivateDistributedBlockIndex>[] blockEntries){
//        return (DistributedBlockEntry<R, OpenDistributedBlockIndex>[]) this.validationService.validate(blockEntries);
//    }
//
//
//
//    @Override
//    public DistributedBlockEntry<R, OpenDistributedBlockIndex> validateBlockEntry(DistributedBlockEntry<R, PrivateDistributedBlockIndex> blockEntry){
//        return (DistributedBlockEntry<R, OpenDistributedBlockIndex>) this.validationService.validate(blockEntry);
//    };
//
//
//
//    //TODO should return request handler
//    @Override
//    public void updateRemote(DistributedBlockEntry<R, ?> blockEntry) {
//        //
//
//        bufferLayerService.update(blockEntry);
//    }
//
//
//    //TODO should return request handler
//    @Override
//    public void updateRemote(DistributedBlockEntry<R, ?>[] blockEntries) {
//          bufferLayerService.update(blockEntries);
//    }

}
