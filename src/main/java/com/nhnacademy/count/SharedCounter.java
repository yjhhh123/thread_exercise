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

package com.nhnacademy.count;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SharedCounter {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    private long count;

    public SharedCounter(){
        this(0l);
    }

    public SharedCounter(long count) {
        //TODO#1-1 생성자를 초기화 합니다. count < 0 IllegalArgumentException아 발생 합니다.
        if(count <0){
            throw new IllegalArgumentException("count > 0 ");
        }
        this.count = count;
    }

    //TODO#1-2 mehtod 단위 lock을 걸고, count 를 반환 합니다.
    public synchronized long getCount(){
        return count;
    }

    public long increaseAndGet(){
        //TODO#1-3 block 단위로 lock을 걸고 count = count + 1 증가시키고 count를 반환 합니다.
        synchronized (lock1) {
            count = count + 1;
            synchronized (lock2){
                log.debug("hold and wait;");
            }
            return count;
        }
    }

    public long decreaseAndGet(){
        //TODO#1-4 count = count -1  부분 lock을 걸고, count를 반환 합니다.
        synchronized (lock2) {
            count = count - 1;
            synchronized (lock1){
                log.debug("hold and wait");
            }
            return count;
        }
    }

}
