package com.snail.springboot.upload;

/**
 * @Author: SnailBBB
 * @Description:
 * @Date 2020/9/7 9:06
 */
public class StorageFileNotFoundException extends RuntimeException {
    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
