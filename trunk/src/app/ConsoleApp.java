package app;

import persistence.base.InitializeDb;

public class ConsoleApp {
	public static void main(String[] args) throws Exception {
		System.out.println("Initializing Db driver");
        //InitializeDb.initialize();
        
        System.out.println("create db");
        //InitializeDb.createDb();
        
        System.out.println("populate db");
        //InitializeDb.PopulateDb();
	}
}