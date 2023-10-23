package com.lcwd.user.service.Service.Controller;

import com.lcwd.user.service.Service.entities.User;
import com.lcwd.user.service.Service.entities.Wallet;
import com.lcwd.user.service.Service.exception.WalletException;
import com.lcwd.user.service.Service.service.UserService;
import com.lcwd.user.service.Service.service.WalletServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/wallet")
public class WalletController {

    @Autowired
    private WalletServices wService;
    @Autowired
    private UserService userService;


    //    http://localhost:8888/WALLET/addMoney/amankumar.ak0012@gmail.com?amount=900.0


    @PostMapping("/addMoney/{email}")
    public ResponseEntity<Wallet> addMoneyToWallet(@PathVariable String email, @RequestParam("amount") Float amount){
        User user = userService.getUserByEmail(email);
        Wallet wallet = user.getWallet();
        Wallet res= wService.addMoney(wallet.getWalletId(), amount);
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);

    }


    @PostMapping("/createWallet/{email}")
    public ResponseEntity<Wallet> createWallet(@PathVariable String email) {
        Wallet res = wService.createWallet(email);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping("/getWallet")
    public ResponseEntity<Wallet> getWallet(String email) {
        User user = userService.getUserByEmail(email);
        Wallet wallet = user.getWallet();
        return new ResponseEntity<>(wallet, HttpStatus.ACCEPTED);
    }


}
