package com.effective.org.effectivejava.myOwnPractices.chapter04.item17;

public class Super
{
    // Broken - constructor invokes an overridable method
    public Super()
    {
        overrideMe();
    }

    public void overrideMe()
    {
    }
}
