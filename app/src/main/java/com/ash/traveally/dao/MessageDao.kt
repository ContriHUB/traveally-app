package com.ash.traveally.dao

import com.ash.traveally.models.Message
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.Filter
import com.google.firebase.firestore.Query
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class MessageDao @Inject constructor(
    private val chatCollection: CollectionReference
) {

    fun getAllMessages(userId1: Long, userId2: Long) = callbackFlow {
        val listener = chatCollection
            .where(Filter.or(Filter.equalTo("senderId", userId1), Filter.equalTo("senderId", userId2)))
            .where(Filter.or(Filter.equalTo("receiverId", userId1), Filter.equalTo("receiverId", userId2)))
            .orderBy("time", Query.Direction.DESCENDING)
            .addSnapshotListener { snapshot, e ->
            if (e != null) {
                close(e)
            }
            if (snapshot != null) {
                val messages = snapshot.toObjects(Message::class.java)
                trySend(messages)
            }
        }
        awaitClose {
            listener.remove()
        }
    }

    suspend fun addMessage(message: String, userId1: Long, userId2: Long) {
        val doc = chatCollection.document()
        doc.set(Message(id = doc.id, senderId = userId1, receiverId = userId2, message = message)).await()
    }
}