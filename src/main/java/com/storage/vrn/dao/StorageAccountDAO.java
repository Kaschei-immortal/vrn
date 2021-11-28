package com.storage.vrn.dao;

import java.util.List;

import javax.sql.DataSource;

//import com.storage.vrn.StorageTransactionException;
import com.storage.vrn.mapper.StorageAccountMapper;
import com.storage.vrn.model.StorageAccountinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
//@Transactional
public class StorageAccountDAO extends JdbcDaoSupport {

    @Autowired
    public StorageAccountDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<StorageAccountinfo> getStorageAccounts() {
        // Select ba.Id, ba.Full_Name, ba.Balance From Bank_Account ba
        String sql = StorageAccountMapper.BASE_SQL;

        Object[] params = new Object[] {};
        StorageAccountMapper mapper = new StorageAccountMapper();
        List<StorageAccountinfo> list = this.getJdbcTemplate().query(sql, params, mapper);

        return list;
    }

    public StorageAccountinfo findStorageAccount(Long id) {
        // Select ba.Id, ba.Full_Name, ba.Balance From Bank_Account ba
        // Where ba.Id = ?
        String sql = StorageAccountMapper.BASE_SQL + " where storage.Id = ? ";

        Object[] params = new Object[] { id };
        StorageAccountMapper mapper = new StorageAccountMapper();
        try {
            StorageAccountinfo storageAccount = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return storageAccount;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

//   // MANDATORY: Transaction must be created before.
//   @Transactional(propagation = Propagation.MANDATORY)
//   public void addAmount(Long id, double amount) throws StorageTransactionException {
//       StorageAccountinfo accountInfo = this.findBankAccount(id);
//       if (accountInfo == null) {
//           throw new StorageTransactionException("Account not found " + id);
//       }
//       double newKab = accountInfo.getKab() + amount;
//       if (accountInfo.getBalance() + amount < 0) {
//           throw new BankTransactionException(
//                   "The money in the account '" + id + "' is not enough (" + accountInfo.getBalance() + ")");
//       }
//       accountInfo.setBalance(newBalance);
//       // Update to DB
//       String sqlUpdate = "Update Bank_Account set Balance = ? where Id = ?";
//       this.getJdbcTemplate().update(sqlUpdate, accountInfo.getBalance(), accountInfo.getId());
//   }
//
//   // Do not catch BankTransactionException in this method.
//   @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = BankTransactionException.class)
//   public void sendMoney(Long fromAccountId, Long toAccountId, double amount) throws BankTransactionException {
//
//       addAmount(toAccountId, amount);
//       addAmount(fromAccountId, -amount);
//   }
}