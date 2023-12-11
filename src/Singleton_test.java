package src;
package com.journaldev.singleton;

public class Singleton_test {


        private static World world = new World();

        private Singleton_test(){}

        public static Singleton_test getInstance() {
            return world;
        }
}

//en eller flera singleton-klasser
//Vilken initialisering