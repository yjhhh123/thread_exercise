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
public class CounterThread {
    private final String name;
    private final long countMaxSize;

    private long count;

    public CounterThread(String name, long countMaxSize) {
        this.name = name;
        this.countMaxSize = countMaxSize;
        this.count = 0;
    }

    public void run() throws InterruptedException {
        do {
            Thread.sleep(1000);
            count++;
            log.debug("count:{}",count);
        }while (count<countMaxSize);
    }
}
