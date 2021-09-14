package com.fontys.semester3individualprojectplayvera.repository;

import com.fontys.semester3individualprojectplayvera.manager.GameManager;
import com.fontys.semester3individualprojectplayvera.manager.UserManager;
import org.springframework.stereotype.Repository;

public class MainHubController {


    //CLASS IS USED FOR TESTING PURPOSES

   private final UserManager userManager;
   private final GameManager gameManager;

   public MainHubController(){
       this.userManager = new UserManager();
       this.gameManager = new GameManager();
       this.userManager.AddUser("vionev", "vionev@gmail.com", "123456", "Victor",
               "Ionev");
       this.userManager.AddUser("hamako", "hamako@gmail.com", "787878", "Hamako",
               "Uchiha");
       this.userManager.AddUser("Andrei2", "andrei2@gmail.com", "ooo123", "Andrei",
               "Petrov");

       this.gameManager.AddGame("CsGO",450, 30);
       this.gameManager.AddGame("Amnesia", 500,20);
       this.gameManager.AddGame("Blastoid", 1900, 30);
       this.gameManager.AddGame("Halo", 1200, 40);
       this.gameManager.AddGame("Uguchiha", 2300, 40);





   }

   public UserManager GetUserManager(){return this.userManager;}
   public GameManager GetGameManager(){return this.gameManager;}







}
