package io.mitter.mitterandroidstarter

import android.app.Application
import com.google.common.eventbus.EventBus
import io.mitter.android.Mitter
import io.mitter.android.domain.model.MitterConfig
import io.mitter.android.domain.model.UserAuth
import io.mitter.models.mardle.messaging.*

class MyApp : Application() {
    lateinit var mitter: Mitter

    override fun onCreate() {
        super.onCreate()

        //Basic Mitter config
        val mitterConfig = MitterConfig(
            applicationId = "your-app-id-here"
        )

        //Put down the user ID and auth token for the user you want to login
        val userAuth = UserAuth(
            userId = "user-id-here",
            userAuthToken = "user-auth-token-here"
        )

        //Configure and initialise the Mitter object
        mitter = Mitter(
            context = this,
            mitterConfig = mitterConfig,
            userAuth = userAuth
        )

        //Add your callback for the FCM push messages here (ex: use an event bus)
        mitter.registerOnPushMessageReceivedListener(object : Mitter.OnPushMessageReceivedCallback {
            override fun onChannelStreamData(channelId: String, streamId: String, streamData: ContextFreeMessage) {

            }

            override fun onNewChannel(channel: Channel) {

            }

            override fun onNewChannelTimelineEvent(channelId: String, timelineEvent: TimelineEvent) {

            }

            override fun onNewMessage(channelId: String, message: Message) {

            }

            override fun onNewMessageTimelineEvent(messageId: String, timelineEvent: TimelineEvent) {

            }

            override fun onParticipationChangedEvent(channelId: String, participantId: String, newStatus: ParticipationStatus, oldStatus: ParticipationStatus?) {

            }
        })
    }
}
