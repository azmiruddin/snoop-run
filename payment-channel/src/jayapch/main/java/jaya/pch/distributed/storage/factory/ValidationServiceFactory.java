package main.java.jaya.pch.distributed.storage.factory;

import main.java.jaya.pch.distributed.connector.ValidationService;


/**
 * Created by Anh Le-Tuan
 * Email: anh.letuan@tu-berlin.de
 * <p>
 * Date: 06.05.19
 */
public interface ValidationServiceFactory {
    public ValidationService<long[]> createValidationService();
}
