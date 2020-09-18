package main.java.jaya.pch.distributed.storage.factory;

import main.java.jaya.pch.distributed.index.DistributedPhysicalLayer;
import main.java.jaya.pch.distributed.storage.block.OpenDistributedBlockIndex;


/**
 * Created by Anh Le-Tuan
 * Email: anh.letuan@tu-berlin.de
 * <p>
 * Date: 06.05.19
 */
public interface PhysicalLayerFactory {
    public DistributedPhysicalLayer<long[], OpenDistributedBlockIndex> createPhysicalLayer();
}
