package com.example.practicekt.activity.sp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practicekt.R
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.PlayerView

class ExoPlayer : AppCompatActivity() {

    private lateinit var exoPlayer: ExoPlayer
    private lateinit var playerView: PlayerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exo_player)

        playerView = findViewById(R.id.playerView)

        exoPlayer = ExoPlayer.Builder(this).build()
        playerView.player = exoPlayer

        val mediaUrls = listOf(
            "https://file-examples.com/storage/fe91352fe66730de9982024/2017/04/file_example_MP4_480_1_5MG.mp4",
            "https://sample-videos.com/video321/mp4/720/big_buck_bunny_720p_1mb.mp4",
            "https://thetestdata.com/assets/video/mp4/480/1MB_480P_THETESTDATA.COM_mp4.mp4",
            "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-2.mp3"
        )

        for (url in mediaUrls) {
            val mediaItem = MediaItem.fromUri(url)
            exoPlayer.addMediaItem(mediaItem)
        }

        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
    }

    override fun onStart() {
        super.onStart()
        exoPlayer.playWhenReady = false
    }

    override fun onPause() {
        super.onPause()
        exoPlayer.playWhenReady = false
    }

    override fun onStop() {
        super.onStop()
        exoPlayer.release()
    }
}
