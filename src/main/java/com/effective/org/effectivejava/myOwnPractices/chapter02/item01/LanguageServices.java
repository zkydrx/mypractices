package com.effective.org.effectivejava.myOwnPractices.chapter02.item01;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-04-02
 * Time: 23:11:06
 * Description:
 */
public class LanguageServices
{
    private LanguageServices()
    {
    }

    ;

    private static final Map<String, LanguageProvider> providers = new ConcurrentHashMap<>();
    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    public static void resigterDefaultProvider(LanguageProvider p)
    {
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }

    public static void registerProvider(String name, LanguageProvider p)
    {
        providers.put(name, p);
    }

    public static LanguageService newInstance()
    {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static LanguageService newInstance(String name)
    {
        LanguageProvider p = providers.get(name);
        if (null == p)
        {
            throw new IllegalArgumentException("No provider registerd");
        }
        return p.study();
    }

}
