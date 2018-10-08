package com.design.mode.bridge;

/**
 * The ConcreteImplementor
 */
public class TextImpLinux implements TextImp
{
    public TextImpLinux()
    {
    }

    @Override
    public void DrawTextImp()
    {
        System.out.println("The text has a Linux style !");
    }
}