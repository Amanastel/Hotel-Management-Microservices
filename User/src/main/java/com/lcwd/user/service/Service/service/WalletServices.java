package com.lcwd.user.service.Service.service;

import com.lcwd.user.service.Service.entities.Transactions;
import com.lcwd.user.service.Service.entities.Wallet;

import java.util.List;
public interface WalletServices {
    /**
     * Adds money to a wallet.
     *
     * @param walletId The ID of the wallet to add money to.
     * @param amount   The amount of money to add.
     * @return The updated wallet details.
     */
    public Wallet addMoney(Integer walletId, Float amount);

    /**
     * Retrieves all transactions associated with a wallet.
     *
     * @param walletId The ID of the wallet to retrieve transactions for.
     * @return A list of transactions associated with the wallet.
     */
    public List<Transactions> getAllTranactions(Integer walletId);


    /**
     * Creates a new wallet for a user with the given email.
     *
     * @param email The email of the user for whom to create a wallet.
     * @return The created wallet details.
     */
    public Wallet createWallet(String email);

    /**
     * Retrieves the details of a wallet by its ID.
     *
     * @param id The ID of the wallet to retrieve.
     * @return The wallet details.
     */
    public Wallet getWallet(Integer id);

    /**
     * Retrieves the wallet associated with a logged-in user by their email.
     *
     * @param email The email of the logged-in user.
     * @return The wallet details associated with the user.
     */
    public Wallet getLoggedUserWallet(String email);

    /**
     * Retrieves the balance of a wallet associated with a logged-in user by their email.
     *
     * @param email The email of the logged-in user.
     * @return The balance of the wallet associated with the user.
     */

    public Float getBalance(String email);

    public Wallet payRideBill(Integer walletId, Float bill);
}
