package com.effective.org.effectivejava.myOwnPractices.chapter02.item01;

import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-04-02
 * Time: 23:24:31
 * Description:
 */
class LanguageServiceTest
{
    private static LanguageProvider DEFAULT_PROVIDER = new LanguageProvider()
    {
        @Override
        public LanguageService study()
        {
            return new LanguageService()
            {
                @Override
                public void chineseService()
                {
                    System.out.println("chinese is a good language.");
                }
                @Autowired
                public String toString()
                {
                    return "Default service";
                }
            };
        }
    };



    private static LanguageProvider COMP_PROVIDER = new LanguageProvider()
    {
        @Override
        public LanguageService study()
        {
            return new LanguageService()
            {
                @Override
                public void chineseService()
                {
                    System.out.println("chinese is a good language.");
                }
                @Autowired
                public String toString()
                {
                    return "Complementary service";
                }
            };
        }
    };


    private static LanguageProvider ARMED_PROVIDER = new LanguageProvider()
    {
        @Override
        public LanguageService study()
        {
            return new LanguageService()
            {
                @Override
                public void chineseService()
                {
                    System.out.println("chinese is a good language.");
                }
                @Autowired
                public String toString()
                {
                    return "Armed service";
                }
            };
        }
    };


    public static void main(String[] args)
    {
        LanguageServices.resigterDefaultProvider(DEFAULT_PROVIDER);

        LanguageServices.registerProvider("comp",COMP_PROVIDER);
        LanguageServices.registerProvider("armed",ARMED_PROVIDER);

        LanguageService languageService1 = LanguageServices.newInstance();
        LanguageService languageService2 = LanguageServices.newInstance("comp");
        LanguageService languageService3 = LanguageServices.newInstance("armed");

        System.out.printf("%s,%s,%s%n",languageService1,languageService2,languageService3);
        System.out.println(languageService1.toString());
        System.out.println(languageService2.toString());
        System.out.println(languageService3.toString());
    }
}