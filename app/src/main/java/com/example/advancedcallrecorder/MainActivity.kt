package com.example.advancedcallrecorder

import android.media.MediaRecorder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aykuttasil.callrecord.CallRecord

class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    private lateinit var callRecord: CallRecord

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        callRecord = CallRecord.init(this)

        callRecord = CallRecord.Builder(this)
            .setLogEnable(true)
            .setRecordFileName("CallRecorderTestFile")
            .setRecordDirName("CallRecorderTest")
            .setAudioSource(MediaRecorder.AudioSource.VOICE_COMMUNICATION)
            .setShowSeed(true)
            .build()
    }
}