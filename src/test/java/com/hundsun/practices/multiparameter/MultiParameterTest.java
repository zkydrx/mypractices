package com.hundsun.practices.multiparameter;

import lombok.extern.log4j.Log4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@Log4j
public class MultiParameterTest
{

    @Before
    public void setUp() throws Exception
    {
        log.info("start");
    }

    @After
    public void tearDown() throws Exception
    {
        log.info("end");
    }

    @Test
    public void multi()
    {
        MultiParameter.multi("1","2","china","red","no","ok");
    }
}