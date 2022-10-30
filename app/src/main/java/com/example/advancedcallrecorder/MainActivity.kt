package com.example.advancedcallrecorder

import android.media.MediaRecorder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.aykuttasil.callrecord.CallRecord
import com.aykuttasil.callrecord.helper.LogUtils

class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    private lateinit var callRecord: CallRecord

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //callRecord = CallRecord.init(this)

        callRecord = CallRecord.Builder(this)
            .setLogEnable(true)
            .setRecordFileName("CallRecorderTestFile")
            .setRecordDirName("CallRecorderTest")
            .setAudioSource(MediaRecorder.AudioSource.VOICE_COMMUNICATION)
            .setShowSeed(true)
            .build()

        //callRecord.changeReceiver(new MyCallRecordReceiver(callRecord));
        //callRecord.enableSaveFile();

        /*
        callRecord = new CallRecord.Builder(this)
                .setRecordFileName("Record_" + new SimpleDateFormat("ddMMyyyyHHmmss", Locale.US).format(new Date()))
                .setRecordDirName("CallRecord")
                .setRecordDirPath(Environment.getExternalStorageDirectory().getPath())
                .setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
                .setOutputFormat(MediaRecorder.OutputFormat.AMR_NB)
                .setAudioSource(MediaRecorder.AudioSource.VOICE_COMMUNICATION)
                .setShowSeed(true)
                .buildService();
        callRecord.startCallRecordService();
        */

        findViewById<Button>(R.id.startRecord).setOnClickListener{
            Toast.makeText(this, "Record started", Toast.LENGTH_LONG).show()
            startCallRecordClick(it)
        }

        findViewById<Button>(R.id.endRecord).setOnClickListener {
            Toast.makeText(this, "Record stopped", Toast.LENGTH_LONG).show()
            stopCallRecordClick(it)
        }
    }

    fun startCallRecordClick(view: View) {
        LogUtils.i(TAG, "StartCallRecordClick")
        callRecord.startCallReceiver()

        //callRecord.enableSaveFile();
        //callRecord.changeRecordDirName("NewDirName");
    }

    fun stopCallRecordClick(view: View) {
        LogUtils.i(TAG, "StopCallRecordClick")
        callRecord.stopCallReceiver()

        //callRecord.disableSaveFile();
        //callRecord.changeRecordFileName("NewFileName");
    }
}