package com.interface21.transaction;

/**
 * Representation of the status of a transaction,
 * consisting of a transaction object and some status flags.
 * Transactional code can use this to retrieve status information
 * and to programatically request a rollback (instead of throwing
 * an exception that causes an implicit rollback).
 *
 * @author Juergen Hoeller
 * @since 27.03.2003
 * @see PlatformTransactionManager
 * @see TransactionCallback
 */
public class TransactionStatus {

	/**
	 * the underlying transaction object, e.g. a JTA UserTransaction
	 */
	private Object transaction = null;

	/**
	 * if the transaction is new,
	 * else taking part in a surrounding transaction
	 */
	private boolean newTransaction = false;

	/**
	 * if the transaction has been set rollback-only
	 */
	private boolean rollbackOnly = false;

	/**
	 * Create a new TransactionStatus instance.
	 * @param transaction  the underlying transaction object, e.g. a JTA UserTransaction
	 * @param newTransaction  if the transaction is new,
	 * else taking part in a surrounding transaction
	 */
	public TransactionStatus(Object transaction, boolean newTransaction) {
		this.transaction = transaction;
		this.newTransaction = newTransaction;
	}

	/**
	 * Return the underlying transaction object, e.g. a JTA UserTransaction.
	 */
	public Object getTransaction() {
		return transaction;
	}

	/**
	 * Return if the transaction is new,
	 * else taking part in a surrounding transaction.
	 */
	public boolean isNewTransaction() {
		return (transaction != null && newTransaction);
	}

	/**
	 * Return if the transaction has been set rollback-only.
	 */
	public boolean isRollbackOnly() {
		return rollbackOnly;
	}

	/**
	 * Set the transaction rollback-only.
	 */
	public void setRollbackOnly() {
		this.rollbackOnly = true;
	}
}