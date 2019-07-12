package io.mitter.mitterandroidstarter.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import io.mitter.android.Mitter
import io.mitter.android.domain.model.FetchMessageConfig
import io.mitter.android.error.model.base.ApiError
import io.mitter.mitterandroidstarter.MyApp
import io.mitter.mitterandroidstarter.R
import io.mitter.models.mardle.messaging.Message
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mitter: Mitter
    private val channelId: String = "channel-id-here"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Getting a reference of the Mitter object from the application class
        mitter = (application as MyApp).mitter

        //Obtaining categorised API objects from the main Mitter object
        val users = mitter.Users()
        val channels = mitter.Channels()
        val messaging = mitter.Messaging()

        //Setting up the chat recycler view
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.stackFromEnd = true
        chatRecyclerView.layoutManager = linearLayoutManager

        //Getting messages in a given channel
        messaging.getMessagesInChannel(
            channelId = channelId,
            fetchMessageConfig = FetchMessageConfig(limit = 25),
            onValueAvailableCallback = object : Mitter.OnValueAvailableCallback<List<Message>> {
                override fun onError(apiError: ApiError) {
                    //Couldn't get the messages
                }

                override fun onValueAvailable(value: List<Message>) {
                    //Populate your messages in the list
                }
            }
        )
    }
}
