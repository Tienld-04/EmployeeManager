package com.dev.ldt.NewSpring.KienTrucSpring.controller;


import com.dev.ldt.NewSpring.KienTrucSpring.db.checkDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class  checkDBController {

    @Autowired
    private checkDataBase databaseConnectionChecker;

    @GetMapping("/check-db")
    public String checkDatabaseConnection() {
        return databaseConnectionChecker.checkConnection();
    }


}
