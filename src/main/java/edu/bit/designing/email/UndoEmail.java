package edu.bit.designing.email;

/**
 * Undo sending an Email
 *
 *
 * Send Email => Gmail Service ()
 *
 * Delayed send => Gmail Service ()
 * 			[m1(ttl), m2]				=>	Provider
 * Undo =>   Gmail
 * 	[ m2]
 * 	if(there) remove else exception
 *
 *
 *
 * 1.
 *
 * > Producers are (with and without ttl)n
 * > Queueing mechanism (with and without ttl)
 * > Consumer ()
 *
 *
 * ?? audit capability
 *
 *
 * 2. 	DataStore(ttl)
 *
 *
 * Gmail Service => Writes the mail data to one store
 * 		=> Writes the TTL based info to another store
 *
 * (users can undo based on preferences)
 *
 *
 * user_id_mail_id =>
 *
 *
 * 3.
 *
 * 		(action Send) 	--->
 *
 * InitiatedState -(action Send)--> WaitingState -(expiry based)-> SendState
 * 			|				|
 * (action Undo)			|
 * 			|				|
 * 			End State ←----------------------
 *
 * MailId => MailStatus 	Mail’s Expiry
 *
 * Send => Write to store with status WAITING …
 * Undo => Check if the mail is still in WAITING state, then don’t send and mark COMPLETED.
 *
 * Send a cancel request to taskmanagement
 *
 * TaskManagement
 * …. schedule an Event to be triggered at some time
 * [tm1, tm2]
 *
 */
public class UndoEmail {
}
