/*
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * + Copyright 2024. NHN Academy Corp. All rights reserved.
 * + * While every precaution has been taken in the preparation of this resource,  assumes no
 * + responsibility for errors or omissions, or for damages resulting from the use of the information
 * + contained herein
 * + No part of this resource may be reproduced, stored in a retrieval system, or transmitted, in any
 * + form or by any means, electronic, mechanical, photocopying, recording, or otherwise, without the
 * + prior written permission.
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */

package com.nhnacademy;

import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 *
 */

@Slf4j
public class App 
{

    public static void main( String[] args )
    {
        ShardCounter shardCounter = new ShardCounter(1000l);

        Runnable increase = ()->{
            while(!Thread.currentThread().isInterrupted()) {
                long count = shardCounter.increaseAndGet();
                log.debug("thread:{}, count:{}", Thread.currentThread().getName(), count);
            }
        };

        Thread threadA = new Thread(()->{

        });
        threadA.setName("thread-A");
        threadA.start();

        Thread threadB = new Thread();
        threadB.setName("thread-B");
        threadB.start();

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
