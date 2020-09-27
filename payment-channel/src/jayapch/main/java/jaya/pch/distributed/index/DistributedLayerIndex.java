package main.java.jaya.pch.distributed.index;

import main.java.jaya.pch.distributed.connector.ValidationService;
import main.java.jaya.pch.distributed.storage.block.DistributedBlockIndex;


/**
 * Created by Anh Le-Tuan
 * Email: anh.letuan@tu-berlin.de
 * <p>
 * Date: 09.04.19
 */
public class DistributedLayerIndex<R, I extends DistributedBlockIndex> {

    protected DistributedPhysicalLayer<R, I> physicalLayer;
    protected ValidationService<R> validationService;
    protected DistributedBufferLayerSecure<R> bufferLayer;

}
