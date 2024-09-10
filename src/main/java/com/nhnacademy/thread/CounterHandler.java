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

package com.nhnacademy.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CounterHandler implements Runnable  {
    private final long countMaxSize;

    private long count;

    public CounterHandler(long countMaxSize) {
        if(countMaxSize<=0){
            throw new IllegalArgumentException();
        }

        this.countMaxSize = countMaxSize;
        this.count=0l;
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(1000);
                count++;
                log.debug("thread:{},state:{},count:{}",Thread.currentThread().getName(),Thread.currentThread().getState(),count);
            } catch (InterruptedException e) {
                log.debug("{} - state - {}  - interupted 발생",Thread.currentThread().getName(),Thread.currentThread().getState());
                throw new RuntimeException(e);
            }

        //TODO#2 해당 thread가 isInterrupted() 상태가 false 일 while loop를 실행 할 수 있도록 조건을 추가하세요

        }while(!Thread.currentThread().isInterrupted() && count < countMaxSize);

    }
}
